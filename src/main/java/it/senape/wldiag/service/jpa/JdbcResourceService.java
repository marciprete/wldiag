package it.senape.wldiag.service.jpa;

import it.senape.wldiag.jpa.bridge.JdbcResourceMapper;
import it.senape.wldiag.jpa.model.jdbc.JdbcResource;
import it.senape.wldiag.jpa.repository.JdbcResourceRepository;
import it.senape.wldiag.message.JdbcResourceMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by michele.arciprete on 26-Jan-18.
 */
@Service
public class JdbcResourceService {

    private JdbcResourceRepository jdbcResourceRepository;

    @Autowired
    public JdbcResourceService(JdbcResourceRepository jdbcResourceRepository) {
        this.jdbcResourceRepository = jdbcResourceRepository;
    }

    @Transactional(readOnly = true)
    public JdbcResourceMessage get(Long id) {
        Optional<JdbcResource> entity = jdbcResourceRepository.findById(id);
        JdbcResourceMessage message = new JdbcResourceMessage();
        if(entity.isPresent()) {
            message = JdbcResourceMapper.mapEntityIntoDTO(entity.get());
        }
        return message;
    }

    @Transactional(readOnly = true)
    public Page<JdbcResourceMessage> findAllByResourcePoolId(Long resourcePoolId, Pageable pageRequest) {
        Page<JdbcResource> resources = jdbcResourceRepository.findAllByResourcePool_Id(resourcePoolId, pageRequest);
        return JdbcResourceMapper.mapEntityPageIntoDTOPage(pageRequest, resources);
    }

    @Transactional(readOnly = true)
    public Page<JdbcResourceMessage> findAllResourcesFiltered(Long resourcePoolId, Pageable pageRequest) {
        Page<JdbcResource> resources = jdbcResourceRepository.findAllResourcesFiltered(resourcePoolId, true, pageRequest);
        return JdbcResourceMapper.mapEntityPageIntoDTOPage(pageRequest, resources);
    }
}
