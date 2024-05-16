package br.com.univillecalendar.controller;

import br.com.univillecalendar.dto.SubjectDto;
import br.com.univillecalendar.dto.SubjectFormUpdate;
import br.com.univillecalendar.dto.TeacherDto;
import br.com.univillecalendar.model.Subject;
import br.com.univillecalendar.service.SubjectService;
import br.com.univillecalendar.utils.SubjectUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Convert;
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

    @PostMapping("/createSubject")
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Subject createNewSubject(@RequestBody SubjectDto subject) throws JsonProcessingException {

        return subjectService.createNewSubject(subject);
    }

    @GetMapping("/allSubjects")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public List<Subject> getAllSubjects(){

        return this.subjectService.getAllSubjects();
    }

    @GetMapping("/{subjectId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public Subject getSubjectById(@PathVariable UUID subjectId){

        return this.subjectService.getSubjectById(subjectId);
    }

    @DeleteMapping("/{subjectId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable UUID subjectId) throws JsonProcessingException {
        log.info("SubjectController.deleteSubject() -> init process, subjectId {}", subjectId);

        this.subjectService.deleteSubject(subjectId);

        log.info("SubjectController.deleteSubject() -> finish process, subjectId {}", subjectId);
    }

    @PutMapping("/updateSubject/{subjectId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public SubjectDto updateSubject(@PathVariable UUID subjectId,
                                    @RequestBody SubjectFormUpdate subjectFormUpdate) throws JsonProcessingException{
        log.info("SubjectController.updateSubject() -> init process, subjectId{}, updatedSubjectId{}", subjectId, this.objectMapper.writeValueAsString(subjectFormUpdate));

        return subjectService.updateSubject(subjectId,subjectFormUpdate);
    }

    @PutMapping("/teacher/{subjectId}")
    @Transactional
    @ResponseStatus(HttpStatus.OK)
    public SubjectDto addTeacherIntoSubject(@PathVariable UUID subjectId,
                                            @RequestParam String teacherFirstName,
                                            @RequestParam String teacherLastName) throws JsonProcessingException {
        log.info("SubjectController.addTeacherIntoSubject() -> init process, subjectId {}, teacherFirstName {}", subjectId, teacherFirstName);

        return this.subjectService.addTeacherIntoSubject(subjectId, teacherFirstName, teacherLastName);

    }

}
