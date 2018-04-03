package it.senape.wldiag.jpa.bridge;

import it.senape.wldiag.dto.HealthDto;
import it.senape.wldiag.dto.HealthState;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.jpa.model.jta.Jta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
public class JtaMapper {

    /**
     * Transforms the {@link Jta} object given as a method parameter into a
     * {@link JtaDto} object and returns the created object.
     *
     * @param entity
     * @return
     */
    public static JtaDto mapEntityIntoDTO(Jta entity) {
        JtaDto dto = new JtaDto();

        dto.setAbandonTimeout(entity.getAbandonTimeout());
        dto.setBeforeCompletionIterationLimit(entity.getBeforeCompletionIterationLimit());
        dto.setCheckpointInterval(entity.getCheckpointInterval());
        dto.setDefaultTimeout(entity.getDefaultTimeout());
        dto.setForgetHeuristics(entity.getForgetHeuristics());
        HealthDto healthDTO = new HealthDto();
        healthDTO.setHealthState(HealthState.valueOf(entity.getHealth().getState()));
        dto.setHealth(healthDTO);


        return dto;
    }

    /**
     * Transforms the list of {@link Jta} objects given as a method parameter
     * into a list of {@link JtaDto} objects and returns the created list.
     *
     * @param entities
     * @return
     */
    public static List<JtaDto> mapEntitiesIntoDTOs(Iterable<Jta> entities) {
        List<JtaDto> dtos = new ArrayList<>();

        entities.forEach(e -> dtos.add(mapEntityIntoDTO(e)));

        return dtos;
    }

    /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     * @param pageRequest   The information of the requested page.
     * @param source        The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    public static Page<JtaDto> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<Jta> source) {
        List<JtaDto> dtos = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }
}
