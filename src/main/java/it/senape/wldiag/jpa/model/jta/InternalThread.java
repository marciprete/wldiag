package it.senape.wldiag.jpa.model.jta;

import it.senape.wldiag.jpa.model.AbstractEntity;

import javax.persistence.*;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Entity
public class InternalThread extends AbstractEntity<Long>  {

    private String name;
    private Integer poolNumber;
    private String type;
    private String wlsStatus;

    @OneToOne(cascade = CascadeType.REMOVE,
            fetch = FetchType.LAZY)
    @JoinColumn(name="transaction_id")
    private Transaction transaction;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoolNumber() {
        return poolNumber;
    }

    public void setPoolNumber(Integer poolNumber) {
        this.poolNumber = poolNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    //    public void addTransaction(Transaction transaction) {
//        transactions.add(transaction);
//        transaction.setActiveThread(this);
//    }

//    public void removeTransaction(Transaction transaction) {
//        transactions.remove(transaction);
//        transaction.setActiveThread(null);
//    }

    public String getWlsStatus() {
        return wlsStatus;
    }

    public void setWlsStatus(String wlsStatus) {
        this.wlsStatus = wlsStatus;
    }

    @Override
    public String toString() {
        return "InternalThread{" +
                "name='" + name + '\'' +
                ", poolNumber=" + poolNumber +
                ", type='" + type + '\'' +
                ", wlsStatus='" + wlsStatus + '\'' +
                '}';
    }
}
