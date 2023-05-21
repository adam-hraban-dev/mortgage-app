package cz.ahraban.mortgage.domainapi.domainobject;

import java.time.LocalDate;

import lombok.Data;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>

 */
@Data
public class SubscriptionDO {

    private Long id;
    private Long quotationId;
    private LocalDate startDate;
    private LocalDate validUntil;
}
