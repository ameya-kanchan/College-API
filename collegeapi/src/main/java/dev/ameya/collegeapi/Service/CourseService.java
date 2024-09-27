package dev.ameya.collegeapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import dev.ameya.collegeapi.Model.Course;
import dev.ameya.collegeapi.Repository.CourseRepo;

@Service
public class CourseService {

    @Autowired
    private CourseRepo courseRepo;
    
    public List<Course> findAllByCollegeId(int collegeId) {
        return courseRepo.findAllByCollegeId(collegeId);
    }
}
