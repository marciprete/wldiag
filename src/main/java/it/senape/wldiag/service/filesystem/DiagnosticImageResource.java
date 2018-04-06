package it.senape.wldiag.service.filesystem;

import java.nio.file.Path;
import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 03-Apr-18
 */
public class DiagnosticImageResource {

    private Path path;
    private String serverName;
    private LocalDateTime acquisitionTime;

    public DiagnosticImageResource(Path path, String serverName, LocalDateTime acquisitionTime) {
        this.path = path;
        this.serverName = serverName;
        this.acquisitionTime = acquisitionTime;
    }

    public Path getPath() {
        return path;
    }

    public String getServerName() {
        return serverName;
    }

    public LocalDateTime getAcquisitionTime() {
        return acquisitionTime;
    }
}
