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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to SNMPAgentMBean
 *  (Interface=weblogic.management.configuration.SNMPAgentMBean)
 * 
 * <p>Java class for snmp-agentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="snmp-agentType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="send-automatic-traps-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="snmp-port" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="65535"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="snmp-trap-version" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="mib-data-refresh-interval" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="30"/>
 *               &lt;maxInclusive value="65535"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="server-status-check-interval-factor" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="65535"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="community-prefix" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="user-defined-mib" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="debug-level" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;enumeration value="0"/>
 *               &lt;enumeration value="1"/>
 *               &lt;enumeration value="2"/>
 *               &lt;enumeration value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="snmp-trap-destination" type="{http://xmlns.oracle.com/weblogic/domain}snmp-trap-destinationType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="snmp-proxy" type="{http://xmlns.oracle.com/weblogic/domain}snmp-proxyType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="snmp-gauge-monitor" type="{http://xmlns.oracle.com/weblogic/domain}snmp-gauge-monitorType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="snmp-string-monitor" type="{http://xmlns.oracle.com/weblogic/domain}snmp-string-monitorType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="snmp-counter-monitor" type="{http://xmlns.oracle.com/weblogic/domain}snmp-counter-monitorType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="snmp-log-filter" type="{http://xmlns.oracle.com/weblogic/domain}snmp-log-filterType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="snmp-attribute-change" type="{http://xmlns.oracle.com/weblogic/domain}snmp-attribute-changeType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="community-based-access-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="snmp-engine-id" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="authentication-protocol" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="noAuth"/>
 *               &lt;enumeration value="MD5"/>
 *               &lt;enumeration value="SHA"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="privacy-protocol" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="noPriv"/>
 *               &lt;enumeration value="DES"/>
 *               &lt;enumeration value="AES_128"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="inform-retry-interval" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="3000"/>
 *               &lt;maxInclusive value="30000"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="max-inform-retry-count" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="3"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="localized-key-cache-invalidation-interval" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="snmp-access-for-user-m-beans-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="inform-enabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="master-agent-x-port" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="1"/>
 *               &lt;maxInclusive value="65535"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "snmp-agentType", propOrder = {
    "enabled",
    "sendAutomaticTrapsEnabled",
    "snmpPort",
    "snmpTrapVersion",
    "mibDataRefreshInterval",
    "serverStatusCheckIntervalFactor",
    "communityPrefix",
    "userDefinedMib",
    "debugLevel",
    "snmpTrapDestination",
    "snmpProxy",
    "snmpGaugeMonitor",
    "snmpStringMonitor",
    "snmpCounterMonitor",
    "snmpLogFilter",
    "snmpAttributeChange",
    "communityBasedAccessEnabled",
    "snmpEngineId",
    "authenticationProtocol",
    "privacyProtocol",
    "informRetryInterval",
    "maxInformRetryCount",
    "localizedKeyCacheInvalidationInterval",
    "snmpAccessForUserMBeansEnabled",
    "informEnabled",
    "masterAgentXPort"
})
@XmlSeeAlso({
    SnmpAgentDeploymentType.class
})
public class SnmpAgentType
    extends ConfigurationType
{

    @XmlElement(defaultValue = "false")
    protected Boolean enabled;
    @XmlElement(name = "send-automatic-traps-enabled", defaultValue = "true")
    protected Boolean sendAutomaticTrapsEnabled;
    @XmlElement(name = "snmp-port", defaultValue = "161")
    protected Integer snmpPort;
    @XmlElement(name = "snmp-trap-version")
    protected Integer snmpTrapVersion;
    @XmlElement(name = "mib-data-refresh-interval", defaultValue = "120")
    protected Integer mibDataRefreshInterval;
    @XmlElement(name = "server-status-check-interval-factor", defaultValue = "1")
    protected Integer serverStatusCheckIntervalFactor;
    @XmlElementRef(name = "community-prefix", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> communityPrefix;
    @XmlElementRef(name = "user-defined-mib", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> userDefinedMib;
    @XmlElement(name = "debug-level")
    protected Integer debugLevel;
    @XmlElement(name = "snmp-trap-destination", nillable = true)
    protected List<SnmpTrapDestinationType> snmpTrapDestination;
    @XmlElement(name = "snmp-proxy", nillable = true)
    protected List<SnmpProxyType> snmpProxy;
    @XmlElement(name = "snmp-gauge-monitor", nillable = true)
    protected List<SnmpGaugeMonitorType> snmpGaugeMonitor;
    @XmlElement(name = "snmp-string-monitor", nillable = true)
    protected List<SnmpStringMonitorType> snmpStringMonitor;
    @XmlElement(name = "snmp-counter-monitor", nillable = true)
    protected List<SnmpCounterMonitorType> snmpCounterMonitor;
    @XmlElement(name = "snmp-log-filter", nillable = true)
    protected List<SnmpLogFilterType> snmpLogFilter;
    @XmlElement(name = "snmp-attribute-change", nillable = true)
    protected List<SnmpAttributeChangeType> snmpAttributeChange;
    @XmlElement(name = "community-based-access-enabled", defaultValue = "true")
    protected Boolean communityBasedAccessEnabled;
    @XmlElement(name = "snmp-engine-id")
    protected String snmpEngineId;
    @XmlElement(name = "authentication-protocol")
    protected String authenticationProtocol;
    @XmlElement(name = "privacy-protocol")
    protected String privacyProtocol;
    @XmlElement(name = "inform-retry-interval", defaultValue = "10000")
    protected Integer informRetryInterval;
    @XmlElement(name = "max-inform-retry-count", defaultValue = "1")
    protected Integer maxInformRetryCount;
    @XmlElement(name = "localized-key-cache-invalidation-interval")
    protected Long localizedKeyCacheInvalidationInterval;
    @XmlElement(name = "snmp-access-for-user-m-beans-enabled")
    protected Boolean snmpAccessForUserMBeansEnabled;
    @XmlElement(name = "inform-enabled", defaultValue = "false")
    protected Boolean informEnabled;
    @XmlElement(name = "master-agent-x-port", defaultValue = "705")
    protected Integer masterAgentXPort;

    /**
     * Gets the value of the enabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * Sets the value of the enabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setEnabled(Boolean value) {
        this.enabled = value;
    }

    /**
     * Gets the value of the sendAutomaticTrapsEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSendAutomaticTrapsEnabled() {
        return sendAutomaticTrapsEnabled;
    }

    /**
     * Sets the value of the sendAutomaticTrapsEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSendAutomaticTrapsEnabled(Boolean value) {
        this.sendAutomaticTrapsEnabled = value;
    }

    /**
     * Gets the value of the snmpPort property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSnmpPort() {
        return snmpPort;
    }

    /**
     * Sets the value of the snmpPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSnmpPort(Integer value) {
        this.snmpPort = value;
    }

    /**
     * Gets the value of the snmpTrapVersion property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getSnmpTrapVersion() {
        return snmpTrapVersion;
    }

    /**
     * Sets the value of the snmpTrapVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setSnmpTrapVersion(Integer value) {
        this.snmpTrapVersion = value;
    }

    /**
     * Gets the value of the mibDataRefreshInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMibDataRefreshInterval() {
        return mibDataRefreshInterval;
    }

    /**
     * Sets the value of the mibDataRefreshInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMibDataRefreshInterval(Integer value) {
        this.mibDataRefreshInterval = value;
    }

    /**
     * Gets the value of the serverStatusCheckIntervalFactor property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getServerStatusCheckIntervalFactor() {
        return serverStatusCheckIntervalFactor;
    }

    /**
     * Sets the value of the serverStatusCheckIntervalFactor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setServerStatusCheckIntervalFactor(Integer value) {
        this.serverStatusCheckIntervalFactor = value;
    }

    /**
     * Gets the value of the communityPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCommunityPrefix() {
        return communityPrefix;
    }

    /**
     * Sets the value of the communityPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCommunityPrefix(JAXBElement<String> value) {
        this.communityPrefix = value;
    }

    /**
     * Gets the value of the userDefinedMib property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getUserDefinedMib() {
        return userDefinedMib;
    }

    /**
     * Sets the value of the userDefinedMib property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setUserDefinedMib(JAXBElement<String> value) {
        this.userDefinedMib = value;
    }

    /**
     * Gets the value of the debugLevel property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDebugLevel() {
        return debugLevel;
    }

    /**
     * Sets the value of the debugLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDebugLevel(Integer value) {
        this.debugLevel = value;
    }

    /**
     * Gets the value of the snmpTrapDestination property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snmpTrapDestination property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnmpTrapDestination().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SnmpTrapDestinationType }
     * 
     * 
     */
    public List<SnmpTrapDestinationType> getSnmpTrapDestination() {
        if (snmpTrapDestination == null) {
            snmpTrapDestination = new ArrayList<SnmpTrapDestinationType>();
        }
        return this.snmpTrapDestination;
    }

    /**
     * Gets the value of the snmpProxy property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snmpProxy property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnmpProxy().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SnmpProxyType }
     * 
     * 
     */
    public List<SnmpProxyType> getSnmpProxy() {
        if (snmpProxy == null) {
            snmpProxy = new ArrayList<SnmpProxyType>();
        }
        return this.snmpProxy;
    }

    /**
     * Gets the value of the snmpGaugeMonitor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snmpGaugeMonitor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnmpGaugeMonitor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SnmpGaugeMonitorType }
     * 
     * 
     */
    public List<SnmpGaugeMonitorType> getSnmpGaugeMonitor() {
        if (snmpGaugeMonitor == null) {
            snmpGaugeMonitor = new ArrayList<SnmpGaugeMonitorType>();
        }
        return this.snmpGaugeMonitor;
    }

    /**
     * Gets the value of the snmpStringMonitor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snmpStringMonitor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnmpStringMonitor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SnmpStringMonitorType }
     * 
     * 
     */
    public List<SnmpStringMonitorType> getSnmpStringMonitor() {
        if (snmpStringMonitor == null) {
            snmpStringMonitor = new ArrayList<SnmpStringMonitorType>();
        }
        return this.snmpStringMonitor;
    }

    /**
     * Gets the value of the snmpCounterMonitor property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snmpCounterMonitor property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnmpCounterMonitor().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SnmpCounterMonitorType }
     * 
     * 
     */
    public List<SnmpCounterMonitorType> getSnmpCounterMonitor() {
        if (snmpCounterMonitor == null) {
            snmpCounterMonitor = new ArrayList<SnmpCounterMonitorType>();
        }
        return this.snmpCounterMonitor;
    }

    /**
     * Gets the value of the snmpLogFilter property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snmpLogFilter property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnmpLogFilter().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SnmpLogFilterType }
     * 
     * 
     */
    public List<SnmpLogFilterType> getSnmpLogFilter() {
        if (snmpLogFilter == null) {
            snmpLogFilter = new ArrayList<SnmpLogFilterType>();
        }
        return this.snmpLogFilter;
    }

    /**
     * Gets the value of the snmpAttributeChange property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the snmpAttributeChange property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSnmpAttributeChange().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SnmpAttributeChangeType }
     * 
     * 
     */
    public List<SnmpAttributeChangeType> getSnmpAttributeChange() {
        if (snmpAttributeChange == null) {
            snmpAttributeChange = new ArrayList<SnmpAttributeChangeType>();
        }
        return this.snmpAttributeChange;
    }

    /**
     * Gets the value of the communityBasedAccessEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isCommunityBasedAccessEnabled() {
        return communityBasedAccessEnabled;
    }

    /**
     * Sets the value of the communityBasedAccessEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setCommunityBasedAccessEnabled(Boolean value) {
        this.communityBasedAccessEnabled = value;
    }

    /**
     * Gets the value of the snmpEngineId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSnmpEngineId() {
        return snmpEngineId;
    }

    /**
     * Sets the value of the snmpEngineId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSnmpEngineId(String value) {
        this.snmpEngineId = value;
    }

    /**
     * Gets the value of the authenticationProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthenticationProtocol() {
        return authenticationProtocol;
    }

    /**
     * Sets the value of the authenticationProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthenticationProtocol(String value) {
        this.authenticationProtocol = value;
    }

    /**
     * Gets the value of the privacyProtocol property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrivacyProtocol() {
        return privacyProtocol;
    }

    /**
     * Sets the value of the privacyProtocol property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrivacyProtocol(String value) {
        this.privacyProtocol = value;
    }

    /**
     * Gets the value of the informRetryInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getInformRetryInterval() {
        return informRetryInterval;
    }

    /**
     * Sets the value of the informRetryInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setInformRetryInterval(Integer value) {
        this.informRetryInterval = value;
    }

    /**
     * Gets the value of the maxInformRetryCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMaxInformRetryCount() {
        return maxInformRetryCount;
    }

    /**
     * Sets the value of the maxInformRetryCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMaxInformRetryCount(Integer value) {
        this.maxInformRetryCount = value;
    }

    /**
     * Gets the value of the localizedKeyCacheInvalidationInterval property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLocalizedKeyCacheInvalidationInterval() {
        return localizedKeyCacheInvalidationInterval;
    }

    /**
     * Sets the value of the localizedKeyCacheInvalidationInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLocalizedKeyCacheInvalidationInterval(Long value) {
        this.localizedKeyCacheInvalidationInterval = value;
    }

    /**
     * Gets the value of the snmpAccessForUserMBeansEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isSnmpAccessForUserMBeansEnabled() {
        return snmpAccessForUserMBeansEnabled;
    }

    /**
     * Sets the value of the snmpAccessForUserMBeansEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setSnmpAccessForUserMBeansEnabled(Boolean value) {
        this.snmpAccessForUserMBeansEnabled = value;
    }

    /**
     * Gets the value of the informEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isInformEnabled() {
        return informEnabled;
    }

    /**
     * Sets the value of the informEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setInformEnabled(Boolean value) {
        this.informEnabled = value;
    }

    /**
     * Gets the value of the masterAgentXPort property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getMasterAgentXPort() {
        return masterAgentXPort;
    }

    /**
     * Sets the value of the masterAgentXPort property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setMasterAgentXPort(Integer value) {
        this.masterAgentXPort = value;
    }

}