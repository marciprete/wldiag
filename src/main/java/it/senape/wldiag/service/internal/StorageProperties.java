package it.senape.wldiag.service.internal;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@ConfigurationProperties("storage")
public class StorageProperties {

    public static final String DIAGNOSTIC_IMAGE_FILENAME_PATTERN = "diagnostic_image_(\\w+)_(\\d{4})_(\\d{2})_(\\d{2})_(\\d{2})_(\\d{2})_(\\d{2})\\.zip";

    /**
     * Folder location for storing files
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
