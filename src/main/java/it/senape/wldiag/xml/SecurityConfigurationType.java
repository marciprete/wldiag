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
 * Corresponds to SecurityConfigurationMBean
 *  (Interface=weblogic.management.configuration.SecurityConfigurationMBean)
 * 
 * <p>Java class for security-configurationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="security-configurationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="realm" type="{http://xmlns.oracle.com/weblogic/security}realmType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="default-realm" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="anonymous-admin-lookup-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="clear-text-credential-access-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="credential-encrypted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="web-app-files-case-insensitive" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="os"/>
 *               &lt;enumeration value="true"/>
 *               &lt;enumeration value="false"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="realm-boot-strap-version" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="unknown"/>
 *               &lt;enumeration value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="connection-filter" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="connection-filter-rule" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="connection-logger-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="compatibility-connection-filters-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="node-manager-username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="node-manager-password-encrypted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="principal-equals-case-insensitive" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="principal-equals-compare-dn-and-guid" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="downgrade-untrusted-principals" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="enforce-strict-url-pattern" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="enforce-valid-basic-auth-credentials" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="console-full-delegation-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="default-realm-jpa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="excluded-domain-name" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cross-domain-security-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "security-configurationType", propOrder = {
    "realm",
    "defaultRealm",
    "anonymousAdminLookupEnabled",
    "clearTextCredentialAccessEnabled",
    "credentialEncrypted",
    "webAppFilesCaseInsensitive",
    "realmBootStrapVersion",
    "connectionFilter",
    "connectionFilterRule",
    "connectionLoggerEnabled",
    "compatibilityConnectionFiltersEnabled",
    "nodeManagerUsername",
    "nodeManagerPasswordEncrypted",
    "principalEqualsCaseInsensitive",
    "principalEqualsCompareDnAndGuid",
    "downgradeUntrustedPrincipals",
    "enforceStrictUrlPattern",
    "enforceValidBasicAuthCredentials",
    "consoleFullDelegationEnabled",
    "defaultRealmInternal",
    "excludedDomainName",
    "crossDomainSecurityEnabled"
})
public class SecurityConfigurationType
    extends ConfigurationType
{

    @XmlElement(nillable = true)
    protected List<RealmType> realm;
    @XmlElementRef(name = "default-realm", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultRealm;
    @XmlElement(name = "anonymous-admin-lookup-enabled", defaultValue = "false")
    protected Boolean anonymousAdminLookupEnabled;
    @XmlElement(name = "clear-text-credential-access-enabled", defaultValue = "false")
    protected Boolean clearTextCredentialAccessEnabled;
    @XmlElementRef(name = "credential-encrypted", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> credentialEncrypted;
    @XmlElementRef(name = "web-app-files-case-insensitive", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> webAppFilesCaseInsensitive;
    @XmlElementRef(name = "realm-boot-strap-version", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> realmBootStrapVersion;
    @XmlElementRef(name = "connection-filter", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> connectionFilter;
    @XmlElement(name = "connection-filter-rule", nillable = true)
    protected List<String> connectionFilterRule;
    @XmlElement(name = "connection-logger-enabled", defaultValue = "false")
    protected Boolean connectionLoggerEnabled;
    @XmlElement(name = "compatibility-connection-filters-enabled", defaultValue = "false")
    protected Boolean compatibilityConnectionFiltersEnabled;
    @XmlElementRef(name = "node-manager-username", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nodeManagerUsername;
    @XmlElementRef(name = "node-manager-password-encrypted", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nodeManagerPasswordEncrypted;
    @XmlElement(name = "principal-equals-case-insensitive", defaultValue = "false")
    protected Boolean principalEqualsCaseInsensitive;
    @XmlElement(name = "principal-equals-compare-dn-and-guid", defaultValue = "false")
    protected Boolean principalEqualsCompareDnAndGuid;
    @XmlElement(name = "downgrade-untrusted-principals", defaultValue = "false")
    protected Boolean downgradeUntrustedPrincipals;
    @XmlElement(name = "enforce-strict-url-pattern", defaultValue = "true")
    protected Boolean enforceStrictUrlPattern;
    @XmlElement(name = "enforce-valid-basic-auth-credentials", defaultValue = "true")
    protected Boolean enforceValidBasicAuthCredentials;
    @XmlElement(name = "console-full-delegation-enabled", defaultValue = "false")
    protected Boolean consoleFullDelegationEnabled;
    @XmlElementRef(name = "default-realm-jpa", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultRealmInternal;
    @XmlElement(name = "excluded-domain-name", nillable = true)
    protected List<String> excludedDomainName;
    @XmlElement(name = "cross-domain-security-enabled", defaultValue = "false")
    protected Boolean crossDomainSecurityEnabled;

    /**
     * Gets the value of the realm property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the realm property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRealm().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RealmType }
     * 
     * 
     */
    public List<RealmType> getRealm() {
        if (realm == null) {
            realm = new ArrayList<RealmType>();
        }
        return this.realm;
    }

    /**
     * Gets the value of the defaultRealm property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultRealm() {
        return defaultRealm;
    }

    /**
     * Sets the value of the defaultRealm property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultRealm(JAXBElement<String> value) {
        this.defaultRealm = value;
    }

    /**
     * Gets the value of the anonymousAdminLookupEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnonymousAdminLookupEnabled() {
        return anonymousAdminLookupEnabled;
    }

    /**
     * Sets the value of the anonymousAdminLookupEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnonymousAdminLookupEnabled(Boolean value) {
        this.anonymousAdminLookupEnabled = value;
    }

    /**
     * Gets the value of the clearTextCredentialAccessEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isClearTextCredentialAccessEnabled() {
        return clearTextCredentialAccessEnabled;
    }

    /**
     * Sets the value of the clearTextCredentialAccessEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setClearTextCredentialAccessEnabled(Boolean value) {
        this.clearTextCredentialAccessEnabled = value;
    }

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
     * Gets the value of the webAppFilesCaseInsensitive property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWebAppFilesCaseInsensitive() {
        return webAppFilesCaseInsensitive;
    }

    /**
     * Sets the value of the webAppFilesCaseInsensitive property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWebAppFilesCaseInsensitive(JAXBElement<String> value) {
        this.webAppFilesCaseInsensitive = value;
    }

    /**
     * Gets the value of the realmBootStrapVersion property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRealmBootStrapVersion() {
        return realmBootStrapVersion;
    }

    /**
     * Sets the value of the realmBootStrapVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRealmBootStrapVersion(JAXBElement<String> value) {
        this.realmBootStrapVersion = value;
    }

    /**
     * Gets the value of the connectionFilter property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getConnectionFilter() {
        return connectionFilter;
    }

    /**
     * Sets the value of the connectionFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setConnectionFilter(JAXBElement<String> value) {
        this.connectionFilter = value;
    }

    /**
     * Gets the value of the connectionFilterRule property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the connectionFilterRule property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getConnectionFilterRule().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getConnectionFilterRule() {
        if (connectionFilterRule == null) {
            connectionFilterRule = new ArrayList<String>();
        }
        return this.connectionFilterRule;
    }

    /**
     * Gets the value of the connectionLoggerEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConnectionLoggerEnabled() {
        return connectionLoggerEnabled;
    }

    /**
     * Sets the value of the connectionLoggerEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConnectionLoggerEnabled(Boolean value) {
        this.connectionLoggerEnabled = value;
    }

    /**
     * Gets the value of the compatibilityConnectionFiltersEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCompatibilityConnectionFiltersEnabled() {
        return compatibilityConnectionFiltersEnabled;
    }

    /**
     * Sets the value of the compatibilityConnectionFiltersEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCompatibilityConnectionFiltersEnabled(Boolean value) {
        this.compatibilityConnectionFiltersEnabled = value;
    }

    /**
     * Gets the value of the nodeManagerUsername property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNodeManagerUsername() {
        return nodeManagerUsername;
    }

    /**
     * Sets the value of the nodeManagerUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNodeManagerUsername(JAXBElement<String> value) {
        this.nodeManagerUsername = value;
    }

    /**
     * Gets the value of the nodeManagerPasswordEncrypted property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNodeManagerPasswordEncrypted() {
        return nodeManagerPasswordEncrypted;
    }

    /**
     * Sets the value of the nodeManagerPasswordEncrypted property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNodeManagerPasswordEncrypted(JAXBElement<String> value) {
        this.nodeManagerPasswordEncrypted = value;
    }

    /**
     * Gets the value of the principalEqualsCaseInsensitive property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPrincipalEqualsCaseInsensitive() {
        return principalEqualsCaseInsensitive;
    }

    /**
     * Sets the value of the principalEqualsCaseInsensitive property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrincipalEqualsCaseInsensitive(Boolean value) {
        this.principalEqualsCaseInsensitive = value;
    }

    /**
     * Gets the value of the principalEqualsCompareDnAndGuid property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPrincipalEqualsCompareDnAndGuid() {
        return principalEqualsCompareDnAndGuid;
    }

    /**
     * Sets the value of the principalEqualsCompareDnAndGuid property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPrincipalEqualsCompareDnAndGuid(Boolean value) {
        this.principalEqualsCompareDnAndGuid = value;
    }

    /**
     * Gets the value of the downgradeUntrustedPrincipals property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDowngradeUntrustedPrincipals() {
        return downgradeUntrustedPrincipals;
    }

    /**
     * Sets the value of the downgradeUntrustedPrincipals property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDowngradeUntrustedPrincipals(Boolean value) {
        this.downgradeUntrustedPrincipals = value;
    }

    /**
     * Gets the value of the enforceStrictUrlPattern property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnforceStrictUrlPattern() {
        return enforceStrictUrlPattern;
    }

    /**
     * Sets the value of the enforceStrictUrlPattern property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnforceStrictUrlPattern(Boolean value) {
        this.enforceStrictUrlPattern = value;
    }

    /**
     * Gets the value of the enforceValidBasicAuthCredentials property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnforceValidBasicAuthCredentials() {
        return enforceValidBasicAuthCredentials;
    }

    /**
     * Sets the value of the enforceValidBasicAuthCredentials property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnforceValidBasicAuthCredentials(Boolean value) {
        this.enforceValidBasicAuthCredentials = value;
    }

    /**
     * Gets the value of the consoleFullDelegationEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isConsoleFullDelegationEnabled() {
        return consoleFullDelegationEnabled;
    }

    /**
     * Sets the value of the consoleFullDelegationEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setConsoleFullDelegationEnabled(Boolean value) {
        this.consoleFullDelegationEnabled = value;
    }

    /**
     * Gets the value of the defaultRealmInternal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultRealmInternal() {
        return defaultRealmInternal;
    }

    /**
     * Sets the value of the defaultRealmInternal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultRealmInternal(JAXBElement<String> value) {
        this.defaultRealmInternal = value;
    }

    /**
     * Gets the value of the excludedDomainName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the excludedDomainName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getExcludedDomainName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getExcludedDomainName() {
        if (excludedDomainName == null) {
            excludedDomainName = new ArrayList<String>();
        }
        return this.excludedDomainName;
    }

    /**
     * Gets the value of the crossDomainSecurityEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCrossDomainSecurityEnabled() {
        return crossDomainSecurityEnabled;
    }

    /**
     * Sets the value of the crossDomainSecurityEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCrossDomainSecurityEnabled(Boolean value) {
        this.crossDomainSecurityEnabled = value;
    }

}
