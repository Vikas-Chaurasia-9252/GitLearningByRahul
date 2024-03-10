package vikaschaurasiatest.SeleniumFrameworkDesign;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import vikaschaurasiaacademy.SeleniumFrameworkDesign.LoginPage;

public class BaseTest {
	public static WebDriver driver;
	public String error ;
	
	public WebDriver InstallApp(String email, String pwd) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\chourasv\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\vikaschaurasiaacademy\\SeleniumFrameworkDesign\\GlobalData.properties");
		prop.load(file);
		String browser= prop.getProperty("browse");
		
		if (browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			LoginPage loginMe = new LoginPage(driver);
			loginMe.getURL();
			loginMe.LoginMe(email, pwd);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
		
	}
	
public String ExceptionTest(String email, String pwd) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\chourasv\\eclipse-workspace\\SeleniumFrameworkDesign\\src\\main\\java\\vikaschaurasiaacademy\\SeleniumFrameworkDesign\\GlobalData.properties");
		prop.load(file);
		String browser= prop.getProperty("browse");
		
		
		if (browser.equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			LoginPage loginMe = new LoginPage(driver);
			loginMe.getURL();
			//System.out.println("Login done");
			 error = loginMe.GetMeError(email, pwd);
			// System.out.println("After Login done");
			// System.out.println("This is the error is base class= "+error);
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return error;
		
	}

public static String getScreenShot(String testName, WebDriver driver) throws IOException {
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileHandler handle = new FileHandler();
	handle.copy(src, new File(System.getProperty("user.dir")+"//reports//"+".png"));
	return System.getProperty("user.dir")+"//reports//"+".png";
}

@AfterMethod
public void closeBrowser() {
	driver.quit();
}
}
