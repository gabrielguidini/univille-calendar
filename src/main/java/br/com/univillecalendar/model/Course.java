package br.com.univillecalendar.model;

import br.com.univillecalendar.model.enums.CourseEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class Course {
    @Id @Builder.Default
    private UUID courseId = UUID.randomUUID();
    private String courseName;
    private CourseEnum courseType;;
    @ManyToMany(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
    @JoinTable(name = "course")
    private List<Subject> subjects;
}
