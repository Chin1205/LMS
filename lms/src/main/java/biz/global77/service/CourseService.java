package biz.global77.service;

import biz.global77.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(long id);
    void addCourse(Course course);
    void updateCourse(Course course);
    void archiveCourse(long id);
    List<Course> getArchiveCourses();
    void enableCourse(long id);
}
