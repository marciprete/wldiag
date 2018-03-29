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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to GroupMembershipHierarchyCacheMBean
 *  (Interface=weblogic.management.security.authentication.GroupMembershipHierarchyCacheMBean)
 * 
 * <p>Java class for group-membership-hierarchy-cacheType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="group-membership-hierarchy-cacheType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="enable-group-membership-lookup-hierarchy-caching" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="max-group-hierarchies-in-cache" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="group-hierarchy-cache-ttl" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "group-membership-hierarchy-cacheType", namespace = "http://xmlns.oracle.com/weblogic/security", propOrder = {
    "enableGroupMembershipLookupHierarchyCaching",
    "maxGroupHierarchiesInCache",
    "groupHierarchyCacheTtl"
})
public class GroupMembershipHierarchyCacheType {

    @XmlElementRef(name = "enable-group-membership-lookup-hierarchy-caching", namespace = "http://xmlns.oracle.com/weblogic/security", type = JAXBElement.class, required = false)
    protected JAXBElement<Boolean> enableGroupMembershipLookupHierarchyCaching;
    @XmlElementRef(name = "max-group-hierarchies-in-cache", namespace = "http://xmlns.oracle.com/weblogic/security", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> maxGroupHierarchiesInCache;
    @XmlElementRef(name = "group-hierarchy-cache-ttl", namespace = "http://xmlns.oracle.com/weblogic/security", type = JAXBElement.class, required = false)
    protected JAXBElement<Integer> groupHierarchyCacheTtl;

    /**
     * Gets the value of the enableGroupMembershipLookupHierarchyCaching property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public JAXBElement<Boolean> getEnableGroupMembershipLookupHierarchyCaching() {
        return enableGroupMembershipLookupHierarchyCaching;
    }

    /**
     * Sets the value of the enableGroupMembershipLookupHierarchyCaching property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Boolean }{@code >}
     *     
     */
    public void setEnableGroupMembershipLookupHierarchyCaching(JAXBElement<Boolean> value) {
        this.enableGroupMembershipLookupHierarchyCaching = value;
    }

    /**
     * Gets the value of the maxGroupHierarchiesInCache property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getMaxGroupHierarchiesInCache() {
        return maxGroupHierarchiesInCache;
    }

    /**
     * Sets the value of the maxGroupHierarchiesInCache property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setMaxGroupHierarchiesInCache(JAXBElement<Integer> value) {
        this.maxGroupHierarchiesInCache = value;
    }

    /**
     * Gets the value of the groupHierarchyCacheTtl property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getGroupHierarchyCacheTtl() {
        return groupHierarchyCacheTtl;
    }

    /**
     * Sets the value of the groupHierarchyCacheTtl property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setGroupHierarchyCacheTtl(JAXBElement<Integer> value) {
        this.groupHierarchyCacheTtl = value;
    }

}
