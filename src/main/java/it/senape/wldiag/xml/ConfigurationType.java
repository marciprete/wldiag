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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to ConfigurationMBean
 *  (Interface=weblogic.management.configuration.ConfigurationMBean)
 * 
 * <p>Java class for configurationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="configurationType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="notes" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "configurationType", propOrder = {
    "name",
    "notes"
})
@XmlSeeAlso({
    DomainType.class,
    ExecuteQueueType.class,
    FederationServicesType.class,
    StuckThreadActionType.class,
    OverloadProtectionType.class,
    JmsDestinationKeyType.class,
    DatabaseLessLeasingBasisType.class,
    WebServicePersistenceType.class,
    JdbcDataSourceFactoryType.class,
    PasswordPolicyType.class,
    DebugScopeType.class,
    OldRealmType.class,
    AdminConsoleType.class,
    JpaType.class,
    WebAppContainerType.class,
    KernelType.class,
    IiopType.class,
    AdminType.class,
    WebServiceType.class,
    WtcPasswordType.class,
    JmxType.class,
    CacheTransactionType.class,
    AdminServerType.class,
    LogFilterType.class,
    CacheAsyncListenersType.class,
    CacheStoreType.class,
    NodeManagerType.class,
    ServerFailureTriggerType.class,
    JmsSessionPoolType.class,
    ServerStartType.class,
    GenericJdbcStoreType.class,
    WorkManagerShutdownTriggerType.class,
    SslType.class,
    WsReliableDeliveryPolicyType.class,
    SecurityType.class,
    ComType.class,
    XmlParserSelectRegistryEntryType.class,
    WtcResourcesType.class,
    SnmpProxyType.class,
    RemoteSafContextType.class,
    WebServicePhysicalStoreType.class,
    WtcTbridgeGlobalType.class,
    CacheExpirationType.class,
    JtaType.class,
    DomainTargetedType.class,
    XmlEntitySpecRegistryEntryType.class,
    DomainLogFilterType.class,
    ApplicationType.class,
    XmlEntityCacheType.class,
    XmlRegistryType.class,
    SelfTuningType.class,
    CachingRealmType.class,
    WebserviceTimestampType.class,
    SnmpAgentType.class,
    JmsDistributedDestinationMemberType.class,
    WtcTbridgeRedirectType.class,
    WtcLocalTuxDomType.class,
    ForeignJndiObjectType.class,
    WebServiceReliabilityType.class,
    EjbContainerType.class,
    ErrorHandlingType.class,
    SingleSignOnServicesType.class,
    JmsStoreType.class,
    FileRealmType.class,
    LogFileType.class,
    BridgeDestinationCommonType.class,
    ScaContainerType.class,
    XmlRegistryEntryType.class,
    WtcImportType.class,
    WebServiceBufferingQueueType.class,
    ConfigurationPropertyType.class,
    EmbeddedLdapType.class,
    ConfigurationExtensionType.class,
    NetworkAccessPointType.class,
    CacheLoaderType.class,
    SnmpTrapSourceType.class,
    TargetType.class,
    WldfServerDiagnosticType.class,
    DeploymentConfigurationType.class,
    TargetInfoType.class,
    SnmpTrapDestinationType.class,
    JmsDestCommonType.class,
    SingletonServiceBaseType.class,
    WtcExportType.class,
    SecurityConfigurationType.class,
    WebserviceSecurityConfigurationType.class,
    MachineType.class,
    WebServiceLogicalStoreType.class,
    DebugType.class,
    WtcRemoteTuxDomType.class,
    JmsConnectionConsumerType.class,
    GenericFileStoreType.class,
    ForeignJndiLinkType.class,
    WldfDataRetirementType.class,
    WebserviceSecurityType.class,
    WebServiceBufferingType.class,
    BasicRealmType.class,
    DeploymentType.class
})
public class ConfigurationType {

    protected String name;
    @XmlElementRef(name = "notes", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> notes;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the notes property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getNotes() {
        return notes;
    }

    /**
     * Sets the value of the notes property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setNotes(JAXBElement<String> value) {
        this.notes = value;
    }

}