package cz.ahraban.mortgage.service;

import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.domainapi.domainobject.CustomerDO;

/**
 * Handles operations on {@link cz.ahraban.mortgage.domainapi.entity.Customer}
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
public interface CustomerService {

    CustomerDO getById(Long id) throws ApplicationException;

    CustomerDO create(CustomerDO customerDO);

    CustomerDO update(Long id, CustomerDO customerDO) throws ApplicationException;
}
