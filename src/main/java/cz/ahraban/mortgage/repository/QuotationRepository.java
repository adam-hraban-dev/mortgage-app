package cz.ahraban.mortgage.repository;

import cz.ahraban.mortgage.domainapi.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA repository for {@link Quotation}
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
public interface QuotationRepository extends JpaRepository<Quotation, Long> {
}
