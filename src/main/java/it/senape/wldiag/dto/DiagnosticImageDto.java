package it.senape.wldiag.dto;

import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.dto.jvm.JvmDto;
import it.senape.wldiag.dto.workmanager.WorkManagerDto;

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
    private WorkManagerDto workManagerDto;
    private JvmDto jvmDto;

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

    public WorkManagerDto getWorkManagerDto() {
        return workManagerDto;
    }

    public void setWorkManagerDto(WorkManagerDto workManagerDto) {
        this.workManagerDto = workManagerDto;
    }

    public JvmDto getJvmDto() {
        return jvmDto;
    }

    public void setJvmDto(JvmDto jvmDto) {
        this.jvmDto = jvmDto;
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
