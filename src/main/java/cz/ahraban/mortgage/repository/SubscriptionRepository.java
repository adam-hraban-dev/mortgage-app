package cz.ahraban.mortgage.repository;

import cz.ahraban.mortgage.domainapi.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
