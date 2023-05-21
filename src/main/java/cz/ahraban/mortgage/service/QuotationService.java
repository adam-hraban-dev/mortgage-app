package cz.ahraban.mortgage.service;

import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.domainapi.domainobject.QuotationDO;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
public interface QuotationService {

    QuotationDO create(QuotationDO quotationDO) throws ApplicationException;
}
