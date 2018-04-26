package it.senape.wldiag.service.jpa.impl;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.dto.jvm.JvmDto;
import it.senape.wldiag.dto.workmanager.WorkManagerDto;
import it.senape.wldiag.jpa.bridge.DiagnosticImageProjectionMapper;
import it.senape.wldiag.jpa.model.internal.Customer;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.projection.DiagnosticImageDetailProjection;
import it.senape.wldiag.jpa.projection.DiagnosticImageProjection;
import it.senape.wldiag.jpa.repository.CustomerRepository;
import it.senape.wldiag.jpa.repository.DiagnosticImageRepository;
import it.senape.wldiag.service.jpa.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.Optional;

/**
 * Created by michele.arciprete on 30-Mar-18
 */
@Service
@Transactional
public class DiagnosticImageServiceImpl implements DiagnosticImageService {

    private static final Logger logger = LoggerFactory.getLogger(DiagnosticImageServiceImpl.class);

    private CustomerRepository customerRepository;
    private DiagnosticImageRepository diagnosticImageRepository;
    private JtaService jtaService;
    private JdbcResourcePoolService jdbcResourcePoolService;
    private WorkManagerService workManagerService;
    private JvmService jvmService;

    @Autowired
    public DiagnosticImageServiceImpl(
            DiagnosticImageRepository diagnosticImageRepository,
            CustomerRepository customerRepository,
            JtaService jtaService,
            JdbcResourcePoolService jdbcResourcePoolService,
            WorkManagerService workManagerService,
            JvmService jvmService
    ) {

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
            diagnosticImage.setServerLabel(diagnosticImageDto.getServerLabel());
            diagnosticImage.setFileName(diagnosticImageDto.getFileName());

            try {
                diagnosticImage = diagnosticImageRepository.save(diagnosticImage);
                Long diagnosticImageId = diagnosticImage.getId();
                if(diagnosticImageId == null) {
                    throw new CannotCreateTransactionException("Failed saving Diagnostic Image");
                }

                JtaDto jtaDto = diagnosticImageDto.getJtaDto();
                jtaDto.setDiagnosticImageId(diagnosticImageId);
                jtaDto.setCustomerId(diagnosticImage.getCustomer().getId());
                jtaDto.setServerLabel(diagnosticImageDto.getServer().getLabel());
                jtaService.save(jtaDto);


                JdbcResourcePoolDto jdbcResourcePoolDto = diagnosticImageDto.getJdbcResourcePool();
                jdbcResourcePoolDto.setDiagnosticImageId(diagnosticImageId);
                jdbcResourcePoolService.save(jdbcResourcePoolDto);

                WorkManagerDto workManagerDto = diagnosticImageDto.getWorkManagerDto();
                workManagerDto.setDiagnosticImageId(diagnosticImageId);
                workManagerService.save(workManagerDto);

                JvmDto jvmDto = diagnosticImageDto.getJvmDto();
                jvmDto.setDiagnosticImageId(diagnosticImageId);
                jvmService.save(jvmDto);

                return true;
            } catch (TransactionException txe) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }

        }
        logger.error("Customer not found with id {}", diagnosticImageDto.getCustomerId());
        return false;
    }

    @Override
    public void delete(String fileName, Long customerId) {
        diagnosticImageRepository.deleteByFileNameAndCustomer_Id(fileName, customerId);
    }

    @Override
    public DiagnosticImageDetailProjection getDiagnosticImageDetails(Long diagnosticImageId) {
        return diagnosticImageRepository.findDiagnosticImageDetails(diagnosticImageId);
    }

    @Override
    @Transactional(readOnly = true)
    public DiagnosticImageDto findByFileName(String fileName) {
        if (fileName != null) {
            return getDummyDto(diagnosticImageRepository.findByFileName(fileName));
        }
        return new DiagnosticImageDto();
    }

    @Override
    public long count() {
        return diagnosticImageRepository.count();
    }

    @Override
    @Transactional(readOnly = true)
    public DiagnosticImageDto findById(Long diagnosticImageId) {
        if (diagnosticImageId != null) {
            return getDummyDto(diagnosticImageRepository.findById(diagnosticImageId));
        }
        return new DiagnosticImageDto();
    }

    private DiagnosticImageDto getDummyDto(Optional<DiagnosticImage> di) {
        DiagnosticImageDto dto = new DiagnosticImageDto();
        if (di.isPresent()) {
            DiagnosticImage dummyDI = di.get();
            dto.setAcquisitionTime(dummyDI.getAcquisitionTime());
            dto.setFileName(dummyDI.getFileName());
        }
        return dto;
    }

    @Override
    @Transactional(readOnly = true)
    public Page<DiagnosticImageDto> findLatest(Pageable pageRequest) {
        logger.trace("Find latest DIs");
        if (pageRequest.getSort() == null) {
            pageRequest = PageRequest.of(pageRequest.getPageNumber(),
                    pageRequest.getPageSize(),
                    Sort.Direction.DESC,
                    "acquisitionTime");
        }
        Page<DiagnosticImageProjection> resultsPage = diagnosticImageRepository.retrieveAll(pageRequest);
        logger.debug("Found {} diagnostic images", resultsPage.getTotalElements());
        return DiagnosticImageProjectionMapper.mapEntityPageIntoDTOPage(pageRequest, resultsPage);
    }


}
