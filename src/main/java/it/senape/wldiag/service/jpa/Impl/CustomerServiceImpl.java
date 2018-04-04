package it.senape.wldiag.service.jpa.Impl;

import it.senape.wldiag.dto.CustomerDto;
import it.senape.wldiag.jpa.bridge.CustomerMapper;
import it.senape.wldiag.jpa.model.internal.Customer;
import it.senape.wldiag.jpa.repository.CustomerRepository;
import it.senape.wldiag.service.jpa.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Created by michele.arciprete on 15-Dec-17.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
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

    @Override
    @Transactional(readOnly = true)
    public List<CustomerDto> findAll() {
        Iterable<Customer> customers = customerRepository.findAll();
        return CustomerMapper.mapEntitiesIntoDTOs(customers);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerDto> findById(Long id) {
        CustomerDto dto = new CustomerDto();
        Optional<Customer> customer = customerRepository.findById(id);
        if(customer.isPresent()) {
            dto = CustomerMapper.mapEntityIntoDTO(customer.get());
        }
        Optional<CustomerDto> customerDto = Optional.of(dto);
        return customerDto;
    }
}
