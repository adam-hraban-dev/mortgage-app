package cz.ahraban.mortgage.service;

import cz.ahraban.mortgage.persistence.model.CustomerDO;
import cz.ahraban.mortgage.persistence.model.CustomerDTO;
import cz.ahraban.mortgage.persistence.model.mapper.CustomerControllerMapper;
import cz.ahraban.mortgage.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl {

    private final CustomerRepository customerRepository;
    private final CustomerControllerMapper mapper;

    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return mapper.toCustomerDTO(customerRepository.save(mapper.toCustomer(customerDTO)));
    }
}
