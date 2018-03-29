package it.senape.wldiag.jpa.model.jta;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Entity
public class XAResource implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;//="EBOOKING_DATASOURCE_ebooking"
    private String enlistmentType;//="dynamic"
    private Boolean registered;//="true"
    private Boolean coordinatedLocally;//="false"
    private Boolean unregistering;//="false"
    private Integer transactionReferenceCount;//="3"
    private Boolean assignableOnlyToEnlistingServers;//="true"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jta_id")
    private Jta jta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnlistmentType() {
        return enlistmentType;
    }

    public void setEnlistmentType(String enlistmentType) {
        this.enlistmentType = enlistmentType;
    }

    public Boolean isRegistered() {
        return registered;
    }

    public void setRegistered(Boolean registered) {
        this.registered = registered;
    }

    public Boolean isCoordinatedLocally() {
        return coordinatedLocally;
    }

    public void setCoordinatedLocally(Boolean coordinatedLocally) {
        this.coordinatedLocally = coordinatedLocally;
    }

    public Boolean isUnregistering() {
        return unregistering;
    }

    public void setUnregistering(Boolean unregistering) {
        this.unregistering = unregistering;
    }

    public Integer getTransactionReferenceCount() {
        return transactionReferenceCount;
    }

    public void setTransactionReferenceCount(Integer transactionReferenceCount) {
        this.transactionReferenceCount = transactionReferenceCount;
    }

    public Boolean isAssignableOnlyToEnlistingServers() {
        return assignableOnlyToEnlistingServers;
    }

    public void setAssignableOnlyToEnlistingServers(Boolean assignableOnlyToEnlistingServers) {
        this.assignableOnlyToEnlistingServers = assignableOnlyToEnlistingServers;
    }

    public Boolean getRegistered() {
        return registered;
    }

    public Boolean getCoordinatedLocally() {
        return coordinatedLocally;
    }

    public Boolean getUnregistering() {
        return unregistering;
    }

    public Boolean getAssignableOnlyToEnlistingServers() {
        return assignableOnlyToEnlistingServers;
    }

    public Jta getJta() {
        return jta;
    }

    public void setJta(Jta jta) {
        this.jta = jta;
    }

    @Override
    public String toString() {
        return "XAResource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", enlistmentType='" + enlistmentType + '\'' +
                ", registered=" + registered +
                ", coordinatedLocally=" + coordinatedLocally +
                ", unregistering=" + unregistering +
                ", transactionReferenceCount=" + transactionReferenceCount +
                ", assignableOnlyToEnlistingServers=" + assignableOnlyToEnlistingServers +
                '}';
    }
}
