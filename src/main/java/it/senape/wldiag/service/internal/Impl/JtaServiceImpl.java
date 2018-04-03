package it.senape.wldiag.service.internal.Impl;

import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.jpa.bridge.Converter;
import it.senape.wldiag.jpa.bridge.JtaMessageMapper;
import it.senape.wldiag.jpa.model.jta.*;
import it.senape.wldiag.jpa.repository.JtaRepository;
import it.senape.wldiag.message.JtaMessage;
import it.senape.wldiag.service.internal.InternalThreadService;
import it.senape.wldiag.service.internal.JtaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
@Service
@Transactional
public class JtaServiceImpl implements JtaService {

    JtaRepository jtaRepository;
    InternalThreadService internalThreadService;

    @Autowired
    public JtaServiceImpl(
            JtaRepository jtaRepository,
            InternalThreadService internalThreadService) {
        this.jtaRepository = jtaRepository;
        this.internalThreadService = internalThreadService;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<JtaMessage> findAll(Pageable pageRequest) {
//        if(pageRequest.getSort() == null) {
//            pageRequest = new PageRequest(pageRequest.getOffset(),
//                    pageRequest.getPageSize(),
//                    Sort.Direction.DESC,
//                    "acquisitionTime");
//        }
        Page<Jta> jtas = jtaRepository.findAll(pageRequest);
        return JtaMessageMapper.mapEntityPageIntoDTOPage(pageRequest, jtas);
    }

    @Override
    public JtaMessage save(JtaDto dto) {
        Jta jta = convertJtaDtoToEntity(dto);
        jta = jtaRepository.save(jta);
        return null;
    }


    private Jta convertJtaDtoToEntity(JtaDto dto) {
        Jta entry = new Jta();
        if (dto != null) {
            entry.setAbandonTimeout(dto.getAbandonTimeout());
            entry.setBeforeCompletionIterationLimit(dto.getBeforeCompletionIterationLimit());
            entry.setCheckpointInterval(dto.getCheckpointInterval());
            entry.setCompletionTimeout(dto.getCompletionTimeout());
            entry.setDefaultTimeout(dto.getDefaultTimeout());
            entry.setForgetHeuristics(dto.isForgetHeuristics());
            entry.setLastCheckpointTime(Converter.fromLongToLocalDateTime(dto.getLastCheckpointTime()));
            entry.setMaxTransactions(dto.getMaxTransactions());
            entry.setMaxUniqueNameStatistics(dto.getMaxUniqueNameStatistics());
            entry.setTlogStoreName(dto.getTlogStoreName());
            entry.setHlogStoreName(dto.getHlogStoreName());
            entry.setParallelXAEnabled(dto.isParallelXAEnabled());
            entry.setTwoPhaseEnabled(dto.isTwoPhaseEnabled());

            entry.setHealth(Health.valueOf(dto.getHealth().getHealthState().getState().toString()));

            entry.setTransactionCount(dto.getTransactions().size());

            dto.getTransactions().forEach(transactionDTO -> {
                Transaction transaction = new Transaction();
                transaction.setXid(transactionDTO.getXid());
                transaction.setState(transactionDTO.getState());
                transaction.setStatus(transactionDTO.getStatus());
                transaction.setBeginTime(Converter.fromLongToLocalDateTime(transactionDTO.getBeginTime()));
                transaction.setCoordinatorURL(transactionDTO.getCoordinatorURL());
                transaction.setOwnerTM(transactionDTO.getOwnerTM());

                InternalThread it = internalThreadService.save(transactionDTO.getActiveThread());
                if(it!= null) {
                    transaction.setActiveThread(it);
                }

                transaction.setRepliesOwedMe(transactionDTO.getRepliesOwedMe());
                transaction.setRetry(transactionDTO.isRetry());

                transactionDTO.getGlobalProperties().forEach(globalProp -> {
                    Property p = Converter.convertDtoToEntity(globalProp);
                    transaction.getGlobalProperties().add(p);
                    p.setTransaction(transaction);
                });

                transactionDTO.getLocalProperties().forEach(localProp -> {
                    Property p = Converter.convertDtoToEntity(localProp);
                    transaction.getLocalProperties().add(p);
                    p.setTransaction(transaction);
                });

                entry.getTransactions().add(transaction);
                transaction.setJta(entry);

                //TODO: develop the "servers" part
//                transactionDTO.getServers().forEach(serverDTO -> {
//                    Server server = extractServerFromDto(serverDTO);
//                    transaction.addServer(server, serverDTO.isSyncRegistered(), serverDTO.getState());
//                });

            });

//            dto.getServers().forEach(serverDTO -> {
//                Server server = extractServerFromDto(serverDTO);
//                entry.getServers().add(server);
//            });

        }
        return entry;
    }
}
