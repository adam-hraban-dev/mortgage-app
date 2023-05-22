package cz.ahraban.mortgage.service;

import static cz.ahraban.mortgage.util.ApplicationError.E01;

import java.util.Optional;

import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.domainapi.domainobject.CustomerDO;
import cz.ahraban.mortgage.domainapi.entity.Customer;
import cz.ahraban.mortgage.domainapi.mapper.CustomerMapper;
import cz.ahraban.mortgage.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link CustomerService}
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;
    private final CustomerMapper mapper;

    /**
     * Returns customer domain object for provided id
     *
     * @param id customer id
     * @return {@link CustomerDO} for provided id
     * @throws ApplicationException if no customer is found for provided id
     */
    @Override
    public CustomerDO getById(final Long id) throws ApplicationException {
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isEmpty()) {
            log.warn(E01.getMessage() + id);
            throw new ApplicationException(E01.getMessage() + id, HttpStatus.BAD_REQUEST);
        } else {
            return mapper.toCustomerDO(customerOpt.get());
        }
    }

    @Override
    public CustomerDO create(CustomerDO customerDO) {
        return mapper.toCustomerDO(customerRepository.save(mapper.toCustomer(customerDO)));
    }

    /**
     * Updates existing customer
     *
     * @param id for customer that should be updated
     * @param fromCustomerDO change source for customer being updated
     * @return updated {@link CustomerDO}
     * @throws ApplicationException if no customer is found for provided id
     */
    @Override
    public CustomerDO update(Long id, CustomerDO fromCustomerDO) throws ApplicationException {
        // find customer
        Optional<Customer> customerOpt = customerRepository.findById(id);
        if (customerOpt.isEmpty()) {
            log.warn(E01.getMessage() + id);
            throw new ApplicationException(E01.getMessage() + id, HttpStatus.BAD_REQUEST);
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
