package it.senape.wldiag.jpa.projection;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 10-Apr-18
 */
public interface ThreadedTransaction {

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
    @Value("#{target.wls_status}") String getWlsStatus();

    //From ThreadDump
    @Value("#{target.state}") String getJavaThreadState();
    @Value("#{target.stack_trace}") String getStackTrace();
//    @Value("#{target.extra_info}")
    String getExtraInfo();

    //From ExecutionDetails
    String getECID();

    //From Work
    @Value("#{target.type}") String getWorkManagerType();
    @Value("#{target.work_manager}") String getWorkManager();
    Boolean getStarted();
    Boolean getScheduled();
//    @Value("#{target.started_time_millis}")
    Long getStartedTimeMillis();


}
