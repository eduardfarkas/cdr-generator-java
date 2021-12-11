package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExtensionAlreadyExistsException extends RuntimeException {
    public ExtensionAlreadyExistsException(String message) {
        super(message);
    }
}
