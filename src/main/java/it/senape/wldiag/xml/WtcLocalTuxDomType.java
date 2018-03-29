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
 * Corresponds to WTCLocalTuxDomMBean
 *  (Interface=weblogic.management.configuration.WTCLocalTuxDomMBean)
 * 
 * <p>Java class for wtc-local-tux-domType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wtc-local-tux-domType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="access-point" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="access-point-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="security" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="NONE"/>
 *               &lt;enumeration value="APP_PW"/>
 *               &lt;enumeration value="DM_PW"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="connection-policy" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="ON_DEMAND"/>
 *               &lt;enumeration value="ON_STARTUP"/>
 *               &lt;enumeration value="INCOMING_ONLY"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="conn-principal-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="retry-interval" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="max-retries" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="9223372036854775807"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="block-time" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="nw-addr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cmp-limit" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="min-encrypt-bits" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="40"/>
 *               &lt;enumeration value="56"/>
 *               &lt;enumeration value="128"/>
 *               &lt;enumeration value="256"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="max-encrypt-bits" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="40"/>
 *               &lt;enumeration value="56"/>
 *               &lt;enumeration value="128"/>
 *               &lt;enumeration value="256"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="interoperate" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Yes"/>
 *               &lt;enumeration value="No"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="keep-alive" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="keep-alive-wait" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *               &lt;maxInclusive value="2147483647"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="use-ssl" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Off"/>
 *               &lt;enumeration value="TwoWay"/>
 *               &lt;enumeration value="OneWay"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="key-stores-location" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="WLS Stores"/>
 *               &lt;enumeration value="Custom Stores"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="identity-key-store-file-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="identity-key-store-pass-phrase-encrypted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="private-key-alias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="private-key-pass-phrase-encrypted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trust-key-store-file-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="trust-key-store-pass-phrase-encrypted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wtc-local-tux-domType", propOrder = {
    "accessPoint",
    "accessPointId",
    "security",
    "connectionPolicy",
    "connPrincipalName",
    "retryInterval",
    "maxRetries",
    "blockTime",
    "nwAddr",
    "cmpLimit",
    "minEncryptBits",
    "maxEncryptBits",
    "interoperate",
    "keepAlive",
    "keepAliveWait",
    "useSsl",
    "keyStoresLocation",
    "identityKeyStoreFileName",
    "identityKeyStorePassPhraseEncrypted",
    "privateKeyAlias",
    "privateKeyPassPhraseEncrypted",
    "trustKeyStoreFileName",
    "trustKeyStorePassPhraseEncrypted"
})
public class WtcLocalTuxDomType
    extends ConfigurationType
{

    @XmlElement(name = "access-point", defaultValue = "myLAP")
    protected String accessPoint;
    @XmlElement(name = "access-point-id", defaultValue = "myLAPId")
    protected String accessPointId;
    @XmlElementRef(name = "security", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> security;
    @XmlElementRef(name = "connection-policy", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> connectionPolicy;
    @XmlElementRef(name = "conn-principal-name", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> connPrincipalName;
    @XmlElement(name = "retry-interval", defaultValue = "60")
    protected Integer retryInterval;
    @XmlElement(name = "max-retries", defaultValue = "9223372036854775807")
    protected Long maxRetries;
    @XmlElement(name = "block-time", defaultValue = "60")
    protected Integer blockTime;
    @XmlElementRef(name = "nw-addr", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nwAddr;
    @XmlElement(name = "cmp-limit", defaultValue = "2147483647")
    protected Integer cmpLimit;
    @XmlElementRef(name = "min-encrypt-bits", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> minEncryptBits;
    @XmlElementRef(name = "max-encrypt-bits", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> maxEncryptBits;
    @XmlElementRef(name = "interoperate", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> interoperate;
    @XmlElement(name = "keep-alive", defaultValue = "0")
    protected Integer keepAlive;
    @XmlElement(name = "keep-alive-wait", defaultValue = "0")
    protected Integer keepAliveWait;
    @XmlElementRef(name = "use-ssl", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> useSsl;
    @XmlElementRef(name = "key-stores-location", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> keyStoresLocation;
    @XmlElementRef(name = "identity-key-store-file-name", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> identityKeyStoreFileName;
    @XmlElementRef(name = "identity-key-store-pass-phrase-encrypted", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> identityKeyStorePassPhraseEncrypted;
    @XmlElementRef(name = "private-key-alias", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> privateKeyAlias;
    @XmlElementRef(name = "private-key-pass-phrase-encrypted", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> privateKeyPassPhraseEncrypted;
    @XmlElementRef(name = "trust-key-store-file-name", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> trustKeyStoreFileName;
    @XmlElementRef(name = "trust-key-store-pass-phrase-encrypted", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> trustKeyStorePassPhraseEncrypted;

    /**
     * Gets the value of the accessPoint property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessPoint() {
        return accessPoint;
    }

    /**
     * Sets the value of the accessPoint property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessPoint(String value) {
        this.accessPoint = value;
    }

    /**
     * Gets the value of the accessPointId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessPointId() {
        return accessPointId;
    }

    /**
     * Sets the value of the accessPointId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessPointId(String value) {
        this.accessPointId = value;
    }

    /**
     * Gets the value of the security property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSecurity() {
        return security;
    }

    /**
     * Sets the value of the security property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSecurity(JAXBElement<String> value) {
        this.security = value;
    }

    /**
     * Gets the value of the connectionPolicy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConnectionPolicy() {
        return connectionPolicy;
    }

    /**
     * Sets the value of the connectionPolicy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConnectionPolicy(JAXBElement<String> value) {
        this.connectionPolicy = value;
    }

    /**
     * Gets the value of the connPrincipalName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConnPrincipalName() {
        return connPrincipalName;
    }

    /**
     * Sets the value of the connPrincipalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConnPrincipalName(JAXBElement<String> value) {
        this.connPrincipalName = value;
    }

    /**
     * Gets the value of the retryInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRetryInterval() {
        return retryInterval;
    }

    /**
     * Sets the value of the retryInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRetryInterval(Integer value) {
        this.retryInterval = value;
    }

    /**
     * Gets the value of the maxRetries property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getMaxRetries() {
        return maxRetries;
    }

    /**
     * Sets the value of the maxRetries property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setMaxRetries(Long value) {
        this.maxRetries = value;
    }

    /**
     * Gets the value of the blockTime property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getBlockTime() {
        return blockTime;
    }

    /**
     * Sets the value of the blockTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setBlockTime(Integer value) {
        this.blockTime = value;
    }

    /**
     * Gets the value of the nwAddr property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNwAddr() {
        return nwAddr;
    }

    /**
     * Sets the value of the nwAddr property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNwAddr(JAXBElement<String> value) {
        this.nwAddr = value;
    }

    /**
     * Gets the value of the cmpLimit property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getCmpLimit() {
        return cmpLimit;
    }

    /**
     * Sets the value of the cmpLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setCmpLimit(Integer value) {
        this.cmpLimit = value;
    }

    /**
     * Gets the value of the minEncryptBits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMinEncryptBits() {
        return minEncryptBits;
    }

    /**
     * Sets the value of the minEncryptBits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMinEncryptBits(JAXBElement<String> value) {
        this.minEncryptBits = value;
    }

    /**
     * Gets the value of the maxEncryptBits property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMaxEncryptBits() {
        return maxEncryptBits;
    }

    /**
     * Sets the value of the maxEncryptBits property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMaxEncryptBits(JAXBElement<String> value) {
        this.maxEncryptBits = value;
    }

    /**
     * Gets the value of the interoperate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getInteroperate() {
        return interoperate;
    }

    /**
     * Sets the value of the interoperate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setInteroperate(JAXBElement<String> value) {
        this.interoperate = value;
    }

    /**
     * Gets the value of the keepAlive property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKeepAlive() {
        return keepAlive;
    }

    /**
     * Sets the value of the keepAlive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKeepAlive(Integer value) {
        this.keepAlive = value;
    }

    /**
     * Gets the value of the keepAliveWait property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getKeepAliveWait() {
        return keepAliveWait;
    }

    /**
     * Sets the value of the keepAliveWait property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setKeepAliveWait(Integer value) {
        this.keepAliveWait = value;
    }

    /**
     * Gets the value of the useSsl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUseSsl() {
        return useSsl;
    }

    /**
     * Sets the value of the useSsl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUseSsl(JAXBElement<String> value) {
        this.useSsl = value;
    }

    /**
     * Gets the value of the keyStoresLocation property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getKeyStoresLocation() {
        return keyStoresLocation;
    }

    /**
     * Sets the value of the keyStoresLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setKeyStoresLocation(JAXBElement<String> value) {
        this.keyStoresLocation = value;
    }

    /**
     * Gets the value of the identityKeyStoreFileName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdentityKeyStoreFileName() {
        return identityKeyStoreFileName;
    }

    /**
     * Sets the value of the identityKeyStoreFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdentityKeyStoreFileName(JAXBElement<String> value) {
        this.identityKeyStoreFileName = value;
    }

    /**
     * Gets the value of the identityKeyStorePassPhraseEncrypted property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIdentityKeyStorePassPhraseEncrypted() {
        return identityKeyStorePassPhraseEncrypted;
    }

    /**
     * Sets the value of the identityKeyStorePassPhraseEncrypted property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIdentityKeyStorePassPhraseEncrypted(JAXBElement<String> value) {
        this.identityKeyStorePassPhraseEncrypted = value;
    }

    /**
     * Gets the value of the privateKeyAlias property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrivateKeyAlias() {
        return privateKeyAlias;
    }

    /**
     * Sets the value of the privateKeyAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrivateKeyAlias(JAXBElement<String> value) {
        this.privateKeyAlias = value;
    }

    /**
     * Gets the value of the privateKeyPassPhraseEncrypted property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrivateKeyPassPhraseEncrypted() {
        return privateKeyPassPhraseEncrypted;
    }

    /**
     * Sets the value of the privateKeyPassPhraseEncrypted property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrivateKeyPassPhraseEncrypted(JAXBElement<String> value) {
        this.privateKeyPassPhraseEncrypted = value;
    }

    /**
     * Gets the value of the trustKeyStoreFileName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrustKeyStoreFileName() {
        return trustKeyStoreFileName;
    }

    /**
     * Sets the value of the trustKeyStoreFileName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrustKeyStoreFileName(JAXBElement<String> value) {
        this.trustKeyStoreFileName = value;
    }

    /**
     * Gets the value of the trustKeyStorePassPhraseEncrypted property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTrustKeyStorePassPhraseEncrypted() {
        return trustKeyStorePassPhraseEncrypted;
    }

    /**
     * Sets the value of the trustKeyStorePassPhraseEncrypted property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTrustKeyStorePassPhraseEncrypted(JAXBElement<String> value) {
        this.trustKeyStorePassPhraseEncrypted = value;
    }

}
