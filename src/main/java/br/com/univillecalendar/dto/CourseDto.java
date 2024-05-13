package br.com.univillecalendar.dto;

import br.com.univillecalendar.model.enums.CourseEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link br.com.univillecalendar.model.Course}
 */
@Getter
@Setter
public class CourseDto implements Serializable {
    private UUID courseId = UUID.randomUUID();
    private String courseName;
    private CourseEnum courseType;
    private List<SubjectDto> subjects;
}