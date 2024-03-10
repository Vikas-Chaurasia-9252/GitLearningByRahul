package vikaschaurasiaacademy.SeleniumFrameworkDesign;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Report {
	
	
	public static ExtentReports getReportGenerate() {
		System.out.println("GetReport");
		String path = System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter  = new ExtentSparkReporter(path);
		reporter.config().setReportName("Vikas Chourasia");
		reporter.config().setDocumentTitle("My Test");
		reporter.config().setReportName("Selenium Learning");
		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Vikas Chourasia");
		return extent;
	}

}
