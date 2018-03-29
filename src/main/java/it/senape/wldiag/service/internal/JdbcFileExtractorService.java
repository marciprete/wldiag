package it.senape.wldiag.service.internal;

import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.jdbc.*;
import it.senape.wldiag.jpa.repository.JdbcResourcePoolRepository;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.LineIterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * Created by michele.arciprete on 25-Jan-18.
 */
@Service
public class JdbcFileExtractorService {

    private static final Logger log = LoggerFactory.getLogger(JdbcFileExtractorService.class);

    private static final String FIRST_ROW_TEXT = "Dumping Resource Pool:";
    private static final String CURRENT_CAPACITY = "Current Capacity";
    private static final String AVAILABLE_RESOURCES = "dumping available resources";
    private static final String AVAILABLE_RESOURCE = "AVAILABLE_RESOURCE";
    private static final String RESERVED_RESOURCES = "dumping reserved resources";
    private static final String RESERVED_RESOURCE = "RESERVED_RESOURCE";
    private static final String DEAD_RESOURCES = "dead resources";
    private static final String DEAD_RESOURCE = "DEAD_RESOURCE";

    private JdbcResourcePoolRepository resourcePoolRepository;

    @Autowired
    public JdbcFileExtractorService(JdbcResourcePoolRepository resourcePoolRepository) {
        this.resourcePoolRepository = resourcePoolRepository;
    }

//    public ResourcePool extract(File jdbc, DiagnosticImage diagnosticImage) {
    public JdbcResourcePool extract(BufferedReader br, DiagnosticImage diagnosticImage) {
        JdbcResourcePool resourcePool = new JdbcResourcePool();
        resourcePool.setDiagnosticImage(diagnosticImage);

        try {
//            LineIterator lineIterator = FileUtils.lineIterator(jdbc, "UTF-8");
            String prev = "",
                    next = "";

            String datasourceName = "";
            String dumpPoolString = "";

            Integer currentCapacity = 0;
            Integer availableResourcesCounter = 0;
            Integer reservedResourcesCounter = 0;
            Integer deadResourcesCounter = 0;

//            while (lineIterator.hasNext()) {
//            next = lineIterator.nextLine();
            while ((next = br.readLine()) != null) {
                if("".equals(prev) &&
                       !next.startsWith(FIRST_ROW_TEXT) ) {
                    //the file isn't a valid/recognized diagnostic image jdbc
                    log.warn("Could not recognize JDBC File. First row \"{}\" differs from expected", next);
                    return resourcePool;
                }

                if("".equals(prev)) {
                    log.debug("Parsing begins.");
                    datasourceName = next.split(":")[1];
                    log.info("Datasource name: {}", datasourceName);
                    dumpPoolString = "Resource Pool:"+datasourceName+":dumpPool";
                    prev = next;

                    resourcePool.setPoolname(datasourceName);
                } else {
                    if(next.startsWith(dumpPoolString)) {

                        if(prev.startsWith(JdbcFileExtractorService.FIRST_ROW_TEXT)) {
                            prev = CURRENT_CAPACITY;
                            currentCapacity = Integer.parseInt(next.split("\\s=\\s")[1]);
                            log.debug("Current capacity: {}", currentCapacity);
                            resourcePool.setCurrentCapacity(currentCapacity);
                        }

                        else if (prev.equals(CURRENT_CAPACITY)) {
                            prev = AVAILABLE_RESOURCES;
                            availableResourcesCounter = Integer.parseInt(next.split("\\s=\\s")[1]);
                            log.info("Available resources: {}", availableResourcesCounter);
                        }

                        else if (prev.equals(AVAILABLE_RESOURCES)) {
                            prev = AVAILABLE_RESOURCE;
                            AvailableResource availableResource = parseAvailableResource(next);
                            availableResource.setResourcePool(resourcePool);
                            if("java.lang.Exception".equals(availableResource.getCurrentUser())) {
//                                availableResource.setStackTrace(getStackTrace(lineIterator));
                                availableResource.setStackTrace(getStackTrace(br));
                            }
                            resourcePool.getAvailableResources().add(availableResource);
                        }

                        else if(prev.equals(AVAILABLE_RESOURCE)){

                            if(next.contains(RESERVED_RESOURCES)) {
                                prev = RESERVED_RESOURCES;
                                reservedResourcesCounter = Integer.parseInt(next.split("\\s=\\s")[1]);
                                log.info("Reserved counter: {}", reservedResourcesCounter);
                            } else {
                                AvailableResource availableResource = parseAvailableResource(next);
                                availableResource.setResourcePool(resourcePool);
                                if("java.lang.Exception".equals(availableResource.getCurrentUser())) {
//                                    availableResource.setStackTrace(getStackTrace(lineIterator));
                                    availableResource.setStackTrace(getStackTrace(br));
                                }
                                resourcePool.getAvailableResources().add(availableResource);
                            }
                        }

                        else if (prev.equals(RESERVED_RESOURCES)) {
                            prev = RESERVED_RESOURCE;
                            ReservedResource reservedResource = parseReservedResource(next);
                            reservedResource.setResourcePool(resourcePool);
                            if("java.lang.Exception".equals(reservedResource.getCurrentUser())) {
//                                reservedResource.setStackTrace(getStackTrace(lineIterator));
                                reservedResource.setStackTrace(getStackTrace(br));
                            }
                            resourcePool.getReservedResources().add(reservedResource);
                        }

                        else if(prev.equals(RESERVED_RESOURCE)) {
                            if(next.contains(DEAD_RESOURCES)) {
                                prev = DEAD_RESOURCES;
                                deadResourcesCounter = Integer.parseInt(next.split("\\s=\\s")[1]);
                                log.info("Dead counter: {}", deadResourcesCounter);
                            } else {
                                ReservedResource reservedResource = parseReservedResource(next);
                                reservedResource.setResourcePool(resourcePool);
                                if("java.lang.Exception".equals(reservedResource.getCurrentUser())) {
//                                    reservedResource.setStackTrace(getStackTrace(lineIterator));
                                    reservedResource.setStackTrace(getStackTrace(br));
                                }
                                resourcePool.getReservedResources().add(reservedResource);
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
            resourcePool = resourcePoolRepository.save(resourcePool);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return resourcePool;
    }


    private String getStackTrace(BufferedReader br) throws IOException {
        StringBuffer sb = new StringBuffer();
        String excLine = br.readLine();
        while (excLine.startsWith("\t")) {
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

    private AvailableResource parseAvailableResource(String res) {
        log.info("Parsing available resource");
        return (AvailableResource) parseResource(res, ResourceType.AVAILABLE);
    }

    private ReservedResource parseReservedResource(String res) {
        log.info("Parsing reserved resource");
        return (ReservedResource) parseResource(res, ResourceType.RESERVED);
    }

    private JdbcResource parseResource(String next, ResourceType resourceType) {
        //Check that the string is valid:
        assert next != null;
        assert next.startsWith("Resource Pool:");
        String properties = next.split("\\s=\\s")[1];
        JdbcResource jdbcResource = null;//new JdbcResource();
        switch (resourceType) {
            case AVAILABLE:
                jdbcResource = new AvailableResource();
                break;
            case RESERVED:
                jdbcResource = new ReservedResource();
                break;
            case DEAD:
                jdbcResource = new DeadResource();
                break;
            default:
                return new JdbcResource();
        }
        try {
            Properties p = buildProperties(properties, ",");
            JdbcResource finalJdbcResource = jdbcResource;
            p.forEach((k, v) -> {
//                log.info("{}: {}",k,v);
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

    private enum ResourceType {
        AVAILABLE,
        RESERVED,
        DEAD
    }
}
