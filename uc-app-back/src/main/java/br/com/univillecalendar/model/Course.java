package br.com.univillecalendar.model;

import br.com.univillecalendar.model.enums.CourseEnum;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
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
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinTable(name = "course")
    @Nullable
    private List<Subject> subjects = new ArrayList<>();
}
