package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.projection.DiagnosticImageDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Repository
public interface DiagnosticImageRepository extends PagingAndSortingRepository<DiagnosticImage, Long> {

    DiagnosticImage findByFileName(String fileName);

    DiagnosticImage findByFileNameAndCustomerId(String fileName, Long customerId);

    /**
     * Retrieves all the DiagnosticImages, paged, joined with the customer object
     * and the server object
     *
     * @param pageable
     * @return a Page with the DiagnosticImage
     */
    @Query(value = "select di from DiagnosticImage di "
           + "join fetch di.customer as c "
//         +   "left join fetch di.server as s"
    ,countQuery = "select count(di) from DiagnosticImage di")
    Page<DiagnosticImage> findAll(Pageable pageable);


//    /**
//     * Returns a page with all the diagnostic images, joined with the customer object
//     * and the server object, filtered by server
//     * @param server
//     * @param pageable
//     * @return
//     */
//    @Query(value = "select di from DiagnosticImage di " +
//            "join fetch di.customer as c " +
//            "left join fetch di.server as s " +
//            "where s = :server",
//            countQuery = "select count(di) from DiagnosticImage di " +
//                    "where di.server = :server")
//    Page<DiagnosticImage> findAllByServer(Server server, Pageable pageable);


    void deleteByFileNameAndCustomer_Id(String fileName, Long customerId);


    @Query(value = "select " +
            "di.file_name, di.acquisition_time " +
            ", jta.health, jta.last_checkpoint_time, jta.transaction_count " +
            ", wm.total_thread_count, wm.idle_thread_count, wm.standby_thread_count, wm.mean_throughput, wm.total_requests " +
            ", jvm.heap_memory_max_bytes, jvm.heap_memory_used_bytes, jvm.heap_memory_init_bytes, jvm.heap_memory_committed_bytes " +
            ", jvm.non_heap_memory_used_bytes, jvm.non_heap_memory_init_bytes, jvm.non_heap_memory_committed_bytes " +
            ", jvm.thread_count, jvm.peak_thread_count, jvm.total_started_thread_count " +
            ", jvm.current_thread_cpu_time, jvm.current_thread_user_time, jvm.uptime " +
            "from jta " +
            "inner join diagnostic_image di on di.id=jta.diagnostic_image_id " +
            "inner join work_manager wm on wm.diagnostic_image_id=di.id " +
            "inner join jvm on jvm.diagnostic_image_id = di.id " +
            "where di.id = :diagnosticImageId",
    nativeQuery = true)
    DiagnosticImageDetail findDiagnosticImageDetails(@Param("diagnosticImageId") Long diagnosticImageId);

}
