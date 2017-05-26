package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Home {

	WebDriver driver;

	By title = By.className("title");
	By signInLink = By.className("login");
	By womenLink = By.className("sf-with-ul");
	public Home(WebDriver driver) {
		this.driver = driver;
	}

	public void clickSignInLink() {
		driver.get(driver.findElement(signInLink).getAttribute("href"));
	}
	
	public void clickWomenCatalogue() {
		driver.findElement(womenLink).click();
	}

	public String getTitle() {
		return driver.getTitle();
	}
}