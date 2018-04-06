package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.Resource;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by michele.arciprete on 04-Apr-18
 */
@Repository
public interface ResourceRepository extends CrudRepository<Resource, Long> {

    Optional<Resource> findByXid(String xid);

}
