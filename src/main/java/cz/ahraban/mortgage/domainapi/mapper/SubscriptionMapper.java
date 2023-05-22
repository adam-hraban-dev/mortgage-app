package cz.ahraban.mortgage.domainapi.mapper;

import cz.ahraban.mortgage.domainapi.domainobject.SubscriptionDO;
import cz.ahraban.mortgage.domainapi.entity.Subscription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Mapper
public interface SubscriptionMapper {

    @Mapping(target = "quotationId", source = "quotation.id")
    SubscriptionDO toSubscriptionDO(Subscription subscription);

    @Mapping(target = "quotation", ignore = true)
    Subscription toSubscription(SubscriptionDO subscriptionDO);
}
