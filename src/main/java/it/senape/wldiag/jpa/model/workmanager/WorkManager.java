package it.senape.wldiag.jpa.model.workmanager;

import it.senape.wldiag.jpa.model.AbstractEntity;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Entity
public class WorkManager extends AbstractEntity<Long> {

    private Integer totalThreadCount;
    private Integer idleThreadCount;
    private Integer standbyThreadCount;
    private Integer queueDepth;
    private Long queueDepartures;
    private Double meanThroughput;
    private Integer totalRequests;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    private DiagnosticImage diagnosticImage;

    public Integer getTotalThreadCount() {
        return totalThreadCount;
    }

    public void setTotalThreadCount(Integer totalThreadCount) {
        this.totalThreadCount = totalThreadCount;
    }

    public Integer getIdleThreadCount() {
        return idleThreadCount;
    }

    public void setIdleThreadCount(Integer idleThreadCount) {
        this.idleThreadCount = idleThreadCount;
    }

    public Integer getStandbyThreadCount() {
        return standbyThreadCount;
    }

    public void setStandbyThreadCount(Integer standbyThreadCount) {
        this.standbyThreadCount = standbyThreadCount;
    }

    public Integer getQueueDepth() {
        return queueDepth;
    }

    public void setQueueDepth(Integer queueDepth) {
        this.queueDepth = queueDepth;
    }

    public Long getQueueDepartures() {
        return queueDepartures;
    }

    public void setQueueDepartures(Long queueDepartures) {
        this.queueDepartures = queueDepartures;
    }

    public Double getMeanThroughput() {
        return meanThroughput;
    }

    public void setMeanThroughput(Double meanThroughput) {
        this.meanThroughput = meanThroughput;
    }

    public Integer getTotalRequests() {
        return totalRequests;
    }

    public void setTotalRequests(Integer totalRequests) {
        this.totalRequests = totalRequests;
    }

    public DiagnosticImage getDiagnosticImage() {
        return diagnosticImage;
    }

    public void setDiagnosticImage(DiagnosticImage diagnosticImage) {
        this.diagnosticImage = diagnosticImage;
    }

    @Override
    public String toString() {
        return "WorkManager{" +
                "totalThreadCount=" + totalThreadCount +
                ", idleThreadCount=" + idleThreadCount +
                ", standbyThreadCount=" + standbyThreadCount +
                ", queueDepth=" + queueDepth +
                ", queueDepartures=" + queueDepartures +
                ", meanThroughput=" + meanThroughput +
                ", totalRequests=" + totalRequests +
                ", diagnosticImage=" + diagnosticImage +
                '}';
    }
}
