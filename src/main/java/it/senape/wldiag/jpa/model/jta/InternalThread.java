package it.senape.wldiag.jpa.model.jta;

import it.senape.wldiag.jpa.model.AbstractEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Entity
public class InternalThread extends AbstractEntity<Long>  {

    @NaturalId
    private String name;
    private Integer poolNumber;
    private String type;

    @OneToMany(
            mappedBy = "activeThread",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    private List<Transaction> transactions = new LinkedList<>();

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

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setActiveThread(this);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
        transaction.setActiveThread(null);
    }

    @Override
    public String toString() {
        return "InternalThread{" +
                "name='" + name + '\'' +
                ", poolNumber=" + poolNumber +
                ", type='" + type + '\'' +
                '}';
    }
}
