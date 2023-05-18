package cz.ahraban.mortgage.persistence.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@AllArgsConstructor
@Getter
@ToString
public class QuotationDTO {

    private Long id;
    private Long customerId;
    private LocalDate beginningOfInsurance;
    private LocalDate dateOfSigningMortgage;
    private BigDecimal insuredAmount;
}
