package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExtensionDoesNotExistException extends RuntimeException {
    public ExtensionDoesNotExistException(String message) {
        super(message);
    }
}
