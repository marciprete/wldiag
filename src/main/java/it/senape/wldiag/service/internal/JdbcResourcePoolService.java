package it.senape.wldiag.service.internal;

import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.jpa.bridge.ResourcePoolMessageMapper;
import it.senape.wldiag.jpa.model.jdbc.AvailableResource;
import it.senape.wldiag.jpa.model.jdbc.DeadResource;
import it.senape.wldiag.jpa.model.jdbc.JdbcResourcePool;
import it.senape.wldiag.jpa.model.jdbc.ReservedResource;
import it.senape.wldiag.jpa.repository.JdbcResourcePoolRepository;
import it.senape.wldiag.message.JdbcResourcePoolMessage;
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

    public void save(JdbcResourcePoolDto jdbcResourcePoolDto) {
        JdbcResourcePool jdbcResourcePool = convertDtoToEntity(jdbcResourcePoolDto) ;
        jdbcResourcePoolRepository.save(jdbcResourcePool);
    }

    private JdbcResourcePool convertDtoToEntity(JdbcResourcePoolDto jdbcResourcePoolDto) {
        JdbcResourcePool jdbcResourcePool = new JdbcResourcePool();
        BeanUtils.copyProperties(jdbcResourcePoolDto, jdbcResourcePool);
        jdbcResourcePoolDto.getAvailableResources().forEach(availableResourceDto -> {
            AvailableResource availableResource = new AvailableResource();
            BeanUtils.copyProperties(availableResourceDto, availableResource);
            jdbcResourcePool.getAvailableResources().add(availableResource);
        });
        jdbcResourcePoolDto.getReservedResources().forEach(reservedResourceDto -> {
            ReservedResource reservedResource = new ReservedResource();
            BeanUtils.copyProperties(reservedResourceDto, reservedResource);
            jdbcResourcePool.getReservedResources().add(reservedResource);
        });
        jdbcResourcePoolDto.getDeadResources().forEach(deadResourceDto -> {
            DeadResource deadResource = new DeadResource();
            BeanUtils.copyProperties(deadResourceDto, deadResource);
            jdbcResourcePool.getDeadResources().add(deadResource);
        });
        return jdbcResourcePool;
    }
}
