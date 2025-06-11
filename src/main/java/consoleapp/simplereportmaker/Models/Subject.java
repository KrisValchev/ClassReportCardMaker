package consoleapp.simplereportmaker.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "subjects")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name="subject_name")
    private String subjectName;
    public Subject() {

    }
    public Subject(String subjectName) {
        this.subjectName = subjectName;

    }
    public Long getId() {
        return Id;
    }
    public void setId(Long id) {
        this.Id = id;
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }


}
