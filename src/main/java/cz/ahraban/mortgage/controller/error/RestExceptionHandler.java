package cz.ahraban.mortgage.controller.error;

import cz.ahraban.mortgage.controller.CustomerController;
import cz.ahraban.mortgage.controller.QuotationController;
import cz.ahraban.mortgage.exception.ApplicationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author Adam Hrabaň <a hrej="mailto:adam.hraban@seznam.cz">adam.hraban@seznam.cz</a>
 */

@ControllerAdvice(assignableTypes = {CustomerController.class, QuotationController.class})
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<Object> handleApplicationException(ApplicationException ex){
        return buildResponseEntity(new ErrorResponse(ex.getHttpStatus(), ex.getMessage()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex){
        return buildResponseEntity(new ErrorResponse(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

    private ResponseEntity<Object> buildResponseEntity (ErrorResponse errorResponse) {
        return new ResponseEntity<>(errorResponse, errorResponse.getHttpStatus());
    }
}
