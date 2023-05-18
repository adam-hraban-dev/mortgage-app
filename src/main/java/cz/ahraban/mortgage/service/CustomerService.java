package cz.ahraban.mortgage.service;

import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.persistence.model.CustomerDO;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
public interface CustomerService {

    CustomerDO getById(Long id) throws ApplicationException;

    CustomerDO create(CustomerDO customerDO);

    CustomerDO update(Long id, CustomerDO customerDO) throws ApplicationException;
}
