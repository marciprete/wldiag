package it.senape.wldiag.message;

import it.senape.wldiag.dto.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by michele.arciprete on 10-Jan-18.
 */
public class TransactionMessage implements Serializable {

    private String xid;//="BEA1-1E47ED1E038FAAAEA9A1"
    private String state;//="active"
    private String status;//="Active"
    private LocalDateTime beginTime;//="1513171463043"
    private String coordinatorURL;//="ManagedServer_1+172.26.80.143:7011+ebooking+t3+"
    private String ownerTM;//="ServerTM[ServerCoordinatorDescriptor=(CoordinatorURL=ManagedServer_1+172.26.80.143:7011+ebooking+t3+ CoordinatorNonSecureURL=ManagedServer_1+172.26.80.143:7011+ebooking+t3+ coordinatorSecureURL=ManagedServer_1+172.26.80.143:7503+ebooking+t3s+, XAResources={WSATGatewayRM_ManagedServer_1_ebooking, EBOOKING_DATASOURCE_ebooking},NonXAResources={})]"
    private InternalThreadDto activeThread;//="Thread[StartupThread_OPTION_BOOKINGS[GRIMALDI FERRY],5,Pooled Threads]"
    private Integer repliesOwedMe;//="0"
    private Integer repliesOwedOthers;//="0"
    private Boolean retry;//="false"

    private Set<PropertyDto> localProperties = new LinkedHashSet<>();
    private Set<PropertyDto> globalProperties = new LinkedHashSet<>();
    private Set<ServerDto> servers = new LinkedHashSet<>();
    private Set<ResourceDto> resources = new LinkedHashSet<>();

    private List<EjbTransactionPropertyDto> ejbTransactions = new LinkedList<>();

    public List<EjbTransactionPropertyDto> getEjbTransactions() {
        return ejbTransactions;
    }

    public void setEjbTransactions(List<EjbTransactionPropertyDto> ejbTransactions) {
        this.ejbTransactions = ejbTransactions;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(LocalDateTime beginTime) {
        this.beginTime = beginTime;
    }

    public String getCoordinatorURL() {
        return coordinatorURL;
    }

    public void setCoordinatorURL(String coordinatorURL) {
        this.coordinatorURL = coordinatorURL;
    }

    public String getOwnerTM() {
        return ownerTM;
    }

    public void setOwnerTM(String ownerTM) {
        this.ownerTM = ownerTM;
    }

    public InternalThreadDto getActiveThread() {
        return activeThread;
    }

    public void setActiveThread(InternalThreadDto activeThread) {
        this.activeThread = activeThread;
    }

    public Integer getRepliesOwedMe() {
        return repliesOwedMe;
    }

    public void setRepliesOwedMe(Integer repliesOwedMe) {
        this.repliesOwedMe = repliesOwedMe;
    }

    public Integer getRepliesOwedOthers() {
        return repliesOwedOthers;
    }

    public void setRepliesOwedOthers(Integer repliesOwedOthers) {
        this.repliesOwedOthers = repliesOwedOthers;
    }

    public Boolean getRetry() {
        return retry;
    }

    public void setRetry(Boolean retry) {
        this.retry = retry;
    }

    public Set<PropertyDto> getLocalProperties() {
        return localProperties;
    }

    public void setLocalProperties(Set<PropertyDto> localProperties) {
        this.localProperties = localProperties;
    }

    public Set<PropertyDto> getGlobalProperties() {
        return globalProperties;
    }

    public void setGlobalProperties(Set<PropertyDto> globalProperties) {
        this.globalProperties = globalProperties;
    }

    public Set<ServerDto> getServers() {
        return servers;
    }

    public void setServers(Set<ServerDto> servers) {
        this.servers = servers;
    }

    public Set<ResourceDto> getResources() {
        return resources;
    }

    public void setResources(Set<ResourceDto> resources) {
        this.resources = resources;
    }
}
