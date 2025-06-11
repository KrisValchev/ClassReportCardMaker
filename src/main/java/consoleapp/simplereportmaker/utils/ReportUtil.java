package consoleapp.simplereportmaker.utils;

import consoleapp.simplereportmaker.Models.GradeData;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ReportUtil {
    public static void generateReport(List<GradeData> data, String jasperPath, Map<String, Object> parameter)
            throws JRException, IOException {
        //compiling into jasper report from the file path
        JasperReport report = JasperCompileManager.compileReport(jasperPath);
        //collection bean source from which will be taken data from java to the report
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(data);
        //putting parameters into the parameters map
        //in this case CROSSTAB_DATA_SOURCE because that's the object we created in the jasper report
        //CROSSTAB_DATA_SOURCE takes new java.util.HashMap() as parameter
        //in this exact report I've made I group objects by Name for row and Subject for column
        parameter.put("CROSSTAB_DATA_SOURCE", dataSource);
        //jasperprint object for printing the file at the end
        JasperPrint print = JasperFillManager.fillReport(report, parameter, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(print,"(file path to your the place you want to creade the pdf)\\ClassPdf.pdf");

    }
}
