package cz.ahraban.mortgage.domainapi;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * Customer data transfer object
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@openwise.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */

@AllArgsConstructor
@Getter
@ToString
@Builder
public class CustomerDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
}
