package br.com.univillecalendar.service;

import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.exceptions.GenericException;
import br.com.univillecalendar.model.Teacher;
import br.com.univillecalendar.repository.TeacherRepository;
import br.com.univillecalendar.utils.TeacherUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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

    public TeacherDto createNewTeacher(TeacherDto teacher) {

        this.save(TeacherUtils.convertDtoToEntity(teacher));

        return teacher;
    }

    public List<Teacher> getAllTeachers() {

        return this.teacherRepository.findAll();
    }

    public TeacherDto getTeacherById(UUID uuid) {

        Teacher teacher = this.teacherRepository.findById(uuid).orElseThrow(() -> new GenericException("Teacher Not Found"));

        return TeacherUtils.convertEntityToDto(teacher);
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
