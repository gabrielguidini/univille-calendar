package br.com.univillecalendar.utils;

import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.model.Teacher;
import lombok.experimental.UtilityClass;

@UtilityClass
public class TeacherUtils {

    public TeacherDto convertEntityToDto(Teacher teacher) {

        return TeacherDto.builder()
                .teacherId(teacher.getTeacherId())
                .teacherFirstName(teacher.getTeacherFirstName())
                .teacherLastName(teacher.getTeacherLastName())
                .teacherEmail(teacher.getTeacherEmail())
                .build();
    }
}
