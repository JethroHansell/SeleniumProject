package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenCatalogue {

	WebDriver driver;

	By title = By.className("category-name");
	By  blouseLink = By.xpath("//*[@id='center_column']/ul/li[2]/div/div[1]/div/a[1]/img");
	public WomenCatalogue(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickBlouse() {
		driver.findElement(blouseLink).click();
	}
	
	public String getTitle() {
		return driver.findElement(title).getText();
	}
}
