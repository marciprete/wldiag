package it.senape.wldiag.jpa.model.jta;

import it.senape.wldiag.jpa.model.AbstractEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Entity
public class Resource extends AbstractEntity<Long> {

    private String name;//="EBOOKING_DATASOURCE_ebooking"
    private String state;//="started"

    @NaturalId
    private String xid;//="BEA1-1E47ED1E038FAAAEA9A1-45424F4F4B494E475F44415441534F555243455F65626F6F6B696E67"
    private Boolean busy;//="false"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getXid() {
        return xid;
    }

    public void setXid(String xid) {
        this.xid = xid;
    }

    public Boolean isBusy() {
        return busy;
    }

    public void setBusy(Boolean busy) {
        this.busy = busy;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", state='" + state + '\'' +
                ", xid='" + xid + '\'' +
                ", busy=" + busy +
                '}';
    }
}
