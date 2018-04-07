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
 * Corresponds to EJBContainerMBean
 *  (Interface=weblogic.management.configuration.EJBContainerMBean)
 * 
 * <p>Java class for ejb-containerType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ejb-containerType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="java-compiler" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="java-compiler-pre-class-path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="java-compiler-post-class-path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extra-rmic-options" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="keep-generated" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="force-generation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="tmp-path" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="verbose-ejb-deployment-enabled" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extra-ejbc-options" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ejb-containerType", propOrder = {
    "javaCompiler",
    "javaCompilerPreClassPath",
    "javaCompilerPostClassPath",
    "extraRmicOptions",
    "keepGenerated",
    "forceGeneration",
    "tmpPath",
    "verboseEjbDeploymentEnabled",
    "extraEjbcOptions"
})
public class EjbContainerType
    extends ConfigurationType
{

    @XmlElementRef(name = "java-compiler", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> javaCompiler;
    @XmlElementRef(name = "java-compiler-pre-class-path", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> javaCompilerPreClassPath;
    @XmlElementRef(name = "java-compiler-post-class-path", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> javaCompilerPostClassPath;
    @XmlElementRef(name = "extra-rmic-options", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> extraRmicOptions;
    @XmlElement(name = "keep-generated", defaultValue = "true")
    protected Boolean keepGenerated;
    @XmlElement(name = "force-generation", defaultValue = "false")
    protected Boolean forceGeneration;
    @XmlElementRef(name = "tmp-path", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> tmpPath;
    @XmlElementRef(name = "verbose-ejb-deployment-enabled", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> verboseEjbDeploymentEnabled;
    @XmlElementRef(name = "extra-ejbc-options", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> extraEjbcOptions;

    /**
     * Gets the value of the javaCompiler property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getJavaCompiler() {
        return javaCompiler;
    }

    /**
     * Sets the value of the javaCompiler property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setJavaCompiler(JAXBElement<String> value) {
        this.javaCompiler = value;
    }

    /**
     * Gets the value of the javaCompilerPreClassPath property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getJavaCompilerPreClassPath() {
        return javaCompilerPreClassPath;
    }

    /**
     * Sets the value of the javaCompilerPreClassPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setJavaCompilerPreClassPath(JAXBElement<String> value) {
        this.javaCompilerPreClassPath = value;
    }

    /**
     * Gets the value of the javaCompilerPostClassPath property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getJavaCompilerPostClassPath() {
        return javaCompilerPostClassPath;
    }

    /**
     * Sets the value of the javaCompilerPostClassPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setJavaCompilerPostClassPath(JAXBElement<String> value) {
        this.javaCompilerPostClassPath = value;
    }

    /**
     * Gets the value of the extraRmicOptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExtraRmicOptions() {
        return extraRmicOptions;
    }

    /**
     * Sets the value of the extraRmicOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExtraRmicOptions(JAXBElement<String> value) {
        this.extraRmicOptions = value;
    }

    /**
     * Gets the value of the keepGenerated property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isKeepGenerated() {
        return keepGenerated;
    }

    /**
     * Sets the value of the keepGenerated property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setKeepGenerated(Boolean value) {
        this.keepGenerated = value;
    }

    /**
     * Gets the value of the forceGeneration property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForceGeneration() {
        return forceGeneration;
    }

    /**
     * Sets the value of the forceGeneration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForceGeneration(Boolean value) {
        this.forceGeneration = value;
    }

    /**
     * Gets the value of the tmpPath property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTmpPath() {
        return tmpPath;
    }

    /**
     * Sets the value of the tmpPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTmpPath(JAXBElement<String> value) {
        this.tmpPath = value;
    }

    /**
     * Gets the value of the verboseEjbDeploymentEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getVerboseEjbDeploymentEnabled() {
        return verboseEjbDeploymentEnabled;
    }

    /**
     * Sets the value of the verboseEjbDeploymentEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setVerboseEjbDeploymentEnabled(JAXBElement<String> value) {
        this.verboseEjbDeploymentEnabled = value;
    }

    /**
     * Gets the value of the extraEjbcOptions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getExtraEjbcOptions() {
        return extraEjbcOptions;
    }

    /**
     * Sets the value of the extraEjbcOptions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setExtraEjbcOptions(JAXBElement<String> value) {
        this.extraEjbcOptions = value;
    }

}