package dev.ameya.collegeapi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import dev.ameya.collegeapi.Repository.CollegeRepo;
import dev.ameya.collegeapi.Model.College;
@Service
public class CollegeService {

    @Autowired 
    private CollegeRepo collegeRepo;

    public List<College> getAllCollege() {
        return collegeRepo.findAll();
    }

    public College geCollegeById(int Id) {
        return collegeRepo.findById(Id).orElse(null);
    }

}
