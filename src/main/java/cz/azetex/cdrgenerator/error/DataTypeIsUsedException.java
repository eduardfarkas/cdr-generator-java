package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DataTypeIsUsedException extends RuntimeException {
    public DataTypeIsUsedException(String message) {
        super(message);
    }
}
