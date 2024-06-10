package br.com.univillecalendar.controller;

import br.com.univillecalendar.dto.ScheduleDto;
import br.com.univillecalendar.dto.SubjectDto;
import br.com.univillecalendar.exceptions.GenericException;
import br.com.univillecalendar.exceptions.SubjectNotFoundException;
import br.com.univillecalendar.model.Subject;
import br.com.univillecalendar.service.SubjectService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@Slf4j
@RequestMapping("/subject")
public class SubjectController {

    private final SubjectService subjectService;
    private final ObjectMapper objectMapper;

    public SubjectController (SubjectService subjectService, ObjectMapper objectMapper) {
        this.subjectService = subjectService;
        this.objectMapper = objectMapper;
    }

    @PostMapping()
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Subject createNewSubject(@RequestBody SubjectDto subject) throws JsonProcessingException {
        log.info("SubjectController.createNewSubject() -> init process, subject: {}", this.objectMapper.writeValueAsString(subject));
        try {
            return subjectService.createNewBaseSubject(subject);

        } catch (GenericException e) {
            log.error("SubjectController.createNewSubject() -> error while trying to create new subject, body {},error {}",this.objectMapper.writeValueAsString(subject) ,e.getMessage());
            throw new GenericException(e.getMessage());
        }
    }

    @GetMapping("/all")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public List<Subject> getAllSubjects(){
        log.info("SubjectController.getAllSubjects() -> init process");

        return this.subjectService.getAllSubjects();
    }

    @GetMapping("/{subjectId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public Subject getSubjectById(@PathVariable UUID subjectId){
        log.info("SubjectController.getSubjectById() -> init process, subjectId: {}", subjectId);

        try {
            return this.subjectService.getSubjectById(subjectId);

        } catch(SubjectNotFoundException e) {
            log.error("SubjectController.getSubjectById() -> error while trying to get subject by id, subjectId: {}", subjectId);
            throw new SubjectNotFoundException(e.getMessage());
        }
    }

    @DeleteMapping("/{subjectId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void deleteSubject(@PathVariable UUID subjectId) throws JsonProcessingException {
        log.info("SubjectController.deleteSubject() -> init process, subjectId {}", subjectId);

        try {
            this.subjectService.deleteSubject(subjectId);

            log.info("SubjectController.deleteSubject() -> finish process, subjectId {}", subjectId);

        } catch (SubjectNotFoundException e) {
            log.error("SubjectController.deleteSubject() -> error while trying to delete subject by id, subjectId: {}", subjectId);
            throw new SubjectNotFoundException(e.getMessage());
        }

    }

    @PutMapping("/schedule/{subjectId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public SubjectDto addScheduleIntoSubject(@PathVariable UUID subjectId,
                                             @RequestBody ScheduleDto scheduleDto) throws JsonProcessingException{

        log.info("SubjectController.addScheduleIntoSubject() -> init process, subjectId {}", subjectId);

        try {
            return subjectService.addScheduleIntoSubject(subjectId,scheduleDto);

        } catch (SubjectNotFoundException e) {
            log.error("SubjectController.addScheduleIntoSubject() -> error while trying to add schedule into subject, subjectId: {}", subjectId);
            throw new SubjectNotFoundException(e.getMessage());
        }
    }

    @PutMapping("/teacher/{subjectId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public SubjectDto addTeacherIntoSubject(@PathVariable UUID subjectId,
                                            @RequestParam String teacherFirstName,
                                            @RequestParam String teacherLastName) throws JsonProcessingException {
        log.info("SubjectController.addTeacherIntoSubject() -> init process, subjectId {}, teacherFirstName {}", subjectId, teacherFirstName);

        try {
            return this.subjectService.addTeacherIntoSubject(subjectId, teacherFirstName, teacherLastName);

        } catch (SubjectNotFoundException e) {
            log.error("SubjectController.addTeacherIntoSubject() -> error while trying to add teacher into subject, subjectId: {}", subjectId);
            throw new SubjectNotFoundException(e.getMessage());
        }

    }

    @PutMapping("/course/{subjectId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public SubjectDto addCourseIntoSubject(@PathVariable UUID subjectId,
                                           @RequestParam String courseName) throws JsonProcessingException {

        log.info("SubjectController.addCourseIntoSubject() -> init process, subjectId {}", subjectId);

        try {
            return this.subjectService.addCourseIntoSubject(subjectId,courseName);

        } catch (SubjectNotFoundException e) {
            log.error("SubjectController.addCourseIntoSubject() -> error while trying to add course into subject, subjectId: {}", subjectId);
            throw new SubjectNotFoundException(e.getMessage());
        }
    }

}
