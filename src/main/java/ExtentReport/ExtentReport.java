package ExtentReport;

import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	public static  ExtentReports Object() {
	
	Properties property = new Properties();
	String path = System.getProperty("user.dir") + "//reports//index.html";
	ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	reporter.config().setReportName("Practice");
	reporter.config().setDocumentTitle("Repo");
	ExtentReports rep = new ExtentReports();
	rep.attachReporter(reporter);
	return rep;

}
}