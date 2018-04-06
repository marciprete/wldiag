package it.senape.wldiag.dto;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public class XAResourceDto implements Serializable {
    private String name;//="EBOOKING_DATASOURCE_ebooking"
    private String enlistmentType;//="dynamic"
    private boolean registered;//="true"
    private boolean coordinatedLocally;//="false"
    private boolean unregistering;//="false"
    private int transactionReferenceCount;//="3"
    private boolean assignableOnlyToEnlistingServers;//="true"

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public String getEnlistmentType() {
        return enlistmentType;
    }

    @XmlAttribute
    public void setEnlistmentType(String enlistmentType) {
        this.enlistmentType = enlistmentType;
    }

    public boolean isRegistered() {
        return registered;
    }

    @XmlAttribute
    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isCoordinatedLocally() {
        return coordinatedLocally;
    }

    @XmlAttribute
    public void setCoordinatedLocally(boolean coordinatedLocally) {
        this.coordinatedLocally = coordinatedLocally;
    }

    public boolean isUnregistering() {
        return unregistering;
    }

    @XmlAttribute
    public void setUnregistering(boolean unregistering) {
        this.unregistering = unregistering;
    }

    public int getTransactionReferenceCount() {
        return transactionReferenceCount;
    }

    @XmlAttribute
    public void setTransactionReferenceCount(int transactionReferenceCount) {
        this.transactionReferenceCount = transactionReferenceCount;
    }

    public boolean isAssignableOnlyToEnlistingServers() {
        return assignableOnlyToEnlistingServers;
    }

    @XmlAttribute
    public void setAssignableOnlyToEnlistingServers(boolean assignableOnlyToEnlistingServers) {
        this.assignableOnlyToEnlistingServers = assignableOnlyToEnlistingServers;
    }

    @Override
    public String toString() {
        return "XAResource{" +
                "name='" + name + '\'' +
                ", enlistmentType='" + enlistmentType + '\'' +
                ", registered=" + registered +
                ", coordinatedLocally=" + coordinatedLocally +
                ", unregistering=" + unregistering +
                ", transactionReferenceCount=" + transactionReferenceCount +
                ", assignableOnlyToEnlistingServers=" + assignableOnlyToEnlistingServers +
                '}';
    }
}
