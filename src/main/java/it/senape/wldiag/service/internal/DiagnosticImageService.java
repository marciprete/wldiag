package it.senape.wldiag.service.internal;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.jvm.JvmDto;
import it.senape.wldiag.dto.ServerDto;
import it.senape.wldiag.jpa.bridge.Converter;
import it.senape.wldiag.jpa.bridge.DiagnosticImageMapper;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.model.jta.*;
import it.senape.wldiag.jpa.repository.CustomerRepository;
import it.senape.wldiag.jpa.repository.DiagnosticImageRepository;
import it.senape.wldiag.jpa.repository.JtaRepository;
import it.senape.wldiag.xml.DomainType;
import it.senape.wldiag.xml.XMLConverter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Service
@Transactional
public class DiagnosticImageService {

    private static final Logger log = LoggerFactory.getLogger(DiagnosticImageService.class);

    StorageService storageService;
    DiagnosticImageFileExtractorService diagnosticImageFileExtractorService;
    JdbcFileExtractorService jdbcFileExtractorService;

    DiagnosticImageRepository diagnosticImageRepository;
    CustomerRepository customerRepository;
    JtaRepository jtaRepository;
    InternalThreadService internalThreadService;

    @Autowired
    public DiagnosticImageService(
            StorageService storageService,
            DiagnosticImageFileExtractorService diagnosticImageFileExtractorService,
            JdbcFileExtractorService jdbcFileExtractorService,
            DiagnosticImageRepository diagnosticImageRepository,
            CustomerRepository customerRepository,
            JtaRepository jtaRepository,
            InternalThreadService internalThreadService
        ) {

        this.storageService = storageService;
        this.diagnosticImageRepository = diagnosticImageRepository;
        this.jdbcFileExtractorService = jdbcFileExtractorService;
        this.customerRepository = customerRepository;
        this.diagnosticImageFileExtractorService = diagnosticImageFileExtractorService;
        this.jtaRepository = jtaRepository;
        this.internalThreadService = internalThreadService;
    }

    @Transactional(readOnly = true)
    public DiagnosticImageDto findById(Long id) {
        DiagnosticImage di = diagnosticImageRepository.findOne(id);
        DiagnosticImageDto dto = new DiagnosticImageDto();
        if (di != null) {
            dto.setAcquisitionTime(di.getAcquisitionTime());
            dto.setFileName(di.getFileName());
        }
        return dto;
    }

    @Transactional(readOnly = true)
    public Page<DiagnosticImageDto> findLatest(Pageable pageRequest) {
        log.info("Find latest DIs");
        if (pageRequest.getSort() == null) {
            pageRequest = new PageRequest(pageRequest.getOffset(),
                    pageRequest.getPageSize(),
                    Sort.Direction.DESC,
                    "acquisitionTime");
        }
        Page<DiagnosticImage> resultsPage = diagnosticImageRepository.findAll(pageRequest);
        log.info("Found {} diagnostic images", resultsPage.getTotalElements());
        Page<DiagnosticImageDto> results = DiagnosticImageMapper.mapEntityPageIntoDTOPage(pageRequest, resultsPage);
        return results;
    }

    @Transactional
    public Boolean save(String fileName, Long customer) {
        DiagnosticImage diagnosticImage = diagnosticImageRepository.findByFileNameAndCustomerId(fileName, customer);

        if (diagnosticImage != null) {
            return false;
        }

        diagnosticImage = new DiagnosticImage();

        diagnosticImage.setCustomer(customerRepository.findOne(customer));

        Pattern pattern = Pattern.compile(StorageProperties.DIAGNOSTIC_IMAGE_FILENAME_PATTERN);
        Matcher matcher = pattern.matcher(fileName);

        while (matcher.find()) {
            String serverName = matcher.group(1);
            Integer year = Integer.parseInt(matcher.group(2));
            Integer month = Integer.parseInt(matcher.group(3));
            Integer day = Integer.parseInt(matcher.group(4));
            Integer hour = Integer.parseInt(matcher.group(5));
            Integer min = Integer.parseInt(matcher.group(6));
            Integer sec = Integer.parseInt(matcher.group(7));
            diagnosticImage.setFileName(fileName);
            diagnosticImage.setServerName(serverName);
            diagnosticImage.setAcquisitionTime(LocalDateTime.of(year, month, day, hour, min, sec));
            DiagnosticImage di = diagnosticImageRepository.save(diagnosticImage);
            if (di != null) {
                Path path = storageService.load(fileName);
                return extractFiles(path, diagnosticImage);
            }
        }

        return false;
    }

