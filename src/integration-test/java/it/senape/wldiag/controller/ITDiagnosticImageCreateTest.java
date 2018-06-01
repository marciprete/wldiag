package it.senape.wldiag.controller;

import com.google.common.net.MediaType;
import it.senape.wldiag.config.UrlMappings;
import it.senape.wldiag.fixtures.DiagnosticImageDtoFixtures;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.io.FileInputStream;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by michele.arciprete on 30-Mar-18
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ITDiagnosticImageCreateTest {

    private static final String FILE_PATH = "src/integration-test/resources/";
    private static final String FILENAME = "diagnostic_image_ManagedServer_1_2018_01_22_18_23_13.zip";
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void create_shouldSaveDiagnosticImage() throws Exception {

        MockMultipartFile correctFileName = new MockMultipartFile("diagnosticImage",
                FILENAME,
                MediaType.ZIP.toString(),
                new FileInputStream(FILE_PATH + FILENAME));

        assertNotNull(mockMvc);

        mockMvc.perform(multipart(UrlMappings.API_DIAGNOSTIC_IMAGE + "/" + UrlMappings.ADD)
                .file(correctFileName)
                .param("customerId", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.['" + FILENAME + "']", is("Save successful")));
    }

    @Test
    public void delete_shouldRemoveEverything() throws Exception {
        mockMvc.perform(delete(UrlMappings.API_DIAGNOSTIC_IMAGE + "/"
                + FILENAME + "/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

//    @Test
//    public void tmp() throws Exception {
//        mockMvc.perform(get(UrlMappings.API_JTA + "/del"))
//                .andDo(print())
//                .andExpect(status().isOk());
//    }
}