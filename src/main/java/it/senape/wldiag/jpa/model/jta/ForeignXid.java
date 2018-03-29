package it.senape.wldiag.jpa.model.jta;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Entity
public class ForeignXid implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tmxaresource_id")
    private TMXAResource tmxaResource;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TMXAResource getTmxaResource() {
        return tmxaResource;
    }

    public void setTmxaResource(TMXAResource tmxaResource) {
        this.tmxaResource = tmxaResource;
    }
}
