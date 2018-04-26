package it.senape.wldiag.jpa.bridge;

import it.senape.wldiag.dto.PropertyDto;
import it.senape.wldiag.jpa.model.jta.EjbTransactionProperty;
import it.senape.wldiag.jpa.model.jta.Property;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
public class Converter {

    private Converter(){}

    public static Property convertDtoToEntity(PropertyDto dto) {
        Property p = null;
        switch (dto.getName()) {
            case "weblogic.transaction.name":
                if(dto.getValue().startsWith("[EJB")) {
                    p = convertPropertyDtoToEjbTransactionEntity(dto);
                }
                break;
            default:
                p = createProperty(dto);
        }
        return p;
    }

    public static Property convertPropertyDtoToEjbTransactionEntity(PropertyDto dto) {
        Property property = null;
        if(dto!=null) {
            property = new Property();
            property.setName(dto.getName());
            property.setValue(dto.getValue());
            Pattern pattern = Pattern.compile("^\\[EJB\\s(.*)\\((.*)\\)");
            Matcher matcher = pattern.matcher(dto.getValue());
            while (matcher.find()) {
                EjbTransactionProperty ejbTransaction = new EjbTransactionProperty(property);
                String fqn = matcher.group(1);
                String args = matcher.group(2);
                ejbTransaction.setClassName(fqn.substring(0,fqn.lastIndexOf('.')));
                ejbTransaction.setMethod(fqn.substring(fqn.lastIndexOf('.')+1));
                ejbTransaction.setArguments(args);
                return ejbTransaction;
            }
        }
        return property;
    }

    private static Property createProperty(PropertyDto dto) {
        Property p = null;
        if (dto!=null) {
            p = new Property();
            p.setName(dto.getName());
            p.setValue(dto.getValue());
        }
        return p;
    }


    public static LocalDateTime fromLongToLocalDateTime(Long timestamp) {
        return LocalDateTime.ofInstant(
                Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
    }

}
