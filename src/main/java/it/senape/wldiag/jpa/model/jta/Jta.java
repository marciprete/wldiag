package it.senape.wldiag.jpa.model.jta;

import it.senape.wldiag.jpa.model.internal.DiagnosticImage;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Entity
public class Jta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer defaultTimeout;//="3600"
    private Integer abandonTimeout;//="7200"
    private Integer completionTimeout;//="0"
    private Boolean forgetHeuristics;//="true"
    private Integer beforeCompletionIterationLimit;//="10"
    private Integer maxTransactions;//="10000"
    private Integer maxUniqueNameStatistics;//="1000"
    private String tlogStoreName;//="_WLS_ManagedServer_1"
    private String hlogStoreName;//="_WLS_ManagedServer_1"
    private LocalDateTime lastCheckpointTime;//="1513171401858"
    private Long checkpointInterval;//="300000"
    private Boolean parallelXAEnabled;//="true"
    private Boolean twoPhaseEnabled;//="false"

    @Enumerated(EnumType.STRING)
    private Health health;

    @OneToMany(
            mappedBy = "jta",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private Set<Transaction> transactions = new LinkedHashSet<>();

    private Integer transactionCount;

    @OneToOne(fetch = FetchType.LAZY,
        cascade = CascadeType.REMOVE
    )
    @JoinColumn(name = "diagnostic_image_id")
    private DiagnosticImage diagnosticImage;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    private TMXAResource tmxaResource;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
//    @JoinColumn(name = "jta_id")
    private Set<Server> servers = new LinkedHashSet<>();

//    @OneToMany(
//            mappedBy = "jta",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//    private Set<XAResource> resources = new LinkedHashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDefaultTimeout() {
        return defaultTimeout;
    }

    public void setDefaultTimeout(Integer defaultTimeout) {
        this.defaultTimeout = defaultTimeout;
    }

    public Integer getAbandonTimeout() {
        return abandonTimeout;
    }

    public void setAbandonTimeout(Integer abandonTimeout) {
        this.abandonTimeout = abandonTimeout;
    }

    public Integer getCompletionTimeout() {
        return completionTimeout;
    }

    public void setCompletionTimeout(Integer completionTimeout) {
        this.completionTimeout = completionTimeout;
    }

    public Boolean isForgetHeuristics() {
        return forgetHeuristics;
    }

    public void setForgetHeuristics(Boolean forgetHeuristics) {
        this.forgetHeuristics = forgetHeuristics;
    }

    public Integer getBeforeCompletionIterationLimit() {
        return beforeCompletionIterationLimit;
    }

    public void setBeforeCompletionIterationLimit(Integer beforeCompletionIterationLimit) {
        this.beforeCompletionIterationLimit = beforeCompletionIterationLimit;
    }

    public Integer getMaxTransactions() {
        return maxTransactions;
    }

    public void setMaxTransactions(Integer maxTransactions) {
        this.maxTransactions = maxTransactions;
    }

    public Integer getMaxUniqueNameStatistics() {
        return maxUniqueNameStatistics;
    }

    public void setMaxUniqueNameStatistics(Integer maxUniqueNameStatistics) {
        this.maxUniqueNameStatistics = maxUniqueNameStatistics;
    }

    public String getTlogStoreName() {
        return tlogStoreName;
    }

    public void setTlogStoreName(String tlogStoreName) {
        this.tlogStoreName = tlogStoreName;
    }

    public String getHlogStoreName() {
        return hlogStoreName;
    }

    public void setHlogStoreName(String hlogStoreName) {
        this.hlogStoreName = hlogStoreName;
    }

    public LocalDateTime getLastCheckpointTime() {
        return lastCheckpointTime;
    }

    public void setLastCheckpointTime(LocalDateTime lastCheckpointTime) {
        this.lastCheckpointTime = lastCheckpointTime;
    }

    public Long getCheckpointInterval() {
        return checkpointInterval;
    }

    public void setCheckpointInterval(Long checkpointInterval) {
        this.checkpointInterval = checkpointInterval;
    }

    public Boolean isParallelXAEnabled() {
        return parallelXAEnabled;
    }

    public void setParallelXAEnabled(Boolean parallelXAEnabled) {
        this.parallelXAEnabled = parallelXAEnabled;
    }

    public Boolean isTwoPhaseEnabled() {
        return twoPhaseEnabled;
    }

    public void setTwoPhaseEnabled(Boolean twoPhaseEnabled) {
        this.twoPhaseEnabled = twoPhaseEnabled;
    }

    public Health getHealth() {
        return health;
    }

    public void setHealth(Health health) {
        this.health = health;
    }

//    public Set<XAResource> getResources() {
//        return resources;
//    }

//    public void setResources(Set<XAResource> resources) {
//        this.resources = resources;
//    }

    public Set<Server> getServers() {
        return servers;
    }

    public void setServers(Set<Server> servers) {
        this.servers = servers;
    }

    public TMXAResource getTmxaResource() {
        return tmxaResource;
    }

    public void setTmxaResource(TMXAResource tmxaResource) {
        this.tmxaResource = tmxaResource;
    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Set<Transaction> transactions) {
        this.transactions = transactions;
    }


    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        transaction.setJta(this);
    }

    public Boolean getForgetHeuristics() {
        return forgetHeuristics;
    }

    public Boolean getParallelXAEnabled() {
        return parallelXAEnabled;
    }

    public Boolean getTwoPhaseEnabled() {
        return twoPhaseEnabled;
    }

    public DiagnosticImage getDiagnosticImage() {
        return diagnosticImage;
    }

    public void setDiagnosticImage(DiagnosticImage diagnosticImage) {
        this.diagnosticImage = diagnosticImage;
    }

    public Integer getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(Integer transactionCount) {
        this.transactionCount = transactionCount;
    }

    @Override
    public String toString() {
        return "Jta{" +
                "id=" + id +
                ", defaultTimeout=" + defaultTimeout +
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
//                ", servers=" + servers +
//                ", resources=" + resources +
                '}';
    }

}
