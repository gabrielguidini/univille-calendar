package br.com.univillecalendar.service;

import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.model.Teacher;
import br.com.univillecalendar.repository.TeacherRepository;
import br.com.univillecalendar.utils.TeacherUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class TeacherService {

    private TeacherRepository teacherRepository;
    private ObjectMapper objectMapper;

    public TeacherService(TeacherRepository teacherRepository, ObjectMapper objectMapper) {
        this.teacherRepository = teacherRepository;
        this.objectMapper = objectMapper;
    }

    public TeacherDto createNewTeacher(String firsName, String lastName, String email) {

        Teacher teacher = Teacher.builder()
                .teacherFirstName(firsName)
                .teacherLastName(lastName)
                .teacherEmail(email)
                .build();

        this.save(teacher);

        return TeacherUtils.convertEntityToDto(teacher);
    }

    public List<TeacherDto> getAllTeachers() {

        List<Teacher> teacherList = this.teacherRepository.findAll();

        return teacherList.stream()
                .map(TeacherUtils::convertEntityToDto)
                .collect(Collectors.toList());
    }

    /*todo: make the rest of the CRUD developing around the business rules and the SOLID's principle.
    * tip: the main methods that create, delete, read etc, normally is up in the file. create -> delete ............
    *  and finishing the methods that implements the other main methods
    * */

    public void save(Teacher teacher) {
        log.info("");

        this.teacherRepository.save(teacher);

        log.info("");

    }
}
