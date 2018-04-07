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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to WebServiceReliabilityMBean
 *  (Interface=weblogic.management.configuration.WebServiceReliabilityMBean)
 * 
 * <p>Java class for web-service-reliabilityType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="web-service-reliabilityType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="base-retransmission-interval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="retransmission-exponential-backoff" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="non-buffered-source" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="acknowledgement-interval" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inactivity-timeout" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sequence-expiration" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="non-buffered-destination" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "web-service-reliabilityType", propOrder = {
    "baseRetransmissionInterval",
    "retransmissionExponentialBackoff",
    "nonBufferedSource",
    "acknowledgementInterval",
    "inactivityTimeout",
    "sequenceExpiration",
    "nonBufferedDestination"
})
public class WebServiceReliabilityType
    extends ConfigurationType
{

    @XmlElementRef(name = "base-retransmission-interval", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> baseRetransmissionInterval;
    @XmlElementRef(name = "retransmission-exponential-backoff", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> retransmissionExponentialBackoff;
    @XmlElementRef(name = "non-buffered-source", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> nonBufferedSource;
    @XmlElementRef(name = "acknowledgement-interval", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> acknowledgementInterval;
    @XmlElementRef(name = "inactivity-timeout", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> inactivityTimeout;
    @XmlElementRef(name = "sequence-expiration", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sequenceExpiration;
    @XmlElementRef(name = "non-buffered-destination", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> nonBufferedDestination;

    /**
     * Gets the value of the baseRetransmissionInterval property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBaseRetransmissionInterval() {
        return baseRetransmissionInterval;
    }

    /**
     * Sets the value of the baseRetransmissionInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBaseRetransmissionInterval(JAXBElement<String> value) {
        this.baseRetransmissionInterval = value;
    }

    /**
     * Gets the value of the retransmissionExponentialBackoff property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getRetransmissionExponentialBackoff() {
        return retransmissionExponentialBackoff;
    }

    /**
     * Sets the value of the retransmissionExponentialBackoff property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setRetransmissionExponentialBackoff(JAXBElement<Boolean> value) {
        this.retransmissionExponentialBackoff = value;
    }

    /**
     * Gets the value of the nonBufferedSource property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getNonBufferedSource() {
        return nonBufferedSource;
    }

    /**
     * Sets the value of the nonBufferedSource property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setNonBufferedSource(JAXBElement<Boolean> value) {
        this.nonBufferedSource = value;
    }

    /**
     * Gets the value of the acknowledgementInterval property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAcknowledgementInterval() {
        return acknowledgementInterval;
    }

    /**
     * Sets the value of the acknowledgementInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAcknowledgementInterval(JAXBElement<String> value) {
        this.acknowledgementInterval = value;
    }

    /**
     * Gets the value of the inactivityTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInactivityTimeout() {
        return inactivityTimeout;
    }

    /**
     * Sets the value of the inactivityTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInactivityTimeout(JAXBElement<String> value) {
        this.inactivityTimeout = value;
    }

    /**
     * Gets the value of the sequenceExpiration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSequenceExpiration() {
        return sequenceExpiration;
    }

    /**
     * Sets the value of the sequenceExpiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSequenceExpiration(JAXBElement<String> value) {
        this.sequenceExpiration = value;
    }

    /**
     * Gets the value of the nonBufferedDestination property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getNonBufferedDestination() {
        return nonBufferedDestination;
    }

    /**
     * Sets the value of the nonBufferedDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setNonBufferedDestination(JAXBElement<Boolean> value) {
        this.nonBufferedDestination = value;
    }

}