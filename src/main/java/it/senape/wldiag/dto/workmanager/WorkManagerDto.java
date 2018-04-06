package it.senape.wldiag.dto.workmanager;

import java.io.Serializable;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
public class WorkManagerDto implements Serializable {

    private Integer totalThreadCount;
    private Integer idleThreadCount;
    private Integer standbyThreadCount;
    private Integer queueDepth;
    private Long queueDepartures;
    private Double meanThroughput;
    private Integer totalRequests;

    private Long diagnosticImageId;

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

    public Long getDiagnosticImageId() {
        return diagnosticImageId;
    }

    public void setDiagnosticImageId(Long diagnosticImageId) {
        this.diagnosticImageId = diagnosticImageId;
    }
}
