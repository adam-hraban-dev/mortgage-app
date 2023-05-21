package cz.ahraban.mortgage.service;

import static cz.ahraban.mortgage.util.ApplicationError.E03;
import static cz.ahraban.mortgage.util.ApplicationError.E05;
import static cz.ahraban.mortgage.util.ApplicationError.E06;

import java.util.Optional;

import cz.ahraban.mortgage.domainapi.domainobject.SubscriptionDO;
import cz.ahraban.mortgage.domainapi.entity.Quotation;
import cz.ahraban.mortgage.domainapi.entity.Subscription;
import cz.ahraban.mortgage.domainapi.mapper.SubscriptionMapper;
import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.repository.QuotationRepository;
import cz.ahraban.mortgage.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService{

    private final SubscriptionRepository subscriptionRepository;
    private final SubscriptionMapper mapper;
    private final QuotationRepository quotationRepository;

    @Override
    public SubscriptionDO getById(final Long id) throws ApplicationException {
        Optional<Subscription> subscriptionOpt = subscriptionRepository.findById(id);
        if (subscriptionOpt.isEmpty()) {
            log.warn(E03.getMessage() + id);
            throw new ApplicationException(E03.getMessage() + id, HttpStatus.BAD_REQUEST);
        } else {
            return mapper.toSubscriptionDO(subscriptionOpt.get());
        }
    }

    @Override
    public SubscriptionDO create(final SubscriptionDO subscriptionDO) throws ApplicationException {
        Assert.notNull(subscriptionDO.getQuotationId(), E06.getMessage());

        Optional<Quotation> quotationOpt = quotationRepository.findById(subscriptionDO.getQuotationId());
        if (quotationOpt.isEmpty()) {
            throw new ApplicationException(E05.getMessage() + subscriptionDO.getQuotationId(), HttpStatus.BAD_REQUEST);
        } else {
            Subscription subscription = mapper.toSubscription(subscriptionDO);
            subscription.setQuotation(quotationOpt.get());
            return mapper.toSubscriptionDO(subscriptionRepository.save(subscription));
        }
    }
}
