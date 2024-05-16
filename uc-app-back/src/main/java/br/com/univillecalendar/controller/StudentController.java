package br.com.univillecalendar.controller;

import br.com.univillecalendar.dto.StudentDto;
import br.com.univillecalendar.dto.StudentFormUpdate;
import br.com.univillecalendar.model.Student;
import br.com.univillecalendar.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/user")
@Slf4j
    /*
    todo:
        -- create -> no testing done
        -- delete -> no testing done
        -- update -> no testing done
        -- get -> no testing done
     */
public class StudentController {

    private final StudentService studentService;
    private final ObjectMapper objectMapper;

    public StudentController(StudentService studentService, ObjectMapper objectMapper) {
        this.studentService = studentService;
        this.objectMapper = objectMapper;
    }

    @PostMapping("/createStudent")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public StudentDto createNewStudent(@RequestBody StudentDto student){

        return studentService.createNewStudent(student);

    }

    @GetMapping("/allStudents")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudents(){

        return this.studentService.getAllStudents();

    }

    @GetMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public Student getStudentById(@PathVariable UUID studentId){

        return this.studentService.getStudentById(studentId);

    }

    @DeleteMapping("/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    @Transactional
    public void deleteStudent(@PathVariable UUID studentId) throws JsonProcessingException{
        log.info("StudentController.deleteStudent() -> init process, studentId {}", studentId);

        this.studentService.deleteStudent(studentId);

        log.info("StudentController.deleteStudent() -> finish process, studentId {}", studentId);
    }

    @PutMapping("/updateStudent, /{studentId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public StudentDto updateStudent(@PathVariable UUID studentId, @RequestBody StudentFormUpdate studentFormUpdate) throws JsonProcessingException{
        log.info("StudentController.updateStudent() -> init process, studentId{}, updatedStudent{}", studentId, this.objectMapper.writeValueAsString(studentFormUpdate));

        return studentService.updateStudent(studentId, studentFormUpdate);
    }

}

