package org.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AccountPageTest extends BaseTest{
	
	@BeforeClass
	public void doLogin() {
		loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void getAccountPageTitleTest() {
		String actTitle=accountPage.getAccountPageTitle();
		Assert.assertEquals(actTitle, "My Account");
		
	}

	@Test(priority=2)
	public void getAccountSecListCountTest() {
		int accSecListCount=accountPage.getAccountSecList().size();
		Assert.assertEquals(accSecListCount, 4);
		
	}
	@DataProvider
	public Object[][] productData() {
		return new Object[][] { 
			{ "MacBook" }, 
			{ "Apple" }, 
			{ "Samsung" },
			};
	}
	
	
	@Test(priority=3,dataProvider="productData")
	public void searchTest(String productName) {
		
		searchPageResult=accountPage.doSearch(productName);
		int count =searchPageResult.getProductsListCount();
		Assert.assertTrue(count>0);
		
	}
	

}
