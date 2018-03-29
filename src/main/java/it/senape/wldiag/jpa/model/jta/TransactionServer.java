package it.senape.wldiag.jpa.model.jta;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * Created by michele.arciprete on 17-Dec-17.
 */
@Entity
public class TransactionServer implements Serializable {

    @Embeddable
    public class TransactionServerPK implements Serializable {

        @Column(name = "transaction_id")
        private Long transactionId;

        @Column(name = "server_id")
        private Long serverId;

        public TransactionServerPK() {
        }

        public TransactionServerPK(Long transactionId, Long serverId) {
            this.serverId = serverId;
            this.transactionId = transactionId;
        }

        public Long getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(Long transactionId) {
            this.transactionId = transactionId;
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

            TransactionServerPK that = (TransactionServerPK) o;

            if (transactionId != null ? !transactionId.equals(that.transactionId) : that.transactionId != null)
                return false;
            return !(serverId != null ? !serverId.equals(that.serverId) : that.serverId != null);

        }

        @Override
        public int hashCode() {
            int result = transactionId != null ? transactionId.hashCode() : 0;
            result = 31 * result + (serverId != null ? serverId.hashCode() : 0);
            return result;
        }

    }

    @EmbeddedId
    private TransactionServerPK id;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "transaction_id", insertable = false, updatable = false)
    @MapsId("transactionId")
    private Transaction transaction;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "server_id", insertable = false, updatable = false)
    @MapsId("serverId")
    private Server server;

    private Boolean syncRegistered;//="true"
    private String state;//="active"

    public TransactionServer() {
    }

    public TransactionServer(Transaction transaction, Server server, Boolean syncRegistered, String state) {
        this.transaction = transaction;
        this.server = server;
        this.syncRegistered = syncRegistered;
        this.state = state;
        this.id = new TransactionServerPK(transaction.getId(), server.getId());
    }

    public TransactionServerPK getId() {
        return id;
    }

    public void setId(TransactionServerPK id) {
        this.id = id;
    }

    public Boolean getSyncRegistered() {
        return syncRegistered;
    }

    public void setSyncRegistered(Boolean syncRegistered) {
        this.syncRegistered = syncRegistered;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass())
            return false;

        TransactionServer that = (TransactionServer) o;
        return Objects.equals(transaction, that.transaction) &&
                Objects.equals(server, that.server);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction, server);
    }
}
