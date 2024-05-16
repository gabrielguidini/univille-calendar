package br.com.univillecalendar.utils;

import br.com.univillecalendar.dto.StudentDto;
import br.com.univillecalendar.model.Student;
import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class StudentUtils {

    public StudentDto convertEntityToDto(Student student){

        return StudentDto.builder()
                .studentFirstName(student.getStudentFirstName())
                .studentLastName(student.getStudentLastName())
                .studentEmail(student.getStudentEmail())
                .studentPhone(student.getStudentPhone())
                .build();
    }

    public Student convertDtoToEntity(StudentDto student){

        return Student.builder()
                .studentId(UUID.randomUUID())
                .studentFirstName(student.getStudentFirstName())
                .studentLastName(student.getStudentLastName())
                .studentEmail(student.getStudentEmail())
                .studentPhone(student.getStudentPhone())
                .build();
    }
}
