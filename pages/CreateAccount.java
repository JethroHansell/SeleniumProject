package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccount {


	WebDriver driver;

	By heading = By.className("page-subheading");
	By gender = By.id("id_gender1");
	By firstName = By.id("customer_firstname");
	By lastName = By.id("customer_lastname");
	By password = By.id("passwd");
	By birthDay = By.id("days");
	By birthMonth = By.id("months");
	By birthYear = By.id("years");
	By work = By.id("company");
	By address = By.id("address1");
	By town = By.id("city");
	By state = By.id("id_state");
	By zip = By.id("postcode");
	By phone = By.id("phone_mobile");
	By sendForm = By.id("submitAccount");
	
	public CreateAccount(WebDriver driver) {
		this.driver = driver;
	}

	public void selectGender() {
		WebElement myDynamicElement = (new WebDriverWait(driver, 10)) .until(ExpectedConditions.presenceOfElementLocated(gender)); 
		driver.findElement(gender).click();
	}
	
	public void enterFirstName() {
		driver.findElement(firstName).sendKeys("Jethro");
	}
	
	public void enterLastName() {
		driver.findElement(lastName).sendKeys("Hansell");
	}
	
	public void enterPassword() {
		driver.findElement(password).sendKeys("password123");
	}
	
	public void enterDOB() {
		driver.findElement(birthDay).sendKeys("1");
		driver.findElement(birthMonth).sendKeys("January");
		driver.findElement(birthYear).sendKeys("1990");
	}
	
	public void enterWork() {
		driver.findElement(work).sendKeys("QA");
	}
	
	public void enterAddress() {
		driver.findElement(address).sendKeys("Anchorage 1");
		driver.findElement(town).sendKeys("Manchester");
		driver.findElement(state).sendKeys("Hawaii");
		driver.findElement(zip).sendKeys("12345");
	}
	
	public void enterMobile() {
		driver.findElement(phone).sendKeys("07512345678");
	}
	
	public void clickSubmitForm() {
		driver.findElement(sendForm).click();
	}

	public String getHeading() {
		return driver.findElement(heading).getText();
	}
}
	