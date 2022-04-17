package org.qa.opencart.tests;


import org.qa.util.Constantutil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest{
	
	@Test
	public void getLoginPageTitleTest() {
		String actTitlle=loginpage.getLoginPageTitle();
		Assert.assertEquals(actTitlle, Constantutil.LOGIN_PAGE_TITLE);
	}
	
	@Test
	public void regLinkExistTest() {
		boolean flag=loginpage.regLinkExist();
		Assert.assertTrue(flag);
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
