package it.senape.wldiag.jpa.model.jvm;

import it.senape.wldiag.jpa.model.AbstractEntity;

import javax.persistence.*;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Entity
public class ExecutionDetails extends AbstractEntity<Long> {

    private String ECID;

    @OneToOne(fetch = FetchType.LAZY,
    cascade = CascadeType.REMOVE)
    @JoinColumn(name = "work_id")
    private Work work;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
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

    @Override
    public String toString() {
        return "ExecutionDetails{" +
                "ECID='" + ECID + '\'' +
                ", work=" + work +
                '}';
    }
}
