package cz.ahraban.mortgage.domainapi.domainobject;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

/**
 * Domain object representing customer
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
@Data
@Builder
public class CustomerDO {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
}
