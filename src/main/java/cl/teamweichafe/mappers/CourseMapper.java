package cl.teamweichafe.mappers;

import cl.teamweichafe.common.dtos.CourseDto;
import cl.teamweichafe.common.mappers.MapperUtil;
import cl.teamweichafe.domain.Course;

import java.util.List;

public interface CourseMapper extends MapperUtil<Course, CourseDto> {
    CourseDto map(Course course);
    Course map(CourseDto courseDto);
    List<CourseDto> toCourseDtoList(List<Course> entityList);
    List<Course> toCourseList(List<CourseDto> dtoList);
}
