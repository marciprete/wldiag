package it.senape.wldiag.message;

/**
 * Created by michele.arciprete on 26-Jan-18.
 */
public class JdbcResourcePoolMessage {

    private Long id;
    private Integer currentCapacity;
    private String poolname;
    private Integer availableResources;
    private Integer reservedResources;
    private Integer deadResources;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getAvailableResources() {
        return availableResources;
    }

    public void setAvailableResources(Integer availableResources) {
        this.availableResources = availableResources;
    }

    public Integer getReservedResources() {
        return reservedResources;
    }

    public void setReservedResources(Integer reservedResources) {
        this.reservedResources = reservedResources;
    }

    public Integer getDeadResources() {
        return deadResources;
    }

    public void setDeadResources(Integer deadResources) {
        this.deadResources = deadResources;
    }

    @Override
    public String toString() {
        return "JdbcResourcePoolMessage{" +
                "id=" + id +
                ", currentCapacity=" + currentCapacity +
                ", poolname='" + poolname + '\'' +
                ", availableResources=" + availableResources +
                ", reservedResources=" + reservedResources +
                ", deadResources=" + deadResources +
                '}';
    }
}
