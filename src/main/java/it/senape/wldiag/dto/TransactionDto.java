package it.senape.wldiag.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public class TransactionDto implements Serializable {
    private String xid;//="BEA1-1E47ED1E038FAAAEA9A1"
    private String state;//="active"
    private String status;//="Active"
    private Long beginTime;//="1513171463043"
    private String coordinatorURL;//="ManagedServer_1+172.26.80.143:7011+ebooking+t3+"
    private String ownerTM;//="ServerTM[ServerCoordinatorDescriptor=(CoordinatorURL=ManagedServer_1+172.26.80.143:7011+ebooking+t3+ CoordinatorNonSecureURL=ManagedServer_1+172.26.80.143:7011+ebooking+t3+ coordinatorSecureURL=ManagedServer_1+172.26.80.143:7503+ebooking+t3s+, XAResources={WSATGatewayRM_ManagedServer_1_ebooking, EBOOKING_DATASOURCE_ebooking},NonXAResources={})]"
    private String activeThread;//="Thread[StartupThread_OPTION_BOOKINGS[GRIMALDI FERRY],5,Pooled Threads]"
    private Integer repliesOwedMe;//="0"
    private Integer repliesOwedOthers;//="0"
    private Boolean retry;//="false"

    private Set<PropertyDto> localProperties = new HashSet<>();

    private Set<PropertyDto> globalProperties = new HashSet<>();

    private Set<ServerDto> servers = new HashSet<>();

    private Set<ResourceDto> resources = new HashSet<>();

    public String getXid() {
        return xid;
    }

    @XmlAttribute
    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getState() {
        return state;
    }

    @XmlAttribute
    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    @XmlAttribute
    public void setStatus(String status) {
        this.status = status;
    }

    public Long getBeginTime() {
        return beginTime;
    }

    @XmlAttribute
    public void setBeginTime(Long beginTime) {
        this.beginTime = beginTime;
    }

    public String getCoordinatorURL() {
        return coordinatorURL;
    }

    @XmlAttribute
    public void setCoordinatorURL(String coordinatorURL) {
        this.coordinatorURL = coordinatorURL;
    }

    public String getOwnerTM() {
        return ownerTM;
    }

    @XmlAttribute
    public void setOwnerTM(String ownerTM) {
        this.ownerTM = ownerTM;
    }

    public String getActiveThread() {
        return activeThread;
    }

    @XmlAttribute
    public void setActiveThread(String activeThread) {
        this.activeThread = activeThread;
    }

    public Integer getRepliesOwedMe() {
        return repliesOwedMe;
    }

    @XmlAttribute
    public void setRepliesOwedMe(Integer repliesOwedMe) {
        this.repliesOwedMe = repliesOwedMe;
    }

    public Integer getRepliesOwedOthers() {
        return repliesOwedOthers;
    }

    @XmlAttribute
    public void setRepliesOwedOthers(Integer repliesOwedOthers) {
        this.repliesOwedOthers = repliesOwedOthers;
    }

    public Boolean isRetry() {
        return retry;
    }

    @XmlAttribute
    public void setRetry(Boolean retry) {
        this.retry = retry;
    }

    public Set<PropertyDto> getGlobalProperties() {
        return globalProperties;
    }

    @XmlElementWrapper(name = "GlobalProperties")
    @XmlElement(name = "Property")
    public void setGlobalProperties(Set<PropertyDto> globalProperties) {
        this.globalProperties = globalProperties;
    }

    public Set<PropertyDto> getLocalProperties() {
        return localProperties;
    }

    @XmlElementWrapper(name = "LocalProperties")
    @XmlElement(name = "Property")
    public void setLocalProperties(Set<PropertyDto> localProperties) {
        this.localProperties = localProperties;
    }

    public Set<ServerDto> getServers() {
        return servers;
    }

    @XmlElementWrapper(name="Servers")
    @XmlElement(name="Server")
    public void setServers(Set<ServerDto> servers) {
        this.servers = servers;
    }

    public Set<ResourceDto> getResources() {
        return resources;
    }

    @XmlElementWrapper(name="Resources")
    @XmlElement(name="Resource")
    public void setResources(Set<ResourceDto> resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "xid='" + xid + '\'' +
                ", state='" + state + '\'' +
                ", status='" + status + '\'' +
                ", beginTime=" + beginTime +
                ", coordinatorURL='" + coordinatorURL + '\'' +
                ", ownerTM='" + ownerTM + '\'' +
                ", activeThread='" + activeThread + '\'' +
                ", repliesOwedMe=" + repliesOwedMe +
                ", repliesOwedOthers=" + repliesOwedOthers +
                ", retry=" + retry +
                ", localProperties=" + localProperties +
                ", globalProperties=" + globalProperties +
                ", servers=" + servers +
                ", resources=" + resources +
                '}';
    }
}
