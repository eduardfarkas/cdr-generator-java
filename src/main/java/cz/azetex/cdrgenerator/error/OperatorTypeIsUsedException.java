package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class OperatorTypeIsUsedException extends RuntimeException {
    public OperatorTypeIsUsedException(String message) {
        super(message);
    }
}
