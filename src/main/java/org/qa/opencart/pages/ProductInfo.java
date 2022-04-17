package org.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductInfo {
	
	//1.driver
	private WebDriver driver;
	
	//2.constructor
	public ProductInfo(WebDriver driver) {
		this.driver=driver;
	}
	//3.Private By locators
	private By productHeader = By.xpath("//div[@id='content']//h1");
	private By productImages = By.cssSelector("ul.thumbnails img");
	private By productMetaData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(1) li");
	private By productPriceData = By.cssSelector("div#content ul.list-unstyled:nth-of-type(2) li");
	private By qty = By.id("input-quantity");
	private By addToCartBtn = By.id("button-cart");
	
	public String getProductHeader() {
		String productHeaderText=driver.findElement(productHeader).getText();
		System.out.println("product header is: " + productHeaderText);
		return productHeaderText;
	}
	
	public int getProductImagesCount() {
		int productImagesCount=driver.findElements(productImages).size();
		return productImagesCount;
	}
	
	public Map<String, String> productList(String productName, String mainProductName) {
		Map<String, String> actProductInfoMap = new LinkedHashMap<String,String>();
		actProductInfoMap.put(productName, mainProductName);
		return actProductInfoMap;
	}
	
	
	

}
