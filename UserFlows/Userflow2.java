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

public class Userflow2 {
	
	// In this scenario, the user is selecting an item of clothing they want to buy and going through the process of completing a purchase
	ExtentReports report;
	ExtentTest test;
	WebDriver driver;
	Home homePage;
	WomenCatalogue wCPage;
	BlouseProduct bPage;
	ShoppingCart sCPage;
	SignIn signInPage;
	AddressConfirmation aCPage;
	Shipping sPage;
	Payment payPage;
	ConfirmOrder cOPage;
	OrderComplete completePage;
	
	@Before
	public void goToSignIn() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Administrator\\Desktop\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com/");
	}
	@Test
	public void purchaseClothes() {
		
	// create the report file
	report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\Userflow2.html",true);
	
	// start the test
	test = report.startTest("Ordering a product");
	
	// add a note to the test
			test.log(LogStatus.INFO, "Browser started");
	
	homePage = new Home(driver);
	String homePageTitle = homePage.getTitle();
	assertEquals(homePageTitle, "My Store");
	homePage.clickWomenCatalogue();
	
	test.log(LogStatus.INFO, "Catalogue opened");
		
	wCPage = new WomenCatalogue(driver);
	String wCPageTitle = wCPage.getTitle();
	assertEquals(wCPageTitle, "Women");
	wCPage.clickBlouse();
	
	test.log(LogStatus.INFO, "Item chosen");
	
	bPage = new BlouseProduct(driver);
	String bPageName = bPage.getName();
	assertEquals(bPageName, "Blouse");
	bPage.clickAddCart();
	bPage.clickGoCheckout();
	
	test.log(LogStatus.INFO, "Added to cart");
	
	sCPage = new ShoppingCart(driver);
	String sCPageTitle = sCPage.getTitle();
	assertTrue(sCPageTitle.contains("SHOPPING-CART SUMMARY"));
	sCPage.clickToCheckout();
	
	test.log(LogStatus.INFO, "Gone to checkout");
	
	signInPage = new SignIn(driver);
	String signInPageTitle = signInPage.getTitle();
	assertEquals(signInPageTitle, "AUTHENTICATION");
	signInPage.enterExistingEmailText();
	signInPage.enterPassword();
	signInPage.clickSignIn();
	
	test.log(LogStatus.INFO, "Signed in");
	
	aCPage = new AddressConfirmation(driver);
	String aCPageTitle = aCPage.getTitle();
	assertTrue(aCPageTitle.contains("My address"));
	aCPage.goToCheckout();
	
	test.log(LogStatus.INFO, "Confirmed address");
	
	sPage = new Shipping(driver);
	String sPageTitle = sPage.getTitle();
	assertEquals(sPageTitle, "SHIPPING");
	sPage.agreeToTerms();
	sPage.goToCheckout();
	
	test.log(LogStatus.INFO, "Terms and Conditions agreed");
	
	payPage = new Payment(driver);
	String payPageTitle = payPage.getTitle();
	assertEquals(payPageTitle, "PLEASE CHOOSE YOUR PAYMENT METHOD");
	payPage.chooseBankWire();
	
	test.log(LogStatus.INFO, "Payment method selected");
	
	cOPage = new ConfirmOrder(driver);
	String cOPageTitle = cOPage.getTitle();
	assertEquals(cOPageTitle, "ORDER SUMMARY");
	cOPage.confirmOrder();
	
	test.log(LogStatus.INFO, "Order confirmed");
	
	completePage = new OrderComplete(driver);
	String completePageTitle = completePage.getTitle();
	assertEquals(completePageTitle, "ORDER CONFIRMATION");
	
	// report the test as a pass
	test.log(LogStatus.PASS, "The order has been placed");
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
