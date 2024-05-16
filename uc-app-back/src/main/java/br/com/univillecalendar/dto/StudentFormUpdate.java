package br.com.univillecalendar.dto;

import br.com.univillecalendar.model.Course;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentFormUpdate {
    private String studentFirstName;
    private String studentLastName;
    private String studentEmail;
    private String studentPhone;
    private Course course;
}
