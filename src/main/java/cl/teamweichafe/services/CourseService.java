package cl.teamweichafe.services;

import cl.teamweichafe.common.dtos.CourseDto;
import cl.teamweichafe.common.services.BaseService;
import cl.teamweichafe.domain.Course;

import java.util.List;

public interface CourseService extends BaseService<Course, String> {
    CourseDto saveCourse(CourseDto courseDto);
    CourseDto getById(String id);
    List<CourseDto> getAllCourses();
    CourseDto updateCourse(String id, CourseDto courseDto);
}
