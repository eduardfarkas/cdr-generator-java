package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class CdrAlreadyExistsException extends RuntimeException {
    public CdrAlreadyExistsException(String message) {
        super(message);
    }
}
