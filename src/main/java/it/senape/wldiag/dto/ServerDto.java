package it.senape.wldiag.dto;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public class ServerDto implements Serializable {

    private String url;//="ManagedServer_1+172.26.80.143:7011+ebooking+t3+"
    private boolean syncRegistered;//="true"
    private String state;//="active"

    public String getUrl() {
        return url;
    }

    @XmlAttribute
    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSyncRegistered() {
        return syncRegistered;
    }

    @XmlAttribute
    public void setSyncRegistered(boolean syncRegistered) {
        this.syncRegistered = syncRegistered;
    }

    public String getState() {
        return state;
    }

    @XmlAttribute
    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ServerDto{" +
                "url='" + url + '\'' +
                ", syncRegistered=" + syncRegistered +
                ", state='" + state + '\'' +
                '}';
    }
}
