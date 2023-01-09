package biz.global77.service;

import biz.global77.model.Course;
import biz.global77.repository.CourseRepository;
import biz.global77.controller.ResourceNotFoundException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findByArchivedFalse();
    }

    @Override
    public Course getCourseById(long id) {
        return courseRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public void addCourse(Course course) {
        courseRepository.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        courseRepository.save(course);
    }


    @Override
    public void archiveCourse(long id) {
        Course course = courseRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        course.setArchived(true);
        courseRepository.save(course);
    }

    @Override
    public List<Course> getArchiveCourses() {
        return courseRepository.findByArchivedTrue();
    }

    @Override
    public void enableCourse(long id) {
        Course course = courseRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        course.setArchived(false);
        courseRepository.save(course);
    }

    @Override
    public Course getCourse(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
