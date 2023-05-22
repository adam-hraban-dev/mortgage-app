package cz.ahraban.mortgage.domainapi;

import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Quotation data transfer object
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
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
