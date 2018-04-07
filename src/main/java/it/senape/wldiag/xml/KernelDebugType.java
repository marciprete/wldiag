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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to KernelDebugMBean
 *  (Interface=weblogic.management.configuration.KernelDebugMBean)
 * 
 * <p>Java class for kernel-debugType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="kernel-debugType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}debugType">
 *       &lt;sequence>
 *         &lt;element name="debug-abbreviation" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-connection" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-messaging" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-routing" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-load-balancing" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-work-context" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-fail-over" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="force-gc-each-dgc-period" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-dgc-enrollment" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="log-dgc-statistics" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-ssl" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-rc4" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-rsa" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-muxer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-muxer-detail" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-muxer-timeout" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-muxer-connection" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-muxer-exception" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-iiop" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-iiop-transport" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-iiop-marshal" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-iiop-security" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-iiopots" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-iiop-replacer" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-iiop-connection" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-iiop-startup" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="debug-self-tuning" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "kernel-debugType", propOrder = {
    "debugAbbreviation",
    "debugConnection",
    "debugMessaging",
    "debugRouting",
    "debugLoadBalancing",
    "debugWorkContext",
    "debugFailOver",
    "forceGcEachDgcPeriod",
    "debugDgcEnrollment",
    "logDgcStatistics",
    "debugSsl",
    "debugRc4",
    "debugRsa",
    "debugMuxer",
    "debugMuxerDetail",
    "debugMuxerTimeout",
    "debugMuxerConnection",
    "debugMuxerException",
    "debugIiop",
    "debugIiopTransport",
    "debugIiopMarshal",
    "debugIiopSecurity",
    "debugIiopots",
    "debugIiopReplacer",
    "debugIiopConnection",
    "debugIiopStartup",
    "debugSelfTuning"
})
@XmlSeeAlso({
    ServerDebugType.class
})
public class KernelDebugType
    extends DebugType
{

    @XmlElement(name = "debug-abbreviation")
    protected Boolean debugAbbreviation;
    @XmlElement(name = "debug-connection")
    protected Boolean debugConnection;
    @XmlElement(name = "debug-messaging")
    protected Boolean debugMessaging;
    @XmlElement(name = "debug-routing")
    protected Boolean debugRouting;
    @XmlElement(name = "debug-load-balancing")
    protected Boolean debugLoadBalancing;
    @XmlElement(name = "debug-work-context")
    protected Boolean debugWorkContext;
    @XmlElement(name = "debug-fail-over")
    protected Boolean debugFailOver;
    @XmlElement(name = "force-gc-each-dgc-period", defaultValue = "false")
    protected Boolean forceGcEachDgcPeriod;
    @XmlElement(name = "debug-dgc-enrollment")
    protected Boolean debugDgcEnrollment;
    @XmlElement(name = "log-dgc-statistics")
    protected Boolean logDgcStatistics;
    @XmlElement(name = "debug-ssl", defaultValue = "false")
    protected Boolean debugSsl;
    @XmlElement(name = "debug-rc4", defaultValue = "false")
    protected Boolean debugRc4;
    @XmlElement(name = "debug-rsa", defaultValue = "false")
    protected Boolean debugRsa;
    @XmlElement(name = "debug-muxer", defaultValue = "false")
    protected Boolean debugMuxer;
    @XmlElement(name = "debug-muxer-detail", defaultValue = "false")
    protected Boolean debugMuxerDetail;
    @XmlElement(name = "debug-muxer-timeout", defaultValue = "false")
    protected Boolean debugMuxerTimeout;
    @XmlElement(name = "debug-muxer-connection", defaultValue = "false")
    protected Boolean debugMuxerConnection;
    @XmlElement(name = "debug-muxer-exception", defaultValue = "false")
    protected Boolean debugMuxerException;
    @XmlElement(name = "debug-iiop", defaultValue = "false")
    protected Boolean debugIiop;
    @XmlElement(name = "debug-iiop-transport", defaultValue = "false")
    protected Boolean debugIiopTransport;
    @XmlElement(name = "debug-iiop-marshal", defaultValue = "false")
    protected Boolean debugIiopMarshal;
    @XmlElement(name = "debug-iiop-security", defaultValue = "false")
    protected Boolean debugIiopSecurity;
    @XmlElement(name = "debug-iiopots", defaultValue = "false")
    protected Boolean debugIiopots;
    @XmlElement(name = "debug-iiop-replacer", defaultValue = "false")
    protected Boolean debugIiopReplacer;
    @XmlElement(name = "debug-iiop-connection", defaultValue = "false")
    protected Boolean debugIiopConnection;
    @XmlElement(name = "debug-iiop-startup", defaultValue = "false")
    protected Boolean debugIiopStartup;
    @XmlElement(name = "debug-self-tuning", defaultValue = "false")
    protected Boolean debugSelfTuning;

    /**
     * Gets the value of the debugAbbreviation property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugAbbreviation() {
        return debugAbbreviation;
    }

    /**
     * Sets the value of the debugAbbreviation property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugAbbreviation(Boolean value) {
        this.debugAbbreviation = value;
    }

    /**
     * Gets the value of the debugConnection property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugConnection() {
        return debugConnection;
    }

    /**
     * Sets the value of the debugConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugConnection(Boolean value) {
        this.debugConnection = value;
    }

    /**
     * Gets the value of the debugMessaging property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugMessaging() {
        return debugMessaging;
    }

    /**
     * Sets the value of the debugMessaging property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugMessaging(Boolean value) {
        this.debugMessaging = value;
    }

    /**
     * Gets the value of the debugRouting property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugRouting() {
        return debugRouting;
    }

    /**
     * Sets the value of the debugRouting property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugRouting(Boolean value) {
        this.debugRouting = value;
    }

    /**
     * Gets the value of the debugLoadBalancing property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugLoadBalancing() {
        return debugLoadBalancing;
    }

    /**
     * Sets the value of the debugLoadBalancing property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugLoadBalancing(Boolean value) {
        this.debugLoadBalancing = value;
    }

    /**
     * Gets the value of the debugWorkContext property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugWorkContext() {
        return debugWorkContext;
    }

    /**
     * Sets the value of the debugWorkContext property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugWorkContext(Boolean value) {
        this.debugWorkContext = value;
    }

    /**
     * Gets the value of the debugFailOver property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugFailOver() {
        return debugFailOver;
    }

    /**
     * Sets the value of the debugFailOver property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugFailOver(Boolean value) {
        this.debugFailOver = value;
    }

    /**
     * Gets the value of the forceGcEachDgcPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isForceGcEachDgcPeriod() {
        return forceGcEachDgcPeriod;
    }

    /**
     * Sets the value of the forceGcEachDgcPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setForceGcEachDgcPeriod(Boolean value) {
        this.forceGcEachDgcPeriod = value;
    }

    /**
     * Gets the value of the debugDgcEnrollment property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugDgcEnrollment() {
        return debugDgcEnrollment;
    }

    /**
     * Sets the value of the debugDgcEnrollment property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugDgcEnrollment(Boolean value) {
        this.debugDgcEnrollment = value;
    }

    /**
     * Gets the value of the logDgcStatistics property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isLogDgcStatistics() {
        return logDgcStatistics;
    }

    /**
     * Sets the value of the logDgcStatistics property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setLogDgcStatistics(Boolean value) {
        this.logDgcStatistics = value;
    }

    /**
     * Gets the value of the debugSsl property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugSsl() {
        return debugSsl;
    }

    /**
     * Sets the value of the debugSsl property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugSsl(Boolean value) {
        this.debugSsl = value;
    }

    /**
     * Gets the value of the debugRc4 property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugRc4() {
        return debugRc4;
    }

    /**
     * Sets the value of the debugRc4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugRc4(Boolean value) {
        this.debugRc4 = value;
    }

    /**
     * Gets the value of the debugRsa property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugRsa() {
        return debugRsa;
    }

    /**
     * Sets the value of the debugRsa property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugRsa(Boolean value) {
        this.debugRsa = value;
    }

    /**
     * Gets the value of the debugMuxer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugMuxer() {
        return debugMuxer;
    }

    /**
     * Sets the value of the debugMuxer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugMuxer(Boolean value) {
        this.debugMuxer = value;
    }

    /**
     * Gets the value of the debugMuxerDetail property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugMuxerDetail() {
        return debugMuxerDetail;
    }

    /**
     * Sets the value of the debugMuxerDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugMuxerDetail(Boolean value) {
        this.debugMuxerDetail = value;
    }

    /**
     * Gets the value of the debugMuxerTimeout property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugMuxerTimeout() {
        return debugMuxerTimeout;
    }

    /**
     * Sets the value of the debugMuxerTimeout property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugMuxerTimeout(Boolean value) {
        this.debugMuxerTimeout = value;
    }

    /**
     * Gets the value of the debugMuxerConnection property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugMuxerConnection() {
        return debugMuxerConnection;
    }

    /**
     * Sets the value of the debugMuxerConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugMuxerConnection(Boolean value) {
        this.debugMuxerConnection = value;
    }

    /**
     * Gets the value of the debugMuxerException property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugMuxerException() {
        return debugMuxerException;
    }

    /**
     * Sets the value of the debugMuxerException property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugMuxerException(Boolean value) {
        this.debugMuxerException = value;
    }

    /**
     * Gets the value of the debugIiop property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugIiop() {
        return debugIiop;
    }

    /**
     * Sets the value of the debugIiop property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugIiop(Boolean value) {
        this.debugIiop = value;
    }

    /**
     * Gets the value of the debugIiopTransport property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugIiopTransport() {
        return debugIiopTransport;
    }

    /**
     * Sets the value of the debugIiopTransport property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugIiopTransport(Boolean value) {
        this.debugIiopTransport = value;
    }

    /**
     * Gets the value of the debugIiopMarshal property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugIiopMarshal() {
        return debugIiopMarshal;
    }

    /**
     * Sets the value of the debugIiopMarshal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugIiopMarshal(Boolean value) {
        this.debugIiopMarshal = value;
    }

    /**
     * Gets the value of the debugIiopSecurity property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugIiopSecurity() {
        return debugIiopSecurity;
    }

    /**
     * Sets the value of the debugIiopSecurity property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugIiopSecurity(Boolean value) {
        this.debugIiopSecurity = value;
    }

    /**
     * Gets the value of the debugIiopots property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugIiopots() {
        return debugIiopots;
    }

    /**
     * Sets the value of the debugIiopots property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugIiopots(Boolean value) {
        this.debugIiopots = value;
    }

    /**
     * Gets the value of the debugIiopReplacer property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugIiopReplacer() {
        return debugIiopReplacer;
    }

    /**
     * Sets the value of the debugIiopReplacer property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugIiopReplacer(Boolean value) {
        this.debugIiopReplacer = value;
    }

    /**
     * Gets the value of the debugIiopConnection property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugIiopConnection() {
        return debugIiopConnection;
    }

    /**
     * Sets the value of the debugIiopConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugIiopConnection(Boolean value) {
        this.debugIiopConnection = value;
    }

    /**
     * Gets the value of the debugIiopStartup property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugIiopStartup() {
        return debugIiopStartup;
    }

    /**
     * Sets the value of the debugIiopStartup property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugIiopStartup(Boolean value) {
        this.debugIiopStartup = value;
    }

    /**
     * Gets the value of the debugSelfTuning property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDebugSelfTuning() {
        return debugSelfTuning;
    }

    /**
     * Sets the value of the debugSelfTuning property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDebugSelfTuning(Boolean value) {
        this.debugSelfTuning = value;
    }

}