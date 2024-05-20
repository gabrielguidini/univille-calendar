package br.com.univillecalendar.utils;

import br.com.univillecalendar.dto.SubjectDto;
import br.com.univillecalendar.model.Subject;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SubjectUtils {

    public SubjectDto convertEntityToDto(Subject subject) {

        return SubjectDto.builder()
                .subjectName(subject.getSubjectName())
                .schedules(subject.getSchedules().stream().map(ScheduleUtils::convertDtoToEntity).toList())
                .teacher(subject.getTeacher() != null ? TeacherUtils.convertEntityToDto(subject.getTeacher()) : null)
                .build();

    }

    public Subject convertDtoToEntity(SubjectDto subjectDto) {

        return Subject.builder()
                .subjectName(subjectDto.getSubjectName())
                .schedules(subjectDto.getSchedules().stream().map(ScheduleUtils::convertDtoToEntity).toList())
                .teacher(subjectDto.getTeacher() != null ? TeacherUtils.convertDtoToEntity(subjectDto.getTeacher()) : null)
                .build();

    }
}
