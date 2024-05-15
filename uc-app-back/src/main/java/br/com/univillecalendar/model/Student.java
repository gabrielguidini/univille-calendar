package br.com.univillecalendar.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student")
public class Student {

    @Id @Builder.Default
    private UUID studentId = UUID.randomUUID();
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    @OneToOne
    private Course course;
}
