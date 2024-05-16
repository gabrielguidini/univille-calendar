package br.com.univillecalendar.service;

import br.com.univillecalendar.dto.CourseDto;
import br.com.univillecalendar.exceptions.CourseNotFoundException;
import br.com.univillecalendar.model.Course;
import br.com.univillecalendar.repository.CourseRepository;
import br.com.univillecalendar.utils.CourseUtils;
import br.com.univillecalendar.utils.SubjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;
    private final SubjectService subjectService;
    private final ObjectMapper objectMapper;
    private final String NOT_FOUND_EXCEPTION = "Course Not Found";

    public CourseService(CourseRepository courseRepository, SubjectService subjectService, ObjectMapper objectMapper) {
        this.courseRepository = courseRepository;
        this.subjectService = subjectService;
        this.objectMapper = objectMapper;
    }

    public CourseDto createNewCourse(CourseDto courseDto) throws JsonProcessingException {
        log.info("CourseService.createNewCourse() -> init process, body {}", this.objectMapper.writeValueAsString(courseDto));

        CourseDto savedCourse = this.save(CourseUtils.convertDtoToEntity(courseDto));


        log.info("CourseService.createNewCourse() -> finish process, body {}", this.objectMapper.writeValueAsString(courseDto));

        return savedCourse;
    }

    public List<Course> getAllCourses(){
        log.info("CourseService.getAllCourse() -> init process");

        List<Course> courseList = courseRepository.findAll();

        if(courseList.isEmpty()){
            throw new CourseNotFoundException(NOT_FOUND_EXCEPTION);
        }

        log.info("CourseService.getAllCourse() -> finish process");

        return courseList;
    }

    public Course getCourseById(UUID courseId){
        log.info("CourseService.getCourseById() -> init process, courseId {}", courseId);

        Course course = courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(NOT_FOUND_EXCEPTION));

        log.info("CourseService.getCourseById() -> finish process, courseId {}", courseId);

        return course;
    }

    public void deleteCourse(UUID courseId){
        log.info("CourseService.deleteCourse() -> init process, courseId {}", courseId);

        this.courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(NOT_FOUND_EXCEPTION));

        this.courseRepository.deleteById(courseId);

        log.info("CourseService.deleteCourse() -> finish process, courseId {}", courseId);
    }

    public CourseDto updateCourse(UUID courseId, CourseDto courseDto) throws JsonProcessingException {
        log.info("CourseService.updateCourse() -> init process, courseId {}", courseId);

        Course course = this.courseRepository.findById(courseId).orElseThrow(() -> new CourseNotFoundException(NOT_FOUND_EXCEPTION));

        course.setCourseName(courseDto.getCourseName());
        course.setSubjects(courseDto.getSubjects().stream().map(SubjectUtils::convertDtoToEntity).collect(Collectors.toList()));
        course.setCourseType(courseDto.getCourseType());

        this.save(course);

        log.info("CourseService.updateCourse() -> finish process, courseId {}", courseId);

        return CourseUtils.convertEntityToDto(course);
    }

    public CourseDto save(Course course) throws JsonProcessingException {
        log.info("CourseService.save() -> init process, body {}", this.objectMapper.writeValueAsString(course));

        this.courseRepository.save(course);

        log.info("CourseService.save() -> finish process, body {}", this.objectMapper.writeValueAsString(course));

        return CourseUtils.convertEntityToDto(course);
    }
}
