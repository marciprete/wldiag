package it.senape.wldiag.controller;

import it.senape.wldiag.dto.CustomerDto;
import it.senape.wldiag.service.internal.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by michele.arciprete on 19-Dec-17.
 */
@Controller
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "api/customers")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ResponseBody
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<CustomerDto> list() {
        return customerService.findAll();
    }

}
