package cl.teamweichafe.mappers.impl;

import cl.teamweichafe.common.dtos.CourseDto;
import cl.teamweichafe.domain.Course;
import cl.teamweichafe.mappers.CourseMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourseMapperImpl implements CourseMapper {

    private final ModelMapper modelMapper;

    public CourseMapperImpl(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CourseDto map(Course course) {
        return this.getMapper().map(course, CourseDto.class);
    }

    @Override
    public Course map(CourseDto courseDto) {
        return this.getMapper().map(courseDto, Course.class);
    }

    @Override
    public List<CourseDto> toCourseDtoList(List<Course> entityList) {
        return this.toDtoList(entityList, CourseDto.class);
    }

    @Override
    public List<Course> toCourseList(List<CourseDto> dtoList) {
        return this.toEntityList(dtoList, Course.class);
    }

    @Override
    public ModelMapper getMapper() {
        return this.modelMapper;
    }
}
