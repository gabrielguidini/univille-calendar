package br.com.univillecalendar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

@Entity
public class Teacher {
    @Id
    private UUID teacherId;
    private String teacherFirstName;
    private String teacherLastName;
    private String teacherEmail;
    @ManyToMany
    private List<Subject> subjects;
}
