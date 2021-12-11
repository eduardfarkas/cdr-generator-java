package cz.azetex.cdrgenerator.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class DataTypeAlreadyExistsException extends RuntimeException {
    public DataTypeAlreadyExistsException(String message) {
        super(message);
    }
}
