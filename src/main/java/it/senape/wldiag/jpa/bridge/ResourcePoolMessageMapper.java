package it.senape.wldiag.jpa.bridge;

import it.senape.wldiag.jpa.model.jdbc.JdbcResourcePool;
import it.senape.wldiag.message.JdbcResourcePoolMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michele.arciprete on 26-Jan-18.
 */
public class ResourcePoolMessageMapper {

    private ResourcePoolMessageMapper() {
    }

    /**
     * Transforms the {@link JdbcResourcePool} object given as a method parameter into a
     * {@link JdbcResourcePoolMessage} object and returns the created object.
     *
     * @param entity
     * @return
     */
    static JdbcResourcePoolMessage mapEntityIntoDTO(JdbcResourcePool entity) {
        JdbcResourcePoolMessage message = new JdbcResourcePoolMessage();
        message.setId(entity.getId());
        message.setCurrentCapacity(entity.getCurrentCapacity());
        message.setPoolname(entity.getPoolname());
        message.setAvailableResources(entity.getAvailableResources().size());
        message.setReservedResources(entity.getReservedResources().size());
        message.setDeadResources(entity.getDeadResources().size());
        return message;
    }

    /**
     * Transforms the list of {@link JdbcResourcePool} objects given as a method parameter
     * into a list of {@link JdbcResourcePoolMessage} objects and returns the created list.
     *
     * @param entities
     * @return
     */
    static List<JdbcResourcePoolMessage> mapEntitiesIntoDTOs(Iterable<JdbcResourcePool> entities) {
        List<JdbcResourcePoolMessage> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapEntityIntoDTO(e)));
        return dtos;
    }

    /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     * @param pageRequest   The information of the requested page.
     * @param source        The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    public static Page<JdbcResourcePoolMessage> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<JdbcResourcePool> source) {
        List<JdbcResourcePoolMessage> dtos = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }
}
