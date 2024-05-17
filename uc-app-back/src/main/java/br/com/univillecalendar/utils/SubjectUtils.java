package br.com.univillecalendar.utils;

import br.com.univillecalendar.dto.SubjectDto;
import br.com.univillecalendar.model.Subject;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SubjectUtils {

    public SubjectDto convertEntityToDto(Subject subject) {

        return SubjectDto.builder()
                .subjectName(subject.getSubjectName())
                .startingTime(subject.getStartingTime())
                .endingTime(subject.getEndingTime())
                .daysWeek(subject.getDaysWeek())
                .teachers(TeacherUtils.convertEntityToDto(subject.getTeachers()) == null ? null : TeacherUtils.convertEntityToDto(subject.getTeachers()))
                .build();

    }

    public Subject convertDtoToEntity(SubjectDto subjectDto) {

        return Subject.builder()
                .subjectName(subjectDto.getSubjectName())
                .startingTime(subjectDto.getStartingTime())
                .endingTime(subjectDto.getEndingTime())
                .daysWeek(subjectDto.getDaysWeek())
                .teachers(TeacherUtils.convertDtoToEntity(subjectDto.getTeachers()) == null ? null : TeacherUtils.convertDtoToEntity(subjectDto.getTeachers()))
                .build();

    }
}
