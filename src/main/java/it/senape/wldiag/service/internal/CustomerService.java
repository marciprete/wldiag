package it.senape.wldiag.service.internal;

import it.senape.wldiag.dto.CustomerDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Created by michele.arciprete on 30-Mar-18
 */
public interface CustomerService {

    Page<CustomerDto> findAll(Pageable pageRequest);

    List<CustomerDto> findAll();

    Optional<CustomerDto> findById(Long id);
}
