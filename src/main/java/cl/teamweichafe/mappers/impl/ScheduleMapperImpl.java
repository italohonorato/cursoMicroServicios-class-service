package cl.teamweichafe.mappers.impl;

import cl.teamweichafe.common.dtos.ScheduleDto;
import cl.teamweichafe.domain.Schedule;
import cl.teamweichafe.mappers.ScheduleMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleMapperImpl implements ScheduleMapper {

    private final ModelMapper modelMapper;

    public ScheduleMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ScheduleDto map(Schedule schedule) {
        return this.getMapper().map(schedule, ScheduleDto.class);
    }

    @Override
    public Schedule map(ScheduleDto scheduleDto) {
        return this.getMapper().map(scheduleDto, Schedule.class);
    }

    @Override
    public List<ScheduleDto> toScheduleDtoList(List<Schedule> entityList) {
        return this.toDtoList(entityList, ScheduleDto.class);
    }

    @Override
    public List<Schedule> toScheduleList(List<ScheduleDto> dtoList) {
        return this.toEntityList(dtoList, Schedule.class);
    }

    @Override
    public ModelMapper getMapper() {
        return this.modelMapper;
    }
}
