package cz.ahraban.mortgage.domainapi.mapper;

import cz.ahraban.mortgage.domainapi.SubscriptionDTO;
import cz.ahraban.mortgage.domainapi.domainobject.SubscriptionDO;
import org.mapstruct.Mapper;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Mapper
public interface SubscriptionControllerMapper {

    SubscriptionDTO toSubscriptionDTO(SubscriptionDO subscriptionDO);

    SubscriptionDO toSubscriptionDO(SubscriptionDTO subscriptionDTO);
}
