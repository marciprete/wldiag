//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.17 at 03:40:53 PM CET 
//


package it.senape.wldiag.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to WTCPasswordMBean
 *  (Interface=weblogic.management.configuration.WTCPasswordMBean)
 * 
 * <p>Java class for wtc-passwordType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wtc-passwordType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="local-access-point" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remote-access-point" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="local-password-iv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="local-password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remote-password-iv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remote-password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wtc-passwordType", propOrder = {
    "localAccessPoint",
    "remoteAccessPoint",
    "localPasswordIv",
    "localPassword",
    "remotePasswordIv",
    "remotePassword"
})
public class WtcPasswordType
    extends ConfigurationType
{

    @XmlElement(name = "local-access-point", defaultValue = "myLAP")
    protected String localAccessPoint;
    @XmlElement(name = "remote-access-point", defaultValue = "myRAP")
    protected String remoteAccessPoint;
    @XmlElement(name = "local-password-iv", defaultValue = "myLPWDIV")
    protected String localPasswordIv;
    @XmlElement(name = "local-password", defaultValue = "myLPWD")
    protected String localPassword;
    @XmlElement(name = "remote-password-iv", defaultValue = "myRPWDIV")
    protected String remotePasswordIv;
    @XmlElement(name = "remote-password", defaultValue = "myRPWD")
    protected String remotePassword;

    /**
     * Gets the value of the localAccessPoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalAccessPoint() {
        return localAccessPoint;
    }

    /**
     * Sets the value of the localAccessPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalAccessPoint(String value) {
        this.localAccessPoint = value;
    }

    /**
     * Gets the value of the remoteAccessPoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemoteAccessPoint() {
        return remoteAccessPoint;
    }

    /**
     * Sets the value of the remoteAccessPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemoteAccessPoint(String value) {
        this.remoteAccessPoint = value;
    }

    /**
     * Gets the value of the localPasswordIv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalPasswordIv() {
        return localPasswordIv;
    }

    /**
     * Sets the value of the localPasswordIv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalPasswordIv(String value) {
        this.localPasswordIv = value;
    }

    /**
     * Gets the value of the localPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocalPassword() {
        return localPassword;
    }

    /**
     * Sets the value of the localPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocalPassword(String value) {
        this.localPassword = value;
    }

    /**
     * Gets the value of the remotePasswordIv property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemotePasswordIv() {
        return remotePasswordIv;
    }

    /**
     * Sets the value of the remotePasswordIv property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemotePasswordIv(String value) {
        this.remotePasswordIv = value;
    }

    /**
     * Gets the value of the remotePassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRemotePassword() {
        return remotePassword;
    }

    /**
     * Sets the value of the remotePassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRemotePassword(String value) {
        this.remotePassword = value;
    }

}
