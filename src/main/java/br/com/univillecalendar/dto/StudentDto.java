package br.com.univillecalendar.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

/**
 * DTO for {@link br.com.univillecalendar.model.Student}
 */
@Getter
@Setter
@Builder
public class StudentDto implements Serializable {
    private UUID studentId = UUID.randomUUID();
    private String studentFirstName;
    private String studentLastName;
    private String studentEmail;
    private String studentPhone;
    private CourseDto course;
}