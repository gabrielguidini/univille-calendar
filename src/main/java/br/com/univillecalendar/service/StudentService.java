package br.com.univillecalendar.service;

import br.com.univillecalendar.dto.StudentDto;
import br.com.univillecalendar.exceptions.GenericException;
import br.com.univillecalendar.exceptions.StudentNotFoundException;
import br.com.univillecalendar.model.Student;
import br.com.univillecalendar.repository.StudentRepository;
import br.com.univillecalendar.utils.StudentUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;
    private String NULL_ERROR_MESSAGE = "Some value is null";
    private final String STUDENT_NOT_FOUND_MESSAGE = "Student Not Found";

    //filed injection > @Autowired
    public StudentService(StudentRepository studentRepository, ObjectMapper objectMapper) {
        this.studentRepository = studentRepository;
        this.objectMapper = objectMapper;
    }

    public StudentDto createNewStudent(StudentDto student) {

        this.save(StudentUtils.convertDtoToEntity(student));

        return student;

    }

    public List<Student> getAllStudents(){

        return this.studentRepository.findAll();

    }

    public Student getStudentById(UUID uuid){

        return this.studentRepository.findById(uuid).orElseThrow(() -> new GenericException("Student Not Found"));

    }

    public void deleteStudent(UUID studentId) throws JsonProcessingException{
        log.info("StudentController.deleteStudent() -> init process, studentId {}", studentId);

        Student student = this.studentRepository.findById(studentId).orElseThrow(() -> new StudentNotFoundException(STUDENT_NOT_FOUND_MESSAGE));

        this.studentRepository.delete(student);

        log.info("StudentController.deleteStudent() -> finish process, studentId {}", this.objectMapper.writeValueAsString(student));
    }

    public void save(Student student) {
        log.info("init");

        this.studentRepository.save(student);

        log.info("finish");
    }
}
