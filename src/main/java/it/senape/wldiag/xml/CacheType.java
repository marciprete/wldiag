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
 * Corresponds to CacheMBean
 *  (Interface=weblogic.management.configuration.CacheMBean)
 * 
 * <p>Java class for cacheType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="cacheType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}deploymentType">
 *       &lt;sequence>
 *         &lt;element name="jndi-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="max-cache-units" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="expiration" type="{http://xmlns.oracle.com/weblogic/domain}cache-expirationType" minOccurs="0"/>
 *         &lt;element name="eviction-policy" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="LRU"/>
 *               &lt;enumeration value="NRU"/>
 *               &lt;enumeration value="FIFO"/>
 *               &lt;enumeration value="LFU"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="work-manager" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="loader" type="{http://xmlns.oracle.com/weblogic/domain}cache-loaderType" minOccurs="0"/>
 *         &lt;element name="store" type="{http://xmlns.oracle.com/weblogic/domain}cache-storeType" minOccurs="0"/>
 *         &lt;element name="transactional" type="{http://xmlns.oracle.com/weblogic/domain}cache-transactionType" minOccurs="0"/>
 *         &lt;element name="async-listeners" type="{http://xmlns.oracle.com/weblogic/domain}cache-async-listenersType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "cacheType", propOrder = {
    "jndiName",
    "maxCacheUnits",
    "expiration",
    "evictionPolicy",
    "workManager",
    "loader",
    "store",
    "transactional",
    "asyncListeners"
})
public class CacheType
    extends DeploymentType
{

    @XmlElement(name = "jndi-name")
    protected String jndiName;
    @XmlElement(name = "max-cache-units", defaultValue = "64")
    protected Integer maxCacheUnits;
    @XmlElementRef(name = "expiration", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<CacheExpirationType> expiration;
    @XmlElementRef(name = "eviction-policy", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> evictionPolicy;
    @XmlElementRef(name = "work-manager", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> workManager;
    @XmlElementRef(name = "loader", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<CacheLoaderType> loader;
    @XmlElementRef(name = "store", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<CacheStoreType> store;
    @XmlElementRef(name = "transactional", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<CacheTransactionType> transactional;
    @XmlElementRef(name = "async-listeners", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<CacheAsyncListenersType> asyncListeners;

    /**
     * Gets the value of the jndiName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJndiName() {
        return jndiName;
    }

    /**
     * Sets the value of the jndiName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJndiName(String value) {
        this.jndiName = value;
    }

    /**
     * Gets the value of the maxCacheUnits property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxCacheUnits() {
        return maxCacheUnits;
    }

    /**
     * Sets the value of the maxCacheUnits property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxCacheUnits(Integer value) {
        this.maxCacheUnits = value;
    }

    /**
     * Gets the value of the expiration property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CacheExpirationType }{@code >}
     *     
     */
    public JAXBElement<CacheExpirationType> getExpiration() {
        return expiration;
    }

    /**
     * Sets the value of the expiration property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CacheExpirationType }{@code >}
     *     
     */
    public void setExpiration(JAXBElement<CacheExpirationType> value) {
        this.expiration = value;
    }

    /**
     * Gets the value of the evictionPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getEvictionPolicy() {
        return evictionPolicy;
    }

    /**
     * Sets the value of the evictionPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setEvictionPolicy(JAXBElement<String> value) {
        this.evictionPolicy = value;
    }

    /**
     * Gets the value of the workManager property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWorkManager() {
        return workManager;
    }

    /**
     * Sets the value of the workManager property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWorkManager(JAXBElement<String> value) {
        this.workManager = value;
    }

    /**
     * Gets the value of the loader property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CacheLoaderType }{@code >}
     *     
     */
    public JAXBElement<CacheLoaderType> getLoader() {
        return loader;
    }

    /**
     * Sets the value of the loader property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CacheLoaderType }{@code >}
     *     
     */
    public void setLoader(JAXBElement<CacheLoaderType> value) {
        this.loader = value;
    }

    /**
     * Gets the value of the store property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CacheStoreType }{@code >}
     *     
     */
    public JAXBElement<CacheStoreType> getStore() {
        return store;
    }

    /**
     * Sets the value of the store property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CacheStoreType }{@code >}
     *     
     */
    public void setStore(JAXBElement<CacheStoreType> value) {
        this.store = value;
    }

    /**
     * Gets the value of the transactional property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CacheTransactionType }{@code >}
     *     
     */
    public JAXBElement<CacheTransactionType> getTransactional() {
        return transactional;
    }

    /**
     * Sets the value of the transactional property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CacheTransactionType }{@code >}
     *     
     */
    public void setTransactional(JAXBElement<CacheTransactionType> value) {
        this.transactional = value;
    }

    /**
     * Gets the value of the asyncListeners property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link CacheAsyncListenersType }{@code >}
     *     
     */
    public JAXBElement<CacheAsyncListenersType> getAsyncListeners() {
        return asyncListeners;
    }

    /**
     * Sets the value of the asyncListeners property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link CacheAsyncListenersType }{@code >}
     *     
     */
    public void setAsyncListeners(JAXBElement<CacheAsyncListenersType> value) {
        this.asyncListeners = value;
    }

}
