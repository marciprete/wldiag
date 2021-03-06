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
 * Corresponds to WebServiceMBean
 *  (Interface=weblogic.management.configuration.WebServiceMBean)
 * 
 * <p>Java class for web-serviceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="web-serviceType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="jms-connection-factory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messaging-queue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="messaging-queue-mdb-run-as-principal-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="callback-queue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="callback-queue-mdb-run-as-principal-name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="web-service-persistence" type="{http://xmlns.oracle.com/weblogic/domain}web-service-persistenceType" minOccurs="0"/>
 *         &lt;element name="web-service-buffering" type="{http://xmlns.oracle.com/weblogic/domain}web-service-bufferingType" minOccurs="0"/>
 *         &lt;element name="web-service-reliability" type="{http://xmlns.oracle.com/weblogic/domain}web-service-reliabilityType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "web-serviceType", propOrder = {
    "jmsConnectionFactory",
    "messagingQueue",
    "messagingQueueMdbRunAsPrincipalName",
    "callbackQueue",
    "callbackQueueMdbRunAsPrincipalName",
    "webServicePersistence",
    "webServiceBuffering",
    "webServiceReliability"
})
public class WebServiceType
    extends ConfigurationType
{

    @XmlElementRef(name = "jms-connection-factory", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> jmsConnectionFactory;
    @XmlElementRef(name = "messaging-queue", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messagingQueue;
    @XmlElementRef(name = "messaging-queue-mdb-run-as-principal-name", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> messagingQueueMdbRunAsPrincipalName;
    @XmlElementRef(name = "callback-queue", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> callbackQueue;
    @XmlElementRef(name = "callback-queue-mdb-run-as-principal-name", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> callbackQueueMdbRunAsPrincipalName;
    @XmlElementRef(name = "web-service-persistence", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<WebServicePersistenceType> webServicePersistence;
    @XmlElementRef(name = "web-service-buffering", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<WebServiceBufferingType> webServiceBuffering;
    @XmlElementRef(name = "web-service-reliability", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<WebServiceReliabilityType> webServiceReliability;

    /**
     * Gets the value of the jmsConnectionFactory property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getJmsConnectionFactory() {
        return jmsConnectionFactory;
    }

    /**
     * Sets the value of the jmsConnectionFactory property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setJmsConnectionFactory(JAXBElement<String> value) {
        this.jmsConnectionFactory = value;
    }

    /**
     * Gets the value of the messagingQueue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessagingQueue() {
        return messagingQueue;
    }

    /**
     * Sets the value of the messagingQueue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessagingQueue(JAXBElement<String> value) {
        this.messagingQueue = value;
    }

    /**
     * Gets the value of the messagingQueueMdbRunAsPrincipalName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMessagingQueueMdbRunAsPrincipalName() {
        return messagingQueueMdbRunAsPrincipalName;
    }

    /**
     * Sets the value of the messagingQueueMdbRunAsPrincipalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMessagingQueueMdbRunAsPrincipalName(JAXBElement<String> value) {
        this.messagingQueueMdbRunAsPrincipalName = value;
    }

    /**
     * Gets the value of the callbackQueue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCallbackQueue() {
        return callbackQueue;
    }

    /**
     * Sets the value of the callbackQueue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCallbackQueue(JAXBElement<String> value) {
        this.callbackQueue = value;
    }

    /**
     * Gets the value of the callbackQueueMdbRunAsPrincipalName property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCallbackQueueMdbRunAsPrincipalName() {
        return callbackQueueMdbRunAsPrincipalName;
    }

    /**
     * Sets the value of the callbackQueueMdbRunAsPrincipalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCallbackQueueMdbRunAsPrincipalName(JAXBElement<String> value) {
        this.callbackQueueMdbRunAsPrincipalName = value;
    }

    /**
     * Gets the value of the webServicePersistence property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WebServicePersistenceType }{@code >}
     *     
     */
    public JAXBElement<WebServicePersistenceType> getWebServicePersistence() {
        return webServicePersistence;
    }

    /**
     * Sets the value of the webServicePersistence property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WebServicePersistenceType }{@code >}
     *     
     */
    public void setWebServicePersistence(JAXBElement<WebServicePersistenceType> value) {
        this.webServicePersistence = value;
    }

    /**
     * Gets the value of the webServiceBuffering property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WebServiceBufferingType }{@code >}
     *     
     */
    public JAXBElement<WebServiceBufferingType> getWebServiceBuffering() {
        return webServiceBuffering;
    }

    /**
     * Sets the value of the webServiceBuffering property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WebServiceBufferingType }{@code >}
     *     
     */
    public void setWebServiceBuffering(JAXBElement<WebServiceBufferingType> value) {
        this.webServiceBuffering = value;
    }

    /**
     * Gets the value of the webServiceReliability property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WebServiceReliabilityType }{@code >}
     *     
     */
    public JAXBElement<WebServiceReliabilityType> getWebServiceReliability() {
        return webServiceReliability;
    }

    /**
     * Sets the value of the webServiceReliability property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WebServiceReliabilityType }{@code >}
     *     
     */
    public void setWebServiceReliability(JAXBElement<WebServiceReliabilityType> value) {
        this.webServiceReliability = value;
    }

}
