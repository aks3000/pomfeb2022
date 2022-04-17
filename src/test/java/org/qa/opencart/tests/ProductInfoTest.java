package org.qa.opencart.tests;

import java.util.LinkedHashMap;
import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductInfoTest extends BaseTest {
	
	
	@BeforeClass
	public void doLogin() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@DataProvider
	public Object[][] productData() {
		 return new Object[][] {
			 {"Mac","MacBook Pro"},
			 {"iMac","iMac"},
			 {"Apple","Apple Cinema 30\""}
			 
		 };
			
	}
	
	
	@Test(dataProvider="productData")
	public void getProductHeaderTest(String productName, String mainProductName) {
		searchPageResult=accountPage.doSearch(productName);
		productInfo=searchPageResult.selectProduct(mainProductName);
		
		Map<String, String> listProducts=productInfo.productList(productName, mainProductName);
		listProducts.forEach((k, v) -> System.out.println(k + ":" + v));
		
		softAssert.assertEquals(listProducts.get("Mac"),"MacBook Pro");
		softAssert.assertEquals(listProducts.get("iMac"),"iMac");
		softAssert.assertEquals(listProducts.get("Apple"),"Apple Cinema 30\"");
		softAssert.assertAll();
	}
	
	
	
	
	
	
	

}
