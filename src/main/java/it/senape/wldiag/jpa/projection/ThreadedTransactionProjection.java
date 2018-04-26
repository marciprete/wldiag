package it.senape.wldiag.jpa.projection;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 10-Apr-18
 */
public interface ThreadedTransactionProjection {

    //From Transaction Entity
    String getXid();
    String getStatus();
    @Value("#{target.begin_time}") LocalDateTime getBeginTime();


    //From EJBTransactionProperty entity
    String getClassName();
    String getMethod();
    String getArguments();

    //From InternalThread entity
    @Value("#{target.name}") String getThreadName();
    @Value("#{target.pool_number}") String getPoolNumber();
    String getWlsStatus();

    //From ThreadDump
    String getJavaThreadState();
    String getStackTrace();
    String getExtraInfo();

    //From ExecutionDetails
    String getECID();

    //From Work
    String getWorkManagerType();
    String getWorkManager();
    Boolean getStarted();
    Boolean getScheduled();
    Long getStartedTimeMillis();


}
