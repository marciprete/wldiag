package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jdbc.JdbcResourcePool;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by michele.arciprete on 25-Jan-18.
 */
public interface JdbcResourcePoolRepository extends PagingAndSortingRepository<JdbcResourcePool, Long> {

    @Query(value = "select p from JdbcResourcePool p "
            + "left join fetch p.availableResources "
            + "left join fetch p.reservedResources "
            + "left join fetch p.deadResources"
            ,countQuery = "select count(p) from JdbcResourcePool p"
    )
    Page<JdbcResourcePool> findAll(Pageable pageRequest);
}
