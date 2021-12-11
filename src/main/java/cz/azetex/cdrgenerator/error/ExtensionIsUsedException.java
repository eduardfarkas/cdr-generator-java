package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ExtensionIsUsedException extends RuntimeException {
    public ExtensionIsUsedException(String message) {
        super(message);
    }
}
