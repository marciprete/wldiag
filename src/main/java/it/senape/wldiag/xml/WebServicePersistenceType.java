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
 * Corresponds to WebServicePersistenceMBean
 *  (Interface=weblogic.management.configuration.WebServicePersistenceMBean)
 * 
 * <p>Java class for web-service-persistenceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="web-service-persistenceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="default-logical-store-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="web-service-logical-store" type="{http://xmlns.oracle.com/weblogic/domain}web-service-logical-storeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="web-service-physical-store" type="{http://xmlns.oracle.com/weblogic/domain}web-service-physical-storeType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "web-service-persistenceType", propOrder = {
    "defaultLogicalStoreName",
    "webServiceLogicalStore",
    "webServicePhysicalStore"
})
public class WebServicePersistenceType
    extends ConfigurationType
{

    @XmlElementRef(name = "default-logical-store-name", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> defaultLogicalStoreName;
    @XmlElement(name = "web-service-logical-store", nillable = true)
    protected List<WebServiceLogicalStoreType> webServiceLogicalStore;
    @XmlElement(name = "web-service-physical-store", nillable = true)
    protected List<WebServicePhysicalStoreType> webServicePhysicalStore;

    /**
     * Gets the value of the defaultLogicalStoreName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getDefaultLogicalStoreName() {
        return defaultLogicalStoreName;
    }

    /**
     * Sets the value of the defaultLogicalStoreName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setDefaultLogicalStoreName(JAXBElement<String> value) {
        this.defaultLogicalStoreName = value;
    }

    /**
     * Gets the value of the webServiceLogicalStore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the webServiceLogicalStore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWebServiceLogicalStore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WebServiceLogicalStoreType }
     * 
     * 
     */
    public List<WebServiceLogicalStoreType> getWebServiceLogicalStore() {
        if (webServiceLogicalStore == null) {
            webServiceLogicalStore = new ArrayList<WebServiceLogicalStoreType>();
        }
        return this.webServiceLogicalStore;
    }

    /**
     * Gets the value of the webServicePhysicalStore property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the webServicePhysicalStore property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWebServicePhysicalStore().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WebServicePhysicalStoreType }
     * 
     * 
     */
    public List<WebServicePhysicalStoreType> getWebServicePhysicalStore() {
        if (webServicePhysicalStore == null) {
            webServicePhysicalStore = new ArrayList<WebServicePhysicalStoreType>();
        }
        return this.webServicePhysicalStore;
    }

}
