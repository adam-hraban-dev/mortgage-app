package cz.ahraban.mortgage.persistence.model.mapper;

import cz.ahraban.mortgage.persistence.model.CustomerDTO;
import cz.ahraban.mortgage.persistence.model.entity.Customer;
import org.mapstruct.Mapper;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Mapper
public interface CustomerControllerMapper {
    CustomerDTO toCustomerDto(Customer customer);
}
