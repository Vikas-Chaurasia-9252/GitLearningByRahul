package vikaschaurasiatest.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.github.bonigarcia.wdm.WebDriverManager;
import vikaschaurasiaacademy.SeleniumFrameworkDesign.Report;

import org.openqa.selenium.chrome.ChromeDriver;



public class Listeners extends BaseTest implements ITestListener{

	ExtentTest test;
	ExtentReports extent = Report.getReportGenerate();
	WebDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart");
		System.out.println(result.getMethod().getMethodName());
		test = extent.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess");
		test.log(Status.PASS,"Test case is passed");
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure");
		test.fail(result.getThrowable());
		String path = null;
		
		try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		try {
			path = BaseTest.getScreenShot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(path, "Test Case Failed");
	}
	@Override
	public void onFinish(ITestContext context) {
		System.out.println("onFinish");
		extent.flush();
	}
	
	
//	public void onFinish(ITestResult result) {
//		System.out.println("onFinish");
//		extent.flush();
//	}
	
	
	
	
}
