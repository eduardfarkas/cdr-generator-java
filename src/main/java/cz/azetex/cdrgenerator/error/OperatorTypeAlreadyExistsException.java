package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.CONFLICT)
public class OperatorTypeAlreadyExistsException extends RuntimeException {
    public OperatorTypeAlreadyExistsException(String message) {
        super(message);
    }
}
