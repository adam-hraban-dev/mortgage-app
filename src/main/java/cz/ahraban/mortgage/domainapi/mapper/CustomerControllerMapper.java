package cz.ahraban.mortgage.domainapi.mapper;

import cz.ahraban.mortgage.domainapi.domainobject.CustomerDO;
import cz.ahraban.mortgage.domainapi.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Mapper
public interface CustomerControllerMapper {

    CustomerDO toCustomerDO(CustomerDTO customerDTO);

    CustomerDTO toCustomerDTO(CustomerDO customerDO);
}
