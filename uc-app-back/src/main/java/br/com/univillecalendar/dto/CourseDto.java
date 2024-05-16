package br.com.univillecalendar.dto;

import br.com.univillecalendar.model.enums.CourseEnum;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link br.com.univillecalendar.model.Course}
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto implements Serializable {
    private String courseName;
    private CourseEnum courseType;
    private List<SubjectDto> subjects;
}