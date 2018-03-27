package it.senape.wldiag.fixtures;

import it.senape.wldiag.jpa.model.internal.Customer;

public class CustomerFixtures {

    public static Customer createCustomer() {
        Customer c = new Customer();
        c.setId(1L);
        c.setCode("TST");
        c.setName("Test Customer");
        return c;
    }
}
