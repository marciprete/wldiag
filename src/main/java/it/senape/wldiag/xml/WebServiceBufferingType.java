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
 * Corresponds to WebServiceBufferingMBean
 *  (Interface=weblogic.management.configuration.WebServiceBufferingMBean)
 * 
 * <p>Java class for web-service-bufferingType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="web-service-bufferingType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}configurationType">
 *       &lt;sequence>
 *         &lt;element name="web-service-request-buffering-queue" type="{http://xmlns.oracle.com/weblogic/domain}web-service-request-buffering-queueType" minOccurs="0"/>
 *         &lt;element name="web-service-response-buffering-queue" type="{http://xmlns.oracle.com/weblogic/domain}web-service-response-buffering-queueType" minOccurs="0"/>
 *         &lt;element name="retry-count" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}int">
 *               &lt;minInclusive value="0"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="retry-delay" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "web-service-bufferingType", propOrder = {
    "webServiceRequestBufferingQueue",
    "webServiceResponseBufferingQueue",
    "retryCount",
    "retryDelay"
})
public class WebServiceBufferingType
    extends ConfigurationType
{

    @XmlElementRef(name = "web-service-request-buffering-queue", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<WebServiceRequestBufferingQueueType> webServiceRequestBufferingQueue;
    @XmlElementRef(name = "web-service-response-buffering-queue", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<WebServiceResponseBufferingQueueType> webServiceResponseBufferingQueue;
    @XmlElement(name = "retry-count", defaultValue = "3")
    protected Integer retryCount;
    @XmlElementRef(name = "retry-delay", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> retryDelay;

    /**
     * Gets the value of the webServiceRequestBufferingQueue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WebServiceRequestBufferingQueueType }{@code >}
     *     
     */
    public JAXBElement<WebServiceRequestBufferingQueueType> getWebServiceRequestBufferingQueue() {
        return webServiceRequestBufferingQueue;
    }

    /**
     * Sets the value of the webServiceRequestBufferingQueue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WebServiceRequestBufferingQueueType }{@code >}
     *     
     */
    public void setWebServiceRequestBufferingQueue(JAXBElement<WebServiceRequestBufferingQueueType> value) {
        this.webServiceRequestBufferingQueue = value;
    }

    /**
     * Gets the value of the webServiceResponseBufferingQueue property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link WebServiceResponseBufferingQueueType }{@code >}
     *     
     */
    public JAXBElement<WebServiceResponseBufferingQueueType> getWebServiceResponseBufferingQueue() {
        return webServiceResponseBufferingQueue;
    }

    /**
     * Sets the value of the webServiceResponseBufferingQueue property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link WebServiceResponseBufferingQueueType }{@code >}
     *     
     */
    public void setWebServiceResponseBufferingQueue(JAXBElement<WebServiceResponseBufferingQueueType> value) {
        this.webServiceResponseBufferingQueue = value;
    }

    /**
     * Gets the value of the retryCount property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRetryCount() {
        return retryCount;
    }

    /**
     * Sets the value of the retryCount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRetryCount(Integer value) {
        this.retryCount = value;
    }

    /**
     * Gets the value of the retryDelay property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRetryDelay() {
        return retryDelay;
    }

    /**
     * Sets the value of the retryDelay property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRetryDelay(JAXBElement<String> value) {
        this.retryDelay = value;
    }

}
