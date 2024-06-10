package br.com.univillecalendar.model;

import br.com.univillecalendar.model.enums.DayWeekEnum;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Entity
public class Schedule {
    @Id @Builder.Default
    private UUID scheduleId = UUID.randomUUID();
    private DayWeekEnum dayWeekEnum;
    private String startingTime;
    private String endingTime;
    private String room;
}
