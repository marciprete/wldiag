//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.17 at 03:40:53 PM CET 
//


package it.senape.wldiag.xml;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to IdentityAsserterMBean
 *  (Interface=weblogic.management.security.authentication.IdentityAsserterMBean)
 * 
 * <p>Java class for identity-asserterType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="identity-asserterType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/security}authentication-providerType">
 *       &lt;sequence>
 *         &lt;element name="active-type" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="base64-decoding-required" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "identity-asserterType", namespace = "http://xmlns.oracle.com/weblogic/security", propOrder = {
    "activeType",
    "base64DecodingRequired"
})
public class IdentityAsserterType
    extends AuthenticationProviderType
{

    @XmlElement(name = "active-type", nillable = true)
    protected List<String> activeType;
    @XmlElement(name = "base64-decoding-required", defaultValue = "true")
    protected Boolean base64DecodingRequired;

    /**
     * Gets the value of the activeType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the activeType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getActiveType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getActiveType() {
        if (activeType == null) {
            activeType = new ArrayList<String>();
        }
        return this.activeType;
    }

    /**
     * Gets the value of the base64DecodingRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isBase64DecodingRequired() {
        return base64DecodingRequired;
    }

    /**
     * Sets the value of the base64DecodingRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setBase64DecodingRequired(Boolean value) {
        this.base64DecodingRequired = value;
    }

}
