package cz.ahraban.mortgage.domainapi.mapper;

import cz.ahraban.mortgage.domainapi.domainobject.QuotationDO;
import cz.ahraban.mortgage.domainapi.QuotationDTO;
import org.mapstruct.Mapper;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Mapper
public interface QuotationControllerMapper {

    QuotationDO toQuotationDO(QuotationDTO quotationDTO);

    QuotationDTO toQuotationDTO(QuotationDO quotationDO);
}
