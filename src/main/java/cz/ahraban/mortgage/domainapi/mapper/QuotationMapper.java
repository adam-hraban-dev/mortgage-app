package cz.ahraban.mortgage.domainapi.mapper;

import cz.ahraban.mortgage.domainapi.domainobject.QuotationDO;
import cz.ahraban.mortgage.domainapi.entity.Quotation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Mapper
public interface QuotationMapper {

    @Mapping(target = "customerId", source = "customer.id")
    QuotationDO toQuotationDO(Quotation quotation);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "subscription", ignore = true)
    Quotation toQuotation(QuotationDO quotationDO);
}
