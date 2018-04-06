package it.senape.wldiag.service.filesystem;

import com.google.common.base.CaseFormat;
import it.senape.wldiag.dto.workmanager.WorkManagerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.NotWritablePropertyException;
import org.springframework.beans.PropertyAccessor;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Service
public class WorkManagerTxtService {

    private final static Logger logger = LoggerFactory.getLogger(WorkManagerTxtService.class);

    public WorkManagerDto extract(ByteArrayOutputStream outputStream) {
        WorkManagerDto workManagerDto = new WorkManagerDto();
        PropertyAccessor propertyAccessor = PropertyAccessorFactory.forDirectFieldAccess(workManagerDto);
        try (BufferedReader reader = new BufferedReader(new StringReader(new String(outputStream.toByteArray())))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] elements = line.split(":");
                if (elements.length == 2) {
                    String property = getPropertyName(elements[0]);
                    try {
                        propertyAccessor.setPropertyValue(property, elements[1]);
                    } catch (NotWritablePropertyException nwpe) {
                        logger.warn("Property {} not found", property);
                    }
                }
            }
        } catch (IOException ioe) {
            logger.error("Error reading workmanager file", ioe);
        }
        return workManagerDto;
    }

    private String getPropertyName(String string) {
        string = string.trim();
        string = string.replaceAll("\\s", "_");
        return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, string);
    }

}
