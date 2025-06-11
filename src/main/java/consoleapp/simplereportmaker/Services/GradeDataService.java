package consoleapp.simplereportmaker.Services;

import consoleapp.simplereportmaker.Models.GradeData;
import consoleapp.simplereportmaker.Models.Grades;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class GradeDataService {
    //method for converting grade models to GradeData list
    public List<GradeData> convertToGradeDataList(List<Grades> gradesList) {
        List<GradeData> gradeDataList = new ArrayList<>();

        for (Grades grade1 : gradesList) {
            String name = grade1.getStudent().getFirstName() + " " + grade1.getStudent().getLastName();
            String subject = grade1.getSubject().getSubjectName();
            Double grade = grade1.getGrade();

            GradeData gradeData = new GradeData(name, subject, grade);
            gradeDataList.add(gradeData);
        }

        return gradeDataList;
    }
}
