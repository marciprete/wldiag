package it.senape.wldiag.jpa.model.jvm;

import it.senape.wldiag.jpa.model.AbstractEntity;
import it.senape.wldiag.jpa.model.jta.InternalThread;

import javax.persistence.*;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Entity
public class ThreadDump extends AbstractEntity<Long> {

    private Long threadId;
    private String threadName;
    private String state;
    private String stackTrace;
    private String extraInfo;

    @OneToOne(mappedBy = "threadDump", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    @Override
    public String toString() {
        return "ThreadDump{" +
                "threadId=" + threadId +
                ", threadName='" + threadName + '\'' +
                ", state='" + state + '\'' +
                ", stackTrace='" + stackTrace + '\'' +
                ", extraInfo='" + extraInfo + '\'' +
                ", executionDetails=" + executionDetails +
                '}';
    }
}
