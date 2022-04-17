package org.qa.opencart.tests;

import java.util.Random;

import org.qa.util.ExceLUtil;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationPageTest extends BaseTest {
	
	@BeforeClass
	public void gotoRegisterPageSetUp() {
		registrationPage=loginpage.goToRegisterPage();
	}
	
	public String getRandomEmail() {
		Random randonGenerator= new Random();
		String email = "febpom"+randonGenerator.nextInt(1000)+"@testing.com";
		return email;
	}
	
	@DataProvider
	public Object[][] regData() {
		return ExceLUtil.getTestData("registration");
	}
	
	@Test(dataProvider="regData")
	public void regTest(String firstName, String lastname,
			 String telephone,String password, String subscribe)  {
		boolean flag=registrationPage.accountRegistration(firstName,lastname,getRandomEmail()
				,telephone,password,subscribe);
		Assert.assertTrue(flag);
	}
}
