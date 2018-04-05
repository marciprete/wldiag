package it.senape.wldiag.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public class ResourceDto implements Serializable {

    private String name;//="EBOOKING_DATASOURCE_ebooking"
    private String state;//="started"
    private String xid;//="BEA1-1E47ED1E038FAAAEA9A1-45424F4F4B494E475F44415441534F555243455F65626F6F6B696E67"
    private boolean busy;//="false"
    private List<ServerDto> servers = new ArrayList<>();

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

    @XmlElementWrapper(name="Servers")
    @XmlElement(name="Server")
    public void setServers(List<ServerDto> servers) {
        this.servers = servers;
    }

    public List<ServerDto> getServers() {
        return servers;
    }

    @Override
    public String toString() {
        return "ResourceDto{" +
                "name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", xid='" + xid + '\'' +
                ", busy=" + busy +
                ", servers=" + servers +
                '}';
    }
}
