package dev.ameya.collegeapi.Model;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;


@Entity
@Table(name = "colleges")
public class College {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "accommodation")
    private String accommodation;

    @Column(name = "accommodationfee")
    private int accommodationfee;

    @OneToMany(mappedBy = "college", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Course> courses = new ArrayList<>();
    

    public College(int id, String name, String accommodation, int accommodationfee, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.accommodation = accommodation;
        this.accommodationfee = accommodationfee;
        this.courses = courses;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAccommodation(String accommodation) {
        this.accommodation = accommodation;
    }

    public void setAccommodationfee(int accommodationfee) {
        this.accommodationfee = accommodationfee;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getId() {
        return id;
    }

    public College() {
    }

    public String getName() {
        return name;
    }

    public String getAccommodation() {
        return accommodation;
    }

    public int getAccommodationfee() {
        return accommodationfee;
    }

    public List<Course> getCourses() {
        return courses;
    }

}
