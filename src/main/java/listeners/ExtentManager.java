package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import helper.Utility;

public class ExtentManager {



    public static ExtentReports extent;

    public static ExtentReports getInstance(){

        if(extent == null){
            extent = createInstance();  // if report does not exist at all, then create one
            return extent;
        } else {
            return extent;  // if report already exists to append the result, then just return the report
        }
    }

    public static ExtentReports createInstance(){
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\reports\\AutomationReport1_" + Utility.getCurrentTime() + ".html");

        sparkReporter.config().setTheme(Theme.DARK);
        sparkReporter.config().setReportName("Automation Report");
        sparkReporter.config().setDocumentTitle("Sprint 1 Report");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        return extent;
    }
}
