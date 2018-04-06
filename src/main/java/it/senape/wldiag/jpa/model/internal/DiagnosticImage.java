package it.senape.wldiag.jpa.model.internal;

import it.senape.wldiag.jpa.model.AbstractEntity;
import it.senape.wldiag.jpa.model.jdbc.JdbcResourcePool;
import it.senape.wldiag.jpa.model.jta.Jta;
import it.senape.wldiag.jpa.model.workmanager.WorkManager;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Entity
public class DiagnosticImage extends AbstractEntity<Long> {

    @Column(nullable = false)
    private String fileName;

    private LocalDateTime acquisitionTime;

    private String serverName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

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

    public LocalDateTime getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(LocalDateTime acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Jta getJta() {
        return jta;
    }

    public void setJta(Jta jta) {
        this.jta = jta;
    }

    public JdbcResourcePool getJdbcResourcePool() {
        return jdbcResourcePool;
    }

    public void setJdbcResourcePool(JdbcResourcePool jdbcResourcePool) {
        this.jdbcResourcePool = jdbcResourcePool;
    }
}
