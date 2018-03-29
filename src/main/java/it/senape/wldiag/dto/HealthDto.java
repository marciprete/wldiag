package it.senape.wldiag.dto;

import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public class HealthDto implements Serializable {

    private HealthState healthState;

    public HealthState getHealthState() {
        return healthState;
    }

    @XmlAttribute(name="state")
    public void setHealthState(HealthState healthState) {
        this.healthState = healthState;
    }

    @Override
    public String toString() {
        return "Health{" +
                "healthState=" + healthState +
                '}';
    }
}
