package it.senape.wldiag.service.jpa;

import it.senape.wldiag.jpa.model.jta.Server;

import java.util.Optional;

/**
 * Created by michele.arciprete on 04-Apr-18
 */
public interface ServerService {

    Server create(Server server);

    int deletes(Server server);

    Optional<Server> findByUrl(String url);
}
