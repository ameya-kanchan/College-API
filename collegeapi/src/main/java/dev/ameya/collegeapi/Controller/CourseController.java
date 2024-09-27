package dev.ameya.collegeapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.ameya.collegeapi.Model.Course;
import java.util.List;

import dev.ameya.collegeapi.Service.CourseService;

@RestController
@CrossOrigin
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;


    @GetMapping("/{collegeId}")
    public List<Course> findAllCoursesByCollegeName(@PathVariable("collegeId") int collegeId) {
        return courseService.findAllByCollegeId(collegeId);
    }
}
