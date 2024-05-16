package br.com.univillecalendar.controller;

import br.com.univillecalendar.controller.documentation.CourseControllerDocuementation;
import br.com.univillecalendar.dto.CourseDto;
import br.com.univillecalendar.exceptions.CourseNotFoundException;
import br.com.univillecalendar.exceptions.GenericException;
import br.com.univillecalendar.model.Course;
import br.com.univillecalendar.service.CourseService;
import br.com.univillecalendar.utils.CourseUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/getCourses")
    @ResponseStatus(HttpStatus.OK)
    public List<CourseDto> getAllCourses() {
        log.info("CourseController.getAllCourses() -> init process");

        return courseService.getAllCourses().stream().map(CourseUtils::convertEntityToDto).toList();

    }

    @GetMapping("/getCourses/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    public Course getCourseById(@PathVariable UUID courseId) {
        log.info("CourseController.getCourseById() -> init process, courseId {}", courseId);

        try {
            return courseService.getCourseById(courseId);
        }catch (CourseNotFoundException e) {
            log.error("CourseController.getCourseById() -> error while trying to find course, courseId {}, error {}",courseId,e.getMessage());
            throw new CourseNotFoundException(e.getMessage());
        }

    }

    @DeleteMapping("/deleteCouse/{courseId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteCourse(@PathVariable UUID courseId) {
        log.info("CourseController.deleteCourse() -> init process, courseId {}", courseId);

        try {
            courseService.deleteCourse(courseId);
            log.info("CourseController.deleteCourse() -> finish process, courseId {}", courseId);
        }catch (CourseNotFoundException e) {
            log.error("CourseController.deleteCourse() -> error while trying to delete course, courseId {}, error {}",courseId,e.getMessage());
            throw new CourseNotFoundException(e.getMessage());
        }
    }

    @PutMapping("/updateCourse/{courseId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCourse(@PathVariable UUID courseId, @RequestBody CourseDto course) throws JsonProcessingException {
        log.info("CourseController.updateCourse() -> init process, courseId {}", courseId);

        try {
            courseService.deleteCourse(courseId);
        }catch (CourseNotFoundException e) {
            log.error("CourseController.update() -> error while trying to update course, courseId {}, error {}",courseId,e.getMessage());
            throw new CourseNotFoundException(e.getMessage());
        }
    }
}
