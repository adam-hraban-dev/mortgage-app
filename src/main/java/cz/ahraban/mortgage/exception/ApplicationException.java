package cz.ahraban.mortgage.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */
@Getter
public class ApplicationException extends Exception{

    private final HttpStatus httpStatus;
    private final String message;

    public ApplicationException(final String message, final HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
