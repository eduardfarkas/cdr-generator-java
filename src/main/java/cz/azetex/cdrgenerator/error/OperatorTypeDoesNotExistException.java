package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OperatorTypeDoesNotExistException extends RuntimeException {
    public OperatorTypeDoesNotExistException(String message) {
        super(message);
    }
}
