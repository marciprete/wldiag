package it.senape.wldiag.service.internal;

import it.senape.wldiag.dto.DiagnosticImageDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
public interface DiagnosticImageService {

    public DiagnosticImageDto findById(Long id);

    public List<DiagnosticImageDto> findAll();

    public Page<DiagnosticImageDto> findLatest(Pageable pageRequest);

//    public Boolean save(String fileName, Long customerId);

    public Boolean save(DiagnosticImageDto dto);
}
