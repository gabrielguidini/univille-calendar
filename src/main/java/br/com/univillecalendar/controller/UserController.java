package br.com.univillecalendar.controller;

import br.com.univillecalendar.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/user")
@Slf4j
public class UserController {
    /*
    todo:
        -- create
        -- delete
        -- update
        --get
     */

    @GetMapping
    public List<Student> getAllStudents() {
        return null;
    }
}
