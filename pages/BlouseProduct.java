package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BlouseProduct {

	WebDriver driver;

	By name = By.xpath("//*[@id='center_column']/div/div/div[3]/h1");
	By addToCart = By.xpath("//*[@id='add_to_cart']/button");
	By goToCheckout = By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a");
	public BlouseProduct(WebDriver driver) {
		this.driver = driver;
	}

	public void clickAddCart() {
		driver.findElement(addToCart).click();
	}
	
	public void clickGoCheckout() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(goToCheckout).click();
	}
	
	public String getName() {
		return driver.findElement(name).getText();
	
	}

}


