package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressConfirmation {
	
	WebDriver driver;

	By title = By.id("id_address_delivery");
	By proceedToCheckout = By.xpath("//*[@id='center_column']/form/p/button");
	public AddressConfirmation(WebDriver driver) {
		this.driver = driver;
	}
	
	public void goToCheckout() {
		driver.findElement(proceedToCheckout).click();
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	
	}

}

