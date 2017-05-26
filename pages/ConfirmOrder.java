package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmOrder {

	WebDriver driver;

	By title = By.xpath("//*[@id='center_column']/h1");
	By confirmOrder = By.xpath("//*[@id='cart_navigation']/button");
	public ConfirmOrder(WebDriver driver) {
		this.driver = driver;
	}
	
	public void confirmOrder() {
		driver.findElement(confirmOrder).click();
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	
	}

}
