package it.senape.wldiag.dto;

import java.io.Serializable;

/**
 * Created by michele.arciprete on 10-Jan-18.
 */
public class InternalThreadDto implements Serializable {

    private Long id;
    private String name;
    private Integer poolNumber;
    private String type;
    private String wlsStatus;
    private Long transactionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoolNumber() {
        return poolNumber;
    }

    public void setPoolNumber(Integer poolNumber) {
        this.poolNumber = poolNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWlsStatus() {
        return wlsStatus;
    }

    public void setWlsStatus(String wlsStatus) {
        this.wlsStatus = wlsStatus;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Long transactionId) {
        this.transactionId = transactionId;
    }
}
