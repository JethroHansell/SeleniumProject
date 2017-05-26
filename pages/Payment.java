package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payment {

	WebDriver driver;

	By title = By.xpath("//*[@id='center_column']/h1");
	By bankWire = By.className("bankwire");
	public Payment(WebDriver driver) {
		this.driver = driver;
	}
	
	public void chooseBankWire() {
		driver.findElement(bankWire).click();
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	
	}

}
