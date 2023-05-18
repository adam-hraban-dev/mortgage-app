package cz.ahraban.mortgage.persistence.model;

import java.time.LocalDate;

import lombok.Data;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Data
public class CustomerDO {

    private Long id;
    private String firstName;
    private String lastName;
    private String middleName;
    private String email;
    private String phoneNumber;
    private LocalDate birthDate;
}
