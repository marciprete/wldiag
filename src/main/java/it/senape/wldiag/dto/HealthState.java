package it.senape.wldiag.dto;

import java.io.Serializable;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public enum HealthState implements Serializable {
    HEALTH_OK("HEALTH_OK"),
    CRITICAL("CRITICAL");

    private String state;

    HealthState(String state) {
        this.state=state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "HealthState{" +
                "state='" + state + '\'' +
                '}';
    }
}
