package br.com.univillecalendar.exceptions;


import jakarta.persistence.EntityNotFoundException;

public class TeacherNotFoundException extends EntityNotFoundException {

    public TeacherNotFoundException(String message) {
        super(message);
    }
}
