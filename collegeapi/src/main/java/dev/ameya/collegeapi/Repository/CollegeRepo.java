package dev.ameya.collegeapi.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import dev.ameya.collegeapi.Model.College;

public interface CollegeRepo extends JpaRepository<College, Integer>{
  
}
