package it.senape.wldiag.service.jpa.Impl;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.jpa.bridge.DiagnosticImageMapper;
import it.senape.wldiag.jpa.model.internal.Customer;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.repository.CustomerRepository;
import it.senape.wldiag.jpa.repository.DiagnosticImageRepository;
import it.senape.wldiag.service.jpa.DiagnosticImageService;
import it.senape.wldiag.service.jpa.JdbcResourcePoolService;
import it.senape.wldiag.service.jpa.JtaService;
import it.senape.wldiag.service.jpa.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
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


    StorageService storageService;
    CustomerRepository customerRepository;
    DiagnosticImageRepository diagnosticImageRepository;
    JtaService jtaService;
    JdbcResourcePoolService jdbcResourcePoolService;

    @Autowired
    public DiagnosticImageServiceImpl(
            StorageService storageService,
            DiagnosticImageRepository diagnosticImageRepository,
            CustomerRepository customerRepository,
            JtaService jtaService,
            JdbcResourcePoolService jdbcResourcePoolService
    ) {

        this.storageService = storageService;
        this.diagnosticImageRepository = diagnosticImageRepository;
        this.customerRepository = customerRepository;
        this.jtaService = jtaService;
        this.jdbcResourcePoolService = jdbcResourcePoolService;
    }


    @Override
    @Transactional
    public Boolean save(DiagnosticImageDto dto) throws TransactionException {
        Boolean result = false;

        Optional<Customer> customer = customerRepository.findById(dto.getCustomerId());
        if (customer.isPresent()) {
            DiagnosticImage diagnosticImage = diagnosticImageRepository.findByFileNameAndCustomerId(dto.getFileName(), dto.getCustomerId());

            //TODO: Returns false if the image already exists. Don't perform any update, yet.
            if (diagnosticImage != null) {
                return false;
            }

            diagnosticImage = new DiagnosticImage();
            diagnosticImage.setCustomer(customer.get());
            diagnosticImage.setAcquisitionTime(dto.getAcquisitionTime());
            diagnosticImage.setServerName(dto.getServerName());
            diagnosticImage.setFileName(dto.getFileName());

            try {
                diagnosticImage = diagnosticImageRepository.save(diagnosticImage);
                JtaDto jtaDto = dto.getJtaDto();
                jtaDto.setDiagnosticImageId(diagnosticImage.getId());
                jtaService.save(jtaDto);
                JdbcResourcePoolDto jdbcResourcePool = dto.getJdbcResourcePool();
                jdbcResourcePool.setDiagnosticImageId(diagnosticImage.getId());
                jdbcResourcePoolService.save(jdbcResourcePool);
                if (diagnosticImage != null) {
                    result = diagnosticImage.getId() != null;
                }
            } catch (TransactionException txe) {
                TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            }

        }
        log.error("Customer not found with id {}", dto.getCustomerId());
        return result;
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
