package br.com.univillecalendar.dto;

import br.com.univillecalendar.model.enums.DayWeekEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubjectFormUpdate {

        private String subjectName;
        private String startingTime;
        private String endingTime;
        private List<DayWeekEnum> daysWeek;
        private TeacherDto teachers;
}
