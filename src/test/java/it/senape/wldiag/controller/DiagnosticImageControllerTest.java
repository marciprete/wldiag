package it.senape.wldiag.controller;

import com.nitorcreations.junit.runners.NestedRunner;
import it.senape.wldiag.config.WebTestConfig;
import it.senape.wldiag.config.UrlMappings;
import it.senape.wldiag.dto.DiagnosticImageDto;
import it.senape.wldiag.exceptions.StorageException;
import it.senape.wldiag.fixtures.DiagnosticImageDtoFixtures;
import it.senape.wldiag.service.internal.DiagnosticImageService;
import it.senape.wldiag.service.internal.StorageService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by michele.arciprete on 27-Mar-18
 */
@RunWith(NestedRunner.class)
public class DiagnosticImageControllerTest {

    private MockMvc mockMvc;

    private DiagnosticImageService diagnosticImageService;
    private StorageService storageService;

    @Before
    public void setUp() throws Exception {
        diagnosticImageService = mock(DiagnosticImageService.class);
        storageService = mock(StorageService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new DiagnosticImageController(storageService, diagnosticImageService))
                .setCustomArgumentResolvers(WebTestConfig.pageRequestArgumentResolver())
                .build();
    }

    public class Retrieve {

        public class WhenOneImageIsPresent {

            private final DiagnosticImageDto diagnosticImageDto = DiagnosticImageDtoFixtures.createDiagnosticImageDto();

            @Before
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

            @Test
            public void shouldShowImageDetails() throws Exception {
                when(diagnosticImageService.findById(isA(Long.class)))
                        .thenReturn(diagnosticImageDto);
                mockMvc.perform(get(UrlMappings.API_DIAGNOSTIC_IMAGE + "/" + UrlMappings.SHOW + "/1"))
                        .andDo(print())
                        .andExpect(status().isOk())
                ;
            }
        }

        public class WhenNoImagesAreFound {

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

    public class Create {

        public static final String ADD_IMAGE_URL_TEMPLATE = UrlMappings.API_DIAGNOSTIC_IMAGE + "/" + UrlMappings.ADD;
        public final static String COMPLIANT_IMAGE_FILE_NAME = "diagnostic_image_ManagedServer_1_2018_01_22_18_20_43.zip";
        public final static String WRONG_IMAGE_FILE_NAME = "diagnostic_image_file.zip";

        MockMultipartFile wrongFileName = new MockMultipartFile("diagnosticImage", WRONG_IMAGE_FILE_NAME, "text/plain", "some text".getBytes());
        MockMultipartFile correctFileName = new MockMultipartFile("diagnosticImage", COMPLIANT_IMAGE_FILE_NAME, "text/plain", "some text".getBytes());


        public class WhenDiagnosticImageIsNotValid {

            public class WhenImageNameIsNotValid {
                @Test
                public void shouldReturnAnErrorMessage() throws Exception {
                    doNothing().when(storageService).store(isA(MultipartFile.class));
                    mockMvc.perform(fileUpload(ADD_IMAGE_URL_TEMPLATE)
                            .file(wrongFileName)
                            .param("customerId", "1"))
                            .andDo(print())
                            .andExpect(status().isOk())
                    .andExpect(jsonPath("$.['"+WRONG_IMAGE_FILE_NAME+"']", is(DiagnosticImageController.UPLOAD_FAILED_FILENAME_NOT_VALID)));

                    verify(storageService, times(0)).store(isA(MultipartFile.class));

                }
            }

            public class WhenCustomerIdIsMissing {

                @Test
                public void thenSaveShouldFail() throws Exception {
                    doNothing().when(storageService).store(isA(MultipartFile.class));
                    when(diagnosticImageService.save(isA(String.class),isA(Long.class))).thenReturn(false);
                    mockMvc.perform(fileUpload(ADD_IMAGE_URL_TEMPLATE)
                            .file(correctFileName))
                            .andDo(print())
                            .andExpect(status().is4xxClientError())
                    ;

                    verify(storageService, times(0)).store(isA(MultipartFile.class));
                    verify(diagnosticImageService, times(0)).save(COMPLIANT_IMAGE_FILE_NAME,1L);

                }
            }

            public class WhenMultipartFileIsMissing {

                @Test
                public void thenSaveShouldFail() throws Exception {
                    doNothing().when(storageService).store(isA(MultipartFile.class));
                    when(diagnosticImageService.save(isA(String.class),isA(Long.class))).thenReturn(false);
                    mockMvc.perform(fileUpload(ADD_IMAGE_URL_TEMPLATE)
                            .param("customerId", "1"))
                            .andDo(print())
                            .andExpect(status().is4xxClientError())
                    ;
                    verify(storageService, times(0)).store(isA(MultipartFile.class));
                    verify(diagnosticImageService, times(0)).save(COMPLIANT_IMAGE_FILE_NAME,1L);
                }
            }

            public class WhenServiceFails {

                public static final String STORAGE_EXCEPTION_TEXT = "TEST FAIL";

                @Test
                public void theStorageServiceFailsOnSaving() throws Exception {
                    doThrow(new StorageException(STORAGE_EXCEPTION_TEXT)).when(storageService).store(isA(MultipartFile.class));
                    mockMvc.perform(fileUpload(ADD_IMAGE_URL_TEMPLATE)
                            .file(correctFileName)
                            .param("customerId", "1"))
                            .andDo(print())
                            .andExpect(status().isOk())
                            .andExpect(jsonPath("$.['"+COMPLIANT_IMAGE_FILE_NAME +"']", is(STORAGE_EXCEPTION_TEXT)))
                    ;

                    verify(storageService, times(1)).store(isA(MultipartFile.class));
                }

                @Test
                public void theDiagnosticImageServiceFailsOnSaving() throws Exception {
                    doNothing().when(storageService).store(isA(MultipartFile.class));
                    when(diagnosticImageService.save(isA(String.class),isA(Long.class))).thenReturn(false);
                    mockMvc.perform(fileUpload(ADD_IMAGE_URL_TEMPLATE)
                            .file(correctFileName)
                            .param("customerId", "1"))
                            .andDo(print())
                            .andExpect(status().isOk())
                            .andExpect(jsonPath("$.['"+COMPLIANT_IMAGE_FILE_NAME +"']", is(DiagnosticImageController.SAVE_FAILED)))
                    ;

                    verify(storageService, times(1)).store(isA(MultipartFile.class));
                    verify(diagnosticImageService, times(1)).save(COMPLIANT_IMAGE_FILE_NAME,1L);
                }
            }

        }

        public class WhenDiagnosticImageIsValid {
            @Test
            public void shouldReturnResults() throws Exception {
                doNothing().when(storageService).store(isA(MultipartFile.class));
                when(diagnosticImageService.save(isA(String.class), isA(Long.class))).thenReturn(true);
                mockMvc.perform(fileUpload(ADD_IMAGE_URL_TEMPLATE)
                        .file(correctFileName)
                        .param("customerId", "1"))
                        .andDo(print())
                        .andExpect(status().isOk())
                .andExpect(jsonPath("$.['"+COMPLIANT_IMAGE_FILE_NAME+"']", is(DiagnosticImageController.SAVE_SUCCESSFUL)))

                ;
                verify(storageService, times(1)).store(isA(MultipartFile.class));
                verify(diagnosticImageService, times(1)).save(COMPLIANT_IMAGE_FILE_NAME,1L);

            }
        }

    }

}