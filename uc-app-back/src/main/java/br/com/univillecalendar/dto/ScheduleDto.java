package br.com.univillecalendar.dto;

import br.com.univillecalendar.model.enums.DayWeekEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link br.com.univillecalendar.model.Schedule}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ScheduleDto implements Serializable {
    private DayWeekEnum dayWeekEnum;
    private String startingTime;
    private String endingTime;
}