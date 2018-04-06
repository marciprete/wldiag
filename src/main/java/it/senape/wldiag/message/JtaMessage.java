package it.senape.wldiag.message;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 14-Dec-17.
 */
public class JtaMessage implements Serializable {

    private Long id;
    private LocalDateTime checkPoint;
    private String health;
    private Integer transactionCount;

    public LocalDateTime getCheckPoint() {
        return checkPoint;
    }

    public void setCheckPoint(LocalDateTime checkPoint) {
        this.checkPoint = checkPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public Integer getTransactionCount() {
        return transactionCount;
    }

    public void setTransactionCount(Integer transactionCount) {
        this.transactionCount = transactionCount;
    }
}
