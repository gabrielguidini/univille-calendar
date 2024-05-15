package br.com.univillecalendar.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "teacher")
@Embeddable
public class Teacher {
    @Id @Builder.Default
    private UUID teacherId = UUID.randomUUID();
    private String teacherFirstName;
    private String teacherLastName;
    private String teacherEmail;

}
