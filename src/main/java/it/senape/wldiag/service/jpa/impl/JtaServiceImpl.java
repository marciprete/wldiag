package it.senape.wldiag.service.jpa.impl;

import it.senape.wldiag.dto.InternalThreadDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.ServerDto;
import it.senape.wldiag.jpa.bridge.Converter;
import it.senape.wldiag.jpa.bridge.JtaMessageMapper;
import it.senape.wldiag.jpa.model.internal.Customer;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.jta.*;
import it.senape.wldiag.jpa.repository.JtaRepository;
import it.senape.wldiag.jpa.repository.ServerRepository;
import it.senape.wldiag.message.JtaMessage;
import it.senape.wldiag.service.jpa.JtaService;
import it.senape.wldiag.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
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


    private Jta convertJtaDtoToEntity(JtaDto jtaDto) {
        Jta jtaEntry = new Jta();
        if (jtaDto != null) {
            jtaEntry.setAbandonTimeout(jtaDto.getAbandonTimeout());
            jtaEntry.setBeforeCompletionIterationLimit(jtaDto.getBeforeCompletionIterationLimit());
            jtaEntry.setCheckpointInterval(jtaDto.getCheckpointInterval());
            jtaEntry.setCompletionTimeout(jtaDto.getCompletionTimeout());
            jtaEntry.setDefaultTimeout(jtaDto.getDefaultTimeout());
            jtaEntry.setForgetHeuristics(jtaDto.isForgetHeuristics());
            jtaEntry.setLastCheckpointTime(Converter.fromLongToLocalDateTime(jtaDto.getLastCheckpointTime()));
            jtaEntry.setMaxTransactions(jtaDto.getMaxTransactions());
            jtaEntry.setMaxUniqueNameStatistics(jtaDto.getMaxUniqueNameStatistics());
            jtaEntry.setTlogStoreName(jtaDto.getTlogStoreName());
            jtaEntry.setHlogStoreName(jtaDto.getHlogStoreName());
            jtaEntry.setParallelXAEnabled(jtaDto.isParallelXAEnabled());
            jtaEntry.setTwoPhaseEnabled(jtaDto.isTwoPhaseEnabled());
            jtaEntry.setHealth(Health.valueOf(jtaDto.getHealth().getHealthState().getState().toString()));
            jtaEntry.setTransactionCount(jtaDto.getTransactions().size());

            DiagnosticImage diagnosticImage = new DiagnosticImage();
            diagnosticImage.setId(jtaDto.getDiagnosticImageId());
            jtaEntry.setDiagnosticImage(diagnosticImage);

            Customer customer = new Customer();
            customer.setId(jtaDto.getCustomerId());

            Map<String, Server> serverMap = new HashMap<>();

            jtaDto.getTransactions().forEach(transactionDto -> {
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

                jtaEntry.getTransactions().add(transaction);
                transaction.setJta(jtaEntry);


                for(ServerDto serverDto : transactionDto.getServers()) {
                    if(!serverMap.keySet().contains(serverDto.getUrl()) ) {
                        serverDto.setServerLabel(jtaDto.getServerLabel());
                        Server server = extractServerFromDto(serverDto, customer);
                        transaction.addServer(server, serverDto.isSyncRegistered(), serverDto.getState());
                        serverMap.put(serverDto.getUrl(),server);
                    }
                }

                transactionDto.getResources().forEach(resourceDto -> {
                    Resource resource = new Resource();
                    resource.setName(resourceDto.getName());
                    resource.setBusy(resourceDto.isBusy());
                    resource.setState(resourceDto.getState());
                    resource.setXid(resourceDto.getXid());

                    for (ServerDto serverDto : resourceDto.getServers()) {
                        Server server = serverMap.get(serverDto.getUrl());
                        if (server == null) {
                            server = extractServerFromDto(serverDto, customer);
                            serverMap.put(server.getUrl(), server);
                        }
                        resource.addServer(server);
                        resource.setTransaction(transaction);
                    }
                    transaction.getResources().add(resource);
                });

            });

        }
        return jtaEntry;
    }

    private Optional<InternalThreadDto> convertStringToInternalThreadDto(String activeThreadString) {
        Pattern pattern = Pattern.compile("^Thread\\[(.*)\\]");
        Optional<InternalThreadDto> option = Optional.empty();
        if(activeThreadString != null) {
            Matcher matcher = pattern.matcher(activeThreadString);
            while (matcher.find()) {
                String thread = matcher.group(1);

                String[] elements = thread.split(",");
                String name = elements[0];
                String poolNumber = elements[1];
                String type = elements[2];
                InternalThreadDto internalThreadDto = new InternalThreadDto();
                internalThreadDto.setWlsStatus(Util.extractWlsStatus(thread));
                internalThreadDto.setName(name);
                internalThreadDto.setPoolNumber(Integer.parseInt(poolNumber));
                internalThreadDto.setType(type);
                option = Optional.of(internalThreadDto);
            }
        }
        return option;
    }

    private Server extractServerFromDto(ServerDto serverDto, Customer customer) {
        String[] splittedUrl = serverDto.getUrl().split("\\+");
        assert splittedUrl.length == 4;
        String serverName = splittedUrl[0];
        String url = splittedUrl[1];
        String domain = splittedUrl[2];
        String connection = splittedUrl[3];
        Optional<Server> optionalServer = serverRepository.findByUrl(url);
        if (!optionalServer.isPresent()) {
            Server toCreate = new Server();
            toCreate.setCustomer(customer);
            toCreate.setServerName(serverName);
            toCreate.setUrl(serverDto.getUrl());
            toCreate.setLabel(serverDto.getServerLabel());
            String[] completeAddress = url.split(":");
            String address = completeAddress[0];
            String port = completeAddress[1];
            toCreate.setListenAddress(address);
            toCreate.setServerPort(Long.parseLong(port));
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
