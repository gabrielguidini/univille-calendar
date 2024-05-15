package br.com.univillecalendar.service;

import br.com.univillecalendar.dto.StudentDto;
import br.com.univillecalendar.model.Student;
import br.com.univillecalendar.repository.StudentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StudentService {
    private final StudentRepository studentRepository;
    private final ObjectMapper objectMapper;
    private String NULL_ERROR_MESSAGE = "Some value is null";

    //filed injection > @Autowired
    public StudentService(StudentRepository studentRepository, ObjectMapper objectMapper) {
        this.studentRepository = studentRepository;
        this.objectMapper = objectMapper;
    }

    public void save(Student student) {
        log.info("init");

        this.studentRepository.save(student);

        log.info("finish");
    }

}
