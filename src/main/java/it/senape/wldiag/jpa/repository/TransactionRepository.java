package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.Transaction;
import it.senape.wldiag.jpa.projection.ThreadedTransactionProjection;
import it.senape.wldiag.jpa.projection.TransactionProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {

    @Query(value = "select distinct t from Transaction t "
            + "inner join fetch t.jta jta "
            + "inner join fetch t.activeThread at "
            + "left outer join fetch t.localProperties lp "
            + "left outer join fetch t.globalProperties gp "
            + "left outer join fetch t.resources res "
            + "where jta.id = :jtaId"
    )
    List<Transaction> findCompleteTransactionFromJtaId(@Param("jtaId") Long jtaId);


//    @Query(name = "Transaction.findDiagnosticImageTransactions")
//    @Query(value = "select t.health  " +
//                "from transaction t " +
//                "inner join jta on jta.id=t.jta_id " +
//                "left outer join ejb_transaction ejb on ejb.ejb_transaction_id=t.id " +
//                "inner join diagnostic_image di on di.id=jta.diagnostic_image_id " +
//                "inner join work_manager wm on wm.diagnostic_image_id=di.id " +
//                "inner join internal_thread it on it.transaction_id=t.id " +
//                "inner join thread_dump td on td.internal_thread_id=it.id " +
//                "inner join execution_details ed on ed.thread_dump_id=td.id " +
//                "inner join work on ed.id=work.execution_details_id " +
//                "where di.id= :diagnosticImageId"
//            ,nativeQuery = true)
//    Collection<DiagnosticImageDetailImpl> findAllByDiagnosticImageId(@Param("diagnosticImageId") Long di);



    @Query(value = "select " +
            "t.xid, t.status, t.begin_time, " +
            "ejb.class_name as className, ejb.method, ejb.arguments, " +
            "it.name, it.pool_number, it.wls_status wlsStatus, " +
            "td.status as javaThreadState " +
            ",td.stack_trace as stackTrace, td.extra_info as extraInfo, " +
            "ed.ecid " +
            ",w.work_manager workManager, w.scheduled, w.started, w.started_time_millis as startedTimeMillis, w.type workManagerType " +
            "from transaction t " +
            "inner join jta on jta.id=t.jta_id " +
            "left outer join ejb_transaction ejb on ejb.ejb_transaction_id=t.id " +
            "inner join diagnostic_image di on di.id=jta.diagnostic_image_id " +
            "left outer join internal_thread it on it.transaction_id=t.id " +
            "left outer join thread_dump td on td.internal_thread_id=it.id " +
            "left outer join execution_details ed on ed.thread_dump_id=td.id " +
            "left outer join work w on ed.id=w.execution_details_id " +
            "where di.id= :diagnosticImageId",
            countQuery = "select count(*) from transaction t " +
                    "inner join jta on jta.id=t.jta_id " +
                    "where jta.diagnostic_image_id = :diagnosticImageId",
            nativeQuery=true)
    Page<ThreadedTransactionProjection> findAllThreadedTransaction(@Param("diagnosticImageId") Long diagnosticImageId, Pageable pageRequest);


    @Query(value = "select t.xid, t.status, t.begin_time as beginTime, " +
            "it.name as threadName, it.wls_status as wlsStatus, " +
            "inner_p.class_name className, inner_p.method, inner_p.arguments " +
            "from transaction t " +
            "inner join internal_thread it on it.transaction_id = t.id " +
            "left join " +
            "(select * from property p " +
            "inner join ejb_transaction et on et.ejb_transaction_id=p.property_id) inner_p on inner_p.transaction_id=t.id"
    ,countQuery = "select count(t.xid) " +
            "from transaction t " +
            "inner join internal_thread it on it.transaction_id = t.id " +
            "left join " +
            "(select * from property p " +
            "inner join ejb_transaction et on et.ejb_transaction_id=p.property_id) inner_p on inner_p.transaction_id=t.id"
            ,nativeQuery = true)
    Page<TransactionProjection> retrieveAll(Pageable pageRequest);
}
