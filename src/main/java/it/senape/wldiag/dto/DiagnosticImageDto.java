package it.senape.wldiag.dto;

import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 17-Dec-17.
 */
public class DiagnosticImageDto implements Serializable {

    private Long imageId;
    private String fileName;
    private LocalDateTime acquisitionTime;
    private Long customerId;
    private String customerName;
    private Long serverId;
    private String serverName;

    private JtaDto jtaDto;
    private JdbcResourcePoolDto jdbcResourcePool;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public LocalDateTime getAcquisitionTime() {
        return acquisitionTime;
    }

    public void setAcquisitionTime(LocalDateTime acquisitionTime) {
        this.acquisitionTime = acquisitionTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getServerId() {
        return serverId;
    }

    public void setServerId(Long serverId) {
        this.serverId = serverId;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public JtaDto getJtaDto() {
        return jtaDto;
    }

    public void setJtaDto(JtaDto jtaDto) {
        this.jtaDto = jtaDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DiagnosticImageDto that = (DiagnosticImageDto) o;

        if (!fileName.equals(that.fileName)) return false;
        if (!acquisitionTime.equals(that.acquisitionTime)) return false;
        if (customerName != null ? !customerName.equals(that.customerName) : that.customerName != null) return false;
        return serverName != null ? serverName.equals(that.serverName) : that.serverName == null;
    }

    @Override
    public int hashCode() {
        int result = fileName.hashCode();
        result = 31 * result + acquisitionTime.hashCode();
        result = 31 * result + (customerName != null ? customerName.hashCode() : 0);
        result = 31 * result + (serverName != null ? serverName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "DiagnosticImageDto{" +
                "imageId=" + imageId +
                ", fileName='" + fileName + '\'' +
                ", acquisitionTime=" + acquisitionTime +
                ", customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", serverId=" + serverId +
                ", serverName='" + serverName + '\'' +
                ", jta ='" + jtaDto + '\'' +
                ", jdbcResourcePool='" + jdbcResourcePool + '\'' +
                '}';
    }

    public void setImageId(Long imageId) {
        this.imageId = imageId;
    }

    public Long getImageId() {
        return imageId;
    }

    public void setJdbcResourcePool(JdbcResourcePoolDto jdbcResourcePool) {
        this.jdbcResourcePool = jdbcResourcePool;
    }

    public JdbcResourcePoolDto getJdbcResourcePool() {
        return jdbcResourcePool;
    }
}
