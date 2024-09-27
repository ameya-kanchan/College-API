package dev.ameya.collegeapi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import dev.ameya.collegeapi.Service.CollegeService;
import dev.ameya.collegeapi.Model.*;
@RestController
@CrossOrigin
@RequestMapping("/api/colleges")
public class CollegeController {

    @Autowired
    private CollegeService collegeService;

    @GetMapping
    public List<College> getAllCollege() {
        return collegeService.getAllCollege();
    }

    @GetMapping("/{collegeId}")
    public College getCollegebyId(@PathVariable("collegeId") int collegeId) {
        return collegeService.geCollegeById(collegeId);
    }
}
