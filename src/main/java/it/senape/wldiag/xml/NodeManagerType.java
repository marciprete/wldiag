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
 * Corresponds to NodeManagerMBean
 *  (Interface=weblogic.management.configuration.NodeManagerMBean)
 * 
 * <p>Java class for node-managerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="node-managerType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="nm-type" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="SSH"/>
 *               &lt;enumeration value="RSH"/>
 *               &lt;enumeration value="Plain"/>
 *               &lt;enumeration value="SSL"/>
 *               &lt;enumeration value="ssh"/>
 *               &lt;enumeration value="rsh"/>
 *               &lt;enumeration value="ssl"/>
 *               &lt;enumeration value="plain"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="listen-address" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="listen-port" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="65534"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="debug-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="shell-command" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="node-manager-home" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "node-managerType", propOrder = {
    "nmType",
    "listenAddress",
    "listenPort",
    "debugEnabled",
    "shellCommand",
    "nodeManagerHome"
})
public class NodeManagerType
    extends ConfigurationType
{

    @XmlElementRef(name = "nm-type", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nmType;
    @XmlElementRef(name = "listen-address", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> listenAddress;
    @XmlElement(name = "listen-port", defaultValue = "5556")
    protected Integer listenPort;
    @XmlElement(name = "debug-enabled", defaultValue = "false")
    protected Boolean debugEnabled;
    @XmlElementRef(name = "shell-command", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> shellCommand;
    @XmlElementRef(name = "node-manager-home", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> nodeManagerHome;

    /**
     * Gets the value of the nmType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNmType() {
        return nmType;
    }

    /**
     * Sets the value of the nmType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNmType(JAXBElement<String> value) {
        this.nmType = value;
    }

    /**
     * Gets the value of the listenAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getListenAddress() {
        return listenAddress;
    }

    /**
     * Sets the value of the listenAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setListenAddress(JAXBElement<String> value) {
        this.listenAddress = value;
    }

    /**
     * Gets the value of the listenPort property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getListenPort() {
        return listenPort;
    }

    /**
     * Sets the value of the listenPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setListenPort(Integer value) {
        this.listenPort = value;
    }

    /**
     * Gets the value of the debugEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugEnabled() {
        return debugEnabled;
    }

    /**
     * Sets the value of the debugEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugEnabled(Boolean value) {
        this.debugEnabled = value;
    }

    /**
     * Gets the value of the shellCommand property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getShellCommand() {
        return shellCommand;
    }

    /**
     * Sets the value of the shellCommand property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setShellCommand(JAXBElement<String> value) {
        this.shellCommand = value;
    }

    /**
     * Gets the value of the nodeManagerHome property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNodeManagerHome() {
        return nodeManagerHome;
    }

    /**
     * Sets the value of the nodeManagerHome property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNodeManagerHome(JAXBElement<String> value) {
        this.nodeManagerHome = value;
    }

}
