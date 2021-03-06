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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to CommonLogMBean
 *  (Interface=weblogic.management.configuration.CommonLogMBean)
 * 
 * <p>Java class for common-logType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="common-logType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}log-fileType">
 *       &lt;sequence>
 *         &lt;element name="logger-severity" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Trace"/>
 *               &lt;enumeration value="Debug"/>
 *               &lt;enumeration value="Info"/>
 *               &lt;enumeration value="Notice"/>
 *               &lt;enumeration value="Warning"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="logger-severity-properties" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="log-file-severity" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Trace"/>
 *               &lt;enumeration value="Debug"/>
 *               &lt;enumeration value="Info"/>
 *               &lt;enumeration value="Notice"/>
 *               &lt;enumeration value="Warning"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="stdout-severity" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Trace"/>
 *               &lt;enumeration value="Debug"/>
 *               &lt;enumeration value="Info"/>
 *               &lt;enumeration value="Warning"/>
 *               &lt;enumeration value="Error"/>
 *               &lt;enumeration value="Notice"/>
 *               &lt;enumeration value="Critical"/>
 *               &lt;enumeration value="Alert"/>
 *               &lt;enumeration value="Emergency"/>
 *               &lt;enumeration value="Off"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="stdout-format" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="standard"/>
 *               &lt;enumeration value="noid"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="stdout-log-stack" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="stacktrace-depth" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "common-logType", propOrder = {
    "loggerSeverity",
    "loggerSeverityProperties",
    "logFileSeverity",
    "stdoutSeverity",
    "stdoutFormat",
    "stdoutLogStack",
    "stacktraceDepth"
})
@XmlSeeAlso({
    LogType.class
})
public class CommonLogType
    extends LogFileType
{

    @XmlElementRef(name = "logger-severity", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> loggerSeverity;
    @XmlElementRef(name = "logger-severity-properties", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> loggerSeverityProperties;
    @XmlElementRef(name = "log-file-severity", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> logFileSeverity;
    @XmlElementRef(name = "stdout-severity", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stdoutSeverity;
    @XmlElementRef(name = "stdout-format", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> stdoutFormat;
    @XmlElement(name = "stdout-log-stack", defaultValue = "true")
    protected Boolean stdoutLogStack;
    @XmlElement(name = "stacktrace-depth", defaultValue = "5")
    protected Integer stacktraceDepth;

    /**
     * Gets the value of the loggerSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLoggerSeverity() {
        return loggerSeverity;
    }

    /**
     * Sets the value of the loggerSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLoggerSeverity(JAXBElement<String> value) {
        this.loggerSeverity = value;
    }

    /**
     * Gets the value of the loggerSeverityProperties property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLoggerSeverityProperties() {
        return loggerSeverityProperties;
    }

    /**
     * Sets the value of the loggerSeverityProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLoggerSeverityProperties(JAXBElement<String> value) {
        this.loggerSeverityProperties = value;
    }

    /**
     * Gets the value of the logFileSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getLogFileSeverity() {
        return logFileSeverity;
    }

    /**
     * Sets the value of the logFileSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setLogFileSeverity(JAXBElement<String> value) {
        this.logFileSeverity = value;
    }

    /**
     * Gets the value of the stdoutSeverity property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStdoutSeverity() {
        return stdoutSeverity;
    }

    /**
     * Sets the value of the stdoutSeverity property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStdoutSeverity(JAXBElement<String> value) {
        this.stdoutSeverity = value;
    }

    /**
     * Gets the value of the stdoutFormat property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getStdoutFormat() {
        return stdoutFormat;
    }

    /**
     * Sets the value of the stdoutFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setStdoutFormat(JAXBElement<String> value) {
        this.stdoutFormat = value;
    }

    /**
     * Gets the value of the stdoutLogStack property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isStdoutLogStack() {
        return stdoutLogStack;
    }

    /**
     * Sets the value of the stdoutLogStack property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setStdoutLogStack(Boolean value) {
        this.stdoutLogStack = value;
    }

    /**
     * Gets the value of the stacktraceDepth property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getStacktraceDepth() {
        return stacktraceDepth;
    }

    /**
     * Sets the value of the stacktraceDepth property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setStacktraceDepth(Integer value) {
        this.stacktraceDepth = value;
    }

}
