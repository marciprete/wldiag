package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jdbc.JdbcResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by michele.arciprete on 26-Jan-18.
 */
@Repository
public interface JdbcResourceRepository extends PagingAndSortingRepository<JdbcResource, Long> {

    Page<JdbcResource> findAllByResourcePool_Id(@Param("resourcePoolId") Long id, Pageable pageRequest);


    @Query(value = "select res from JdbcResource res " +
            "where res.resourcePool.id = :resourcePoolId " +
            "and res.enabled = :enabled",
    countQuery= "select count(res) from JdbcResource res " +
            "where res.resourcePool.id = :resourcePoolId " +
            "and res.enabled = :enabled")
    Page<JdbcResource> findAllResourcesFiltered(@Param("resourcePoolId") Long resourcePoolId,
                                                @Param("enabled") Boolean enabled,
                                                Pageable pageRequest);


//    Page<JdbcResource> findAllByResourcePoolId(@Param("resourcePoolId") Long id, Pageable pageRequest);
}
