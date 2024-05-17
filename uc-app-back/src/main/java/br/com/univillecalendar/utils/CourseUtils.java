package br.com.univillecalendar.utils;

import br.com.univillecalendar.dto.CourseDto;
import br.com.univillecalendar.model.Course;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CourseUtils {

    public CourseDto convertEntityToDto(Course course) {

        return CourseDto.builder()
                .courseName(course.getCourseName())
                .courseType(course.getCourseType())
                .build();
    }

    public Course convertDtoToEntity(CourseDto courseDto) {

        return Course.builder()
                .courseName(courseDto.getCourseName())
                .courseType(courseDto.getCourseType())
                .build();
    }
}
