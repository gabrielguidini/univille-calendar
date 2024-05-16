package br.com.univillecalendar.controller;

import br.com.univillecalendar.controller.documentation.CourseControllerDocuementation;
import br.com.univillecalendar.dto.CourseDto;
import br.com.univillecalendar.exceptions.GenericException;
import br.com.univillecalendar.model.Course;
import br.com.univillecalendar.service.CourseService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/course")
@Slf4j
public class CourseController implements CourseControllerDocuementation {

    private final CourseService courseService;
    private final ObjectMapper objectMapper;

    public CourseController(CourseService courseService, ObjectMapper objectMapper) {
        this.courseService = courseService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/createNewCourse")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public CourseDto createNewCourse(@RequestBody CourseDto course) throws JsonProcessingException {
        log.info("CourseController.createNewCourse() -> init process, body {}", this.objectMapper.writeValueAsString(course));

        try {
            return this.courseService.createNewCourse(course);

        } catch (GenericException e) {
            log.error(e.getMessage());
            throw new GenericException(e.getMessage());
        }
    }
}
