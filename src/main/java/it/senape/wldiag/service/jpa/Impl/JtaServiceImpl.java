package it.senape.wldiag.service.jpa.Impl;

import it.senape.wldiag.dto.InternalThreadDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.ServerDto;
import it.senape.wldiag.jpa.bridge.Converter;
import it.senape.wldiag.jpa.bridge.JtaMessageMapper;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.jta.*;
import it.senape.wldiag.jpa.repository.JtaRepository;
import it.senape.wldiag.jpa.repository.ServerRepository;
import it.senape.wldiag.message.JtaMessage;
import it.senape.wldiag.service.jpa.JtaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
@Service
@Transactional
public class JtaServiceImpl implements JtaService {

    private static final Logger logger = LoggerFactory.getLogger(JtaService.class);

    private JtaRepository jtaRepository;
    private ServerRepository serverRepository;

    @Autowired
    public JtaServiceImpl(
            JtaRepository jtaRepository,
            ServerRepository serverRepository) {
        this.jtaRepository = jtaRepository;
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

            dto.getTransactions().forEach(transactionDto -> {
                Transaction transaction = new Transaction();
                transaction.setXid(transactionDto.getXid());
                transaction.setState(transactionDto.getState());
                transaction.setStatus(transactionDto.getStatus());
                transaction.setCoordinatorURL(transactionDto.getCoordinatorURL());
                transaction.setOwnerTM(transactionDto.getOwnerTM());
                transaction.setBeginTime(Converter.fromLongToLocalDateTime(transactionDto.getBeginTime()));
                transaction.setRepliesOwedOthers(transactionDto.getRepliesOwedOthers());

                String activeThreadString = transactionDto.getActiveThread();
                Optional<InternalThreadDto> internalThreadDtoOptional = convertStringToInternalThreadDto(activeThreadString);

                if (internalThreadDtoOptional.isPresent()) {
                    InternalThreadDto internalThreadDto = internalThreadDtoOptional.get();
                    InternalThread activeThread = new InternalThread();
                    BeanUtils.copyProperties(internalThreadDto, activeThread);
                    transaction.setActiveThread(activeThread);
                    activeThread.setTransaction(transaction);
                }

                transaction.setRepliesOwedMe(transactionDto.getRepliesOwedMe());
                transaction.setRetry(transactionDto.isRetry());

                transactionDto.getGlobalProperties().forEach(globalProp -> {
                    Property p = Converter.convertDtoToEntity(globalProp);
                    transaction.getGlobalProperties().add(p);
                    p.setTransaction(transaction);
                });

                transactionDto.getLocalProperties().forEach(localProp -> {
                    Property p = Converter.convertDtoToEntity(localProp);
                    transaction.getLocalProperties().add(p);
                    p.setTransaction(transaction);
                });

                entry.getTransactions().add(transaction);
                transaction.setJta(entry);

                transactionDto.getServers().forEach(serverDto -> {
                    Server server = extractServerFromDto(serverDto);
//                    if(server.isPresent()) {
                    transaction.addServer(server, serverDto.isSyncRegistered(), serverDto.getState());
//                    }
                });

                transactionDto.getResources().forEach(resourceDto -> {
                    Map<String, Server> serverMap = new HashMap<>();
                    Resource resource = new Resource();
                    resource.setName(resourceDto.getName());
                    resource.setBusy(resourceDto.isBusy());
                    resource.setState(resourceDto.getState());
                    resource.setXid(resourceDto.getXid());

                    for (ServerDto serverDto : resourceDto.getServers()) {
                        Server server = serverMap.get(serverDto.getUrl());
                        if (server == null) {
                            server = extractServerFromDto(serverDto);
                            serverMap.put(server.getUrl(), server);
                        }
                        resource.addServer(server);
                        resource.setTransaction(transaction);
                    }
                    transaction.getResources().add(resource);
                });

            });

        }
        return entry;
    }

    private Optional<InternalThreadDto> convertStringToInternalThreadDto(String activeThreadString) {
        Pattern pattern = Pattern.compile("^Thread\\[(.*)\\]");
        Matcher matcher = pattern.matcher(activeThreadString);
        Optional<InternalThreadDto> option = Optional.empty();
        while (matcher.find()) {
            String thread = matcher.group(1);

            String wlsStatus = null;
            if (thread.startsWith("[")) {
                wlsStatus = thread.substring(thread.indexOf("[") + 1, thread.indexOf("]"));
            }
            String[] elements = thread.split(",");
            String name = elements[0];
            String poolNumber = elements[1];
            String type = elements[2];
            InternalThreadDto internalThreadDto = new InternalThreadDto();
            internalThreadDto.setWlsStatus(wlsStatus);
            internalThreadDto.setName(name);
            internalThreadDto.setPoolNumber(Integer.parseInt(poolNumber));
            internalThreadDto.setType(type);
            option = Optional.of(internalThreadDto);
        }
        return option;
    }

    private Server extractServerFromDto(ServerDto serverDTO) {
        String[] splittedUrl = serverDTO.getUrl().split("\\+");
        assert splittedUrl.length == 4;
        String serverName = splittedUrl[0];
        String url = splittedUrl[1];
        String domain = splittedUrl[2];
        String connection = splittedUrl[3];
        Optional<Server> optionalServer = serverRepository.findByUrl(url);
        if (!optionalServer.isPresent()) {
            Server toCreate = new Server();
            toCreate.setServerName(serverName);
            toCreate.setUrl(url);
            toCreate.setDomain(domain);
            toCreate.setConnection(connection);
            return serverRepository.save(toCreate);
        }
        return optionalServer.get();
    }


    public void delete(Long id) {
        Optional<Jta> jta = jtaRepository.findById(id);
        jta.ifPresent(entity -> jtaRepository.delete(entity));
    }
}
