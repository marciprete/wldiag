package it.senape.wldiag.jpa.projection;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by michele.arciprete on 17-Apr-18
 */
public interface DiagnosticImageProjection {

    Long getId();
    String getName();
    LocalDateTime getAcquisitionTime();

    Long getCustomerId();
    String getCustomerName();

    String getServerLabel();
}
