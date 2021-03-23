package am.itspace.listing_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ListiningNotFoundException extends RuntimeException{
    public ListiningNotFoundException() {
        super();
    }

    public ListiningNotFoundException(String message) {
        super(message);
    }
}
