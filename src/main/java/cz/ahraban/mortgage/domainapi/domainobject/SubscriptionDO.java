package cz.ahraban.mortgage.domainapi.domainobject;

import java.time.LocalDate;

import lombok.Data;

/**
 * Domain object representing subscription
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
@Data
public class SubscriptionDO {

    private Long id;
    private Long quotationId;
    private LocalDate startDate;
    private LocalDate validUntil;
}
