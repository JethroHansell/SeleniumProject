package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart {

	WebDriver driver;

	By title = By.id("cart_title");
	By proceedToCheckout = By.xpath("//*[@id='center_column']/p[2]/a[1]");
	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickToCheckout() {
		driver.findElement(proceedToCheckout).click();
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	
	}

}

