package it.senape.wldiag.controller;

import it.senape.wldiag.config.UrlMappings;
import it.senape.wldiag.config.WebTestConfig;
import it.senape.wldiag.dto.ResourceDto;
import it.senape.wldiag.fixtures.JdbcResourceFixtures;
import it.senape.wldiag.message.JdbcResourcePoolMessage;
import it.senape.wldiag.service.jpa.JdbcResourcePoolService;
import it.senape.wldiag.service.jpa.JdbcResourceService;
import org.junit.jupiter.api.*;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;

import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by michele.arciprete on 29-Mar-18
 */
public class JdbcControllerTest {

    private MockMvc mockMvc;

    private JdbcResourceService jdbcResourceService;
    private JdbcResourcePoolService jdbcResourcePoolService;

    @BeforeEach
    public void setUp() throws Exception {
        jdbcResourceService = mock(JdbcResourceService.class);
        jdbcResourcePoolService = mock(JdbcResourcePoolService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new JdbcController(jdbcResourceService, jdbcResourcePoolService))
                .setCustomArgumentResolvers(WebTestConfig.pageRequestArgumentResolver())
                .build();
    }


    @Nested
    class Retrieve {

        @Nested
        class WhenOneJdbcResourceIsPresent {

            private ResourceDto jdbcResourceDto;
            private JdbcResourcePoolMessage jdbcResourcePoolMessage;

            @BeforeEach
            public void createJdbcResourcePoolMessage() {
                jdbcResourceDto = JdbcResourceFixtures.createJdbcResourceDto();
                jdbcResourcePoolMessage = JdbcResourceFixtures.createJdbcResourcePoolMessage();
            }

            @Test
            @Disabled
            public void shouldReturnAList() throws Exception {
                when(jdbcResourcePoolService.findAllWithCounters(isA(Pageable.class)))
                        .thenReturn(new PageImpl<>(
                                Arrays.asList(jdbcResourcePoolMessage)
                        ));
                mockMvc.perform(get(UrlMappings.API_JDBC + "/" + UrlMappings.LIST))
                        .andDo(print())
                        .andExpect(status().isOk())
                ;
            }

        }
    }
}