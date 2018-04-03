package it.senape.wldiag.service.internal.Impl;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.fixtures.CustomerFixtures;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.repository.CustomerRepository;
import it.senape.wldiag.jpa.repository.DiagnosticImageRepository;
import it.senape.wldiag.service.internal.JdbcResourcePoolService;
import it.senape.wldiag.service.internal.JtaService;
import it.senape.wldiag.service.internal.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

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

    @Nested
    class Retrieve {

        @Test
        void findById() {
            assertNotNull(service);
        }

//        @Test
//        void findLatest() {
//        }
//
//        @Test
//        void findAll() {
//        }

    }


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
//                    when(diagnosticImageFileExtractorHelper.extractFiles(isA(Path.class),isA(DiagnosticImage.class)))
//                            .thenReturn(true);
                    when(diagnosticImageRepository.save(isA(DiagnosticImage.class)))
                            .thenReturn(image);

                    assertTrue(service.save(isA(DiagnosticImageDto.class)));

                    verify(diagnosticImageRepository, times(1)).findByFileNameAndCustomerId(isA(String.class),
                            isA(Long.class));
//                    verify(diagnosticImageFileExtractorHelper, times(1))
//                            .extractFiles(isA(Path.class),isA(DiagnosticImage.class));
                }
            }
        }


    }



}