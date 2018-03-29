/**
 * Created by michele.arciprete on 17-Jan-18.
 */
@XmlSchema(
        namespace = "http://xmlns.oracle.com/weblogic/weblogic-diagnostics-image",
        elementFormDefault= XmlNsForm.QUALIFIED
        //,xmlns={@XmlNs(prefix="lm", namespaceURI="http://www.ae.com/Event/Load")}
        )
package it.senape.wldiag.dto.jvm;


import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlSchema;