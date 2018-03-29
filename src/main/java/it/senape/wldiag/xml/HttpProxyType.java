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
 * Corresponds to HTTPProxyMBean
 *  (Interface=weblogic.management.configuration.HTTPProxyMBean)
 * 
 * <p>Java class for http-proxyType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="http-proxyType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}deploymentType">
 *       &lt;sequence>
 *         &lt;element name="initial-connections" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="65535"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="max-connections" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="65535"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="server-list" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="health-check-interval" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="300"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="max-retries" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="max-health-check-interval" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "http-proxyType", propOrder = {
    "initialConnections",
    "maxConnections",
    "serverList",
    "healthCheckInterval",
    "maxRetries",
    "maxHealthCheckInterval"
})
public class HttpProxyType
    extends DeploymentType
{

    @XmlElement(name = "initial-connections")
    protected Integer initialConnections;
    @XmlElement(name = "max-connections", defaultValue = "100")
    protected Integer maxConnections;
    @XmlElementRef(name = "server-list", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> serverList;
    @XmlElement(name = "health-check-interval", defaultValue = "5")
    protected Integer healthCheckInterval;
    @XmlElement(name = "max-retries", defaultValue = "3")
    protected Integer maxRetries;
    @XmlElement(name = "max-health-check-interval", defaultValue = "60")
    protected Integer maxHealthCheckInterval;

    /**
     * Gets the value of the initialConnections property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInitialConnections() {
        return initialConnections;
    }

    /**
     * Sets the value of the initialConnections property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInitialConnections(Integer value) {
        this.initialConnections = value;
    }

    /**
     * Gets the value of the maxConnections property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxConnections() {
        return maxConnections;
    }

    /**
     * Sets the value of the maxConnections property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxConnections(Integer value) {
        this.maxConnections = value;
    }

    /**
     * Gets the value of the serverList property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getServerList() {
        return serverList;
    }

    /**
     * Sets the value of the serverList property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setServerList(JAXBElement<String> value) {
        this.serverList = value;
    }

    /**
     * Gets the value of the healthCheckInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getHealthCheckInterval() {
        return healthCheckInterval;
    }

    /**
     * Sets the value of the healthCheckInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setHealthCheckInterval(Integer value) {
        this.healthCheckInterval = value;
    }

    /**
     * Gets the value of the maxRetries property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxRetries() {
        return maxRetries;
    }

    /**
     * Sets the value of the maxRetries property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxRetries(Integer value) {
        this.maxRetries = value;
    }

    /**
     * Gets the value of the maxHealthCheckInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxHealthCheckInterval() {
        return maxHealthCheckInterval;
    }

    /**
     * Sets the value of the maxHealthCheckInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxHealthCheckInterval(Integer value) {
        this.maxHealthCheckInterval = value;
    }

}
