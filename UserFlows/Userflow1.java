package UserFlows;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pages.CreateAccount;
import pages.Home;
import pages.MyAccount;
import pages.SignIn;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Userflow1 {
	
	// In this scenario, the user is signing in and then out of their existing account
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home homePage;
	SignIn signInPage;
	MyAccount accountPage;
	
	@Before
	
	public void goToSignIn() {
		
	/*
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	
	*/
	 
	
	System.setProperty("webdriver.gecko.driver",
			"C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe");
	driver = new FirefoxDriver();
	//driver.manage().window().maximize();
	
	
	
	driver.get("http://www.automationpractice.com/");
	
	}
	
	/*
	@Parameters("browser")
	public void setup(String browser) throws Exception {
	if (browser.equalsIgnoreCase("firefox")) {
	System.setProperty("webdriver.gecko.driver",
	"C:\\Users\\Administrator\\Desktop\\Selenium\\geckodriver.exe");
	driver = new FirefoxDriver();
	}
	}
	//This user flow works on both chrome and firefox. However, I didn't get around to completing the test.  
*/
	
	@Test
	public void signInToAccount() {
		
		// create the report file
				report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\Userflow1.html",true);
				
				// start the test
				test = report.startTest("Logging in and out");
				
				// add a note to the test
						test.log(LogStatus.INFO, "Browser started");
		
		homePage = new Home(driver);
		String homePageTitle = homePage.getTitle();
		assertEquals(homePageTitle, "My Store");
		homePage.clickSignInLink();
		
		// add a note to the test
		test.log(LogStatus.INFO, "Clicked sign in");
		
		signInPage = new SignIn(driver);
		String signInPageTitle = signInPage.getTitle();
		assertEquals(signInPageTitle, "AUTHENTICATION");
		signInPage.enterExistingEmailText();
		signInPage.enterPassword();
		signInPage.clickSignIn();
		
		test.log(LogStatus.INFO, "Login details entered");
		
		// I was able to get this user flow to work on firefox by entering this pause
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		accountPage = new MyAccount(driver);
		String accountPageTitle = accountPage.getTitle();
		assertEquals(accountPageTitle, "MY ACCOUNT");
		accountPage.clickSignOut();
		
		test.log(LogStatus.INFO, "Logged back out");
		
		assertEquals(signInPageTitle, "AUTHENTICATION");
		
		// report the test as a pass
		test.log(LogStatus.PASS, "Successfully logged in and out");
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
