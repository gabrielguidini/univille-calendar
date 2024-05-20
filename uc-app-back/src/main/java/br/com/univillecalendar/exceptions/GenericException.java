package br.com.univillecalendar.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class GenericException extends RuntimeException {

    public GenericException(String message) {
        super(message);
    }
}
