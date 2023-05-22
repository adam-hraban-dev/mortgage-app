package cz.ahraban.mortgage.controller.error;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * Error response object to hold information returned by {@link RestExceptionHandler}
 *
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 * @since 0.1.0
 */
@Getter
@Setter
public class ErrorResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;
    private HttpStatus httpStatus;
    private String message;

    public ErrorResponse(){
        timeStamp = LocalDateTime.now();
    }

    public ErrorResponse(HttpStatus httpStatus, String message) {
        this();
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
