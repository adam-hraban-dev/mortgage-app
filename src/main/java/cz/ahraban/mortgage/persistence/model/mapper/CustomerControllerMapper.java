package cz.ahraban.mortgage.persistence.model.mapper;

import cz.ahraban.mortgage.persistence.model.DO.CustomerDO;
import cz.ahraban.mortgage.persistence.model.CustomerDTO;
import org.mapstruct.Mapper;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Mapper
public interface CustomerControllerMapper {

    CustomerDO toCustomerDO(CustomerDTO customerDTO);

    CustomerDTO toCustomerDTO(CustomerDO customerDO);
}
