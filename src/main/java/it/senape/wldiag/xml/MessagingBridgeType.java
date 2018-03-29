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
 * Corresponds to MessagingBridgeMBean
 *  (Interface=weblogic.management.configuration.MessagingBridgeMBean)
 * 
 * <p>Java class for messaging-bridgeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="messaging-bridgeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}deploymentType">
 *       &lt;sequence>
 *         &lt;element name="source-destination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="target-destination" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="selector" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="quality-of-service" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Exactly-once"/>
 *               &lt;enumeration value="Atmost-once"/>
 *               &lt;enumeration value="Duplicate-okay"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="qos-degradation-allowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="durability-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="reconnect-delay-minimum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="reconnect-delay-increase" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="reconnect-delay-maximum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="idle-time-maximum" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="transaction-timeout" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="async-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="started" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="batch-size" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="batch-interval" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="preserve-msg-property" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "messaging-bridgeType", propOrder = {
    "sourceDestination",
    "targetDestination",
    "selector",
    "qualityOfService",
    "qosDegradationAllowed",
    "durabilityEnabled",
    "reconnectDelayMinimum",
    "reconnectDelayIncrease",
    "reconnectDelayMaximum",
    "idleTimeMaximum",
    "transactionTimeout",
    "asyncEnabled",
    "started",
    "batchSize",
    "batchInterval",
    "preserveMsgProperty"
})
public class MessagingBridgeType
    extends DeploymentType
{

    @XmlElementRef(name = "source-destination", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceDestination;
    @XmlElementRef(name = "target-destination", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> targetDestination;
    @XmlElementRef(name = "selector", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> selector;
    @XmlElementRef(name = "quality-of-service", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> qualityOfService;
    @XmlElement(name = "qos-degradation-allowed", defaultValue = "false")
    protected Boolean qosDegradationAllowed;
    @XmlElement(name = "durability-enabled", defaultValue = "true")
    protected Boolean durabilityEnabled;
    @XmlElement(name = "reconnect-delay-minimum", defaultValue = "15")
    protected Integer reconnectDelayMinimum;
    @XmlElement(name = "reconnect-delay-increase", defaultValue = "5")
    protected Integer reconnectDelayIncrease;
    @XmlElement(name = "reconnect-delay-maximum", defaultValue = "60")
    protected Integer reconnectDelayMaximum;
    @XmlElement(name = "idle-time-maximum", defaultValue = "60")
    protected Integer idleTimeMaximum;
    @XmlElement(name = "transaction-timeout", defaultValue = "30")
    protected Integer transactionTimeout;
    @XmlElement(name = "async-enabled", defaultValue = "true")
    protected Boolean asyncEnabled;
    @XmlElement(defaultValue = "true")
    protected Boolean started;
    @XmlElement(name = "batch-size", defaultValue = "10")
    protected Integer batchSize;
    @XmlElement(name = "batch-interval", defaultValue = "-1")
    protected Long batchInterval;
    @XmlElement(name = "preserve-msg-property", defaultValue = "false")
    protected Boolean preserveMsgProperty;

    /**
     * Gets the value of the sourceDestination property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceDestination() {
        return sourceDestination;
    }

    /**
     * Sets the value of the sourceDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceDestination(JAXBElement<String> value) {
        this.sourceDestination = value;
    }

    /**
     * Gets the value of the targetDestination property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTargetDestination() {
        return targetDestination;
    }

    /**
     * Sets the value of the targetDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTargetDestination(JAXBElement<String> value) {
        this.targetDestination = value;
    }

    /**
     * Gets the value of the selector property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSelector() {
        return selector;
    }

    /**
     * Sets the value of the selector property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSelector(JAXBElement<String> value) {
        this.selector = value;
    }

    /**
     * Gets the value of the qualityOfService property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getQualityOfService() {
        return qualityOfService;
    }

    /**
     * Sets the value of the qualityOfService property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setQualityOfService(JAXBElement<String> value) {
        this.qualityOfService = value;
    }

    /**
     * Gets the value of the qosDegradationAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isQosDegradationAllowed() {
        return qosDegradationAllowed;
    }

    /**
     * Sets the value of the qosDegradationAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setQosDegradationAllowed(Boolean value) {
        this.qosDegradationAllowed = value;
    }

    /**
     * Gets the value of the durabilityEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDurabilityEnabled() {
        return durabilityEnabled;
    }

    /**
     * Sets the value of the durabilityEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDurabilityEnabled(Boolean value) {
        this.durabilityEnabled = value;
    }

    /**
     * Gets the value of the reconnectDelayMinimum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReconnectDelayMinimum() {
        return reconnectDelayMinimum;
    }

    /**
     * Sets the value of the reconnectDelayMinimum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReconnectDelayMinimum(Integer value) {
        this.reconnectDelayMinimum = value;
    }

    /**
     * Gets the value of the reconnectDelayIncrease property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReconnectDelayIncrease() {
        return reconnectDelayIncrease;
    }

    /**
     * Sets the value of the reconnectDelayIncrease property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReconnectDelayIncrease(Integer value) {
        this.reconnectDelayIncrease = value;
    }

    /**
     * Gets the value of the reconnectDelayMaximum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getReconnectDelayMaximum() {
        return reconnectDelayMaximum;
    }

    /**
     * Sets the value of the reconnectDelayMaximum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setReconnectDelayMaximum(Integer value) {
        this.reconnectDelayMaximum = value;
    }

    /**
     * Gets the value of the idleTimeMaximum property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdleTimeMaximum() {
        return idleTimeMaximum;
    }

    /**
     * Sets the value of the idleTimeMaximum property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdleTimeMaximum(Integer value) {
        this.idleTimeMaximum = value;
    }

    /**
     * Gets the value of the transactionTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTransactionTimeout() {
        return transactionTimeout;
    }

    /**
     * Sets the value of the transactionTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTransactionTimeout(Integer value) {
        this.transactionTimeout = value;
    }

    /**
     * Gets the value of the asyncEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAsyncEnabled() {
        return asyncEnabled;
    }

    /**
     * Sets the value of the asyncEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAsyncEnabled(Boolean value) {
        this.asyncEnabled = value;
    }

    /**
     * Gets the value of the started property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStarted() {
        return started;
    }

    /**
     * Sets the value of the started property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStarted(Boolean value) {
        this.started = value;
    }

    /**
     * Gets the value of the batchSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBatchSize() {
        return batchSize;
    }

    /**
     * Sets the value of the batchSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBatchSize(Integer value) {
        this.batchSize = value;
    }

    /**
     * Gets the value of the batchInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBatchInterval() {
        return batchInterval;
    }

    /**
     * Sets the value of the batchInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBatchInterval(Long value) {
        this.batchInterval = value;
    }

    /**
     * Gets the value of the preserveMsgProperty property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPreserveMsgProperty() {
        return preserveMsgProperty;
    }

    /**
     * Sets the value of the preserveMsgProperty property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPreserveMsgProperty(Boolean value) {
        this.preserveMsgProperty = value;
    }

}
