package it.senape.wldiag.dto;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class ServerDto implements Serializable {

    @XmlAttribute
    private String url;//="ManagedServer_1+172.26.80.143:7011+ebooking+t3+"
    @XmlAttribute
    private boolean syncRegistered;//="true"
    @XmlAttribute
    private String state;//="active"

    @XmlTransient
    private String serverLabel;


}
