package cz.ahraban.mortgage.service;

import java.util.Optional;

import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.persistence.model.CustomerDO;
import cz.ahraban.mortgage.persistence.model.entity.Customer;
import cz.ahraban.mortgage.persistence.model.mapper.CustomerMapper;
import cz.ahraban.mortgage.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    @Override
    public CustomerDO getById(final Long id) throws ApplicationException {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isEmpty()) {
            log.warn("No customer found for id " + id);
            throw new ApplicationException("No customer found for id " + id, HttpStatus.BAD_REQUEST);
        } else {
            return mapper.toCustomerDO(customerOpt.get());
        }
    }

    @Override
    public CustomerDO create(CustomerDO customerDO) {
        return mapper.toCustomerDO(customerRepository.save(mapper.toCustomer(customerDO)));
    }

    @Override
    public CustomerDO update(Long id, CustomerDO fromCustomerDO) throws ApplicationException {
        // find customer
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isEmpty()) {
            log.warn("No customer found for id " + id);
            throw new ApplicationException("No customer found for id " + id, HttpStatus.BAD_REQUEST);
        } else {
            // update customer
            CustomerDO updatedDO = mapper.toCustomerDO(fromCustomerDO);
            updatedDO.setId(id);
            customerRepository.save(mapper.toCustomer(updatedDO));
            log.info("Customer updated: " + updatedDO);
            return updatedDO;
        }
    }
}
