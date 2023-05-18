package cz.ahraban.mortgage.service;

import java.util.Optional;

import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.persistence.model.DO.QuotationDO;
import cz.ahraban.mortgage.persistence.model.entity.Customer;
import cz.ahraban.mortgage.persistence.model.entity.Quotation;
import cz.ahraban.mortgage.persistence.model.mapper.QuotationMapper;
import cz.ahraban.mortgage.persistence.repository.CustomerRepository;
import cz.ahraban.mortgage.persistence.repository.QuotationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Service
@RequiredArgsConstructor
public class QuotationServiceImpl implements QuotationService{

    private final QuotationRepository quotationRepository;
    private final CustomerRepository customerRepository;
    private final QuotationMapper mapper;

    @Override
    public QuotationDO create(final QuotationDO quotationDO) throws ApplicationException {
        Assert.notNull(quotationDO.getCustomerId(), "No customer ID specified");

        Optional<Customer> customerOpt = customerRepository.findById(quotationDO.getCustomerId());
        if (customerOpt.isEmpty()) {
            throw new ApplicationException("No customer found for ID: " + quotationDO.getCustomerId(), HttpStatus.BAD_REQUEST);
        } else {
            Quotation quotation = mapper.toQuotation(quotationDO);
            quotation.setCustomer(customerOpt.get());
            return mapper.toQuotationDO(quotationRepository.save(quotation));
        }
    }
}
