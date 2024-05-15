package br.com.univillecalendar.service;

import br.com.univillecalendar.controller.documentation.TeacherControllerDocumentation;
import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.dto.TeacherFormUpdate;
import br.com.univillecalendar.exceptions.GenericException;
import br.com.univillecalendar.exceptions.TeacherNotFoundException;
import br.com.univillecalendar.model.Teacher;
import br.com.univillecalendar.repository.TeacherRepository;
import br.com.univillecalendar.utils.TeacherUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ObjectMapper objectMapper;
    private final String TEACHER_NOT_FOUND_MESSAGE = "Teacher Not Found";

    public TeacherService(TeacherRepository teacherRepository, ObjectMapper objectMapper) {
        this.teacherRepository = teacherRepository;
        this.objectMapper = objectMapper;
    }

    public TeacherDto createNewTeacher(TeacherDto teacher) throws JsonProcessingException {

        Teacher savedTeacher = this.save(TeacherUtils.convertDtoToEntity(teacher));

        if (teacherRepository.findById(savedTeacher.getTeacherId()).isPresent()) {
            throw new GenericException("Teacher Already Exists");
        }

        log.info("TeacherService.createNewTeacher() -> finish process, teacherId {}", this.objectMapper.writeValueAsString(savedTeacher));

        return teacher;
    }

    public List<Teacher> getAllTeachers() throws JsonProcessingException {
        log.info("TeacherService.getAllTeachers() -> init process");

        List<Teacher> teacherList = this.teacherRepository.findAll();

        if (teacherList.isEmpty()) {
            throw new GenericException(TEACHER_NOT_FOUND_MESSAGE);
        }

        log.info("TeacherService.getAllTeachers() -> finish process, teacherList {}", this.objectMapper.writeValueAsString(teacherList) );

        return this.teacherRepository.findAll();
    }

    public Teacher getTeacherById(UUID teacherId) {

        log.info("TeacherController.getTeacherById() -> init process teacherId {}", teacherId);

        return this.teacherRepository.findById(teacherId).orElseThrow(() -> new GenericException("Teacher Not Found"));
    }

    public void deleteTeacher(UUID teacherId) throws JsonProcessingException {
        log.info("TeacherService.deleteTeacher() -> init process, teacherId {}", teacherId);

        Teacher teacher = this.teacherRepository.findById(teacherId).orElseThrow(() -> new TeacherNotFoundException(TEACHER_NOT_FOUND_MESSAGE));

        this.teacherRepository.delete(teacher);

        log.info("TeacherService.deleteTeacher() -> finish process, teacherId {}", this.objectMapper.writeValueAsString(teacher));

    }

    public TeacherDto updateTeacher(UUID teacherId, TeacherFormUpdate teacherFormUpdate) throws JsonProcessingException {
        log.info("TeacherService.updateTeacher() -> init process, teacherId {}", teacherId);

        Teacher teacher = this.teacherRepository.findById(teacherId).orElseThrow(() -> new TeacherNotFoundException(TEACHER_NOT_FOUND_MESSAGE));

        teacher.setTeacherFirstName(teacherFormUpdate.getTeacherFirstName());
        teacher.setTeacherLastName(teacherFormUpdate.getTeacherLastName());
        teacher.setTeacherEmail(teacherFormUpdate.getTeacherEmail());

        this.save(teacher);

        log.info("TeacherService.updateTeacher() -> finish process, teacherId {}, teacherUpdated {}", teacherId, this.objectMapper.writeValueAsString(teacher));

        return TeacherUtils.convertEntityToDto(teacher);
    }

    private Teacher save(Teacher teacher) {
        log.info("TeacherService.save() -> init process");

        Teacher savedTeacher = this.teacherRepository.save(teacher);

        log.info("TeacherService.save() -> finish process");

        return savedTeacher;
    }
}
