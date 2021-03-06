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
 * Corresponds to CacheStoreMBean
 *  (Interface=weblogic.management.configuration.CacheStoreMBean)
 * 
 * <p>Java class for cache-storeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cache-storeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="custom-store" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="write-policy" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="None"/>
 *               &lt;enumeration value="WriteThrough"/>
 *               &lt;enumeration value="WriteBehind"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="work-manager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="buffer-max-size" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="buffer-write-timeout" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="buffer-write-attempts" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="store-batch-size" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
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
@XmlType(name = "cache-storeType", propOrder = {
    "customStore",
    "writePolicy",
    "workManager",
    "bufferMaxSize",
    "bufferWriteTimeout",
    "bufferWriteAttempts",
    "storeBatchSize"
})
public class CacheStoreType
    extends ConfigurationType
{

    @XmlElementRef(name = "custom-store", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> customStore;
    @XmlElementRef(name = "write-policy", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> writePolicy;
    @XmlElement(name = "work-manager")
    protected String workManager;
    @XmlElement(name = "buffer-max-size", defaultValue = "100")
    protected Integer bufferMaxSize;
    @XmlElement(name = "buffer-write-timeout")
    protected Long bufferWriteTimeout;
    @XmlElement(name = "buffer-write-attempts", defaultValue = "1")
    protected Integer bufferWriteAttempts;
    @XmlElement(name = "store-batch-size", defaultValue = "1")
    protected Integer storeBatchSize;

    /**
     * Gets the value of the customStore property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomStore() {
        return customStore;
    }

    /**
     * Sets the value of the customStore property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomStore(JAXBElement<String> value) {
        this.customStore = value;
    }

    /**
     * Gets the value of the writePolicy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWritePolicy() {
        return writePolicy;
    }

    /**
     * Sets the value of the writePolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWritePolicy(JAXBElement<String> value) {
        this.writePolicy = value;
    }

    /**
     * Gets the value of the workManager property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkManager() {
        return workManager;
    }

    /**
     * Sets the value of the workManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkManager(String value) {
        this.workManager = value;
    }

    /**
     * Gets the value of the bufferMaxSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBufferMaxSize() {
        return bufferMaxSize;
    }

    /**
     * Sets the value of the bufferMaxSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBufferMaxSize(Integer value) {
        this.bufferMaxSize = value;
    }

    /**
     * Gets the value of the bufferWriteTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBufferWriteTimeout() {
        return bufferWriteTimeout;
    }

    /**
     * Sets the value of the bufferWriteTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBufferWriteTimeout(Long value) {
        this.bufferWriteTimeout = value;
    }

    /**
     * Gets the value of the bufferWriteAttempts property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBufferWriteAttempts() {
        return bufferWriteAttempts;
    }

    /**
     * Sets the value of the bufferWriteAttempts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBufferWriteAttempts(Integer value) {
        this.bufferWriteAttempts = value;
    }

    /**
     * Gets the value of the storeBatchSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStoreBatchSize() {
        return storeBatchSize;
    }

    /**
     * Sets the value of the storeBatchSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStoreBatchSize(Integer value) {
        this.storeBatchSize = value;
    }

}
