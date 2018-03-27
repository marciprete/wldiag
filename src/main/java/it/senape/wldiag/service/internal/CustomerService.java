package it.senape.wldiag.service.internal;

import it.senape.wldiag.dto.CustomerDto;
import it.senape.wldiag.jpa.bridge.CustomerMapper;
import it.senape.wldiag.jpa.model.internal.Customer;
import it.senape.wldiag.jpa.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Service
@Transactional
public class CustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional(readOnly = true)
    public Page<CustomerDto> findAll(Pageable pageRequest) {
//        if(pageRequest.getSort() == null) {
//            pageRequest = new PageRequest(pageRequest.getOffset(),
//                    pageRequest.getPageSize(),
//                    Sort.Direction.DESC,
//                    "acquisitionTime");
//        }
        Page<Customer> customers = customerRepository.findAll(pageRequest);
        return CustomerMapper.mapEntityPageIntoDTOPage(pageRequest, customers);
    }

    @Transactional(readOnly = true)
    public List<CustomerDto> findAll() {
        Iterable<Customer> customers = customerRepository.findAll();
        return CustomerMapper.mapEntitiesIntoDTOs(customers);
    }

    @Transactional(readOnly = true)
    public CustomerDto findOne(Long id) {
        Customer customer = customerRepository.findOne(id);
        return CustomerMapper.mapEntityIntoDTO(customer);
    }
}
