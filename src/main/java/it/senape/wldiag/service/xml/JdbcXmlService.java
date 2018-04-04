package it.senape.wldiag.service.xml;

import it.senape.wldiag.dto.jdbc.JdbcResourceDto;
import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Created by michele.arciprete on 25-Jan-18.
 */
@Service
public class JdbcXmlService {

    private static final Logger log = LoggerFactory.getLogger(JdbcXmlService.class);

    private static final String FIRST_ROW_TEXT = "Dumping Resource Pool:";
    private static final String CURRENT_CAPACITY = "Current Capacity";
    private static final String AVAILABLE_RESOURCES = "dumping available resources";
    private static final String AVAILABLE_RESOURCE = "AVAILABLE_RESOURCE";
    private static final String RESERVED_RESOURCES = "dumping reserved resources";
    private static final String RESERVED_RESOURCE = "RESERVED_RESOURCE";
    private static final String DEAD_RESOURCES = "dead resources";
    private static final String DEAD_RESOURCE = "DEAD_RESOURCE";
    private static final String EQUAL_AND_SPACES_SEPARATOR_REGEXP = "\\s=\\s";
    private static final String JAVA_LANG_EXCEPTION_STRING = "java.lang.Exception";
    private static final String TAB_REGEXP = "\t";

    public JdbcResourcePoolDto extract(BufferedReader br) {
        JdbcResourcePoolDto resourcePoolDto = new JdbcResourcePoolDto();
        try {
            String prev = "",
                    next = "";

            String datasourceName = "";
            String dumpPoolString = "";

            Integer currentCapacity = 0;
            Integer availableResourcesCounter = 0;
            Integer reservedResourcesCounter = 0;
            Integer deadResourcesCounter = 0;

            while ((next = br.readLine()) != null) {
                if("".equals(prev) &&
                       !next.startsWith(FIRST_ROW_TEXT) ) {
                    //the file isn't a valid/recognized diagnostic image jdbc
                    log.warn("Could not recognize JDBC File. First row \"{}\" differs from expected", next);
                    return resourcePoolDto;
                }

                if("".equals(prev)) {
                    log.debug("Parsing begins.");
                    datasourceName = next.split(":")[1];
                    log.info("Datasource name: {}", datasourceName);
                    dumpPoolString = "Resource Pool:"+datasourceName+":dumpPool";
                    prev = next;

                    resourcePoolDto.setPoolname(datasourceName);
                } else {
                    if(next.startsWith(dumpPoolString)) {

                        if(prev.startsWith(JdbcXmlService.FIRST_ROW_TEXT)) {
                            prev = CURRENT_CAPACITY;
                            currentCapacity = Integer.parseInt(next.split(EQUAL_AND_SPACES_SEPARATOR_REGEXP)[1]);
                            log.debug("Current capacity: {}", currentCapacity);
                            resourcePoolDto.setCurrentCapacity(currentCapacity);
                        }

                        else if (prev.equals(CURRENT_CAPACITY)) {
                            prev = AVAILABLE_RESOURCES;
                            availableResourcesCounter = Integer.parseInt(next.split(EQUAL_AND_SPACES_SEPARATOR_REGEXP)[1]);
                            log.info("Available resources: {}", availableResourcesCounter);
                        }

                        else if (prev.equals(AVAILABLE_RESOURCES)) {
                            prev = AVAILABLE_RESOURCE;
                            JdbcResourceDto availableResource = parseResource(next);
                            if(JAVA_LANG_EXCEPTION_STRING.equals(availableResource.getCurrentUser())) {
                                availableResource.setStackTrace(getStackTrace(br));
                            }
                            resourcePoolDto.getAvailableResources().add(availableResource);
                        }

                        else if(prev.equals(AVAILABLE_RESOURCE)){

                            if(next.contains(RESERVED_RESOURCES)) {
                                prev = RESERVED_RESOURCES;
                                reservedResourcesCounter = Integer.parseInt(next.split(EQUAL_AND_SPACES_SEPARATOR_REGEXP)[1]);
                                log.info("Reserved counter: {}", reservedResourcesCounter);
                            } else {
                                JdbcResourceDto availableResource = parseResource(next);
                                if(JAVA_LANG_EXCEPTION_STRING.equals(availableResource.getCurrentUser())) {
                                    availableResource.setStackTrace(getStackTrace(br));
                                }
                                resourcePoolDto.getAvailableResources().add(availableResource);
                            }
                        }

                        else if (prev.equals(RESERVED_RESOURCES)) {
                            prev = RESERVED_RESOURCE;
                            JdbcResourceDto reservedResource = parseResource(next);
                            if(JAVA_LANG_EXCEPTION_STRING.equals(reservedResource.getCurrentUser())) {
                                reservedResource.setStackTrace(getStackTrace(br));
                            }
                            resourcePoolDto.getReservedResources().add(reservedResource);
                        }

                        else if(prev.equals(RESERVED_RESOURCE)) {
                            if(next.contains(DEAD_RESOURCES)) {
                                prev = DEAD_RESOURCES;
                                deadResourcesCounter = Integer.parseInt(next.split(EQUAL_AND_SPACES_SEPARATOR_REGEXP)[1]);
                                log.info("Dead counter: {}", deadResourcesCounter);
                            } else {
                                JdbcResourceDto reservedResource = parseResource(next);
                                if(JAVA_LANG_EXCEPTION_STRING.equals(reservedResource.getCurrentUser())) {
                                    reservedResource.setStackTrace(getStackTrace(br));
                                }
                                resourcePoolDto.getReservedResources().add(reservedResource);
                            }
                        }

                        else if (prev.equals(DEAD_RESOURCES)) {
                            prev = DEAD_RESOURCE;
                        }
                    }

                    else {
                        //exception continue...
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resourcePoolDto;
    }


    private String getStackTrace(BufferedReader br) throws IOException {
        StringBuffer sb = new StringBuffer();
        String excLine = br.readLine();
        while (excLine.startsWith(TAB_REGEXP)) {
            sb.append(excLine);
            excLine = br.readLine();
        }
        System.out.println(sb);
        return sb.toString();
    }

    private String getStackTrace(LineIterator lineIterator) {
        StringBuffer sb = new StringBuffer();
        String excLine = lineIterator.nextLine();
        while (excLine.startsWith("\t")) {
            sb.append(excLine);
            excLine = lineIterator.nextLine();
        }
        System.out.println(sb);
        return sb.toString();
    }

    private JdbcResourceDto parseResource(String next) {
        //Check that the string is valid:
        assert next != null;
        assert next.startsWith("Resource Pool:");
        String properties = next.split(EQUAL_AND_SPACES_SEPARATOR_REGEXP)[1];
        JdbcResourceDto jdbcResource = new JdbcResourceDto();
        try {
            Properties p = buildProperties(properties, ",");
            JdbcResourceDto finalJdbcResource = jdbcResource;
            p.forEach((k, v) -> {
                try {
                    BeanUtils.setProperty(finalJdbcResource,k.toString(),v);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jdbcResource;
    }

    public Properties buildProperties(String propertiesFromString, String entrySeparator) throws IOException {
        Properties properties = new Properties();
        properties.load(new StringReader(propertiesFromString.replaceAll(entrySeparator, "\n")));
        return properties;
    }

//    private enum ResourceType {
//        AVAILABLE,
//        RESERVED,
//        DEAD
//    }
}
