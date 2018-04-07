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
 * Corresponds to AnyIdentityDomainAuthenticatorMBean
 *  (Interface=weblogic.management.security.authentication.AnyIdentityDomainAuthenticatorMBean)
 * 
 * <p>Java class for any-identity-domain-authenticatorType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="any-identity-domain-authenticatorType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/security}identity-domain-aware-providerType">
 *       &lt;sequence>
 *         &lt;element name="any-identity-domain-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "any-identity-domain-authenticatorType", namespace = "http://xmlns.oracle.com/weblogic/security", propOrder = {
    "anyIdentityDomainEnabled"
})
public class AnyIdentityDomainAuthenticatorType
    extends IdentityDomainAwareProviderType
{

    @XmlElement(name = "any-identity-domain-enabled", defaultValue = "false")
    protected Boolean anyIdentityDomainEnabled;

    /**
     * Gets the value of the anyIdentityDomainEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAnyIdentityDomainEnabled() {
        return anyIdentityDomainEnabled;
    }

    /**
     * Sets the value of the anyIdentityDomainEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAnyIdentityDomainEnabled(Boolean value) {
        this.anyIdentityDomainEnabled = value;
    }

}