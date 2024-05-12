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
public class Subject {

    @Id
    private UUID subjectId;
    private String subjectName;
    @OneToOne
    private Teacher teacher;

}
