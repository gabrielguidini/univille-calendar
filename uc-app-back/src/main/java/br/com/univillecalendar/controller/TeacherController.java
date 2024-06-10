package br.com.univillecalendar.controller;

import br.com.univillecalendar.controller.documentation.TeacherControllerDocumentation;
import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.exceptions.GenericException;
import br.com.univillecalendar.exceptions.TeacherNotFoundException;
import br.com.univillecalendar.model.Teacher;
import br.com.univillecalendar.service.TeacherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@RequestMapping("/teacher")
public class TeacherController implements TeacherControllerDocumentation {

    private final TeacherService teacherService;
    private final ObjectMapper objectMapper;

    public TeacherController(TeacherService teacherService, ObjectMapper objectMapper) {
        this.teacherService = teacherService;
        this.objectMapper = objectMapper;
    }

    @PostMapping()
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDto createNewTeacher(@RequestBody TeacherDto teacher) throws JsonProcessingException {
        log.info("TeacherController.createNewTeacher() -> init process, teacherId {}", this.objectMapper.writeValueAsString(teacher));

        try{
            return teacherService.createNewTeacher(teacher);
        } catch (GenericException e) {
            log.error("TeacherController.createNewTeacher() -> error while creating a new teacher, body {} error {}", this.objectMapper.writeValueAsString(teacher), e.getMessage());
            throw new GenericException(e.getMessage());
        }

    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getAllTeachers() throws JsonProcessingException{
        log.info("TeacherController.getAllTeachers() -> init process");

        try {
            return this.teacherService.getAllTeachers();
        } catch (TeacherNotFoundException e) {
            log.error("TeacherController.getAllTeachers() -> error while getting all teachers, error {}", e.getMessage());
            throw new TeacherNotFoundException(e.getMessage());
        }

    }

    @GetMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public Teacher getTeacherById(@PathVariable UUID teacherId) {

        log.info("TeacherController.getTeacherById() -> init process, teacherId {}", teacherId);
        try {
            return this.teacherService.getTeacherById(teacherId);
        } catch (TeacherNotFoundException e) {
            log.error("TeacherController.getTeacherById() -> error while getting teacher by id, teacherId {} , error {}", teacherId,e.getMessage());
            throw new TeacherNotFoundException(e.getMessage());
        }

    }

    @DeleteMapping("/{teacherId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeacher(@PathVariable UUID teacherId) throws JsonProcessingException {
        log.info("TeacherController.deleteTeacher() -> init process, teacherId {}", teacherId);

        try {
            this.teacherService.deleteTeacher(teacherId);
            log.info("TeacherController.deleteTeacher() -> finish process, teacherId {}", teacherId);
        } catch (TeacherNotFoundException e) {
            log.error("TeacherController.deleteTeacher() -> error while deleting teacher , teacherId {} , error {}", teacherId, e.getMessage());
            throw new TeacherNotFoundException(e.getMessage());
        }

    }

    @PutMapping("/{teacherId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public TeacherDto updateTeacher(@PathVariable UUID teacherId, @RequestBody TeacherDto teacherDto) throws JsonProcessingException {
        log.info("TeacherController.updateTeacher() -> init process, teacherId {}, updatedTeacher {}", teacherId, this.objectMapper.writeValueAsString(teacherDto));

        try {
            return teacherService.updateTeacher(teacherId, teacherDto);
        } catch (GenericException e) {
            log.error("TeacherController.updateTeacher() -> error while updating teacher , teacherDto {} , error {}", this.objectMapper.writeValueAsString(teacherDto), e.getMessage());
            throw new GenericException(e.getMessage());
        } catch (TeacherNotFoundException e) {
            log.error("TeacherController.updateTeacher() -> error while updating teacher , teacherDto {} , error {}", this.objectMapper.writeValueAsString(teacherDto), e.getMessage());
            throw new TeacherNotFoundException(e.getMessage());
        }
    }

}
