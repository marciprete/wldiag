package it.senape.wldiag.dto;

import it.senape.wldiag.dto.config.ConfigServerDto;
import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.dto.jvm.JvmDto;
import it.senape.wldiag.dto.workmanager.WorkManagerDto;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 17-Dec-17.
 */
@Data
public class DiagnosticImageDto implements Serializable {

    private Long imageId;
    private String fileName;
    private LocalDateTime acquisitionTime;
    private Long customerId;
    private String customerName;
    private Long serverId;
    private String serverName;
    private String serverLabel;

    private JtaDto jtaDto;
    private JdbcResourcePoolDto jdbcResourcePool;
    private WorkManagerDto workManagerDto;
    private JvmDto jvmDto;
    private ConfigServerDto server;

}
