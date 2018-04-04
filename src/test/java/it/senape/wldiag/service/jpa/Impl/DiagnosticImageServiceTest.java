package it.senape.wldiag.service.jpa.Impl;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.fixtures.CustomerFixtures;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.repository.CustomerRepository;
import it.senape.wldiag.jpa.repository.DiagnosticImageRepository;
import it.senape.wldiag.service.jpa.JdbcResourcePoolService;
import it.senape.wldiag.service.jpa.JtaService;
import it.senape.wldiag.service.jpa.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by michele.arciprete on 30-Mar-18
 */
class DiagnosticImageServiceTest {

    private DiagnosticImageServiceImpl service;

    private StorageService storageService;
    private DiagnosticImageRepository diagnosticImageRepository;
    private CustomerRepository customerRepository;
    private JtaService jtaService;
    private JdbcResourcePoolService jdbcResourcePoolService;

    @BeforeEach
    public void setUp() throws Exception {
        diagnosticImageRepository = mock(DiagnosticImageRepository.class);
        customerRepository = mock(CustomerRepository.class);
        storageService = mock(StorageService.class);
        jtaService = mock(JtaService.class);
        jdbcResourcePoolService = mock(JdbcResourcePoolService.class);

        service = new DiagnosticImageServiceImpl(storageService,
                diagnosticImageRepository,
                customerRepository,
                jtaService,
                jdbcResourcePoolService);
    }

//    @Nested
//    class Retrieve {
//
//
//    }


    @Nested
    class Create {


        @Nested
        class WhenCustomerIsFound {

            @BeforeEach
            public void returnValidCustomer() throws Exception {
                when(customerRepository.findById(isA(Long.class)))
                        .thenReturn(Optional.of(CustomerFixtures.createCustomer()));
            }

            @Nested
            class WhenImageNotExists {

                @Test
                public void shouldCreateOneDiagnosticImage() throws Exception {
                    DiagnosticImage image = new DiagnosticImage();
                    image.setId(1l);

                    when(storageService.load(isA(String.class))).thenReturn(new File("f").toPath());
                    when(customerRepository.findById(isA(Long.class)))
                            .thenReturn(Optional.of(CustomerFixtures.createCustomer()));
                    when(diagnosticImageRepository.save(isA(DiagnosticImage.class)))
                            .thenReturn(image);

                    when(jtaService.save(isA(JtaDto.class))).thenReturn(new JtaDto());

                    DiagnosticImageDto diagnosticImageDto = new DiagnosticImageDto();
                    diagnosticImageDto.setCustomerId(1L);
                    diagnosticImageDto.setJtaDto(new JtaDto());
                    diagnosticImageDto.setJdbcResourcePool(new JdbcResourcePoolDto());
                    service.save(diagnosticImageDto);

//                    verify(diagnosticImageRepository, times(1)).findByFileNameAndCustomerId(isA(String.class),
//                            isA(Long.class));
//                    verify(diagnosticImageFileExtractorHelper, times(1))
//                            .extractFiles(isA(Path.class),isA(DiagnosticImage.class));
                }
            }
        }


    }



}