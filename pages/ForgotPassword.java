package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPassword {

	WebDriver driver;

	By title = By.xpath("//*[@id='center_column']/div/h1");
	By email = By.id("email");
	By pRetrieve = By.xpath("//*[@id='form_forgotpassword']/fieldset/p/button");
	
	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterEmail() {
		driver.findElement(email).sendKeys("jhtest2@email.com");
	}
	
	public void retrievePassword() {
		driver.findElement(pRetrieve).click();
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	}
}
