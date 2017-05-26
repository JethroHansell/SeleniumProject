package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Shipping {

	WebDriver driver;

	By title = By.xpath("//*[@id='carrier_area']/h1");
	By tAndC = By.id("cgv");
	By proceedToCheckout = By.xpath("//*[@id='form']/p/button");
	public Shipping(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToCheckout() {
		driver.findElement(proceedToCheckout).click();
	}
	
	public void agreeToTerms() {
		driver.findElement(tAndC).click();
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	
	}

}


