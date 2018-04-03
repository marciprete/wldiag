package it.senape.wldiag.dto;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@XmlRootElement(name = "JTA")
public class JtaDto implements Serializable {
    private int defaultTimeout;//="3600"
    private int abandonTimeout;//="7200"
    private int completionTimeout;//="0"
    private boolean forgetHeuristics;//="true"
    private int beforeCompletionIterationLimit;//="10"
    private int maxTransactions;//="10000"
    private int maxUniqueNameStatistics;//="1000"
    private String tlogStoreName;//="_WLS_ManagedServer_1"
    private String hlogStoreName;//="_WLS_ManagedServer_1"
    private long lastCheckpointTime;//="1513171401858"
    private long checkpointInterval;//="300000"
    private boolean parallelXAEnabled;//="true"
    private boolean twoPhaseEnabled;//="false"

    private HealthDto health;

    private Collection<TransactionDto> transactions;

    private TMXAResourceDto tmxaResource;

    private Set<ServerDto> servers;

    private Set<XAResourceDto> resources;

    private Long diagnosticImageId;

    public Long getDiagnosticImageId() {
        return diagnosticImageId;
    }

    public void setDiagnosticImageId(Long diagnosticImageId) {
        this.diagnosticImageId = diagnosticImageId;
    }

    public int getDefaultTimeout() {
        return defaultTimeout;
    }

    @XmlAttribute
    public void setDefaultTimeout(int defaultTimeout) {
        this.defaultTimeout = defaultTimeout;
    }

    public int getAbandonTimeout() {
        return abandonTimeout;
    }

    @XmlAttribute
    public void setAbandonTimeout(int abandonTimeout) {
        this.abandonTimeout = abandonTimeout;
    }

    public int getCompletionTimeout() {
        return completionTimeout;
    }

    @XmlAttribute
    public void setCompletionTimeout(int completionTimeout) {
        this.completionTimeout = completionTimeout;
    }

    public boolean isForgetHeuristics() {
        return forgetHeuristics;
    }

    @XmlAttribute
    public void setForgetHeuristics(boolean forgetHeuristics) {
        this.forgetHeuristics = forgetHeuristics;
    }

    public int getBeforeCompletionIterationLimit() {
        return beforeCompletionIterationLimit;
    }

    @XmlAttribute
    public void setBeforeCompletionIterationLimit(int beforeCompletionIterationLimit) {
        this.beforeCompletionIterationLimit = beforeCompletionIterationLimit;
    }

    public int getMaxTransactions() {
        return maxTransactions;
    }

    @XmlAttribute
    public void setMaxTransactions(int maxTransactions) {
        this.maxTransactions = maxTransactions;
    }

    public int getMaxUniqueNameStatistics() {
        return maxUniqueNameStatistics;
    }

    @XmlAttribute
    public void setMaxUniqueNameStatistics(int maxUniqueNameStatistics) {
        this.maxUniqueNameStatistics = maxUniqueNameStatistics;
    }

    public String getTlogStoreName() {
        return tlogStoreName;
    }

    @XmlAttribute
    public void setTlogStoreName(String tlogStoreName) {
        this.tlogStoreName = tlogStoreName;
    }

    public String getHlogStoreName() {
        return hlogStoreName;
    }

    @XmlAttribute
    public void setHlogStoreName(String hlogStoreName) {
        this.hlogStoreName = hlogStoreName;
    }

    public long getLastCheckpointTime() {
        return lastCheckpointTime;
    }

    @XmlAttribute
    public void setLastCheckpointTime(long lastCheckpointTime) {
        this.lastCheckpointTime = lastCheckpointTime;
    }

    public long getCheckpointInterval() {
        return checkpointInterval;
    }

    @XmlAttribute
    public void setCheckpointInterval(long checkpointInterval) {
        this.checkpointInterval = checkpointInterval;
    }

    public boolean isParallelXAEnabled() {
        return parallelXAEnabled;
    }

    @XmlAttribute
    public void setParallelXAEnabled(boolean parallelXAEnabled) {
        this.parallelXAEnabled = parallelXAEnabled;
    }

    public boolean isTwoPhaseEnabled() {
        return twoPhaseEnabled;
    }

    @XmlAttribute
    public void setTwoPhaseEnabled(boolean twoPhaseEnabled) {
        this.twoPhaseEnabled = twoPhaseEnabled;
    }

    public HealthDto getHealth() {
        return health;
    }

    @XmlElement(name="Health")
    public void setHealth(HealthDto health) {
        this.health = health;
    }

    public Set<XAResourceDto> getResources() {
        return resources;
    }

    @XmlElementWrapper(name = "Resources")
    @XmlElement(name = "XAResource")
    public void setResources(Set<XAResourceDto> resources) {
        this.resources = resources;
    }

    public Set<ServerDto> getServers() {
        return servers;
    }

    @XmlElementWrapper(name = "Servers")
    @XmlElement(name="Server")
    public void setServers(Set<ServerDto> servers) {
        this.servers = servers;
    }

    public Collection<TransactionDto> getTransactions() {
        return transactions;
    }

    @XmlElementWrapper(name="TxMap")
    @XmlElement(name = "Transaction")
    public void setTransactions(Collection<TransactionDto> transactions) {
        this.transactions = transactions;
    }

    public TMXAResourceDto getTmxaResource() {
        return tmxaResource;
    }

    @XmlElement(name = "TMXAResource")
    public void setTmxaResource(TMXAResourceDto tmxaResource) {
        this.tmxaResource = tmxaResource;
    }

    @Override
    public String toString() {
        return "JtaDTO{" +
                "defaultTimeout=" + defaultTimeout +
                ", abandonTimeout=" + abandonTimeout +
                ", completionTimeout=" + completionTimeout +
                ", forgetHeuristics=" + forgetHeuristics +
                ", beforeCompletionIterationLimit=" + beforeCompletionIterationLimit +
                ", maxTransactions=" + maxTransactions +
                ", maxUniqueNameStatistics=" + maxUniqueNameStatistics +
                ", tlogStoreName='" + tlogStoreName + '\'' +
                ", hlogStoreName='" + hlogStoreName + '\'' +
                ", lastCheckpointTime=" + lastCheckpointTime +
                ", checkpointInterval=" + checkpointInterval +
                ", parallelXAEnabled=" + parallelXAEnabled +
                ", twoPhaseEnabled=" + twoPhaseEnabled +
                ", health=" + health +
                ", transactions=" + transactions +
                ", tmxaResource=" + tmxaResource +
                ", servers=" + servers +
                ", resources=" + resources +
                '}';
    }

}
