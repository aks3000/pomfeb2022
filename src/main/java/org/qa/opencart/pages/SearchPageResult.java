package org.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SearchPageResult {
	
	
			
			//1.driver
			private WebDriver driver;
			
			//2.constructor
			public SearchPageResult(WebDriver driver) {
				this.driver=driver;
			}
			
			//3.By locators
			private By productResults = By.cssSelector("div.caption a");

			

			public int getProductsListCount() {
				int resultCount = driver.findElements(productResults).size();
				System.out.println("the search product count: " + resultCount);
				return resultCount;
			}
			
			
			public ProductInfo selectProduct(String mainProductName) {
				System.out.println("main product name is : " + mainProductName);
				List<WebElement> searchList = driver.findElements(productResults);
				for (WebElement e : searchList) {
					String text = e.getText();
					if (text.equals(mainProductName)) {
						e.click();
						break;
					}
				}
				return new ProductInfo(driver);
			
			}
			
			
			
}
