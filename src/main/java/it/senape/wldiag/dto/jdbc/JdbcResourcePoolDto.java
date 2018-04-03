package it.senape.wldiag.dto.jdbc;

import it.senape.wldiag.jpa.model.jdbc.AvailableResource;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by michele.arciprete on 03-Apr-18
 */
public class JdbcResourcePoolDto implements Serializable {

    private Integer currentCapacity;
    private String poolname;
    private Collection<JdbcResourceDto> availableResources = new ArrayList<>();
    private Collection<JdbcResourceDto> reservedResources = new ArrayList<>();
    private Collection<JdbcResourceDto> deadResources = new ArrayList<>();

    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(Integer currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public String getPoolname() {
        return poolname;
    }

    public void setPoolname(String poolname) {
        this.poolname = poolname;
    }

    public Collection<JdbcResourceDto> getAvailableResources() {
        return availableResources;
    }

    public void setAvailableResources(Collection<JdbcResourceDto> availableResources) {
        this.availableResources = availableResources;
    }

    public Collection<JdbcResourceDto> getReservedResources() {
        return reservedResources;
    }

    public void setReservedResources(Collection<JdbcResourceDto> reservedResources) {
        this.reservedResources = reservedResources;
    }

    public Collection<JdbcResourceDto> getDeadResources() {
        return deadResources;
    }

    public void setDeadResources(Collection<JdbcResourceDto> deadResources) {
        this.deadResources = deadResources;
    }
}
