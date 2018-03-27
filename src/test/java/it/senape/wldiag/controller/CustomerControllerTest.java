package it.senape.wldiag.controller;

import it.senape.wldiag.fixtures.CustomerDTOFixtures;
import it.senape.wldiag.service.internal.CustomerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Test
    public void thatListShouldReturnValuesFromService() throws Exception {
        when(customerService.findAll())
                .thenReturn(Arrays.asList(CustomerDTOFixtures.createCustomer()));

        this.mockMvc.perform(
                get("/api/customers/list"))
                .andDo(print())
                .andExpect(status().isOk())
//                .andExpect()
        ;
    }
}