package org.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class LoginPage {
	
	//1.driver
	private WebDriver driver;
	
	//2.constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//3.By locators
	private By emailId = By.id("input-email11");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By registerLink = By.linkText("Register11");
	private By forgotPwdLink = By.linkText("Forgotten Password");
	
	//4. page actions
	public String getLoginPageTitle() {
		
		return driver.getTitle();
	}
	
	public String getCurrentPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean regLinkExist() {
		return driver.findElement(registerLink).isDisplayed();
	}
	public boolean forgotPasswordLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}
	public AccountPage doLogin(String un, String pwd) {
		System.out.println("login with : " + un + " : " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		
		return new AccountPage(driver);
		
	}
	
	public RegistrationPage goToRegisterPage() {
		driver.findElement(registerLink).click();
		
		return new RegistrationPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
