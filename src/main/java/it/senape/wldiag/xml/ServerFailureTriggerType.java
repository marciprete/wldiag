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
 * Corresponds to ServerFailureTriggerMBean
 *  (Interface=weblogic.management.configuration.ServerFailureTriggerMBean)
 * 
 * <p>Java class for server-failure-triggerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="server-failure-triggerType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="max-stuck-thread-time" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="stuck-thread-count" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
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
@XmlType(name = "server-failure-triggerType", propOrder = {
    "maxStuckThreadTime",
    "stuckThreadCount"
})
public class ServerFailureTriggerType
    extends ConfigurationType
{

    @XmlElement(name = "max-stuck-thread-time", defaultValue = "600")
    protected Integer maxStuckThreadTime;
    @XmlElement(name = "stuck-thread-count", defaultValue = "0")
    protected Integer stuckThreadCount;

    /**
     * Gets the value of the maxStuckThreadTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxStuckThreadTime() {
        return maxStuckThreadTime;
    }

    /**
     * Sets the value of the maxStuckThreadTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxStuckThreadTime(Integer value) {
        this.maxStuckThreadTime = value;
    }

    /**
     * Gets the value of the stuckThreadCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStuckThreadCount() {
        return stuckThreadCount;
    }

    /**
     * Sets the value of the stuckThreadCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStuckThreadCount(Integer value) {
        this.stuckThreadCount = value;
    }

}
