package cz.ahraban.mortgage.domainapi.domainobject;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

/**
 * Domain object representing quotation
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
@Data
public class QuotationDO {

    private Long id;
    private Long customerId;
    private LocalDate beginningOfInsurance;
    private LocalDate dateOfSigningMortgage;
    private BigDecimal insuredAmount;
}
