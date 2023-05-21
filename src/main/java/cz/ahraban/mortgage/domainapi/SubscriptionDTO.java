package cz.ahraban.mortgage.domainapi;

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
public class SubscriptionDTO {

    private Long id;
    private Long quotationId;
    private LocalDate startDate;
    private LocalDate validUntil;
}
