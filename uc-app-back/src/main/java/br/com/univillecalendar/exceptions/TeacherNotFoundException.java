package br.com.univillecalendar.exceptions;


import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeacherNotFoundException extends EntityNotFoundException {

    public TeacherNotFoundException(String message) {
        super(message);
    }
}
