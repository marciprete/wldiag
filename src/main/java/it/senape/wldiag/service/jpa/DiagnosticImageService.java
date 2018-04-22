package it.senape.wldiag.service.jpa;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.jpa.projection.DiagnosticImageDetailProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.TransactionException;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
public interface DiagnosticImageService {

    DiagnosticImageDto findById(Long id);

    DiagnosticImageDto findByFileName(String fileName);

    Page<DiagnosticImageDto> findLatest(Pageable pageRequest);

    Boolean save(DiagnosticImageDto dto) throws TransactionException;

    void delete(String fileName, Long customerId);
    DiagnosticImageDetailProjection getDiagnosticImageDetails(Long diagnosticImageId);

    long count();

//    int count(Long customerId);
}
