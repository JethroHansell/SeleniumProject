package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignIn {

	WebDriver driver;

	By title = By.className("page-heading");
	By enterNewEmail = By.id("email_create");
	By enterEmail = By.id("email");
	By enterPassword = By.id("passwd");
	By createAccount = By.id("SubmitCreate");
	By signIn = By.id("SubmitLogin");
	By forgotPassword = By.xpath("//*[@id='login_form']/div/p[1]/a");
	public SignIn(WebDriver driver) {
		this.driver = driver;
	}

	public void enterNewEmailText() {
		driver.findElement(enterNewEmail).sendKeys("jhtest27@email.com"); //will have to change the email address each time
	}
	
	public void enterExistingEmailText() {
		driver.findElement(enterEmail).sendKeys("jhtest19@email.com"); 
	}
	
	public void enterPassword() {
		driver.findElement(enterPassword).sendKeys("password123"); 
	}
	
	public void clickCreateAccount() {
		driver.findElement(createAccount).click();
	}
	
	public void clickSignIn() {
		driver.findElement(signIn).click();
	}
	
	public void clickForgotPassword() {
		driver.findElement(forgotPassword).click();
	}

	public String getTitle() {
		return driver.findElement(title).getText();
	}
}
	

