package it.senape.wldiag.jpa.bridge;

import it.senape.wldiag.jpa.model.jdbc.JdbcResource;
import it.senape.wldiag.message.JdbcResourceMessage;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michele.arciprete on 28-Jan-18.
 */
public class JdbcResourceMapper {
    private JdbcResourceMapper() {
    }

    /**
     * Transforms the {@link JdbcResource} object given as a method parameter into a
     * {@link JdbcResourceMessage} object and returns the created object.
     *
     * @param entity
     * @return
     */
    public static JdbcResourceMessage mapEntityIntoDTO(JdbcResource entity) {
        JdbcResourceMessage message = new JdbcResourceMessage();
        BeanUtils.copyProperties(entity, message);
        message.setLastSuccessfulConnectionUse(
                Converter.fromLongToLocalDateTime(entity.getLastSuccessfulConnectionUse())
        );
        message.setId(entity.getId());

        return message;
    }

    /**
     * Transforms the list of {@link JdbcResource} objects given as a method parameter
     * into a list of {@link JdbcResourceMessage} objects and returns the created list.
     *
     * @param entities
     * @return
     */
    static List<JdbcResourceMessage> mapEntitiesIntoDTOs(Iterable<JdbcResource> entities) {
        List<JdbcResourceMessage> dtos = new ArrayList<>();

        entities.forEach(e -> dtos.add(mapEntityIntoDTO(e)));

        return dtos;
    }

    /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     * @param pageRequest   The information of the requested page.
     * @param source        The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    public static Page<JdbcResourceMessage> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<JdbcResource> source) {
        List<JdbcResourceMessage> dtos = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }
}
