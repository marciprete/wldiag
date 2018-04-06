package it.senape.wldiag.jpa.model.jta;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by michele.arciprete on 04-Apr-18
 */
@Entity
public class ResourceServer implements Serializable {

    @Embeddable
    public static class ResourceServerPK implements Serializable {

        @Column(name = "resource_id")
        private Long resourceId;

        @Column(name = "server_id")
        private Long serverId;

        public ResourceServerPK() {
        }

        public ResourceServerPK(Long resourceId, Long serverId) {
            this.resourceId = resourceId;
            this.serverId = serverId;
        }

        public Long getResourceId() {
            return resourceId;
        }

        public void setResourceId(Long resourceId) {
            this.resourceId = resourceId;
        }

        public Long getServerId() {
            return serverId;
        }

        public void setServerId(Long serverId) {
            this.serverId = serverId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ResourceServerPK that = (ResourceServerPK) o;
            return Objects.equals(resourceId, that.resourceId) &&
                    Objects.equals(serverId, that.serverId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(resourceId, serverId);
        }
    }

    @EmbeddedId
    private ResourceServerPK id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.REMOVE)
    @MapsId("resourceId")
    private Resource resource;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("serverId")
    private Server server;

    public ResourceServer() {
    }

    public ResourceServer(Resource resource, Server server) {
        this.resource = resource;
        this.server = server;
        this.id = new ResourceServerPK(resource.getId(), server.getId());
    }

    public ResourceServerPK getId() {
        return id;
    }

    public void setId(ResourceServerPK id) {
        this.id = id;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}
