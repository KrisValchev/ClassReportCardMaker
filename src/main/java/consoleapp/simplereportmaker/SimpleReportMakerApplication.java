package consoleapp.simplereportmaker;

import consoleapp.simplereportmaker.Models.GradeData;
import consoleapp.simplereportmaker.Repo.GradeRepository;
import consoleapp.simplereportmaker.Services.GradeDataService;
import consoleapp.simplereportmaker.utils.ReportUtil;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SimpleReportMakerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleReportMakerApplication.class, args);

    }

    @Bean
    public CommandLineRunner run(GradeRepository gradeRepository, GradeDataService gradeDataService) {
        return args -> {

            //getting all gradeData entities
            List<GradeData> gradeDataList = gradeDataService.convertToGradeDataList(gradeRepository.findAll());

            //Path to the compiled jasper jrxml file (the template)
            String jasperPath = new File("D:\\java\\SimpleReportMaker\\src\\main\\resources\\report\\StudentGrades.jrxml").getAbsolutePath();

            //Parameters for the report
            HashMap<String, Object> parameters = new HashMap<>();

            //method for generating report from ReportUtil class
             ReportUtil.generateReport(gradeDataList, jasperPath, parameters);

        };
    }

}
