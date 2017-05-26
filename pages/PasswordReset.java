package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordReset {

	WebDriver driver;

	By confirmation = By.xpath("//*[@id='center_column']/div/p");
	By backToLogin = By.xpath("//*[@id='center_column']/ul/li/a");
	
	public PasswordReset(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickBackToLogin() {
		driver.findElement(backToLogin).click();
	}
	public String getConfirmation() {
		return driver.findElement(confirmation).getText();
	}
}

