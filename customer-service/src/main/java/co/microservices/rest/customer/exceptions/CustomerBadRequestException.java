package co.microservices.rest.customer.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CustomerBadRequestException extends BaseException{
    public CustomerBadRequestException(String message) {
        super(message);
    }
}
