package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.Transaction;
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

}
