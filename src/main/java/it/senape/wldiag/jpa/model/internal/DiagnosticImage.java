package it.senape.wldiag.jpa.model.internal;

import it.senape.wldiag.jpa.model.AbstractEntity;
import it.senape.wldiag.jpa.model.jdbc.JdbcResourcePool;
import it.senape.wldiag.jpa.model.jta.Jta;
import it.senape.wldiag.jpa.model.jta.Server;
import it.senape.wldiag.jpa.model.jvm.Jvm;
import it.senape.wldiag.jpa.model.workmanager.WorkManager;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Data
@Entity
public class DiagnosticImage extends AbstractEntity<Long> {

    @NaturalId
    private String fileName;

    private LocalDateTime acquisitionTime;
    private String serverLabel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "server_id")
//    private Server server;

    @OneToOne(fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        mappedBy = "diagnosticImage")
    private Jta jta;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "diagnosticImage")
    private JdbcResourcePool jdbcResourcePool;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "diagnosticImage")
    private WorkManager workManager;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "diagnosticImage")
    private Jvm jvm;

}
