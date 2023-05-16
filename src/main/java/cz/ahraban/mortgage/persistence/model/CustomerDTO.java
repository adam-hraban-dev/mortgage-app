package cz.ahraban.mortgage.persistence.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@openwise.cz">adam.hraban@seznam.cz</a>
 */

@AllArgsConstructor
@Getter
@ToString
public class CustomerDTO {

    private long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
}
