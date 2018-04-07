package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.InternalThread;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by michele.arciprete on 10-Jan-18.
 */
@Repository
public interface InternalThreadRepository extends CrudRepository<InternalThread, Long> {

    InternalThread findByNameAndType(String name, String type);

    List<InternalThread> findAllByNameIn(Set<String> threadNames);

    @Query(value = "select it from InternalThread it " +
            "join it.transactions as t " +
            "join t.jta as jta " +
            "join jta.diagnosticImage di " +
            "where di.id = :diagnosticImageId " +
            "and it.name in :threadNames")
    List<InternalThread> findAllByDiagnosticImageIdAndNameIn(@Param("diagnosticImageId") Long diagnosticImageId,
                                                             @Param("threadNames") Collection<String> threadNames);
}
