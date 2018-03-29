package it.senape.wldiag.dto;

import java.util.Date;
import java.util.List;

/**
 * Created by michele.arciprete on 17-Jan-18.
 */
public class ImageSummaryDto {

    private Date imageCreationDate;
    private String imageFileName;
    private Long imageCreationElapsedTime;
    private Boolean imageCaptureCancelled;
    private String serverReleaseInfo;
    private String serverName;
    private String muxerClass;
    private List<SystemPropertyDto> systemProperties;
}
