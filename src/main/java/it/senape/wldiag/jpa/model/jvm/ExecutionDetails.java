package it.senape.wldiag.jpa.model.jvm;

import it.senape.wldiag.jpa.model.AbstractEntity;

import javax.persistence.*;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Entity
public class ExecutionDetails extends AbstractEntity<Long> {

    private String ECID;
    private Long threadId;

    @OneToOne(fetch = FetchType.LAZY,
        cascade = CascadeType.ALL,
        orphanRemoval = true,
        mappedBy = "executionDetails")
    private Work work;

    @OneToOne(fetch = FetchType.LAZY,
        cascade = CascadeType.REMOVE)
    @JoinColumn(name = "thread_dump_id")
    private ThreadDump threadDump;

    public String getECID() {
        return ECID;
    }

    public void setECID(String ECID) {
        this.ECID = ECID;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }

    public ThreadDump getThreadDump() {
        return threadDump;
    }

    public void setThreadDump(ThreadDump threadDump) {
        this.threadDump = threadDump;
    }

    public Long getThreadId() {
        return threadId;
    }

    public void setThreadId(Long threadId) {
        this.threadId = threadId;
    }

    @Override
    public String toString() {
        return "ExecutionDetails{" +
                "ECID='" + ECID + '\'' +
                ", work=" + work +
                '}';
    }
}
