package vikaschaurasiatest.SeleniumFrameworkDesign;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.*;

import io.github.bonigarcia.wdm.WebDriverManager;
import vikaschaurasiaacademy.SeleniumFrameworkDesign.ProductPage;

public class Ecommerce extends BaseTest{

	
		@Test
		public void Ecommerce() throws IOException {
		BaseTest child = new BaseTest();
		WebDriver driver = child.InstallApp("vikas.chourasia@gmail.com", "Newpass@13");
		ProductPage product = new ProductPage(driver);
		product.addProductInCart("ZARA COAT 3");
		product.goToCart();
		String productAdded =product.productAdded();
		Assert.assertTrue(productAdded.equals("ZARA COAT 3"));
		child.closeBrowser();
		}
		
		@Test(groups={"Negative"})
		public void negativeTest() throws IOException {
			
			BaseTest child = new BaseTest();
			String error = child.ExceptionTest("vikas1.chourasia@gmail.com", "Newpass@13");
			System.out.println("This is the error "+ error);
			Assert.assertTrue(error.equals("Incorrect email or password."));
			//Assert.assertFalse(error.equals("Incorrect email or password."));
			
			
			
		}

	

}
