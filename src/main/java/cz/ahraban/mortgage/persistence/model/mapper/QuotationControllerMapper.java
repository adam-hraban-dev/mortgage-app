package cz.ahraban.mortgage.persistence.model.mapper;

import cz.ahraban.mortgage.persistence.model.DO.QuotationDO;
import cz.ahraban.mortgage.persistence.model.QuotationDTO;
import org.mapstruct.Mapper;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Mapper
public interface QuotationControllerMapper {

    QuotationDO toQuotationDO(QuotationDTO quotationDTO);

    QuotationDTO toQuotationDTO(QuotationDO quotationDO);
}
