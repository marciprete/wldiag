package it.senape.wldiag.jpa.model.jvm;

import it.senape.wldiag.jpa.model.AbstractEntity;

import javax.persistence.Entity;

/**
 * Created by michele.arciprete on 05-Apr-18
 */
@Entity
public class Work extends AbstractEntity<Long> {

    private String type;
    private String workManager;
    private Integer version;
    private Boolean scheduled;
    private Boolean started;
    private Long startedTimeMillis;

    public Work(){}

    public Work(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWorkManager() {
        return workManager;
    }

    public void setWorkManager(String workManager) {
        this.workManager = workManager;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Boolean getScheduled() {
        return scheduled;
    }

    public void setScheduled(Boolean scheduled) {
        this.scheduled = scheduled;
    }

    public Boolean getStarted() {
        return started;
    }

    public void setStarted(Boolean started) {
        this.started = started;
    }

    public Long getStartedTimeMillis() {
        return startedTimeMillis;
    }

    public void setStartedTimeMillis(Long startedTimeMillis) {
        this.startedTimeMillis = startedTimeMillis;
    }

    @Override
    public String toString() {
        return "Work{" +
                "type='" + type + '\'' +
                ", workManager='" + workManager + '\'' +
                ", version=" + version +
                ", scheduled=" + scheduled +
                ", started=" + started +
                ", startedTimeMillis=" + startedTimeMillis +
                '}';
    }
}
