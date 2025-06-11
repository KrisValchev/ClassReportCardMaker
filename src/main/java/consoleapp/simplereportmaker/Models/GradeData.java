package consoleapp.simplereportmaker.Models;

//model for exporting the data into pdf file
public class GradeData {
    //fields must be same name and type as the fields in the jasper report
    private String name;
    private String subject;
    private Double grade;

    public GradeData(String studentName, String subjectName, Double gradeValue) {
        this.name = studentName;
        this.subject = subjectName;
        this.grade = gradeValue;
    }

    public String getName() {
        return name;
    }

    public String getSubject() {
        return subject;
    }

    public Double getGrade() {
        return grade;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }
}
