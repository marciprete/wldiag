package it.senape.wldiag.service.jpa.Impl;

import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.ServerDto;
import it.senape.wldiag.jpa.bridge.Converter;
import it.senape.wldiag.jpa.bridge.JtaMessageMapper;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.jta.*;
import it.senape.wldiag.jpa.repository.JtaRepository;
import it.senape.wldiag.jpa.repository.ServerRepository;
import it.senape.wldiag.message.JtaMessage;
import it.senape.wldiag.service.jpa.InternalThreadService;
import it.senape.wldiag.service.jpa.JtaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
@Service
@Transactional
public class JtaServiceImpl implements JtaService {

    private JtaRepository jtaRepository;
    private InternalThreadService internalThreadService;
    private ServerRepository serverRepository;

    @Autowired
    public JtaServiceImpl(
            JtaRepository jtaRepository,
            InternalThreadService internalThreadService,
            ServerRepository serverRepository) {
        this.jtaRepository = jtaRepository;
        this.internalThreadService = internalThreadService;
        this.serverRepository = serverRepository;
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
    public JtaDto save(JtaDto dto) throws TransactionException {
        Jta jta = convertJtaDtoToEntity(dto);
        jtaRepository.save(jta);
        return dto;
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

            DiagnosticImage diagnosticImage = new DiagnosticImage();
            diagnosticImage.setId(dto.getDiagnosticImageId());
            entry.setDiagnosticImage(diagnosticImage);

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
                transactionDTO.getServers().forEach(serverDTO -> {
                    Optional<Server> server = extractServerFromDto(serverDTO);
                    if(server.isPresent()) {
                        transaction.addServer(server.get(), serverDTO.isSyncRegistered(), serverDTO.getState());
                    }
                });

            });

//            dto.getServers().forEach(serverDTO -> {
//                Server server = extractServerFromDto(serverDTO);
//                entry.getServers().add(server);
//            });

        }
        return entry;
    }

    private Optional<Server> extractServerFromDto(ServerDto serverDTO) {
        String[] splittedUrl = serverDTO.getUrl().split("\\+");
        assert splittedUrl.length==4;
        String serverName = splittedUrl[0];
        String url = splittedUrl[1];
        String domain = splittedUrl[2];
        String connection = splittedUrl[3];
        Optional<Server> optionalServer = serverRepository.findByUrl(url);
        if(!optionalServer.isPresent()) {
            Server toCreate = new Server();
            toCreate.setServerName(serverName);
            toCreate.setUrl(url);
            toCreate.setDomain(domain);
            toCreate.setConnection(connection);
            optionalServer = Optional.of(serverRepository.save(toCreate));
        }
        return optionalServer;
    }


    public void delete(Long id) {
        Optional<Jta> jta = jtaRepository.findById(id);
        if(jta.isPresent()) {
            jtaRepository.delete(jta.get());
        }
    }
}
