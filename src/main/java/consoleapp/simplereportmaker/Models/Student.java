package consoleapp.simplereportmaker.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(name = "first_name", length = 255)
    private String firstName;
    @Column(name = "last_name", length = 255)
    private String lastName;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "school_year")
    private int schoolYear;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
     private Set<Grades> grades;
    public Student() {
    }

    public Student(String firstName, String lastName, String email, int schoolYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.schoolYear = schoolYear;
        this.grades = new HashSet<>();
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(int schoolYear) {
        this.schoolYear = schoolYear;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
    public Set<Grades> getGrades() {
        return grades;
    }
    public void setGrades(Set<Grades> grades) {
        this.grades = grades;
    }

}


