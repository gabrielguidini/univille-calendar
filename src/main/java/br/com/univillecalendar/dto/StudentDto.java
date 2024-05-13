package br.com.univillecalendar.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link br.com.univillecalendar.model.Student}
 */
@Getter
@Setter
public class StudentDto implements Serializable {
    private UUID studentId = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private CourseDto course;
}