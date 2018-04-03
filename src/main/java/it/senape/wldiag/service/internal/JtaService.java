package it.senape.wldiag.service.internal;

import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.message.JtaMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by michele.arciprete on 30-Mar-18
 */
public interface JtaService {

    Page<JtaMessage> findAll(Pageable pageRequest);

    JtaMessage save(JtaDto dto);
}
