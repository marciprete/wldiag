package it.senape.wldiag.jpa.bridge;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.jta.Server;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is a mapper class that is used to transform {@link DiagnosticImage} objects
 * into {@link DiagnosticImageDto} objects.
 * Created by michele.arciprete on 18-Dec-17.
 */
public final class DiagnosticImageMapper {

    /**
     * Transforms the list of {@link DiagnosticImage} objects given as a method parameter
     * into a list of {@link DiagnosticImageDto} objects and returns the created list.
     *
     * @param entities
     * @return
     */
    public static List<DiagnosticImageDto> mapEntitiesIntoDTOs(Iterable<DiagnosticImage> entities) {
        List<DiagnosticImageDto> dtos = new ArrayList<>();
        entities.forEach(e -> dtos.add(mapEntityIntoDTO(e)));
        return dtos;
    }

    /**
     * Transforms the {@link DiagnosticImage} object given as a method parameter into a
     * {@link DiagnosticImageDto} object and returns the created object.
     *
     * @param entity
     * @return
     */
    public static DiagnosticImageDto mapEntityIntoDTO(DiagnosticImage entity) {
        DiagnosticImageDto dto = new DiagnosticImageDto();

        dto.setImageId(entity.getId());
        dto.setAcquisitionTime(entity.getAcquisitionTime());
        dto.setFileName(entity.getFileName());
        dto.setCustomerId(entity.getCustomer().getId());
        dto.setCustomerName(entity.getCustomer().getName());
        //TODO: manage server for DI
//        Server server = entity.getServer();
//        if (server != null) {
//            dto.setServerId(server.getId());
//            dto.setServerName(server.getServerName());
//        }

        return dto;
    }


    /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     *
     * @param pageRequest The information of the requested page.
     * @param source      The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    public static Page<DiagnosticImageDto> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<DiagnosticImage> source) {
        List<DiagnosticImageDto> dtos = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }
}