    private Boolean extractFiles(Path path, DiagnosticImage diagnosticImage) {
        Boolean success = true;
        if (path != null) {
            try {
                ByteArrayOutputStream dest = null;
                ZipInputStream zipIn = new ZipInputStream(
                        new ByteArrayInputStream(Files.readAllBytes(path)));
                ZipEntry entry;
                while ((entry = zipIn.getNextEntry()) != null) {
                    assert entry.getSize() >= 0;
                    if ("configuration.zip".equalsIgnoreCase(entry.getName())) {
                        extractConfiguration(zipIn);
                    } else if ("jvm.xml".equalsIgnoreCase(entry.getName())) {
                        dest = getFileAsByteArrayOS(zipIn);
                        JvmDto jvmDTO = XMLConverter.convertJvmInputStreamToObject(new ByteArrayInputStream(dest.toByteArray()));

//                        if(jvmDTO!=null) {
//                            Jta jta = convertJvnDtoToEntity(jtaDTO);
//                            jta.setDiagnosticImage(diagnosticImage);
//                            jvmRepository.save(jta);
//                        }

                    } else if ("JTA.xml".equalsIgnoreCase(entry.getName())) {
                        dest = extractJta(diagnosticImage, zipIn);


                    } else if ("JDBC.txt".equalsIgnoreCase(entry.getName())) {
                        extractJdbc(diagnosticImage, zipIn);
                    }
                    if (dest != null) {
                        dest.flush();
                        dest.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                success = false;
            }
        }
        return success;
    }

    private void extractJdbc(DiagnosticImage diagnosticImage, ZipInputStream zipIn) {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(zipIn)
        );
        jdbcFileExtractorService.extract(br, diagnosticImage);
    }

    private ByteArrayOutputStream extractJta(DiagnosticImage diagnosticImage, ZipInputStream zipIn) throws IOException {
        ByteArrayOutputStream dest;//TODO: Move this code into a service
        dest = getFileAsByteArrayOS(zipIn);
        JtaDto jtaDTO = XMLConverter.convertJTAInputStreamToObject(new ByteArrayInputStream(dest.toByteArray()));
        if (jtaDTO != null) {
            Jta jta = convertJpaDtoToEntity(jtaDTO);
            jta.setDiagnosticImage(diagnosticImage);
            /*jta = */
            jtaRepository.save(jta);
        }
        return dest;
    }

    private void extractConfiguration(ZipInputStream zipIn) throws IOException {
        ZipInputStream config = new ZipInputStream(zipIn);
        ZipEntry configFile;
        while ((configFile = config.getNextEntry()) !=null ) {
            if("config/config.xml".equalsIgnoreCase(configFile.getName())) {
                DomainType domainType = XMLConverter.convertDomainInputStreamToObject(new ByteArrayInputStream(getFileAsByteArrayOS(config).toByteArray()));
//                                domainType.getServer().forEach(serverType -> {
//                                    if(diagnosticImage.getServerName().equals(
//                                            serverType.getName())) {
//
//                                    }
//                                });
                ServerDto server = new ServerDto();
                server.setUrl(domainType.getMachine().get(0).getNodeManager().getValue().getListenAddress().getValue());
            }
        }
    }

    private ByteArrayOutputStream getFileAsByteArrayOS(InputStream is) throws IOException {
        final int BUFFER = 4096;
        int count;
        byte data[] = new byte[BUFFER];
        ByteArrayOutputStream dest = new ByteArrayOutputStream();
        while ((count = is.read(data, 0, BUFFER))
                != -1) {
            dest.write(data, 0, count);
        }
        return dest;
    }

    private Pageable createPageRequest() {
        return new PageRequest(0, 25, Sort.Direction.DESC, "acquisitionTime");
    }

    @Transactional(readOnly = false)
    public Jta convertJpaDtoToEntity(JtaDto dto) {
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

//    @Transactional
//    private Server extractServerFromDto(ServerDTO serverDTO) {
//        String serverUrl = serverDTO.getUrl();
//        String[] parts = serverUrl.split("\\+");
//        String serverName = parts[0];
//        String url = parts[1];
//        String domain = parts[2];
//        String connection = parts[3];
//
//        Server server = serverRepository.findByUrl(url);
//        if (server == null || server.getId() == 0) {
//            server = new Server();
//            server.setServerName(serverName);
//            server.setUrl(url);
//            server.setConnection(connection);
//            server.setDomain(domain);
//            server = serverRepository.save(server);
//        }
//        return server;
//    }

    public JtaDto extractJTAElement(Path path) {
        JtaDto jtaDTO = null;
        return jtaDTO;
    }


    public List<DiagnosticImageDto> findAll() {
        Iterable<DiagnosticImage> entities = diagnosticImageRepository.findAll();
        return DiagnosticImageMapper.mapEntitiesIntoDTOs(entities);
    }
}
