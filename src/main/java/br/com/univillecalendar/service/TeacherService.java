package br.com.univillecalendar.service;

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

    public TeacherDto createNewTeacher(TeacherDto teacher) {

        this.save(TeacherUtils.convertDtoToEntity(teacher));

        return teacher;
    }

    public List<Teacher> getAllTeachers() {

        return this.teacherRepository.findAll();
    }

    public Teacher getTeacherById(UUID uuid) {

        return this.teacherRepository.findById(uuid).orElseThrow(() -> new GenericException("Teacher Not Found"));
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

    public void save(Teacher teacher) {
        log.info("TeacherService.save() -> init process");

        this.teacherRepository.save(teacher);

        log.info("TeacherService.save() -> finish process");
    }
}
