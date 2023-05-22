package cz.ahraban.mortgage.service;

import cz.ahraban.mortgage.exception.ApplicationException;
import cz.ahraban.mortgage.domainapi.domainobject.QuotationDO;

/**
 * Handles operations on {@link cz.ahraban.mortgage.domainapi.entity.Quotation}
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
public interface QuotationService {

    QuotationDO create(QuotationDO quotationDO) throws ApplicationException;
}
