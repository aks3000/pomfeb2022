package org.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class AccountPage {
	
		//1.driver
		private WebDriver driver;
		
		//2.constructor
		public AccountPage(WebDriver driver) {
			this.driver=driver;
		}
		
		//3.By locators
		
		private By header = By.cssSelector("div#logo a");
		private By accountsSections = By.cssSelector("div#content h2");
		private By searchField = By.name("search");
		private By searchButton = By.cssSelector("div#search button");
		private By logoutLink = By.linkText("Logout");
		
		public String getAccountPageTitle() {
			return driver.getTitle();
		}
		
		public String getAccountsPageHeader() {
			return driver.findElement(header).toString();
		}
		
		public boolean isLogoutLinkExist() {
			return driver.findElement(logoutLink).isDisplayed();
		}
		
		public void logout() {
			if(isLogoutLinkExist()) {
				driver.findElement(logoutLink).click();
			}
		}
		
		public List<String> getAccountSecList() {
			
			List<String> accSectionHeaderList= new ArrayList<String>();
			List<WebElement> accSectionList=driver.findElements(accountsSections);
			for(WebElement e:accSectionList) {
				String text=e.getText();
				accSectionHeaderList.add(text);
			}
			return accSectionHeaderList;
		}
		
		public boolean isSearchExist() {
			return driver.findElement(searchField).isDisplayed();
		}
		
		public void doClear() {
			driver.findElement(searchField).clear();
		}
		
		
		public SearchPageResult doSearch(String productName) {
			System.out.println("searching the product: " + productName);
			doClear();
			driver.findElement(searchField).sendKeys(productName);
			driver.findElement(searchButton).click();
			
			return new SearchPageResult(driver);
		}
		
		
		
		
		
		
}
