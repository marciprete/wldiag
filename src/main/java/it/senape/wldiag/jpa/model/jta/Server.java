package it.senape.wldiag.jpa.model.jta;

import it.senape.wldiag.jpa.model.AbstractEntity;
import org.hibernate.annotations.NaturalId;

import javax.persistence.Entity;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
@Entity
//@NaturalIdCache
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Server extends AbstractEntity<Long> {

    private String serverName;

    private String label;

    @NaturalId
    private String url;
    private String domain;
    private String connection;

    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + getId() +
                ", serverName='" + serverName + '\'' +
                ", label='" + label + '\'' +
                ", url='" + url + '\'' +
                ", domain='" + domain + '\'' +
                ", connection='" + connection + '\'' +
                '}';
    }
}
