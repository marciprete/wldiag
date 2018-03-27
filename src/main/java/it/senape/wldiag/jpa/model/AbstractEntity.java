package it.senape.wldiag.jpa.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * Created by michele.arciprete on 27-Jan-18.
 */
@MappedSuperclass
public abstract class AbstractEntity<ID extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(unique = true, updatable = false, nullable = false)
    private ID id;

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

}