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
 * Corresponds to LDAPRealmMBean
 *  (Interface=weblogic.management.configuration.LDAPRealmMBean)
 * 
 * <p>Java class for ldap-realmType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ldap-realmType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}basic-realmType">
 *       &lt;sequence>
 *         &lt;element name="ldapurl" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="principal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="credential-encrypted" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="ssl-enable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="ldap-provider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="auth-protocol" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="none"/>
 *               &lt;enumeration value="simple"/>
 *               &lt;enumeration value="CRAM-MD5"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="user-authentication" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="bind"/>
 *               &lt;enumeration value="external"/>
 *               &lt;enumeration value="local"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="user-password-attribute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="user-dn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="user-name-attribute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="group-dn" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="group-name-attribute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="group-is-context" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="group-username-attribute" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ldap-realmType", propOrder = {
    "ldapurl",
    "principal",
    "credentialEncrypted",
    "sslEnable",
    "ldapProvider",
    "authProtocol",
    "userAuthentication",
    "userPasswordAttribute",
    "userDn",
    "userNameAttribute",
    "groupDn",
    "groupNameAttribute",
    "groupIsContext",
    "groupUsernameAttribute"
})
public class LdapRealmType
    extends BasicRealmType
{

    @XmlElementRef(name = "ldapurl", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ldapurl;
    @XmlElementRef(name = "principal", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> principal;
    @XmlElementRef(name = "credential-encrypted", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> credentialEncrypted;
    @XmlElement(name = "ssl-enable", defaultValue = "false")
    protected Boolean sslEnable;
    @XmlElementRef(name = "ldap-provider", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> ldapProvider;
    @XmlElementRef(name = "auth-protocol", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> authProtocol;
    @XmlElementRef(name = "user-authentication", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userAuthentication;
    @XmlElementRef(name = "user-password-attribute", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userPasswordAttribute;
    @XmlElementRef(name = "user-dn", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userDn;
    @XmlElementRef(name = "user-name-attribute", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userNameAttribute;
    @XmlElementRef(name = "group-dn", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> groupDn;
    @XmlElementRef(name = "group-name-attribute", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> groupNameAttribute;
    @XmlElement(name = "group-is-context", defaultValue = "true")
    protected Boolean groupIsContext;
    @XmlElementRef(name = "group-username-attribute", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> groupUsernameAttribute;

    /**
     * Gets the value of the ldapurl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLdapurl() {
        return ldapurl;
    }

    /**
     * Sets the value of the ldapurl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLdapurl(JAXBElement<String> value) {
        this.ldapurl = value;
    }

    /**
     * Gets the value of the principal property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPrincipal() {
        return principal;
    }

    /**
     * Sets the value of the principal property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPrincipal(JAXBElement<String> value) {
        this.principal = value;
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
     * Gets the value of the sslEnable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSslEnable() {
        return sslEnable;
    }

    /**
     * Sets the value of the sslEnable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSslEnable(Boolean value) {
        this.sslEnable = value;
    }

    /**
     * Gets the value of the ldapProvider property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLdapProvider() {
        return ldapProvider;
    }

    /**
     * Sets the value of the ldapProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLdapProvider(JAXBElement<String> value) {
        this.ldapProvider = value;
    }

    /**
     * Gets the value of the authProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAuthProtocol() {
        return authProtocol;
    }

    /**
     * Sets the value of the authProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAuthProtocol(JAXBElement<String> value) {
        this.authProtocol = value;
    }

    /**
     * Gets the value of the userAuthentication property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserAuthentication() {
        return userAuthentication;
    }

    /**
     * Sets the value of the userAuthentication property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserAuthentication(JAXBElement<String> value) {
        this.userAuthentication = value;
    }

    /**
     * Gets the value of the userPasswordAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserPasswordAttribute() {
        return userPasswordAttribute;
    }

    /**
     * Sets the value of the userPasswordAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserPasswordAttribute(JAXBElement<String> value) {
        this.userPasswordAttribute = value;
    }

    /**
     * Gets the value of the userDn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserDn() {
        return userDn;
    }

    /**
     * Sets the value of the userDn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserDn(JAXBElement<String> value) {
        this.userDn = value;
    }

    /**
     * Gets the value of the userNameAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserNameAttribute() {
        return userNameAttribute;
    }

    /**
     * Sets the value of the userNameAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserNameAttribute(JAXBElement<String> value) {
        this.userNameAttribute = value;
    }

    /**
     * Gets the value of the groupDn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGroupDn() {
        return groupDn;
    }

    /**
     * Sets the value of the groupDn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGroupDn(JAXBElement<String> value) {
        this.groupDn = value;
    }

    /**
     * Gets the value of the groupNameAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGroupNameAttribute() {
        return groupNameAttribute;
    }

    /**
     * Sets the value of the groupNameAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGroupNameAttribute(JAXBElement<String> value) {
        this.groupNameAttribute = value;
    }

    /**
     * Gets the value of the groupIsContext property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isGroupIsContext() {
        return groupIsContext;
    }

    /**
     * Sets the value of the groupIsContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setGroupIsContext(Boolean value) {
        this.groupIsContext = value;
    }

    /**
     * Gets the value of the groupUsernameAttribute property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getGroupUsernameAttribute() {
        return groupUsernameAttribute;
    }

    /**
     * Sets the value of the groupUsernameAttribute property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setGroupUsernameAttribute(JAXBElement<String> value) {
        this.groupUsernameAttribute = value;
    }

}
