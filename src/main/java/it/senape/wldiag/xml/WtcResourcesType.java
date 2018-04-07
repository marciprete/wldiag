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
 * Corresponds to WTCResourcesMBean
 *  (Interface=weblogic.management.configuration.WTCResourcesMBean)
 * 
 * <p>Java class for wtc-resourcesType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wtc-resourcesType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="fld-tbl16-class" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="fld-tbl32-class" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="view-tbl16-class" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="view-tbl32-class" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="app-password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="app-password-iv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tp-usr-file" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="remote-mb-encoding" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="mb-encoding-map-file" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wtc-resourcesType", propOrder = {
    "fldTbl16Class",
    "fldTbl32Class",
    "viewTbl16Class",
    "viewTbl32Class",
    "appPassword",
    "appPasswordIv",
    "tpUsrFile",
    "remoteMbEncoding",
    "mbEncodingMapFile"
})
public class WtcResourcesType
    extends ConfigurationType
{

    @XmlElement(name = "fld-tbl16-class", nillable = true)
    protected List<String> fldTbl16Class;
    @XmlElement(name = "fld-tbl32-class", nillable = true)
    protected List<String> fldTbl32Class;
    @XmlElement(name = "view-tbl16-class", nillable = true)
    protected List<String> viewTbl16Class;
    @XmlElement(name = "view-tbl32-class", nillable = true)
    protected List<String> viewTbl32Class;
    @XmlElementRef(name = "app-password", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> appPassword;
    @XmlElementRef(name = "app-password-iv", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> appPasswordIv;
    @XmlElementRef(name = "tp-usr-file", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tpUsrFile;
    @XmlElementRef(name = "remote-mb-encoding", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> remoteMbEncoding;
    @XmlElementRef(name = "mb-encoding-map-file", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mbEncodingMapFile;

    /**
     * Gets the value of the fldTbl16Class property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fldTbl16Class property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFldTbl16Class().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFldTbl16Class() {
        if (fldTbl16Class == null) {
            fldTbl16Class = new ArrayList<String>();
        }
        return this.fldTbl16Class;
    }

    /**
     * Gets the value of the fldTbl32Class property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fldTbl32Class property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFldTbl32Class().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFldTbl32Class() {
        if (fldTbl32Class == null) {
            fldTbl32Class = new ArrayList<String>();
        }
        return this.fldTbl32Class;
    }

    /**
     * Gets the value of the viewTbl16Class property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the viewTbl16Class property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getViewTbl16Class().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getViewTbl16Class() {
        if (viewTbl16Class == null) {
            viewTbl16Class = new ArrayList<String>();
        }
        return this.viewTbl16Class;
    }

    /**
     * Gets the value of the viewTbl32Class property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the viewTbl32Class property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getViewTbl32Class().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getViewTbl32Class() {
        if (viewTbl32Class == null) {
            viewTbl32Class = new ArrayList<String>();
        }
        return this.viewTbl32Class;
    }

    /**
     * Gets the value of the appPassword property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAppPassword() {
        return appPassword;
    }

    /**
     * Sets the value of the appPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAppPassword(JAXBElement<String> value) {
        this.appPassword = value;
    }

    /**
     * Gets the value of the appPasswordIv property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getAppPasswordIv() {
        return appPasswordIv;
    }

    /**
     * Sets the value of the appPasswordIv property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setAppPasswordIv(JAXBElement<String> value) {
        this.appPasswordIv = value;
    }

    /**
     * Gets the value of the tpUsrFile property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTpUsrFile() {
        return tpUsrFile;
    }

    /**
     * Sets the value of the tpUsrFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTpUsrFile(JAXBElement<String> value) {
        this.tpUsrFile = value;
    }

    /**
     * Gets the value of the remoteMbEncoding property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRemoteMbEncoding() {
        return remoteMbEncoding;
    }

    /**
     * Sets the value of the remoteMbEncoding property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRemoteMbEncoding(JAXBElement<String> value) {
        this.remoteMbEncoding = value;
    }

    /**
     * Gets the value of the mbEncodingMapFile property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMbEncodingMapFile() {
        return mbEncodingMapFile;
    }

    /**
     * Sets the value of the mbEncodingMapFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMbEncodingMapFile(JAXBElement<String> value) {
        this.mbEncodingMapFile = value;
    }

}