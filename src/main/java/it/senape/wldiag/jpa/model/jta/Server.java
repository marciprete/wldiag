package it.senape.wldiag.jpa.model.jta;

import it.senape.wldiag.jpa.model.AbstractEntity;
import it.senape.wldiag.jpa.model.internal.Customer;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Data
@Entity
//@NaturalIdCache
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Server extends AbstractEntity<Long> {

    private String serverName;
    private String label;

    private String url;
    private String listenAddress;
    private Long serverPort;

    private String domain;
    private String connection;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
