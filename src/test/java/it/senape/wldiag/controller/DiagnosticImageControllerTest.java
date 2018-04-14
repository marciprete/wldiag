package it.senape.wldiag.controller;

import it.senape.wldiag.config.UrlMappings;
import it.senape.wldiag.config.WebTestConfig;
import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.exceptions.StorageException;
import it.senape.wldiag.fixtures.DiagnosticImageDtoFixtures;
import it.senape.wldiag.service.filesystem.DiagnosticImageResource;
import it.senape.wldiag.service.filesystem.DiagnosticImageXmlService;
import it.senape.wldiag.service.jpa.DiagnosticImageService;
import it.senape.wldiag.service.jpa.StorageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by michele.arciprete on 27-Mar-18
 */
public class DiagnosticImageControllerTest {

    private MockMvc mockMvc;

    private StorageService storageService;
    private DiagnosticImageService diagnosticImageService;
    private DiagnosticImageXmlService diagnosticImageXmlService;

    @BeforeEach
    public void setUp() throws Exception {
        storageService = mock(StorageService.class);
        diagnosticImageService = mock(DiagnosticImageService.class);
        diagnosticImageXmlService = mock(DiagnosticImageXmlService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new DiagnosticImageController(
                    storageService,
                    diagnosticImageService,
                    diagnosticImageXmlService))
                .setCustomArgumentResolvers(WebTestConfig.pageRequestArgumentResolver())
                .build();
    }

    @Nested
    class Retrieve {

        @Nested
        class WhenOneImageIsPresent {

            private final DiagnosticImageDto diagnosticImageDto = DiagnosticImageDtoFixtures.createDiagnosticImageDto();

            @BeforeEach
            public void setUp() throws Exception {
                given(diagnosticImageService.findLatest(isA(Pageable.class)))
                        .willReturn(new PageImpl<>(
                                Arrays.asList(diagnosticImageDto)
                        ));
            }

            @Test
            public void shouldListOneEntityAsJson() throws Exception {
                mockMvc.perform(get(UrlMappings.API_DIAGNOSTIC_IMAGE + "/" + UrlMappings.LIST)
                        .param("page", "0"))
                        .andDo(print())
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.content.length()",is(1)))
                        .andExpect(jsonPath("$.content[0].imageId", is(1)))
                        .andExpect(jsonPath("$.content[0].fileName", is(DiagnosticImageDtoFixtures.TEST_TILE_NAME)))
                        .andExpect(jsonPath("$.content[0].customerName", is(DiagnosticImageDtoFixtures.TEST_CUSTOMER_NAME)))
                ;

                verify(diagnosticImageService, times(1)).findLatest(isA(Pageable.class));
            }

//            @Test
//            public void shouldShowImageDetails() throws Exception {
//                when(diagnosticImageService.getDiagnosticImageDetails(isA(Long.class)))
//                        .thenReturn(diagnosticImageDto);
//                mockMvc.perform(get(UrlMappings.API_DIAGNOSTIC_IMAGE + "/" + UrlMappings.SHOW + "/1"))
//                        .andDo(print())
//                        .andExpect(status().isOk())
//                ;
//            }

            @Nested
            class WhenFileNameIsNull {
                @Test
                public void showNotFoundPage() throws Exception {
                    diagnosticImageDto.setFileName(null);
                    when(diagnosticImageService.findById(isA(Long.class)))
                            .thenReturn(diagnosticImageDto);
                    mockMvc.perform(get(UrlMappings.API_DIAGNOSTIC_IMAGE + "/" + UrlMappings.SHOW + "/1"))
                            .andDo(print())
                            .andExpect(status().isNotFound());
                }
            }
        }

        @Nested
        class WhenNoImagesAreFound {

            @Test
            public void showNotFoundPage() throws Exception {
                given(diagnosticImageService.findById(isA(Long.class)))
                        .willReturn(null);
                mockMvc.perform(get(UrlMappings.API_DIAGNOSTIC_IMAGE + "/" + UrlMappings.SHOW + "/1"))
                        .andDo(print())
                        .andExpect(status().isNotFound());
            }

        }
    }

    @Nested
    class Create {

        public static final String ADD_IMAGE_URL_TEMPLATE = UrlMappings.API_DIAGNOSTIC_IMAGE + "/" + UrlMappings.ADD;

        MockMultipartFile wrongFileName = new MockMultipartFile("diagnosticImage", DiagnosticImageDtoFixtures.WRONG_IMAGE_FILE_NAME, "text/plain", "some text".getBytes());
        MockMultipartFile correctFileName = new MockMultipartFile("diagnosticImage", DiagnosticImageDtoFixtures.COMPLIANT_IMAGE_FILE_NAME, "text/plain", "some text".getBytes());


        @Nested
        class WhenDiagnosticImageIsNotValid {

