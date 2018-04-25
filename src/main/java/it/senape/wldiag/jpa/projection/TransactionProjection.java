package it.senape.wldiag.jpa.projection;

import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 17-Apr-18
 */
public interface TransactionProjection {

    String getXID();
    String getStatus();
    LocalDateTime getBeginTime();
    String getThreadName();
    String getWlsStatus();
    String getClassName();
    String getMethod();
    String getArguments();

    default String getEjbTransactionSignature() {
        if (getClassName()!=null && getMethod() != null) {
            return getClassName().concat(".").concat(getMethod()).concat("(").concat(getArguments()).concat(")");
        }
        return "";
    }
}
