package it.senape.wldiag.jpa.bridge;

import it.senape.wldiag.dto.CustomerDto;
import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.jpa.model.internal.Customer;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
public class CustomerMapper {

    /**
     * Transforms the {@link Customer} object given as a method parameter into a
     * {@link CustomerDto} object and returns the created object.
     *
     * @param entity
     * @return
     */
    public static CustomerDto mapEntityIntoDTO(Customer entity) {
        CustomerDto dto = new CustomerDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());

        return dto;
    }

    /**
     * Transforms the list of {@link Customer} objects given as a method parameter
     * into a list of {@link CustomerDto} objects and returns the created list.
     *
     * @param entities
     * @return
     */
    public static List<CustomerDto> mapEntitiesIntoDTOs(Iterable<Customer> entities) {
        List<CustomerDto> dtos = new ArrayList<>();

        entities.forEach(e -> dtos.add(mapEntityIntoDTO(e)));

        return dtos;
    }

    /**
     * Transforms {@code Page<ENTITY>} objects into {@code Page<DTO>} objects.
     * @param pageRequest   The information of the requested page.
     * @param source        The {@code Page<ENTITY>} object.
     * @return The created {@code Page<DTO>} object.
     */
    public static Page<CustomerDto> mapEntityPageIntoDTOPage(Pageable pageRequest, Page<Customer> source) {
        List<CustomerDto> dtos = mapEntitiesIntoDTOs(source.getContent());
        return new PageImpl<>(dtos, pageRequest, source.getTotalElements());
    }
}
