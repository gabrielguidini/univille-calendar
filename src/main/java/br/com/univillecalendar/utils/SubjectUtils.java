package br.com.univillecalendar.utils;

import br.com.univillecalendar.dto.SubjectDto;
import br.com.univillecalendar.model.Subject;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class SubjectUtils {

    public SubjectDto convertEntityToDto(Subject subject){

        return SubjectDto.builder()
                .subjectName(subject.getSubjectName())
                .startingTime(subject.getStartingTime())
                .endingTime(subject.getEndingTime())
                .daysWeek(subject.getDaysWeek())
                .build();
    }

    public Subject convertDtoToEntity(SubjectDto subject){

        return Subject.builder()
                .subjectId(UUID.randomUUID())
                .subjectName(subject.getSubjectName())
                .startingTime(subject.getStartingTime())
                .endingTime(subject.getEndingTime())
                .daysWeek(subject.getDaysWeek())
                .build();
    }
}
