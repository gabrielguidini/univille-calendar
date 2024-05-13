package br.com.univillecalendar.controller;

import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.dto.TeacherFormUpdate;
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

@RestController("/teacher")
@Slf4j
public class TeacherController {

    private final TeacherService teacherService;
    private final ObjectMapper objectMapper;

    public TeacherController(TeacherService teacherService, ObjectMapper objectMapper) {
        this.teacherService = teacherService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/createTeacher")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public TeacherDto createNewTeacher(@RequestBody TeacherDto teacher) {

        return teacherService.createNewTeacher(teacher);

    }

    @GetMapping("/allTeachers")
    @ResponseStatus(HttpStatus.OK)
    public List<Teacher> getAllTeachers() {

        return this.teacherService.getAllTeachers();
    }

    @GetMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public Teacher getTeacherById(@PathVariable UUID teacherId) {

        return this.teacherService.getTeacherById(teacherId);
    }

    @DeleteMapping("/{teacherId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void deleteTeacher(@PathVariable UUID teacherId) throws JsonProcessingException {
        log.info("TeacherController.deleteTeacher() -> init process, teacherId {}", teacherId);

        this.teacherService.deleteTeacher(teacherId);

        log.info("TeacherController.deleteTeacher() -> finish process, teacherId {}", teacherId);
    }

    @PutMapping("/updateTeacher/{teacherId}")
    @Transactional
    @ResponseStatus(HttpStatus.ACCEPTED)
    public TeacherDto updateTeacher(@PathVariable UUID teacherId, @RequestBody TeacherFormUpdate teacherFormUpdate) throws JsonProcessingException {
        log.info("TeacherController.updateTeacher() -> init process, teacherId {}, updatedTeacher {}", teacherId, this.objectMapper.writeValueAsString(teacherFormUpdate));

        return teacherService.updateTeacher(teacherId, teacherFormUpdate);

    }

}
