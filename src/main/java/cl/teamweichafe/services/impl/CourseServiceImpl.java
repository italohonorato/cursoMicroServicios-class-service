package cl.teamweichafe.services.impl;

import cl.teamweichafe.common.dtos.CourseDto;
import cl.teamweichafe.domain.Course;
import cl.teamweichafe.mappers.CourseMapper;
import cl.teamweichafe.mappers.ScheduleMapper;
import cl.teamweichafe.repositories.CourseRepository;
import cl.teamweichafe.services.CourseService;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;
    private final ScheduleMapper scheduleMapper;

    public CourseServiceImpl(CourseRepository courseRepository, CourseMapper courseMapper, ScheduleMapper scheduleMapper) {
        this.courseRepository = courseRepository;
        this.courseMapper = courseMapper;
        this.scheduleMapper = scheduleMapper;
    }

    @Override
    public CourseDto saveCourse(CourseDto courseDto) {
        Course course = this.courseMapper.map(courseDto);

        return this.courseMapper.map(this.courseRepository.save(course));
    }

    @Override
    public CourseDto getById(String id) {
        return this.courseMapper.map(this.get(id));
    }

    @Override
    public List<CourseDto> getAllCourses() {
        return this.courseMapper.toCourseDtoList(this.getAll());
    }

    @Override
    public CourseDto updateCourse(String id, CourseDto courseDto) {
        Course course = this.get(id);
        course.setDesc(courseDto.getDesc());
        course.setName(courseDto.getName());
        course.setSchedule(this.scheduleMapper.toScheduleList(courseDto.getSchedule()));

        return this.courseMapper.map(course);
    }

    @Override
    public MongoRepository<Course, String> getRepository() {
        return this.courseRepository;
    }
}
