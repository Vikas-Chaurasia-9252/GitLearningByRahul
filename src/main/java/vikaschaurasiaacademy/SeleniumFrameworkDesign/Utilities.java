package vikaschaurasiaacademy.SeleniumFrameworkDesign;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
static WebDriver driver;
	
	public Utilities(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	By toast = By.className("toast-success");
	By aniMation = By.className("ng-animating");
	By cart = By.xpath("//button[@routerlink='/dashboard/cart']");
	
	public void WaitforElementToAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(findBy));
	}
    public void WaitforElementToDisAppear(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(findBy));
	}
    
 public void WaitforElementToBeClick(By findBy) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();
	}
	
	public void goToCart() {
		WaitforElementToAppear(toast);
		WaitforElementToDisAppear(aniMation);
		WaitforElementToBeClick(cart);
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@routerlink='/dashboard/cart']"))).click();
	}
	

}
