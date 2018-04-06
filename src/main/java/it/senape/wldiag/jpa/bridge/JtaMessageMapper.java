package it.senape.wldiag.jpa.bridge;

import it.senape.wldiag.jpa.model.jta.Jta;
import it.senape.wldiag.message.JtaMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michele.arciprete on 10-Jan-18.
 */
public class JtaMessageMapper {

    private JtaMessageMapper() {
    }

    /**
     * Transforms the {@link Jta} object given as a method parameter into a
     * {@link JtaMessage} object and returns the created object.
     *
     * @param entity
     * @return
     */
    static JtaMessage mapEntityIntoDTO(Jta entity) {
        JtaMessage message = new JtaMessage();
        message.setCheckPoint(entity.getLastCheckpointTime());
        message.setId(entity.getId());
        message.setTransactionCount(entity.getTransactionCount());
        message.setHealth(entity.getHealth().getState().toString());
        return message;
    }

    /**
     * Transforms the list of {@link Jta} objects given as a method parameter
     * into a list of {@link JtaMessage} objects and returns the created list.
     *
     * @param entities
     * @return
     */
    static List<JtaMessage> mapEntitiesIntoDTOs(Iterable<Jta> entities) {
        List<JtaMessage> dtos = new ArrayList<>();

        entities.forEach(e -> dtos.add(mapEntityIntoDTO(e)));

        return dtos;
    }

    /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     * @param pageRequest   The information of the requested page.
     * @param source        The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    public static Page<JtaMessage> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<Jta> source) {
        List<JtaMessage> dtos = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }
}
