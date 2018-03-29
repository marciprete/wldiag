package it.senape.wldiag.jpa.model.jta;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Entity
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String xid;//="BEA1-1E47ED1E038FAAAEA9A1"
    private String state;//="active"
    private String status;//="Active"
    private LocalDateTime beginTime;//="1513171463043"
    private String coordinatorURL;//="ManagedServer_1+172.26.80.143:7011+ebooking+t3+"

    @Column(length = 750)
    private String ownerTM;//="ServerTM[ServerCoordinatorDescriptor=(CoordinatorURL=ManagedServer_1+172.26.80.143:7011+ebooking+t3+ CoordinatorNonSecureURL=ManagedServer_1+172.26.80.143:7011+ebooking+t3+ coordinatorSecureURL=ManagedServer_1+172.26.80.143:7503+ebooking+t3s+, XAResources={WSATGatewayRM_ManagedServer_1_ebooking, EBOOKING_DATASOURCE_ebooking},NonXAResources={})]"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="internal_thread_id")
    private InternalThread activeThread;//="Thread[StartupThread_OPTION_BOOKINGS[GRIMALDI FERRY],5,Pooled Threads]"

    private Integer repliesOwedMe;//="0"
    private Integer repliesOwedOthers;//="0"
    private boolean retry;//="false"

    @OneToMany(mappedBy = "transaction",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Set<Property> localProperties = new LinkedHashSet<>();

    @OneToMany(mappedBy = "transaction",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private Set<Property> globalProperties = new LinkedHashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Resource> resources;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jta_id")
    private Jta jta;

    @OneToMany(
            mappedBy = "transaction",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<TransactionServer> servers = new LinkedList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public InternalThread getActiveThread() {
        return activeThread;
    }

    
    public void setActiveThread(InternalThread activeThread) {
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

    public boolean isRetry() {
        return retry;
    }

    
    public void setRetry(boolean retry) {
        this.retry = retry;
    }


    public Set<Property> getGlobalProperties() {
        return globalProperties;
    }

    public void setGlobalProperties(Set<Property> globalProperties) {
        this.globalProperties = globalProperties;
    }

    public Set<Property> getLocalProperties() {
        return localProperties;
    }

    public void setLocalProperties(Set<Property> localProperties) {
        this.localProperties = localProperties;
    }

    public Set<Resource> getResources() {
        return resources;
    }

    public void setResources(Set<Resource> resources) {
        this.resources = resources;
    }

    public Jta getJta() {
        return jta;
    }

    public void setJta(Jta jta) {
        this.jta = jta;
    }

    public List<TransactionServer> getServers() {
        return servers;
    }

    public void setServers(List<TransactionServer> servers) {
        this.servers = servers;
    }

    public void addServer(Server server, Boolean syncRegistered, String state) {
        TransactionServer ts = new TransactionServer(this, server, syncRegistered, state);
        servers.add(ts);
    }

    public void removeServer(Server server) {
        for (Iterator<TransactionServer> iterator = servers.iterator();
             iterator.hasNext(); ) {
            TransactionServer ts = iterator.next();

            if (ts.getTransaction().equals(this) &&
                    ts.getServer().equals(server)) {
                iterator.remove();
                ts.setTransaction(null);
                ts.setServer(null);
            }
        }
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", xid='" + xid + '\'' +
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
                ", resources=" + resources +
                '}';
    }
}
