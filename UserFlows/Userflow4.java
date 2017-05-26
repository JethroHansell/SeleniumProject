package UserFlows;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import pages.ForgotPassword;
import pages.Home;
import pages.PasswordReset;
import pages.SignIn;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Userflow4 {

	// In this scenario, the user is trying to reset their password
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home homePage;
	SignIn signInPage;
	ForgotPassword pReset;
	PasswordReset reset;
	
	@Before
	
	public void goToSignIn() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com/");
	}
	
	@Test
	public void resetPassword() {
		
		// create the report file
				report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\Userflow4.html",true);
				
				// start the test
				test = report.startTest("Resetting a password");
				
				// add a note to the test
						test.log(LogStatus.INFO, "Browser started");
		
		homePage = new Home(driver);
		String homePageTitle = homePage.getTitle();
		assertEquals(homePageTitle, "My Store");
		homePage.clickSignInLink();

		signInPage = new SignIn(driver);
		String signInPageTitle = signInPage.getTitle();
		assertEquals(signInPageTitle, "AUTHENTICATION");
		signInPage.clickForgotPassword();
		
		// add a note to the test
		test.log(LogStatus.INFO, "Clicked 'forgot password'");
		
		pReset = new ForgotPassword(driver);
		String pResetTitle = pReset.getTitle();
		assertEquals(pResetTitle, "FORGOT YOUR PASSWORD?");
		pReset.enterEmail();
		pReset.retrievePassword();
		
		// add a note to the test
				test.log(LogStatus.INFO, "Entered email address");
		
		reset = new PasswordReset(driver);
		String resetConfirmation = reset.getConfirmation();
		assertTrue(resetConfirmation.contains("A confirmation email has been sent"));
		reset.clickBackToLogin();
		
		// report the test as a pass
				test.log(LogStatus.PASS, "A confirmation email was sent");
				report.endTest(test);
				report.flush();
		
	}
	
	
	@After
	public void tearDown() {
		try {
			driver.close();
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
	}
	
}
