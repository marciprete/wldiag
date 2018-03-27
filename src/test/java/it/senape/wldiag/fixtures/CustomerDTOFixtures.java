package it.senape.wldiag.fixtures;

import it.senape.wldiag.dto.CustomerDto;

public class CustomerDTOFixtures {

    public static CustomerDto createCustomer() {
        CustomerDto c = new CustomerDto();
        c.setId(1L);
        c.setCode("TST");
        c.setName("Test Customer");
        return c;
    }

}
