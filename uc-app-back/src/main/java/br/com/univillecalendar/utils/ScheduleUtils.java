package br.com.univillecalendar.utils;

import br.com.univillecalendar.dto.ScheduleDto;
import br.com.univillecalendar.model.Schedule;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ScheduleUtils {

    public ScheduleDto convertDtoToEntity(Schedule schedule) {

        return ScheduleDto.builder()
                .dayWeekEnum(schedule.getDayWeekEnum())
                .startingTime(schedule.getStartingTime())
                .endingTime(schedule.getEndingTime())
                .build();
    }

    public Schedule convertDtoToEntity(ScheduleDto scheduleDto) {

        return Schedule.builder()
                .dayWeekEnum(scheduleDto.getDayWeekEnum())
                .startingTime(scheduleDto.getStartingTime())
                .endingTime(scheduleDto.getEndingTime())
                .build();
    }
}
