package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
 

import base.BaseTest;
import pages.LoginPage;

public class LoginTest extends BaseTest{
	
	@Test
	public void testValidLogin() {
		System.out.println("HEYYYYYYYYYYYYYYYYYYYYYYYYY");
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterUsername("123456");
		loginPage.enterPassword("123456");
		loginPage.clickLogin();
		String title = driver.getTitle();
		System.out.println("The Title is : "+title);
//		Assert.assertEquals(title, "Just a moment...");
	}
   
	
}
