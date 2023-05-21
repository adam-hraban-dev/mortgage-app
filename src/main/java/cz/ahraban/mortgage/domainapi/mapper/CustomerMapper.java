package cz.ahraban.mortgage.domainapi.mapper;

import cz.ahraban.mortgage.domainapi.domainobject.CustomerDO;
import cz.ahraban.mortgage.domainapi.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Mapper
public interface CustomerMapper {
    CustomerDO toCustomerDO(Customer customer);

    @Mapping(target = "quotation", ignore = true)
    Customer toCustomer(CustomerDO customerDO);

    @Mapping(target = "id", ignore = true)
    CustomerDO toCustomerDO(CustomerDO customerDO);
}
