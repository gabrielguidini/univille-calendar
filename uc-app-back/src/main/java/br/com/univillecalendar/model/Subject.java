package br.com.univillecalendar.model;

import br.com.univillecalendar.model.enums.DayWeekEnum;
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
@Table(name = "subject")
public class Subject {
    @Id @Builder.Default
    private UUID subjectId = UUID.randomUUID();
    private String subjectName;
    private String startingTime;
    private String endingTime;
    private List<DayWeekEnum> daysWeek;
    @OneToOne(cascade = CascadeType.MERGE)
    private Teacher teachers;

}
