package it.senape.wldiag.jpa.model.jta;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Entity
public class TMXAResource implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer timeout;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<ForeignXid> foreignXids;

    @OneToOne
    @JoinColumn(name="transaction_id")
    private Transaction transaction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTimeout() {
        return timeout;
    }

    @XmlAttribute
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Set<ForeignXid> getForeignXids() {
        return foreignXids;
    }

    public void setForeignXids(Set<ForeignXid> foreignXids) {
        this.foreignXids = foreignXids;
    }

    @Override
    public String toString() {
        return "TMXAResource{" +
                "id=" + id +
                ", timeout=" + timeout +
                '}';
    }
}
