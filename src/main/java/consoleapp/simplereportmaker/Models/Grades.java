package consoleapp.simplereportmaker.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="grades")
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @Column(name="grade")
    private double grade;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;
    public Grades() {
    }
    public Grades(Student student, double grade, Subject subject) {
        this.student = student;
        this.grade = grade;
        this.subject = subject;
    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        Id = id;
    }
    public Student getStudent() {
        return student;
    }
    public void setStudent(Student student) {
        this.student = student;
    }
    public double getGrade() {
        return grade;
    }
    public void setGrade(double grade) {
        this.grade = grade;
    }
    public Subject getSubject() {
        return subject;
    }
    public void setSubject(Subject subject) {
        this.subject = subject;
    }


}
