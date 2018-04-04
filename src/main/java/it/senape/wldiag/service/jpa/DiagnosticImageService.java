package it.senape.wldiag.service.jpa;

import it.senape.wldiag.dto.DiagnosticImageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.TransactionException;

import java.util.List;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
public interface DiagnosticImageService {

    DiagnosticImageDto findById(Long id);

    List<DiagnosticImageDto> findAll();

    Page<DiagnosticImageDto> findLatest(Pageable pageRequest);

    Boolean save(DiagnosticImageDto dto) throws TransactionException;

    void delete(String fileName, Long customerId);
}
