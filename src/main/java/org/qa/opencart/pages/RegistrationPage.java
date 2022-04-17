package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.qa.util.Constantutil;
import org.qa.util.ElementUtil;

public class RegistrationPage {
	
		//1.driver
		private WebDriver driver;
		public ElementUtil eleUtil;
		
		//2.constructor
		public RegistrationPage(WebDriver driver) {
			this.driver=driver;
			eleUtil = new ElementUtil(driver);
		}
		
		

		private By firstName = By.id("input-firstname");
		private By lastName = By.id("input-lastname");
		private By email = By.id("input-email");
		private By telephone = By.id("input-telephone");
		private By password = By.id("input-password");
		private By confirmpassword = By.id("input-confirm");

		private By subscribeYes = By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
		private By subscribeNo = By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");

		private By agreeCheckBox = By.name("agree");
		private By continueButton = By.xpath("//input[@type='submit' and @value='Continue']");
		private By sucessMessg = By.cssSelector("div#content h1");

		private By logoutLink = By.linkText("Logout");
		private By registerLink = By.linkText("Register");
		
		public boolean accountRegistration(String firstName, String lastName, String email, String telephone,
				String password, String subscribe)  {
			
			eleUtil.doSendKeys(this.firstName, firstName);
			eleUtil.doSendKeys(this.lastName, lastName);
			eleUtil.doSendKeys(this.email,email);
			eleUtil.doSendKeys(this.telephone, telephone);
			eleUtil.doSendKeys(this.password, password);
			eleUtil.doSendKeys(this.confirmpassword, password);
			
			if(subscribe.equals("yes")) {
			eleUtil.doClick(subscribeYes);
			}else {
				eleUtil.doClick(subscribeNo);
			}
			
			
			
			
			eleUtil.doClick(agreeCheckBox);
			eleUtil.doClick(continueButton);
			
			
			
			String msg=eleUtil.waitForElementToBeVisibleWithWebElement(sucessMessg, 10, 1000).getText();
			
			if(msg.equals(Constantutil.REG_SUCCESS_MSG)) {
				System.out.println("Registration successful");
				eleUtil.doClick(logoutLink);
				eleUtil.doClick(registerLink);
				return true;
			}
			return false;

			
			
		}
		

}
