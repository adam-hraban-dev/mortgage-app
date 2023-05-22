package cz.ahraban.mortgage.service;

import cz.ahraban.mortgage.domainapi.domainobject.SubscriptionDO;
import cz.ahraban.mortgage.exception.ApplicationException;

/**
 * Handles operations on {@link cz.ahraban.mortgage.domainapi.entity.Subscription}
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
public interface SubscriptionService {

    SubscriptionDO getById(Long id) throws ApplicationException;

    SubscriptionDO create(SubscriptionDO subscriptionDO) throws ApplicationException;
}
