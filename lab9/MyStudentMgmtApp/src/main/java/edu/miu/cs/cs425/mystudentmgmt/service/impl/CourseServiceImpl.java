package edu.miu.cs.cs425.mystudentmgmt.service.impl;

import edu.miu.cs.cs425.mystudentmgmt.model.Course;
import edu.miu.cs.cs425.mystudentmgmt.repository.CourseRepository;
import edu.miu.cs.cs425.mystudentmgmt.service.CourseService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public void saveCourse(Course course) {
        courseRepository.save(course);
    }
}
