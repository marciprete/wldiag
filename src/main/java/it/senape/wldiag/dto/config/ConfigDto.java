package it.senape.wldiag.dto.config;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Created by michele.arciprete on 17-Jan-18.
 */
@Data
@XmlRootElement(name = "domain")
@XmlAccessorType(XmlAccessType.FIELD)
public class ConfigDto implements Serializable {

    private String name;

    @XmlElement(name = "domain-version")
    private String domainVersion;

    @XmlElement(name = "server")
    private List<ConfigServerDto> servers;

//    //security configuration element
//
//    //within jta element
//    private String jtaName;
//    private String jatTimeoutSeconds;
//    private String jtaAbandonTimeoutSeconds;
//    private String jtaSecurityInteropMode;



}