            @Nested
            class WhenImageNameIsNotValid {
                @Test
                public void shouldReturnAnErrorMessage() throws Exception {
                    doNothing().when(storageService).store(isA(MultipartFile.class));
                    mockMvc.perform(multipart(ADD_IMAGE_URL_TEMPLATE)
                            .file(wrongFileName)
                            .param("customerId", "1"))
                            .andDo(print())
                            .andExpect(status().isOk())
                    .andExpect(jsonPath("$.['"+ DiagnosticImageDtoFixtures.WRONG_IMAGE_FILE_NAME+"']", is(DiagnosticImageController.UPLOAD_FAILED_FILENAME_NOT_VALID)));

                    verify(storageService, times(0)).store(isA(MultipartFile.class));

                }
            }

            @Nested
            class WhenCustomerIdIsMissing {

                @Test
                public void thenSaveShouldFail() throws Exception {
                    doNothing().when(storageService).store(isA(MultipartFile.class));
                    when(diagnosticImageService.save(isA(DiagnosticImageDto.class))).thenReturn(false);
                    mockMvc.perform(multipart(ADD_IMAGE_URL_TEMPLATE)
                            .file(correctFileName))
                            .andDo(print())
                            .andExpect(status().is4xxClientError())
                    ;

                    verify(storageService, times(0)).store(isA(MultipartFile.class));
                    verify(diagnosticImageService, times(0)).save(isA(DiagnosticImageDto.class));
                }
            }

            @Nested
            class WhenMultipartFileIsMissing {

                @Test
                public void thenSaveShouldFail() throws Exception {
                    doNothing().when(storageService).store(isA(MultipartFile.class));
                    when(diagnosticImageService.save(isA(DiagnosticImageDto.class))).thenReturn(false);
                    mockMvc.perform(multipart(ADD_IMAGE_URL_TEMPLATE)
                            .param("customerId", "1"))
                            .andDo(print())
                            .andExpect(status().is4xxClientError())
                    ;
                    verify(storageService, times(0)).store(isA(MultipartFile.class));
                    verify(diagnosticImageService, times(0)).save(isA(DiagnosticImageDto.class));
                }
            }

            @Nested
            class WhenServiceFails {

                public static final String STORAGE_EXCEPTION_TEXT = "TEST FAIL";

                @Test
                public void theStorageServiceFailsOnSaving() throws Exception {
                    doThrow(new StorageException(STORAGE_EXCEPTION_TEXT)).when(storageService).store(isA(MultipartFile.class));
                    mockMvc.perform(multipart(ADD_IMAGE_URL_TEMPLATE)
                            .file(correctFileName)
                            .param("customerId", "1"))
                            .andDo(print())
                            .andExpect(status().isOk())
                            .andExpect(jsonPath("$.['"+ DiagnosticImageDtoFixtures.COMPLIANT_IMAGE_FILE_NAME +"']", is(STORAGE_EXCEPTION_TEXT)))
                    ;

                    verify(storageService, times(1)).store(isA(MultipartFile.class));
                }

                @Test
                public void theDiagnosticImageServiceFailsOnSaving() throws Exception {
                    doNothing().when(storageService).store(isA(MultipartFile.class));
                    when(diagnosticImageService.save(isA(DiagnosticImageDto.class))).thenReturn(false);
                    when(diagnosticImageXmlService.extract(isA(DiagnosticImageResource.class))).thenReturn(DiagnosticImageDtoFixtures.createDiagnosticImageDto());
                    mockMvc.perform(multipart(ADD_IMAGE_URL_TEMPLATE)
                            .file(correctFileName)
                            .param("customerId", "1"))
                            .andDo(print())
                            .andExpect(status().isOk())
                            .andExpect(jsonPath("$.['"+ DiagnosticImageDtoFixtures.COMPLIANT_IMAGE_FILE_NAME +"']", is(DiagnosticImageController.SAVE_FAILED)))
                    ;

                    verify(storageService, times(1)).store(isA(MultipartFile.class));
                    verify(diagnosticImageService, times(1)).save(isA(DiagnosticImageDto.class));
                }
            }

        }

        @Nested
        class WhenDiagnosticImageIsValid {

            @Test
            public void shouldCreateOneDiagnosticImage() throws Exception {
                doNothing().when(storageService).store(isA(MultipartFile.class));
                when(diagnosticImageService.save(isA(DiagnosticImageDto.class))).thenReturn(true);
                when(diagnosticImageXmlService.extract(isA(DiagnosticImageResource.class)))
                        .thenReturn(DiagnosticImageDtoFixtures.createDiagnosticImageDto());
                mockMvc.perform(multipart(ADD_IMAGE_URL_TEMPLATE)
                        .file(correctFileName)
                        .param("customerId", "1"))
                        .andDo(print())
                        .andExpect(status().isOk())
                .andExpect(jsonPath("$.['"+ DiagnosticImageDtoFixtures.COMPLIANT_IMAGE_FILE_NAME+"']", is(DiagnosticImageController.SAVE_SUCCESSFUL)))

                ;
                verify(storageService, times(1)).store(isA(MultipartFile.class));
                verify(diagnosticImageService, times(1)).save(isA(DiagnosticImageDto.class));

            }
        }

    }

}