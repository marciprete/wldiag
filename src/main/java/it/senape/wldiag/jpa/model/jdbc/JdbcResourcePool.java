package it.senape.wldiag.jpa.model.jdbc;

import it.senape.wldiag.jpa.model.AbstractEntity;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by michele.arciprete on 25-Jan-18.
 */
@Entity
@AttributeOverride(name = "id", column = @Column(name = "jdbc_resource_pool_id"))
public class JdbcResourcePool extends AbstractEntity<Long> {

    private Integer currentCapacity;

    private String poolname;

    @OneToMany(//mappedBy = "resourcePool",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    @JoinTable(name = "jdbc_available_resource",
            joinColumns = {@JoinColumn(name = "available_resource_id")}
            , inverseJoinColumns = {@JoinColumn(name="jdbc_resource_pool_id")})
    private Set<AvailableResource> availableResources = new LinkedHashSet<>();

    @OneToMany(//mappedBy = "resourcePool",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinTable(name = "jdbc_reserved_resource",
            joinColumns = {@JoinColumn(name = "reserved_resource_id")}
            , inverseJoinColumns = {@JoinColumn(name="jdbc_resource_pool_id")})
    private Set<ReservedResource> reservedResources = new LinkedHashSet<>();

    @OneToMany(//mappedBy = "resourcePool",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY)
    @JoinTable(name = "jdbc_dead_resource",
            joinColumns = {@JoinColumn(name = "dead_resource_id")}
            , inverseJoinColumns = {@JoinColumn(name="jdbc_resource_pool_id")})
    private Set<DeadResource> deadResources = new LinkedHashSet<>();


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diagnostic_image_id")
    private DiagnosticImage diagnosticImage;

    public String getPoolname() {
        return poolname;
    }

    public void setPoolname(String poolname) {
        this.poolname = poolname;
    }

    public Integer getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(Integer currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public Set<AvailableResource> getAvailableResources() {
        return availableResources;
    }

    public void setAvailableResources(Set<AvailableResource> availableResources) {
        this.availableResources = availableResources;
    }

    public Set<ReservedResource> getReservedResources() {
        return reservedResources;
    }

    public void setReservedResources(Set<ReservedResource> reservedResources) {
        this.reservedResources = reservedResources;
    }

    public Set<DeadResource> getDeadResources() {
        return deadResources;
    }

    public void setDeadResources(Set<DeadResource> deadResources) {
        this.deadResources = deadResources;
    }

    public DiagnosticImage getDiagnosticImage() {
        return diagnosticImage;
    }

    public void setDiagnosticImage(DiagnosticImage diagnosticImage) {
        this.diagnosticImage = diagnosticImage;
    }
}
