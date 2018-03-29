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
 * Corresponds to WSReliableDeliveryPolicyMBean
 *  (Interface=weblogic.management.configuration.WSReliableDeliveryPolicyMBean)
 * 
 * <p>Java class for ws-reliable-delivery-policyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ws-reliable-delivery-policyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="jms-server" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="default-retry-count" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="default-retry-interval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="default-time-to-live" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ws-reliable-delivery-policyType", propOrder = {
    "jmsServer",
    "defaultRetryCount",
    "defaultRetryInterval",
    "defaultTimeToLive"
})
public class WsReliableDeliveryPolicyType
    extends ConfigurationType
{

    @XmlElementRef(name = "jms-server", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> jmsServer;
    @XmlElement(name = "default-retry-count", defaultValue = "10")
    protected Integer defaultRetryCount;
    @XmlElement(name = "default-retry-interval", defaultValue = "6")
    protected Integer defaultRetryInterval;
    @XmlElement(name = "default-time-to-live", defaultValue = "360")
    protected Integer defaultTimeToLive;

    /**
     * Gets the value of the jmsServer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getJmsServer() {
        return jmsServer;
    }

    /**
     * Sets the value of the jmsServer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setJmsServer(JAXBElement<String> value) {
        this.jmsServer = value;
    }

    /**
     * Gets the value of the defaultRetryCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultRetryCount() {
        return defaultRetryCount;
    }

    /**
     * Sets the value of the defaultRetryCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultRetryCount(Integer value) {
        this.defaultRetryCount = value;
    }

    /**
     * Gets the value of the defaultRetryInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultRetryInterval() {
        return defaultRetryInterval;
    }

    /**
     * Sets the value of the defaultRetryInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultRetryInterval(Integer value) {
        this.defaultRetryInterval = value;
    }

    /**
     * Gets the value of the defaultTimeToLive property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDefaultTimeToLive() {
        return defaultTimeToLive;
    }

    /**
     * Sets the value of the defaultTimeToLive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDefaultTimeToLive(Integer value) {
        this.defaultTimeToLive = value;
    }

}
