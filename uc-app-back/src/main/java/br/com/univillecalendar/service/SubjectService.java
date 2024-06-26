package br.com.univillecalendar.service;

import br.com.univillecalendar.dto.ScheduleDto;
import br.com.univillecalendar.dto.SubjectDto;
import br.com.univillecalendar.exceptions.SubjectNotFoundException;
import br.com.univillecalendar.model.Course;
import br.com.univillecalendar.model.Subject;
import br.com.univillecalendar.model.Teacher;
import br.com.univillecalendar.repository.SubjectRepository;
import br.com.univillecalendar.utils.ScheduleUtils;
import br.com.univillecalendar.utils.SubjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final ObjectMapper objectMapper;
    private static final String SUBJECT_NOT_FOUND = "Subject Not Found";

    public SubjectService(SubjectRepository subjectRepository, ObjectMapper objectMapper) {
        this.subjectRepository = subjectRepository;
        this.objectMapper = objectMapper;
    }

    public Subject createNewBaseSubject(SubjectDto subjectDto) throws JsonProcessingException {

        log.info("SubjectService.createNewBaseSubject() -> init process, subject {}", this.objectMapper.writeValueAsString(subjectDto));

        Subject subject = Subject.builder()
                .subjectName(subjectDto.getSubjectName())
                .schedules(null)
                .teacher(null)
                .course(null)
                .build();

        this.save(subject);

        log.info("SubjectService.createNewBaseSubject() -> finish process, subject {}", this.objectMapper.writeValueAsString(subject));

        return subject;
    }

    public List<Subject> getAllSubjects(){
        log.info("SubjectService.getAllSubjects() -> init process");

        return this.subjectRepository.findAll();

    }

    public Subject getSubjectById(UUID subjectId){
        log.info("SubjectService.getSubjectById(subjectId) -> init process, subjectId {} ", subjectId);

        return this.subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(SUBJECT_NOT_FOUND));
    }

    public void deleteSubject(UUID subjectId) throws JsonProcessingException{
        log.info("SubjectController.deleteSubject() -> init process, subjectId {}", subjectId);

        Subject subject = this.subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(SUBJECT_NOT_FOUND));

        this.subjectRepository.delete(subject);

        log.info("SubjectController.deleteSubject() -> finish process, subjectId{}", this.objectMapper.writeValueAsString(subject));
    }

    public SubjectDto addScheduleIntoSubject(UUID subjectId,
                                             ScheduleDto scheduleDto) throws JsonProcessingException{
        log.info("SubjectService.updateSubject() -> init process, subjectId{}", subjectId);

        Subject subject = this.subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(SUBJECT_NOT_FOUND));

        subject.getSchedules().add(ScheduleUtils.convertDtoToEntity(scheduleDto));

        this.save(subject);

        log.info("SubjectService.updateSubject() -> finish process, subjectId{}, subjectUpdated{}", subjectId, this.objectMapper.writeValueAsString(subject));

        return SubjectUtils.convertEntityToDto(subject);
    }

    public SubjectDto addTeacherIntoSubject(UUID subjectId, String teacherFirstName, String teacherLastName) throws JsonProcessingException {
        log.info("SubjectService.updateSubjectTeacher() -> init process, subjectId {}", subjectId);

        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(SUBJECT_NOT_FOUND));

        Teacher teacher = subjectRepository.findTeacherByName(teacherFirstName, teacherLastName);

        subject.setTeacher(teacher);

        this.save(subject);

        log.info("SubjectService.updateSubjectTeacher() -> finish process, subjectId {}", this.objectMapper.writeValueAsString(subjectId));

        return SubjectUtils.convertEntityToDto(subject);
    }


    public void save(Subject subject) throws JsonProcessingException {
        log.info("SubjectService.save() -> init process, subject {}", this.objectMapper.writeValueAsString(subject));

        this.subjectRepository.save(subject);

        log.info("SubjectService.save() -> finish process, subject {}", this.objectMapper.writeValueAsString(subject));
    }

    public SubjectDto addCourseIntoSubject(UUID subjectId, String courseName) throws JsonProcessingException {

        log.info("SubjectService.addCourseIntoSubject() -> init process, subjectId {}, courseName {}", subjectId, courseName);

        Subject subject = subjectRepository.findById(subjectId).orElseThrow(() -> new SubjectNotFoundException(SUBJECT_NOT_FOUND));

        Course course = subjectRepository.findCourseByName(courseName);

        subject.setCourse(course);

        this.save(subject);

        log.info("SubjectService.addCourseIntoSubject() -> finish process, subjectId {}, courseName {}", subjectId, courseName);

        return SubjectUtils.convertEntityToDto(subject);
    }
}

