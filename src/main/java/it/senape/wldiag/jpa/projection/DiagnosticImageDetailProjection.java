package it.senape.wldiag.jpa.projection;

import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDateTime;

/**
 * Created by michele.arciprete on 10-Apr-18
 */
public interface DiagnosticImageDetailProjection {

    @Value("#{target.file_name}") String getFileName();
    @Value("#{target.acquisition_time}") LocalDateTime getAcquisitionTime();


    //JTA Info
    String getHealth();
    @Value("#{target.last_checkpoint_time}") LocalDateTime getLastCheckpointTime();
    @Value("#{target.transaction_count}") Integer getTransactionCount();

    //Work Manager Info
    @Value("#{target.total_thread_count}") Integer getTotalThreadCount();
    @Value("#{target.idle_thread_count}") Integer getIdleThreadCount();
    @Value("#{target.standby_thread_count}") Integer getStandbyThreadCount();
    @Value("#{target.mean_throughput}") Double getMeanThroughput();
    @Value("#{target.total_requests}") Integer getTotalRequests();

    //JVM Info
    @Value("#{target.heap_memory_used_bytes}") Long getHeapMemoryUsedBytes();
    @Value("#{target.heap_memory_max_bytes}") Long getHeapMemoryMaxBytes();
    @Value("#{target.heap_memory_init_bytes}") Long getHeapMemoryInitBytes();
    @Value("#{target.heap_memory_committed_bytes}") Long getHeapMemoryCommittedBytes();
    @Value("#{target.non_heap_memory_used_bytes}") Long getNonHeapMemoryUsedBytes();
    @Value("#{target.non_heap_memory_init_bytes}") Long getNonHeapMemoryInitBytes();
    @Value("#{target.non_heap_memory_committed_bytes}")  Long getNonHeapMemoryCommittedBytes();
    @Value("#{target.thread_count}")  Integer getThreadCount();
    @Value("#{target.peak_thread_count}") Integer getPeakThreadCount();
    @Value("#{target.total_started_thread_count}") Integer getTotalStartedThreadCount();
    @Value("#{target.current_thread_cpu_time}") Long getCurrentThreadCpuTime();
    @Value("#{target.current_thread_user_time}") Long getCurrentThreadUserTime();
    Long getUptime();
}
