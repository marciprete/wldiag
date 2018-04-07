package it.senape.wldiag.service.jpa.Impl;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.dto.jvm.JvmDto;
import it.senape.wldiag.dto.workmanager.WorkManagerDto;
import it.senape.wldiag.fixtures.CustomerFixtures;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.repository.CustomerRepository;
import it.senape.wldiag.jpa.repository.DiagnosticImageRepository;
import it.senape.wldiag.service.jpa.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by michele.arciprete on 30-Mar-18
 */
class DiagnosticImageServiceTest {

    private DiagnosticImageServiceImpl service;

    private DiagnosticImageRepository diagnosticImageRepository;
    private CustomerRepository customerRepository;
    private JtaService jtaService;
    private JdbcResourcePoolService jdbcResourcePoolService;
    private WorkManagerService workManagerService;
    private JvmService jvmService;

    @BeforeEach
    public void setUp() throws Exception {
        diagnosticImageRepository = mock(DiagnosticImageRepository.class);
        customerRepository = mock(CustomerRepository.class);
        jtaService = mock(JtaService.class);
        jdbcResourcePoolService = mock(JdbcResourcePoolService.class);
        workManagerService = mock(WorkManagerService.class);
        jvmService = mock(JvmService.class);

        service = new DiagnosticImageServiceImpl(
                diagnosticImageRepository,
                customerRepository,
                jtaService,
                jdbcResourcePoolService,
                workManagerService,
                jvmService);
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
                    given(customerRepository.findById(1l)).willReturn(Optional.of(CustomerFixtures.createCustomer()));
                    given(diagnosticImageRepository.findByFileNameAndCustomerId(isA(String.class), isA(Long.class)))
                            .willReturn(null);
                    given(diagnosticImageRepository.save(isA(DiagnosticImage.class))).willReturn(image);
                    given(jtaService.save(isA(JtaDto.class))).willReturn(new JtaDto());
                    given(workManagerService.save(isA(WorkManagerDto.class))).willReturn(new WorkManagerDto());
                    given(jvmService.save(isA(JvmDto.class))).willReturn(true);

                    DiagnosticImageDto diagnosticImageDto = new DiagnosticImageDto();
                    diagnosticImageDto.setCustomerId(1L);
                    diagnosticImageDto.setJtaDto(new JtaDto());
                    diagnosticImageDto.setJdbcResourcePool(new JdbcResourcePoolDto());
                    diagnosticImageDto.setWorkManagerDto(new WorkManagerDto());
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