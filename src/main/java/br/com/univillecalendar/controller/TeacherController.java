package br.com.univillecalendar.controller;

import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.service.TeacherService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.constraints.Email;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    private final ObjectMapper objectMapper;

    public TeacherController(TeacherService teacherService, ObjectMapper objectMapper) {
        this.teacherService = teacherService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/createTeacher")
    public TeacherDto createNewTeacher(@RequestParam String firstName,
                                       @RequestParam String lastName,
                                       @RequestParam @Email String email) {

        return teacherService.createNewTeacher(firstName, lastName, email);

    }
}
