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
 * Corresponds to SNMPStringMonitorMBean
 *  (Interface=weblogic.management.configuration.SNMPStringMonitorMBean)
 * 
 * <p>Java class for snmp-string-monitorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="snmp-string-monitorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}snmp-jmx-monitorType">
 *       &lt;sequence>
 *         &lt;element name="string-to-compare" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="notify-differ" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="notify-match" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "snmp-string-monitorType", propOrder = {
    "stringToCompare",
    "notifyDiffer",
    "notifyMatch"
})
public class SnmpStringMonitorType
    extends SnmpJmxMonitorType
{

    @XmlElementRef(name = "string-to-compare", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stringToCompare;
    @XmlElement(name = "notify-differ", defaultValue = "false")
    protected Boolean notifyDiffer;
    @XmlElement(name = "notify-match", defaultValue = "false")
    protected Boolean notifyMatch;

    /**
     * Gets the value of the stringToCompare property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStringToCompare() {
        return stringToCompare;
    }

    /**
     * Sets the value of the stringToCompare property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStringToCompare(JAXBElement<String> value) {
        this.stringToCompare = value;
    }

    /**
     * Gets the value of the notifyDiffer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotifyDiffer() {
        return notifyDiffer;
    }

    /**
     * Sets the value of the notifyDiffer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotifyDiffer(Boolean value) {
        this.notifyDiffer = value;
    }

    /**
     * Gets the value of the notifyMatch property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isNotifyMatch() {
        return notifyMatch;
    }

    /**
     * Sets the value of the notifyMatch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setNotifyMatch(Boolean value) {
        this.notifyMatch = value;
    }

}
