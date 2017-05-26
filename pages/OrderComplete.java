package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderComplete {

	WebDriver driver;

	By title = By.xpath("//*[@id='center_column']/h1");
	public OrderComplete(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	
	}

}