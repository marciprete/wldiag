package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.InternalThread;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by michele.arciprete on 10-Jan-18.
 */
@Repository
public interface InternalThreadRepository extends CrudRepository<InternalThread, Long> {

    InternalThread findByNameAndType(String name, String type);

}
