package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccount {
	
	WebDriver driver;

	By title = By.xpath("//*[@id='center_column']/h1");
	By signOut = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]/a");
	
	public MyAccount(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignOut() {
		driver.findElement(signOut).click();
	}
	public String getTitle() {
		return driver.findElement(title).getText();
	}
}
