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
 * Corresponds to FederationServicesMBean
 *  (Interface=weblogic.management.configuration.FederationServicesMBean)
 * 
 * <p>Java class for federation-servicesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="federation-servicesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="source-site-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="source-site-url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="intersite-transfer-uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="its-requires-ssl" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="assertion-retrieval-uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ars-requires-ssl" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ars-requires-two-way-ssl" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="assertion-store-class-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="assertion-store-properties" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signing-key-alias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="signing-key-pass-phrase-encrypted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destination-site-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="assertion-consumer-uri" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="acs-requires-ssl" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="post-recipient-check-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="post-one-use-check-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="used-assertion-cache-class-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="used-assertion-cache-properties" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssl-client-identity-alias" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssl-client-identity-pass-phrase-encrypted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "federation-servicesType", propOrder = {
    "sourceSiteEnabled",
    "sourceSiteUrl",
    "intersiteTransferUri",
    "itsRequiresSsl",
    "assertionRetrievalUri",
    "arsRequiresSsl",
    "arsRequiresTwoWaySsl",
    "assertionStoreClassName",
    "assertionStoreProperties",
    "signingKeyAlias",
    "signingKeyPassPhraseEncrypted",
    "destinationSiteEnabled",
    "assertionConsumerUri",
    "acsRequiresSsl",
    "postRecipientCheckEnabled",
    "postOneUseCheckEnabled",
    "usedAssertionCacheClassName",
    "usedAssertionCacheProperties",
    "sslClientIdentityAlias",
    "sslClientIdentityPassPhraseEncrypted"
})
public class FederationServicesType
    extends ConfigurationType
{

    @XmlElement(name = "source-site-enabled", defaultValue = "false")
    protected Boolean sourceSiteEnabled;
    @XmlElementRef(name = "source-site-url", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sourceSiteUrl;
    @XmlElement(name = "intersite-transfer-uri", nillable = true)
    protected List<String> intersiteTransferUri;
    @XmlElement(name = "its-requires-ssl", defaultValue = "true")
    protected Boolean itsRequiresSsl;
    @XmlElement(name = "assertion-retrieval-uri", nillable = true)
    protected List<String> assertionRetrievalUri;
    @XmlElement(name = "ars-requires-ssl", defaultValue = "true")
    protected Boolean arsRequiresSsl;
    @XmlElement(name = "ars-requires-two-way-ssl", defaultValue = "false")
    protected Boolean arsRequiresTwoWaySsl;
    @XmlElementRef(name = "assertion-store-class-name", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> assertionStoreClassName;
    @XmlElementRef(name = "assertion-store-properties", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> assertionStoreProperties;
    @XmlElementRef(name = "signing-key-alias", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> signingKeyAlias;
    @XmlElementRef(name = "signing-key-pass-phrase-encrypted", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> signingKeyPassPhraseEncrypted;
    @XmlElement(name = "destination-site-enabled", defaultValue = "false")
    protected Boolean destinationSiteEnabled;
    @XmlElement(name = "assertion-consumer-uri", nillable = true)
    protected List<String> assertionConsumerUri;
    @XmlElement(name = "acs-requires-ssl", defaultValue = "true")
    protected Boolean acsRequiresSsl;
    @XmlElement(name = "post-recipient-check-enabled", defaultValue = "true")
    protected Boolean postRecipientCheckEnabled;
    @XmlElement(name = "post-one-use-check-enabled", defaultValue = "true")
    protected Boolean postOneUseCheckEnabled;
    @XmlElementRef(name = "used-assertion-cache-class-name", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> usedAssertionCacheClassName;
    @XmlElementRef(name = "used-assertion-cache-properties", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> usedAssertionCacheProperties;
    @XmlElementRef(name = "ssl-client-identity-alias", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sslClientIdentityAlias;
    @XmlElementRef(name = "ssl-client-identity-pass-phrase-encrypted", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sslClientIdentityPassPhraseEncrypted;

    /**
     * Gets the value of the sourceSiteEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSourceSiteEnabled() {
        return sourceSiteEnabled;
    }

    /**
     * Sets the value of the sourceSiteEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSourceSiteEnabled(Boolean value) {
        this.sourceSiteEnabled = value;
    }

    /**
     * Gets the value of the sourceSiteUrl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSourceSiteUrl() {
        return sourceSiteUrl;
    }

    /**
     * Sets the value of the sourceSiteUrl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSourceSiteUrl(JAXBElement<String> value) {
        this.sourceSiteUrl = value;
    }

    /**
     * Gets the value of the intersiteTransferUri property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intersiteTransferUri property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntersiteTransferUri().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIntersiteTransferUri() {
        if (intersiteTransferUri == null) {
            intersiteTransferUri = new ArrayList<String>();
        }
        return this.intersiteTransferUri;
    }

    /**
     * Gets the value of the itsRequiresSsl property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isItsRequiresSsl() {
        return itsRequiresSsl;
    }

    /**
     * Sets the value of the itsRequiresSsl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setItsRequiresSsl(Boolean value) {
        this.itsRequiresSsl = value;
    }

    /**
     * Gets the value of the assertionRetrievalUri property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assertionRetrievalUri property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssertionRetrievalUri().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAssertionRetrievalUri() {
        if (assertionRetrievalUri == null) {
            assertionRetrievalUri = new ArrayList<String>();
        }
        return this.assertionRetrievalUri;
    }

    /**
     * Gets the value of the arsRequiresSsl property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isArsRequiresSsl() {
        return arsRequiresSsl;
    }

    /**
     * Sets the value of the arsRequiresSsl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setArsRequiresSsl(Boolean value) {
        this.arsRequiresSsl = value;
    }

    /**
     * Gets the value of the arsRequiresTwoWaySsl property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isArsRequiresTwoWaySsl() {
        return arsRequiresTwoWaySsl;
    }

    /**
     * Sets the value of the arsRequiresTwoWaySsl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setArsRequiresTwoWaySsl(Boolean value) {
        this.arsRequiresTwoWaySsl = value;
    }

    /**
     * Gets the value of the assertionStoreClassName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAssertionStoreClassName() {
        return assertionStoreClassName;
    }

    /**
     * Sets the value of the assertionStoreClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAssertionStoreClassName(JAXBElement<String> value) {
        this.assertionStoreClassName = value;
    }

    /**
     * Gets the value of the assertionStoreProperties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAssertionStoreProperties() {
        return assertionStoreProperties;
    }

    /**
     * Sets the value of the assertionStoreProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAssertionStoreProperties(JAXBElement<String> value) {
        this.assertionStoreProperties = value;
    }

    /**
     * Gets the value of the signingKeyAlias property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSigningKeyAlias() {
        return signingKeyAlias;
    }

    /**
     * Sets the value of the signingKeyAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSigningKeyAlias(JAXBElement<String> value) {
        this.signingKeyAlias = value;
    }

    /**
     * Gets the value of the signingKeyPassPhraseEncrypted property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSigningKeyPassPhraseEncrypted() {
        return signingKeyPassPhraseEncrypted;
    }

    /**
     * Sets the value of the signingKeyPassPhraseEncrypted property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSigningKeyPassPhraseEncrypted(JAXBElement<String> value) {
        this.signingKeyPassPhraseEncrypted = value;
    }

    /**
     * Gets the value of the destinationSiteEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDestinationSiteEnabled() {
        return destinationSiteEnabled;
    }

    /**
     * Sets the value of the destinationSiteEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDestinationSiteEnabled(Boolean value) {
        this.destinationSiteEnabled = value;
    }

    /**
     * Gets the value of the assertionConsumerUri property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the assertionConsumerUri property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAssertionConsumerUri().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAssertionConsumerUri() {
        if (assertionConsumerUri == null) {
            assertionConsumerUri = new ArrayList<String>();
        }
        return this.assertionConsumerUri;
    }

    /**
     * Gets the value of the acsRequiresSsl property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAcsRequiresSsl() {
        return acsRequiresSsl;
    }

    /**
     * Sets the value of the acsRequiresSsl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAcsRequiresSsl(Boolean value) {
        this.acsRequiresSsl = value;
    }

    /**
     * Gets the value of the postRecipientCheckEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPostRecipientCheckEnabled() {
        return postRecipientCheckEnabled;
    }

    /**
     * Sets the value of the postRecipientCheckEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPostRecipientCheckEnabled(Boolean value) {
        this.postRecipientCheckEnabled = value;
    }

    /**
     * Gets the value of the postOneUseCheckEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPostOneUseCheckEnabled() {
        return postOneUseCheckEnabled;
    }

    /**
     * Sets the value of the postOneUseCheckEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPostOneUseCheckEnabled(Boolean value) {
        this.postOneUseCheckEnabled = value;
    }

    /**
     * Gets the value of the usedAssertionCacheClassName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUsedAssertionCacheClassName() {
        return usedAssertionCacheClassName;
    }

    /**
     * Sets the value of the usedAssertionCacheClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUsedAssertionCacheClassName(JAXBElement<String> value) {
        this.usedAssertionCacheClassName = value;
    }

    /**
     * Gets the value of the usedAssertionCacheProperties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUsedAssertionCacheProperties() {
        return usedAssertionCacheProperties;
    }

    /**
     * Sets the value of the usedAssertionCacheProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUsedAssertionCacheProperties(JAXBElement<String> value) {
        this.usedAssertionCacheProperties = value;
    }

    /**
     * Gets the value of the sslClientIdentityAlias property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSslClientIdentityAlias() {
        return sslClientIdentityAlias;
    }

    /**
     * Sets the value of the sslClientIdentityAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSslClientIdentityAlias(JAXBElement<String> value) {
        this.sslClientIdentityAlias = value;
    }

    /**
     * Gets the value of the sslClientIdentityPassPhraseEncrypted property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSslClientIdentityPassPhraseEncrypted() {
        return sslClientIdentityPassPhraseEncrypted;
    }

    /**
     * Sets the value of the sslClientIdentityPassPhraseEncrypted property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSslClientIdentityPassPhraseEncrypted(JAXBElement<String> value) {
        this.sslClientIdentityPassPhraseEncrypted = value;
    }

}
