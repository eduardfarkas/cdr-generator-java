package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class GroupIsUsedException extends RuntimeException {
    public GroupIsUsedException(String message) {
        super(message);
    }
}
