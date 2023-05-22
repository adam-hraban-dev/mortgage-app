package cz.ahraban.mortgage.domainapi.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Subscription entity
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
@Entity
@Getter
@Setter
@ToString
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(mappedBy = "subscription")
    private Quotation quotation;

    private LocalDate startDate;
    private LocalDate validUntil;
}
