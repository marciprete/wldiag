package it.senape.wldiag.service.internal;

import it.senape.wldiag.jpa.bridge.ResourcePoolMessageMapper;
import it.senape.wldiag.jpa.model.jdbc.JdbcResource;
import it.senape.wldiag.jpa.model.jdbc.JdbcResourcePool;
import it.senape.wldiag.jpa.repository.JdbcResourcePoolRepository;
import it.senape.wldiag.message.JdbcResourceMessage;
import it.senape.wldiag.message.JdbcResourcePoolMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by michele.arciprete on 26-Jan-18.
 */
@Service
public class JdbcResourcePoolService {

    private JdbcResourcePoolRepository jdbcResourcePoolRepository;

    @Autowired
    public JdbcResourcePoolService(JdbcResourcePoolRepository jdbcResourcePoolRepository) {
        this.jdbcResourcePoolRepository = jdbcResourcePoolRepository;
    }

    public Page<JdbcResourcePoolMessage> findAllWithCounters(Pageable pageRequest) {
        System.out.println("Page request: " +pageRequest);
        Page<JdbcResourcePool> resourcePools = jdbcResourcePoolRepository.findAll(pageRequest);
        return ResourcePoolMessageMapper.mapEntityPageIntoDTOPage(pageRequest, resourcePools);
    }

}
