package br.com.univillecalendar.controller;

import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.model.Teacher;
import br.com.univillecalendar.service.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/teacher")
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
    public List<Teacher> getAllTeachers(@PathVariable UUID teacherId) {

        return this.teacherService.getAllTeachers();
    }


}
