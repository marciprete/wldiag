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
 * Corresponds to JMSDistributedTopicMemberMBean
 *  (Interface=weblogic.management.configuration.JMSDistributedTopicMemberMBean)
 * 
 * <p>Java class for jms-distributed-topic-memberType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="jms-distributed-topic-memberType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}jms-distributed-destination-memberType">
 *       &lt;sequence>
 *         &lt;element name="jms-topic" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jms-distributed-topic-memberType", propOrder = {
    "jmsTopic"
})
public class JmsDistributedTopicMemberType
    extends JmsDistributedDestinationMemberType
{

    @XmlElementRef(name = "jms-topic", namespace = "http://xmlns.oracle.com/weblogic/domain", type = JAXBElement.class, required = false)
    protected JAXBElement<String> jmsTopic;

    /**
     * Gets the value of the jmsTopic property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getJmsTopic() {
        return jmsTopic;
    }

    /**
     * Sets the value of the jmsTopic property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setJmsTopic(JAXBElement<String> value) {
        this.jmsTopic = value;
    }

}
