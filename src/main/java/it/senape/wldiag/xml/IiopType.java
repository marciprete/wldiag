//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.17 at 03:40:53 PM CET 
//


package it.senape.wldiag.xml;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to IIOPMBean
 *  (Interface=weblogic.management.configuration.IIOPMBean)
 * 
 * <p>Java class for iiopType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="iiopType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="idle-connection-timeout" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="complete-message-timeout" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="-1"/>
 *               &lt;maxInclusive value="480"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="max-message-size" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="default-minor-version" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="use-locate-request" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="tx-mechanism" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="OTS"/>
 *               &lt;enumeration value="JTA"/>
 *               &lt;enumeration value="OTSv11"/>
 *               &lt;enumeration value="none"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="location-forward-policy" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="off"/>
 *               &lt;enumeration value="failover"/>
 *               &lt;enumeration value="round-robin"/>
 *               &lt;enumeration value="random"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="default-wide-char-codeset" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="UCS-2"/>
 *               &lt;enumeration value="UTF-16"/>
 *               &lt;enumeration value="UTF-8"/>
 *               &lt;enumeration value="UTF-16BE"/>
 *               &lt;enumeration value="UTF-16LE"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="default-char-codeset" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="US-ASCII"/>
 *               &lt;enumeration value="UTF-8"/>
 *               &lt;enumeration value="ISO-8859-1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="use-full-repository-id-list" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="use-stateful-authentication" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="use-serial-format-version2" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="enable-ior-servlet" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="use-java-serialization" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="system-security" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="none"/>
 *               &lt;enumeration value="supported"/>
 *               &lt;enumeration value="required"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "iiopType", propOrder = {
    "idleConnectionTimeout",
    "completeMessageTimeout",
    "maxMessageSize",
    "defaultMinorVersion",
    "useLocateRequest",
    "txMechanism",
    "locationForwardPolicy",
    "defaultWideCharCodeset",
    "defaultCharCodeset",
    "useFullRepositoryIdList",
    "useStatefulAuthentication",
    "useSerialFormatVersion2",
    "enableIorServlet",
    "useJavaSerialization",
    "systemSecurity"
})
public class IiopType
    extends ConfigurationType
{

    @XmlElement(name = "idle-connection-timeout", defaultValue = "-1")
    protected Integer idleConnectionTimeout;
    @XmlElement(name = "complete-message-timeout", defaultValue = "-1")
    protected Integer completeMessageTimeout;
    @XmlElement(name = "max-message-size", defaultValue = "-1")
    protected Integer maxMessageSize;
    @XmlElement(name = "default-minor-version", defaultValue = "2")
    protected Integer defaultMinorVersion;
    @XmlElement(name = "use-locate-request", defaultValue = "false")
    protected Boolean useLocateRequest;
    @XmlElementRef(name = "tx-mechanism", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> txMechanism;
    @XmlElementRef(name = "location-forward-policy", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> locationForwardPolicy;
    @XmlElementRef(name = "default-wide-char-codeset", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultWideCharCodeset;
    @XmlElementRef(name = "default-char-codeset", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultCharCodeset;
    @XmlElement(name = "use-full-repository-id-list", defaultValue = "false")
    protected Boolean useFullRepositoryIdList;
    @XmlElement(name = "use-stateful-authentication", defaultValue = "true")
    protected Boolean useStatefulAuthentication;
    @XmlElement(name = "use-serial-format-version2", defaultValue = "false")
    protected Boolean useSerialFormatVersion2;
    @XmlElement(name = "enable-ior-servlet", defaultValue = "false")
    protected Boolean enableIorServlet;
    @XmlElement(name = "use-java-serialization", defaultValue = "false")
    protected Boolean useJavaSerialization;
    @XmlElementRef(name = "system-security", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> systemSecurity;

    /**
     * Gets the value of the idleConnectionTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdleConnectionTimeout() {
        return idleConnectionTimeout;
    }

    /**
     * Sets the value of the idleConnectionTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdleConnectionTimeout(Integer value) {
        this.idleConnectionTimeout = value;
    }

    /**
     * Gets the value of the completeMessageTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCompleteMessageTimeout() {
        return completeMessageTimeout;
    }

    /**
     * Sets the value of the completeMessageTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCompleteMessageTimeout(Integer value) {
        this.completeMessageTimeout = value;
    }

    /**
     * Gets the value of the maxMessageSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxMessageSize() {
        return maxMessageSize;
    }

    /**
     * Sets the value of the maxMessageSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxMessageSize(Integer value) {
        this.maxMessageSize = value;
    }

    /**
     * Gets the value of the defaultMinorVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultMinorVersion() {
        return defaultMinorVersion;
    }

    /**
     * Sets the value of the defaultMinorVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultMinorVersion(Integer value) {
        this.defaultMinorVersion = value;
    }

    /**
     * Gets the value of the useLocateRequest property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseLocateRequest() {
        return useLocateRequest;
    }

    /**
     * Sets the value of the useLocateRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseLocateRequest(Boolean value) {
        this.useLocateRequest = value;
    }

    /**
     * Gets the value of the txMechanism property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTxMechanism() {
        return txMechanism;
    }

    /**
     * Sets the value of the txMechanism property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTxMechanism(JAXBElement<String> value) {
        this.txMechanism = value;
    }

    /**
     * Gets the value of the locationForwardPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLocationForwardPolicy() {
        return locationForwardPolicy;
    }

    /**
     * Sets the value of the locationForwardPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLocationForwardPolicy(JAXBElement<String> value) {
        this.locationForwardPolicy = value;
    }

    /**
     * Gets the value of the defaultWideCharCodeset property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultWideCharCodeset() {
        return defaultWideCharCodeset;
    }

    /**
     * Sets the value of the defaultWideCharCodeset property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultWideCharCodeset(JAXBElement<String> value) {
        this.defaultWideCharCodeset = value;
    }

    /**
     * Gets the value of the defaultCharCodeset property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultCharCodeset() {
        return defaultCharCodeset;
    }

    /**
     * Sets the value of the defaultCharCodeset property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultCharCodeset(JAXBElement<String> value) {
        this.defaultCharCodeset = value;
    }

    /**
     * Gets the value of the useFullRepositoryIdList property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseFullRepositoryIdList() {
        return useFullRepositoryIdList;
    }

    /**
     * Sets the value of the useFullRepositoryIdList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseFullRepositoryIdList(Boolean value) {
        this.useFullRepositoryIdList = value;
    }

    /**
     * Gets the value of the useStatefulAuthentication property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseStatefulAuthentication() {
        return useStatefulAuthentication;
    }

    /**
     * Sets the value of the useStatefulAuthentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseStatefulAuthentication(Boolean value) {
        this.useStatefulAuthentication = value;
    }

    /**
     * Gets the value of the useSerialFormatVersion2 property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseSerialFormatVersion2() {
        return useSerialFormatVersion2;
    }

    /**
     * Sets the value of the useSerialFormatVersion2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseSerialFormatVersion2(Boolean value) {
        this.useSerialFormatVersion2 = value;
    }

    /**
     * Gets the value of the enableIorServlet property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnableIorServlet() {
        return enableIorServlet;
    }

    /**
     * Sets the value of the enableIorServlet property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnableIorServlet(Boolean value) {
        this.enableIorServlet = value;
    }

    /**
     * Gets the value of the useJavaSerialization property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseJavaSerialization() {
        return useJavaSerialization;
    }

    /**
     * Sets the value of the useJavaSerialization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseJavaSerialization(Boolean value) {
        this.useJavaSerialization = value;
    }

    /**
     * Gets the value of the systemSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSystemSecurity() {
        return systemSecurity;
    }

    /**
     * Sets the value of the systemSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSystemSecurity(JAXBElement<String> value) {
        this.systemSecurity = value;
    }

}
