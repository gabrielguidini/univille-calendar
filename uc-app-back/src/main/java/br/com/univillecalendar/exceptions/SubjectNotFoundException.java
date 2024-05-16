package br.com.univillecalendar.exceptions;

import jakarta.persistence.EntityNotFoundException;

public class SubjectNotFoundException extends EntityNotFoundException {

    public SubjectNotFoundException(String message){
        super (message);
    }
}
