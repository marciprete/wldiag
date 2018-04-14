package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.Transaction;
import it.senape.wldiag.jpa.projection.ThreadedTransaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
@Repository
public interface TransactionRepository extends PagingAndSortingRepository<Transaction, Long> {

    //    @Query(value = "select * from transaction t " +
//            "inner join jta j on j.id = t.jta_id " +
//            "left outer join property p on p.transaction_id=t.id " +
//            "where jta_id = 2",
//    nativeQuery = true)
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
            "it.name, it.pool_number, it.wls_status, " +
            "td.state, td.stack_trace, td.extra_info as extraInfo, " +
            "ed.ecid " +
            ",w.work_manager, w.scheduled, w.started, w.started_time_millis as startedTimeMillis, w.type " +
//            ", w.started, w.scheduled, w.started_time_millis " +
            "from transaction t " +
            "inner join jta on jta.id=t.jta_id " +
            "left outer join ejb_transaction ejb on ejb.ejb_transaction_id=t.id " +
            "inner join diagnostic_image di on di.id=jta.diagnostic_image_id " +
            "inner join internal_thread it on it.transaction_id=t.id " +
            "inner join thread_dump td on td.internal_thread_id=it.id " +
            "inner join execution_details ed on ed.thread_dump_id=td.id " +
            "inner join work w on ed.id=w.execution_details_id " +
            "where di.id= :diagnosticImageId",
            countQuery = "select count(*) from transaction t " +
                    "inner join jta on jta.id=t.jta_id " +
                    "where jta.diagnostic_image_id = :diagnosticImageId",
            nativeQuery=true)
    Page<ThreadedTransaction> findAllThreadedTransaction(@Param("diagnosticImageId") Long diagnosticImageId, Pageable pageRequest);


}
