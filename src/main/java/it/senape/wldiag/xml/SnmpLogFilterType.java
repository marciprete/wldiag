//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.17 at 03:40:53 PM CET 
//


package it.senape.wldiag.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to SNMPLogFilterMBean
 *  (Interface=weblogic.management.configuration.SNMPLogFilterMBean)
 * 
 * <p>Java class for snmp-log-filterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="snmp-log-filterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}snmp-trap-sourceType">
 *       &lt;sequence>
 *         &lt;element name="severity-level" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="subsystem-name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="user-id" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="message-id" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="message-substring" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "snmp-log-filterType", propOrder = {
    "severityLevel",
    "subsystemName",
    "userId",
    "messageId",
    "messageSubstring"
})
public class SnmpLogFilterType
    extends SnmpTrapSourceType
{

    @XmlElementRef(name = "severity-level", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> severityLevel;
    @XmlElement(name = "subsystem-name", nillable = true)
    protected List<String> subsystemName;
    @XmlElement(name = "user-id", nillable = true)
    protected List<String> userId;
    @XmlElement(name = "message-id", nillable = true)
    protected List<String> messageId;
    @XmlElementRef(name = "message-substring", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messageSubstring;

    /**
     * Gets the value of the severityLevel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSeverityLevel() {
        return severityLevel;
    }

    /**
     * Sets the value of the severityLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSeverityLevel(JAXBElement<String> value) {
        this.severityLevel = value;
    }

    /**
     * Gets the value of the subsystemName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the subsystemName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSubsystemName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSubsystemName() {
        if (subsystemName == null) {
            subsystemName = new ArrayList<String>();
        }
        return this.subsystemName;
    }

    /**
     * Gets the value of the userId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the userId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUserId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getUserId() {
        if (userId == null) {
            userId = new ArrayList<String>();
        }
        return this.userId;
    }

    /**
     * Gets the value of the messageId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the messageId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMessageId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getMessageId() {
        if (messageId == null) {
            messageId = new ArrayList<String>();
        }
        return this.messageId;
    }

    /**
     * Gets the value of the messageSubstring property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessageSubstring() {
        return messageSubstring;
    }

    /**
     * Sets the value of the messageSubstring property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessageSubstring(JAXBElement<String> value) {
        this.messageSubstring = value;
    }

}
