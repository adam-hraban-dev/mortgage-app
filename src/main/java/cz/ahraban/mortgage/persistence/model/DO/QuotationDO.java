package cz.ahraban.mortgage.persistence.model.DO;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.Data;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Data
public class QuotationDO {

    private Long id;
    private Long customerId;
    private LocalDate beginningOfInsurance;
    private LocalDate dateOfSigningMortgage;
    private BigDecimal insuredAmount;
}
