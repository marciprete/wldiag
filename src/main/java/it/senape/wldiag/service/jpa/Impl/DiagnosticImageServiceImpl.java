package it.senape.wldiag.service.jpa.Impl;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.dto.jvm.JvmDto;
import it.senape.wldiag.dto.workmanager.WorkManagerDto;
import it.senape.wldiag.jpa.bridge.DiagnosticImageMapper;
import it.senape.wldiag.jpa.model.internal.Customer;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.repository.CustomerRepository;
import it.senape.wldiag.jpa.repository.DiagnosticImageRepository;
import it.senape.wldiag.service.jpa.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Optional;

/**
 * Created by michele.arciprete on 30-Mar-18
 */
@Service
@Transactional
public class DiagnosticImageServiceImpl implements DiagnosticImageService {

    Logger log = LoggerFactory.getLogger(DiagnosticImageServiceImpl.class);


    private StorageService storageService;
    private CustomerRepository customerRepository;
    private DiagnosticImageRepository diagnosticImageRepository;
    private JtaService jtaService;
    private JdbcResourcePoolService jdbcResourcePoolService;
    private WorkManagerService workManagerService;
    private JvmService jvmService;

    @Autowired
    public DiagnosticImageServiceImpl(
            StorageService storageService,
            DiagnosticImageRepository diagnosticImageRepository,
            CustomerRepository customerRepository,
            JtaService jtaService,
            JdbcResourcePoolService jdbcResourcePoolService,
            WorkManagerService workManagerService,
            JvmService jvmService
    ) {

        this.storageService = storageService;
        this.diagnosticImageRepository = diagnosticImageRepository;
        this.customerRepository = customerRepository;
        this.jtaService = jtaService;
        this.jdbcResourcePoolService = jdbcResourcePoolService;
        this.workManagerService = workManagerService;
        this.jvmService = jvmService;
    }


    @Override
    @Transactional
    public Boolean save(DiagnosticImageDto diagnosticImageDto) throws TransactionException {
        Optional<Customer> customer = customerRepository.findById(diagnosticImageDto.getCustomerId());
        if (customer.isPresent()) {
            DiagnosticImage diagnosticImage = diagnosticImageRepository.findByFileNameAndCustomerId(diagnosticImageDto.getFileName(), diagnosticImageDto.getCustomerId());

            //TODO: Returns false if the image already exists. Don't perform any update, yet.
            if (diagnosticImage != null) {
                return false;
            }

            diagnosticImage = new DiagnosticImage();
            diagnosticImage.setCustomer(customer.get());
            diagnosticImage.setAcquisitionTime(diagnosticImageDto.getAcquisitionTime());
            diagnosticImage.setServerName(diagnosticImageDto.getServerName());
            diagnosticImage.setFileName(diagnosticImageDto.getFileName());

            try {
                diagnosticImage = diagnosticImageRepository.save(diagnosticImage);
                Long diagnosticImageId = diagnosticImage.getId();
                if(diagnosticImageId == null) {
                    throw new CannotCreateTransactionException("Failed saving Diagnostic Image");
                }

                JtaDto jtaDto = diagnosticImageDto.getJtaDto();
                jtaDto.setDiagnosticImageId(diagnosticImageId);
                jtaService.save(jtaDto);

                JdbcResourcePoolDto jdbcResourcePool = diagnosticImageDto.getJdbcResourcePool();
                jdbcResourcePool.setDiagnosticImageId(diagnosticImageId);
                jdbcResourcePoolService.save(jdbcResourcePool);

                WorkManagerDto workManagerDto = diagnosticImageDto.getWorkManagerDto();
                workManagerDto.setDiagnosticImageId(diagnosticImageId);
                workManagerService.save(workManagerDto);

                JvmDto jvmDto = diagnosticImageDto.getJvmDto();
//                jvmDto
                jvmService.save(jvmDto);

                return true;
            } catch (TransactionException txe) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }

        }
        log.error("Customer not found with id {}", diagnosticImageDto.getCustomerId());
        return false;
    }

    @Override
    public void delete(String fileName, Long customerId) {
        diagnosticImageRepository.deleteByFileNameAndCustomer_Id(fileName, customerId);
    }

    @Override
    @Transactional(readOnly = true)
    public DiagnosticImageDto findById(Long id) {
        Optional<DiagnosticImage> di = diagnosticImageRepository.findById(id);
        DiagnosticImageDto dto = new DiagnosticImageDto();
        if (di.isPresent()) {
            DiagnosticImage _di = di.get();
            dto.setAcquisitionTime(_di.getAcquisitionTime());
            dto.setFileName(_di.getFileName());
        }
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DiagnosticImageDto> findLatest(Pageable pageRequest) {
        log.info("Find latest DIs");
//        if (pageRequest.getSort() == null) {
//            pageRequest = new PageRequest(pageRequest.getOffset(),
//                    pageRequest.getPageSize(),
//                    Sort.Direction.DESC,
//                    "acquisitionTime");
//        }
        Page<DiagnosticImage> resultsPage = diagnosticImageRepository.findAll(pageRequest);
        log.info("Found {} diagnostic images", resultsPage.getTotalElements());
        Page<DiagnosticImageDto> results = DiagnosticImageMapper.mapEntityPageIntoDTOPage(pageRequest, resultsPage);
        return results;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DiagnosticImageDto> findAll() {
        Iterable<DiagnosticImage> entities = diagnosticImageRepository.findAll();
        return DiagnosticImageMapper.mapEntitiesIntoDTOs(entities);
    }

}
