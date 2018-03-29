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
 * Corresponds to UnixMachineMBean
 *  (Interface=weblogic.management.configuration.UnixMachineMBean)
 * 
 * <p>Java class for unix-machineType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="unix-machineType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}machineType">
 *       &lt;sequence>
 *         &lt;element name="post-bind-uid-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="post-bind-uid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="post-bind-gid-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="post-bind-gid" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "unix-machineType", propOrder = {
    "postBindUidEnabled",
    "postBindUid",
    "postBindGidEnabled",
    "postBindGid"
})
public class UnixMachineType
    extends MachineType
{

    @XmlElement(name = "post-bind-uid-enabled", defaultValue = "false")
    protected Boolean postBindUidEnabled;
    @XmlElementRef(name = "post-bind-uid", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> postBindUid;
    @XmlElement(name = "post-bind-gid-enabled", defaultValue = "false")
    protected Boolean postBindGidEnabled;
    @XmlElementRef(name = "post-bind-gid", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> postBindGid;

    /**
     * Gets the value of the postBindUidEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPostBindUidEnabled() {
        return postBindUidEnabled;
    }

    /**
     * Sets the value of the postBindUidEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPostBindUidEnabled(Boolean value) {
        this.postBindUidEnabled = value;
    }

    /**
     * Gets the value of the postBindUid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPostBindUid() {
        return postBindUid;
    }

    /**
     * Sets the value of the postBindUid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPostBindUid(JAXBElement<String> value) {
        this.postBindUid = value;
    }

    /**
     * Gets the value of the postBindGidEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPostBindGidEnabled() {
        return postBindGidEnabled;
    }

    /**
     * Sets the value of the postBindGidEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPostBindGidEnabled(Boolean value) {
        this.postBindGidEnabled = value;
    }

    /**
     * Gets the value of the postBindGid property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getPostBindGid() {
        return postBindGid;
    }

    /**
     * Sets the value of the postBindGid property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setPostBindGid(JAXBElement<String> value) {
        this.postBindGid = value;
    }

}
