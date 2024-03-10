package vikaschaurasiaacademy.SeleniumFrameworkDesign;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Utilities {
	
	WebDriver driver;
	public String error;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="userEmail")
	WebElement usrEmail;
	
	@FindBy(id="userPassword")
	WebElement usrpwd;
	
	@FindBy(id="login")
	WebElement submit;
	
	@FindBy(className="toast-message")
	WebElement Error;
	
	public void LoginMe(String email, String pwd) {
		
		usrEmail.sendKeys(email);
		usrpwd.sendKeys(pwd);
		submit.click();
		
	}
	public void getURL() {
	
		driver.get("https://rahulshettyacademy.com/client/");
	}
	public String GetMeError(String email, String pwd) {
		
		LoginMe(email,pwd);
		WaitforElementToAppear(By.className("toast-message"));
		error = Error.getText();
		return error;
	}
	

}
