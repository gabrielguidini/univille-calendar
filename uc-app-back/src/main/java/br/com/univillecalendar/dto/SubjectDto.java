package br.com.univillecalendar.dto;

import br.com.univillecalendar.model.Schedule;
import br.com.univillecalendar.model.enums.DayWeekEnum;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

/**
 * DTO for {@link br.com.univillecalendar.model.Subject}
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDto implements Serializable {
    private String subjectName;
    private List<ScheduleDto> schedules;
    private TeacherDto teacher;
    private CourseDto course;
}