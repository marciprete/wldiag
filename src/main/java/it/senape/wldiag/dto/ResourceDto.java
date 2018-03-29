package it.senape.wldiag.dto;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public class ResourceDto implements Serializable {

    private String name;//="EBOOKING_DATASOURCE_ebooking"
    private String state;//="started"
    private String xid;//="BEA1-1E47ED1E038FAAAEA9A1-45424F4F4B494E475F44415441534F555243455F65626F6F6B696E67"
    private boolean busy;//="false"

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    @XmlAttribute
    public void setState(String state) {
        this.state = state;
    }

    public String getXid() {
        return xid;
    }

    @XmlAttribute
    public void setXid(String xid) {
        this.xid = xid;
    }

    public boolean isBusy() {
        return busy;
    }

    @XmlAttribute
    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    @Override
    public String toString() {
        return "JdbcResource{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", xid='" + xid + '\'' +
                ", busy=" + busy +
                '}';
    }
}
