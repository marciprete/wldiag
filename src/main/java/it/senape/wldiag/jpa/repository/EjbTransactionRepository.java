package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.EjbTransactionProperty;
import it.senape.wldiag.jpa.projection.TopClassProjection;
import it.senape.wldiag.jpa.projection.TopMethodProjection;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
@Repository
public interface EjbTransactionRepository extends PagingAndSortingRepository<EjbTransactionProperty, Long> {

    @Query(value = "select class_name fqnClassName, method, " +
            "count(*) hits " +
            "from ejb_transaction " +
            "group by method, class_name " +
            "order by hits desc " +
            "limit 5",
    nativeQuery = true)
    public List<TopMethodProjection> getTopMethods();

    @Query(value = "select class_name fqnClassName, " +
            "count(*) hits " +
            "from ejb_transaction " +
            "group by class_name " +
            "order by hits desc " +
            "limit 5",
            nativeQuery = true)
    public List<TopClassProjection> getTopClasses();
}
