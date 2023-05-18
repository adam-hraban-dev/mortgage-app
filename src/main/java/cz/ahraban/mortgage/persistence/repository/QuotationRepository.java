package cz.ahraban.mortgage.persistence.repository;

import cz.ahraban.mortgage.persistence.model.entity.Quotation;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
public interface QuotationRepository extends JpaRepository<Quotation, Long> {
}
