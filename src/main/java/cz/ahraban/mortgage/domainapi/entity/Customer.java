package cz.ahraban.mortgage.domainapi.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Customer entity
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
@Entity
@Getter
@Setter
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(mappedBy = "customer")
    private List<Quotation> quotation;

    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
}
