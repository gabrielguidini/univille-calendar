package br.com.univillecalendar.service;

import br.com.univillecalendar.dto.CourseDto;
import br.com.univillecalendar.model.Course;
import br.com.univillecalendar.repository.CourseRepository;
import br.com.univillecalendar.utils.CourseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;
    private final ObjectMapper objectMapper;

    public CourseService(CourseRepository courseRepository, ObjectMapper objectMapper) {
        this.courseRepository = courseRepository;
        this.objectMapper = objectMapper;
    }

//    public CourseDto createNewCourse(CourseDto course) throws JsonProcessingException {
//        log.info("CourseService.createNewCourse() -> init process, body {}", this.objectMapper.writeValueAsString(course));
//
//        this.save(course);
//
//
//    }

    public CourseDto save(Course course) throws JsonProcessingException {
        log.info("CourseService.save() -> init process, body {}", this.objectMapper.writeValueAsString(course));

        this.courseRepository.save(course);

        log.info("CourseService.save() -> finish process, body {}", this.objectMapper.writeValueAsString(course));

        return CourseUtils.convertEntityToDto(course);
    }
}
