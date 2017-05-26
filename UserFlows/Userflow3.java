package UserFlows;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.*;

public class Userflow3 {
	
	// In this scenario, the user is creating a brand new account including all the relevant details
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home homePage;
	SignIn signInPage;
	CreateAccount createAccountPage;
	
	@Before
	
	public void goToSignIn() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com/");
	}
	
	@Test
	public void createAccount() {
		
		// create the report file
		report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\Userflow3.html",true);
		
		// start the test
		test = report.startTest("Creating a new account");
		
		// add a note to the test
				test.log(LogStatus.INFO, "Browser started");
		
		homePage = new Home(driver);
		String homePageTitle = homePage.getTitle();
		assertEquals(homePageTitle, "My Store");
		homePage.clickSignInLink();
		
		// add a note to the test
		test.log(LogStatus.INFO, "Gone to sign in");

		signInPage = new SignIn(driver);
		String signInPageTitle = signInPage.getTitle();
		assertEquals(signInPageTitle, "AUTHENTICATION");
		signInPage.enterNewEmailText();
		signInPage.clickCreateAccount();
		
		// add a note to the test
				test.log(LogStatus.INFO, "Registered a new email address");
		
		createAccountPage = new CreateAccount(driver);
		String createAccountPageHeading = createAccountPage.getHeading();
		assertEquals(createAccountPageHeading, "CREATE AN ACCOUNT");
		createAccountPage.selectGender();
		createAccountPage.enterFirstName();
		createAccountPage.enterLastName();
		createAccountPage.enterPassword();
		createAccountPage.enterDOB();
		createAccountPage.enterWork();
		createAccountPage.enterAddress();
		createAccountPage.enterMobile();
		createAccountPage.clickSubmitForm();
		
		// add a note to the test
		test.log(LogStatus.INFO, "Details entered");
		
		System.out.println("New account has been registered.");
		
		// report the test as a pass
		test.log(LogStatus.PASS, "The account was created");
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
