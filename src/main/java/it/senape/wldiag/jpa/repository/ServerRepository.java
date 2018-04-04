package it.senape.wldiag.jpa.repository;

import it.senape.wldiag.jpa.model.jta.Server;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by michele.arciprete on 17-Dec-17.
 */
@Repository
public interface ServerRepository extends CrudRepository<Server,Long> {

    Server findByServerNameAndUrl(String serverName, String url);

    Optional<Server> findByUrl(String url);
}
