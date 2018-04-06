package it.senape.wldiag.service.jpa;

import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.jpa.bridge.ResourcePoolMessageMapper;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.jdbc.AvailableResource;
import it.senape.wldiag.jpa.model.jdbc.DeadResource;
import it.senape.wldiag.jpa.model.jdbc.JdbcResourcePool;
import it.senape.wldiag.jpa.model.jdbc.ReservedResource;
import it.senape.wldiag.jpa.repository.JdbcResourcePoolRepository;
import it.senape.wldiag.message.JdbcResourcePoolMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by michele.arciprete on 26-Jan-18.
 */
@Service
public class JdbcResourcePoolService {

    private static final Logger logger = LoggerFactory.getLogger(JdbcResourcePoolService.class);

    private JdbcResourcePoolRepository jdbcResourcePoolRepository;

    @Autowired
    public JdbcResourcePoolService(JdbcResourcePoolRepository jdbcResourcePoolRepository) {
        this.jdbcResourcePoolRepository = jdbcResourcePoolRepository;
    }

    public Page<JdbcResourcePoolMessage> findAllWithCounters(Pageable pageRequest) {
        logger.debug("Page request: {}", pageRequest);
        Page<JdbcResourcePool> resourcePools = jdbcResourcePoolRepository.findAll(pageRequest);
        return ResourcePoolMessageMapper.mapEntityPageIntoDTOPage(pageRequest, resourcePools);
    }

    public void save(JdbcResourcePoolDto jdbcResourcePoolDto) {
        JdbcResourcePool jdbcResourcePool = convertDtoToEntity(jdbcResourcePoolDto) ;
        jdbcResourcePoolRepository.save(jdbcResourcePool);
    }

    private JdbcResourcePool convertDtoToEntity(JdbcResourcePoolDto jdbcResourcePoolDto) {
        JdbcResourcePool jdbcResourcePool = new JdbcResourcePool();
        BeanUtils.copyProperties(jdbcResourcePoolDto, jdbcResourcePool);
        DiagnosticImage diagnosticImage = new DiagnosticImage();
        diagnosticImage.setId(jdbcResourcePoolDto.getDiagnosticImageId());
        jdbcResourcePool.setDiagnosticImage(diagnosticImage);
        jdbcResourcePoolDto.getAvailableResources().forEach(availableResourceDto -> {
            AvailableResource availableResource = new AvailableResource();
            BeanUtils.copyProperties(availableResourceDto, availableResource);
            availableResource.setResourcePool(jdbcResourcePool);
            jdbcResourcePool.getAvailableResources().add(availableResource);
        });
        jdbcResourcePoolDto.getReservedResources().forEach(reservedResourceDto -> {
            ReservedResource reservedResource = new ReservedResource();
            BeanUtils.copyProperties(reservedResourceDto, reservedResource);
            reservedResource.setResourcePool(jdbcResourcePool);
            jdbcResourcePool.getReservedResources().add(reservedResource);
        });
        jdbcResourcePoolDto.getDeadResources().forEach(deadResourceDto -> {
            DeadResource deadResource = new DeadResource();
            BeanUtils.copyProperties(deadResourceDto, deadResource);
            deadResource.setResourcePool(jdbcResourcePool);
            jdbcResourcePool.getDeadResources().add(deadResource);
        });
        return jdbcResourcePool;
    }
}
