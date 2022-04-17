package org.qa.opencart.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.qa.opencart.driverfactory.DriverFactory;
import org.qa.opencart.pages.AccountPage;
import org.qa.opencart.pages.LoginPage;
import org.qa.opencart.pages.ProductInfo;
import org.qa.opencart.pages.RegistrationPage;
import org.qa.opencart.pages.SearchPageResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

public class BaseTest {
	WebDriver driver;
	DriverFactory df;
	LoginPage loginpage;
	AccountPage accountPage;
	Properties prop;
	SearchPageResult searchPageResult;
	ProductInfo productInfo;
	SoftAssert softAssert;
	RegistrationPage registrationPage;
	
	@BeforeTest
	public void setUp() {
		df = new DriverFactory();
		prop= df.init_prop();
		driver =df.init_driver(prop);
		loginpage= new LoginPage(driver);
		accountPage = new AccountPage(driver);
		searchPageResult= new SearchPageResult(driver);
		productInfo= new ProductInfo(driver);
		softAssert = new SoftAssert();
		registrationPage = new RegistrationPage(driver);
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
