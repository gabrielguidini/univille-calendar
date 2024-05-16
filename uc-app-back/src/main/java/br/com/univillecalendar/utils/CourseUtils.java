package br.com.univillecalendar.utils;

import br.com.univillecalendar.dto.CourseDto;
import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.model.Course;
import br.com.univillecalendar.model.Teacher;
import lombok.experimental.UtilityClass;

import java.util.UUID;
import java.util.stream.Collectors;

@UtilityClass
public class CourseUtils {

    public CourseDto convertEntityToDto(Course course) {

        return CourseDto.builder()
                .courseName(course.getCourseName())
                .courseType(course.getCourseType())
                .subjects(course.getSubjects().stream().map(SubjectUtils::convertEntityToDto).collect(Collectors.toList()))
                .build();
    }

    public Course convertDtoToEntity(CourseDto courseDto) {

        return Course.builder()
                .courseName(courseDto.getCourseName())
                .courseType(courseDto.getCourseType())
                .subjects(courseDto.getSubjects().stream().map(SubjectUtils::convertDtoToEntity).collect(Collectors.toList()))
                .build();
    }
}
