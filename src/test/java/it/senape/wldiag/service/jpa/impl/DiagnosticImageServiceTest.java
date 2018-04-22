package it.senape.wldiag.service.jpa.impl;

import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.dto.JtaDto;
import it.senape.wldiag.dto.jdbc.JdbcResourcePoolDto;
import it.senape.wldiag.dto.jvm.JvmDto;
import it.senape.wldiag.dto.workmanager.WorkManagerDto;
import it.senape.wldiag.fixtures.CustomerFixtures;
import it.senape.wldiag.fixtures.DiagnosticImageFixtures;
import it.senape.wldiag.jpa.model.internal.DiagnosticImage;
import it.senape.wldiag.jpa.repository.CustomerRepository;
import it.senape.wldiag.jpa.repository.DiagnosticImageRepository;
import it.senape.wldiag.service.jpa.JdbcResourcePoolService;
import it.senape.wldiag.service.jpa.JtaService;
import it.senape.wldiag.service.jpa.JvmService;
import it.senape.wldiag.service.jpa.WorkManagerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

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

    @Nested
    class FindById {

        @Nested
        class WhenIdIsValid {

            @Test
            public void shouldReturnDiagnosticImage() throws Exception {
                Long id = 1L;
                DiagnosticImage diagnosticImage = new DiagnosticImage();
                diagnosticImage.setFileName("TEST");
                LocalDateTime now = LocalDateTime.now();
                diagnosticImage.setAcquisitionTime(now);
                when(diagnosticImageRepository.findById(id)).thenReturn(Optional.of(diagnosticImage));

                DiagnosticImageDto dto = service.findById(id);
                assertEquals(now, dto.getAcquisitionTime());
                assertEquals("TEST", dto.getFileName());

                verify(diagnosticImageRepository, times(1))
                        .findById(id);
            }
        }

        @Nested
        class WhenIdIsNull {

            @Test
            public void shouldReturnAnEmptyDto() throws Exception {
                Long id = 5L;
                DiagnosticImageDto dto = service.findById(id);
                assertNotNull(dto);
                assertEquals(null, dto.getImageId());
                verify(diagnosticImageRepository, times(1))
                        .findById(id);
            }
        }

        @Nested
        class WhenIdDoesntExist {

            @Test
            public void shouldReturnAnEmptyDto() throws Exception {
                Long id = null;
                when(diagnosticImageRepository.findById(id)).thenReturn(Optional.empty());
                DiagnosticImageDto dto = service.findById(id);
                assertNotNull(dto);
                assertEquals(null, dto.getImageId());
            }
        }
    }

    @Nested
    class FindLatest {

        PageRequest pageRequest;

        @Nested
        class WhenDefaultPageSort {

            @BeforeEach()
            public void setDefaultPageSort() {
                pageRequest = PageRequest.of(0, 10);
            }

            @Nested
            class WhenImagesExist {

                @Test
                public void shoudlReturnAList() throws Exception {
                    when(diagnosticImageRepository.retrieveAll(isA(Pageable.class)))
                            .thenReturn(
                                    new PageImpl<>(Arrays.asList(DiagnosticImageFixtures.createProjection())));

                    Page<DiagnosticImageDto> projections = service.findLatest(pageRequest);

                    assertTrue(projections.hasContent());
                    verify(diagnosticImageRepository).retrieveAll(pageRequest);
                }
            }
        }

        @Nested
        class WhenSortingByFileName {
            @BeforeEach()
            public void setSort() {
                pageRequest = PageRequest.of(0, 10, Sort.Direction.DESC, "file_name");
            }

            @Test
            public void shoudlReturnASortedList() throws Exception {
                when(diagnosticImageRepository.retrieveAll(isA(Pageable.class)))
                        .thenReturn(
                                new PageImpl<>(Arrays.asList(DiagnosticImageFixtures.createProjection())));

                Page<DiagnosticImageDto> projections = service.findLatest(pageRequest);

                assertTrue(projections.hasContent());
                verify(diagnosticImageRepository).retrieveAll(pageRequest);
            }
        }

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
                    diagnosticImageDto.setJvmDto(new JvmDto());
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