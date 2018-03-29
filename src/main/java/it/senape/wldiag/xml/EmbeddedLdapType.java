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
 * Corresponds to EmbeddedLDAPMBean
 *  (Interface=weblogic.management.configuration.EmbeddedLDAPMBean)
 * 
 * <p>Java class for embedded-ldapType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="embedded-ldapType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="credential-encrypted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="backup-hour" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="23"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="backup-minute" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="59"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="backup-copies" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="65534"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cache-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="cache-size" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="cache-ttl" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="refresh-replica-at-startup" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="master-first" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="timeout" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="anonymous-bind-allowed" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "embedded-ldapType", propOrder = {
    "credentialEncrypted",
    "backupHour",
    "backupMinute",
    "backupCopies",
    "cacheEnabled",
    "cacheSize",
    "cacheTtl",
    "refreshReplicaAtStartup",
    "masterFirst",
    "timeout",
    "anonymousBindAllowed"
})
public class EmbeddedLdapType
    extends ConfigurationType
{

    @XmlElementRef(name = "credential-encrypted", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> credentialEncrypted;
    @XmlElement(name = "backup-hour", defaultValue = "23")
    protected Integer backupHour;
    @XmlElement(name = "backup-minute", defaultValue = "5")
    protected Integer backupMinute;
    @XmlElement(name = "backup-copies", defaultValue = "7")
    protected Integer backupCopies;
    @XmlElement(name = "cache-enabled", defaultValue = "true")
    protected Boolean cacheEnabled;
    @XmlElement(name = "cache-size", defaultValue = "32")
    protected Integer cacheSize;
    @XmlElement(name = "cache-ttl", defaultValue = "60")
    protected Integer cacheTtl;
    @XmlElement(name = "refresh-replica-at-startup", defaultValue = "false")
    protected Boolean refreshReplicaAtStartup;
    @XmlElement(name = "master-first", defaultValue = "false")
    protected Boolean masterFirst;
    @XmlElement(defaultValue = "0")
    protected Integer timeout;
    @XmlElement(name = "anonymous-bind-allowed", defaultValue = "false")
    protected Boolean anonymousBindAllowed;

    /**
     * Gets the value of the credentialEncrypted property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCredentialEncrypted() {
        return credentialEncrypted;
    }

    /**
     * Sets the value of the credentialEncrypted property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCredentialEncrypted(JAXBElement<String> value) {
        this.credentialEncrypted = value;
    }

    /**
     * Gets the value of the backupHour property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBackupHour() {
        return backupHour;
    }

    /**
     * Sets the value of the backupHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBackupHour(Integer value) {
        this.backupHour = value;
    }

    /**
     * Gets the value of the backupMinute property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBackupMinute() {
        return backupMinute;
    }

    /**
     * Sets the value of the backupMinute property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBackupMinute(Integer value) {
        this.backupMinute = value;
    }

    /**
     * Gets the value of the backupCopies property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBackupCopies() {
        return backupCopies;
    }

    /**
     * Sets the value of the backupCopies property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBackupCopies(Integer value) {
        this.backupCopies = value;
    }

    /**
     * Gets the value of the cacheEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCacheEnabled() {
        return cacheEnabled;
    }

    /**
     * Sets the value of the cacheEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCacheEnabled(Boolean value) {
        this.cacheEnabled = value;
    }

    /**
     * Gets the value of the cacheSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCacheSize() {
        return cacheSize;
    }

    /**
     * Sets the value of the cacheSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCacheSize(Integer value) {
        this.cacheSize = value;
    }

    /**
     * Gets the value of the cacheTtl property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCacheTtl() {
        return cacheTtl;
    }

    /**
     * Sets the value of the cacheTtl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCacheTtl(Integer value) {
        this.cacheTtl = value;
    }

    /**
     * Gets the value of the refreshReplicaAtStartup property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isRefreshReplicaAtStartup() {
        return refreshReplicaAtStartup;
    }

    /**
     * Sets the value of the refreshReplicaAtStartup property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setRefreshReplicaAtStartup(Boolean value) {
        this.refreshReplicaAtStartup = value;
    }

    /**
     * Gets the value of the masterFirst property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isMasterFirst() {
        return masterFirst;
    }

    /**
     * Sets the value of the masterFirst property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setMasterFirst(Boolean value) {
        this.masterFirst = value;
    }

    /**
     * Gets the value of the timeout property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getTimeout() {
        return timeout;
    }

    /**
     * Sets the value of the timeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setTimeout(Integer value) {
        this.timeout = value;
    }

    /**
     * Gets the value of the anonymousBindAllowed property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnonymousBindAllowed() {
        return anonymousBindAllowed;
    }

    /**
     * Sets the value of the anonymousBindAllowed property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnonymousBindAllowed(Boolean value) {
        this.anonymousBindAllowed = value;
    }

}
