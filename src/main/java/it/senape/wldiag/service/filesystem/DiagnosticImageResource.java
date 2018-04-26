package it.senape.wldiag.service.filesystem;

import lombok.Data;
import lombok.Getter;

import java.nio.file.Path;
import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 03-Apr-18
 */
@Data
@Getter
public class DiagnosticImageResource {

    private Path path;
    private String serverName;
    private LocalDateTime acquisitionTime;
    private String serverLabel;

    public DiagnosticImageResource(Path path, String serverName, String serverLabel, LocalDateTime acquisitionTime) {
        this.path = path;
        this.serverName = serverName;
        this.serverLabel = serverLabel;
        this.acquisitionTime = acquisitionTime;
    }

}
