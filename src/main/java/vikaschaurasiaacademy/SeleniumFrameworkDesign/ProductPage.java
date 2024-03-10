package vikaschaurasiaacademy.SeleniumFrameworkDesign;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utilities {
	
WebDriver driver;
	
	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="div.mb-3")
	List<WebElement> listOfProducts;
	
	@FindBy(xpath = "//div[@class='cartSection']//h3")
	WebElement productAdded;
	
	By products =  By.cssSelector("div.mb-3");
	By addCart = By.xpath("//div[@class='card-body']//button[2]");
	By myCart = By.xpath("//div[@class='heading cf']//h1");
	
	public void addProductInCart(String productName) {
		List<WebElement> cards = getMeProductList();
		WebElement flag = cards.stream().filter(card -> card.findElement(By.cssSelector("b")).
				getText().equals(productName)).findFirst().orElse(null);
		flag.findElement(addCart).click();
		
	}
	
	public List<WebElement> getMeProductList() {
		
		WaitforElementToAppear(products);
		return listOfProducts;
		
	}
	

	
	public String productAdded() {
		WaitforElementToAppear(myCart);
		return productAdded.getText();
		
	}
	
	

}
