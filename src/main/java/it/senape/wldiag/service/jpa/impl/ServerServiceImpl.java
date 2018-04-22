package it.senape.wldiag.service.jpa.impl;

import it.senape.wldiag.jpa.model.jta.Server;
import it.senape.wldiag.jpa.repository.ServerRepository;
import it.senape.wldiag.service.jpa.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by michele.arciprete on 04-Apr-18
 */
@Service
public class ServerServiceImpl implements ServerService {

    private ServerRepository serverRepository;

    @Autowired
    public ServerServiceImpl(ServerRepository serverRepository) {
        this.serverRepository = serverRepository;
    }

    @Override
    public Server create(Server server) {
        return null;
    }

    @Override
    public int deletes(Server server) {
        return 0;
    }

    @Override
    public Optional<Server> findByUrl(String url) {
        return serverRepository.findByUrl(url);
    }
}
