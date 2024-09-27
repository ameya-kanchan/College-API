package dev.ameya.collegeapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;
import dev.ameya.collegeapi.Model.Course;

public interface CourseRepo extends JpaRepository<Course, Integer>{

    @Query("SELECT c FROM Course c WHERE c.college.id = :collegeId")
    List<Course> findAllByCollegeId(@Param("collegeId") int collegeId);

}
