//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.01.17 at 03:40:53 PM CET 
//


package it.senape.wldiag.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * Corresponds to JMSDestinationMBean
 *  (Interface=weblogic.management.configuration.JMSDestinationMBean)
 * 
 * <p>Java class for jms-destinationType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="jms-destinationType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://xmlns.oracle.com/weblogic/domain}jms-dest-commonType">
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "jms-destinationType")
@XmlSeeAlso({
    JmsTopicType.class,
    JmsQueueType.class
})
public class JmsDestinationType
    extends JmsDestCommonType
{


}
