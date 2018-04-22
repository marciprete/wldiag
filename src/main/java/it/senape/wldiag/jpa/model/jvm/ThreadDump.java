package it.senape.wldiag.jpa.model.jvm;

import it.senape.wldiag.jpa.model.AbstractEntity;
import it.senape.wldiag.jpa.model.jta.InternalThread;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Entity
//@Table(
//        uniqueConstraints = @UniqueConstraint(columnNames = {"thread_id", "thread_name"})
//)
public class ThreadDump extends AbstractEntity<Long> {

//    @Column(name = "thread_id")
    private Long threadId;
//    @Column(name = "thread_name")
    private String threadName;
    private String javaThreadState;
    private String stateInformation;

    private String threadType; //daemon;
    private String prio;
    private String osPrio;
    private String tid;
    private String nid;
    private String status; //waiting on condition, running, in Object.wait()
    private String onCondition;

    private String referencedTid;
    private String wlsStatus;


    @Column(columnDefinition = "TEXT")
    private String stackTrace;
    private String extraInfo;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            mappedBy = "threadDump")
    private ExecutionDetails executionDetails;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="internal_thread_id")
    private InternalThread internalThread;

    @ManyToOne(fetch = FetchType.LAZY,
        cascade = CascadeType.REMOVE)
    @JoinColumn(name="jvm_id")
    private Jvm jvm;

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public String getJavaThreadState() {
        return javaThreadState;
    }

    public void setJavaThreadState(String state) {
        this.javaThreadState = state;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public ExecutionDetails getExecutionDetails() {
        return executionDetails;
    }

    public void setExecutionDetails(ExecutionDetails executionDetails) {
        this.executionDetails = executionDetails;
    }

    public InternalThread getInternalThread() {
        return internalThread;
    }

    public void setInternalThread(InternalThread internalThread) {
        this.internalThread = internalThread;
    }

    public Jvm getJvm() {
        return jvm;
    }

    public void setJvm(Jvm jvm) {
        this.jvm = jvm;
    }

    public String getStateInformation() {
        return stateInformation;
    }

    public void setStateInformation(String stateInformation) {
        this.stateInformation = stateInformation;
    }

    public String getThreadType() {
        return threadType;
    }

    public void setThreadType(String threadType) {
        this.threadType = threadType;
    }

    public String getPrio() {
        return prio;
    }

    public void setPrio(String prio) {
        this.prio = prio;
    }

    public String getOsPrio() {
        return osPrio;
    }

    public void setOsPrio(String osPrio) {
        this.osPrio = osPrio;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOnCondition() {
        return onCondition;
    }

    public void setOnCondition(String onCondition) {
        this.onCondition = onCondition;
    }

    public String getReferencedTid() {
        return referencedTid;
    }

    public void setReferencedTid(String referencedTid) {
        this.referencedTid = referencedTid;
    }

    public String getWlsStatus() {
        return wlsStatus;
    }

    public void setWlsStatus(String wlsStatus) {
        this.wlsStatus = wlsStatus;
    }

    @Override
    public String toString() {
        return "ThreadDump{" +
                "threadId=" + threadId +
                ", threadName='" + threadName + '\'' +
                ", javaThreadState='" + javaThreadState + '\'' +
                ", stateInformation='" + stateInformation + '\'' +
                ", threadType='" + threadType + '\'' +
                ", prio='" + prio + '\'' +
                ", osPrio='" + osPrio + '\'' +
                ", tid='" + tid + '\'' +
                ", nid='" + nid + '\'' +
                ", status='" + status + '\'' +
                ", onCondition='" + onCondition + '\'' +
                ", stackTrace='" + stackTrace + '\'' +
                ", extraInfo='" + extraInfo + '\'' +
                ", executionDetails=" + executionDetails +
                ", internalThread=" + internalThread +
                '}';
    }
}
