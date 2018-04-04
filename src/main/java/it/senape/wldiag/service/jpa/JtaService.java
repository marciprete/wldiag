package it.senape.wldiag.service.jpa;

import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.message.JtaMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.TransactionException;

/**
 * Created by michele.arciprete on 30-Mar-18
 */
public interface JtaService {

    Page<JtaMessage> findAll(Pageable pageRequest);

    JtaDto save(JtaDto dto) throws TransactionException;

    void delete(Long id);
}
