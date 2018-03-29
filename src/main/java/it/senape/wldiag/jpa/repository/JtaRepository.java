package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.Jta;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Repository
public interface JtaRepository extends PagingAndSortingRepository<Jta, Long> {

}
