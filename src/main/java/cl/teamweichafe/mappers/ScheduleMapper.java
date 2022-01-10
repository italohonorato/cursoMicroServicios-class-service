package cl.teamweichafe.mappers;

import cl.teamweichafe.common.dtos.ScheduleDto;
import cl.teamweichafe.common.mappers.MapperUtil;
import cl.teamweichafe.domain.Schedule;

import java.util.List;

public interface ScheduleMapper extends MapperUtil<Schedule, ScheduleDto> {
    ScheduleDto map(Schedule schedule);
    Schedule map(ScheduleDto scheduleDto);
    List<ScheduleDto> toScheduleDtoList(List<Schedule> entityList);
    List<Schedule> toScheduleList(List<ScheduleDto> dtoList);
}
