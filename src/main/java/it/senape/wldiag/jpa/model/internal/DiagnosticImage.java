package it.senape.wldiag.jpa.model.internal;

import it.senape.wldiag.jpa.model.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Entity
public class DiagnosticImage extends AbstractEntity<Long> {

    private String fileName;

    private LocalDateTime acquisitionTime;

    private String serverName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "server_id")
//    private Server server;

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
    //    public Server getServer() {
//        return server;
//    }
//
//    public void setServer(Server server) {
//        this.server = server;
//    }
}
