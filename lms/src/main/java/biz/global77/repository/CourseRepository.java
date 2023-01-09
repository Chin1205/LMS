package biz.global77.repository;

import biz.global77.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByArchivedFalse();
    List<Course> findByArchivedTrue();
}




