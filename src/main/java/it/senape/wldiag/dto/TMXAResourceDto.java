package it.senape.wldiag.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public class TMXAResourceDto implements Serializable {

    private int timeout;
    
    private Set<ForeignXidDto> foreignXids;

    public int getTimeout() {
        return timeout;
    }

    @XmlAttribute
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public Set<ForeignXidDto> getForeignXids() {
        return foreignXids;
    }

    @XmlElementWrapper(name = "ForeignXids")
    @XmlElement(name = "ForeignXid")
    public void setForeignXids(Set<ForeignXidDto> foreignXids) {
        this.foreignXids = foreignXids;
    }

    @Override
    public String toString() {
        return "TMXAResource{" +
                "timeout=" + timeout +
                '}';
    }
}
