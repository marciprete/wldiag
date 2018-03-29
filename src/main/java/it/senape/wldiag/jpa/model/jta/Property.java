package it.senape.wldiag.jpa.model.jta;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Entity
@Table(name = "property")
@Inheritance(strategy = InheritanceType.JOINED)
public class Property implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "property_id")
    private Long id;

    private String name;

    @Column(length = 750)
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transaction_id")
    private Transaction transaction;

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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
}
