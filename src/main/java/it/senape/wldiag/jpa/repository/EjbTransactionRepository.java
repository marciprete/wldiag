package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.EjbTransactionProperty;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
@Repository
public interface EjbTransactionRepository extends PagingAndSortingRepository<EjbTransactionProperty, Long> {

}
