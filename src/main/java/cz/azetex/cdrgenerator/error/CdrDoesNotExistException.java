package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CdrDoesNotExistException extends RuntimeException {
    public CdrDoesNotExistException(String message) {
        super(message);
    }
}
