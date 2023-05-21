package cz.ahraban.mortgage.service;

import static cz.ahraban.mortgage.util.ApplicationError.E01;
import static cz.ahraban.mortgage.util.ApplicationError.E02;

import java.util.Optional;

import cz.ahraban.mortgage.domainapi.domainobject.QuotationDO;
import cz.ahraban.mortgage.domainapi.entity.Customer;
import cz.ahraban.mortgage.domainapi.entity.Quotation;
import cz.ahraban.mortgage.domainapi.mapper.QuotationMapper;
import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.repository.CustomerRepository;
import cz.ahraban.mortgage.repository.QuotationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Service
@RequiredArgsConstructor
@Transactional
public class QuotationServiceImpl implements QuotationService{

    private final QuotationRepository quotationRepository;
    private final CustomerRepository customerRepository;
    private final QuotationMapper mapper;

    @Override
    public QuotationDO create(final QuotationDO quotationDO) throws ApplicationException {
        Assert.notNull(quotationDO.getCustomerId(), E02.getMessage());

        Optional<Customer> customerOpt = customerRepository.findById(quotationDO.getCustomerId());
        if (customerOpt.isEmpty()) {
            throw new ApplicationException(E01.getMessage() + quotationDO.getCustomerId(), HttpStatus.BAD_REQUEST);
        } else {
            Quotation quotation = mapper.toQuotation(quotationDO);
            quotation.setCustomer(customerOpt.get());
            return mapper.toQuotationDO(quotationRepository.save(quotation));
        }
    }
}
