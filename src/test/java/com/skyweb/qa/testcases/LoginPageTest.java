package com.skyweb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.skyweb.qa.base.TestBase;
import com.skyweb.qa.pages.AdminPage;
import com.skyweb.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	AdminPage adminPage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
	//	driver.quit();
		loginPage = new LoginPage();
		adminPage = new AdminPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "Login");
	}
	
	
//	
//	@Test(priority=2)
//	public void loginTest() throws InterruptedException {
//		
//		adminPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
//		String title = adminPage.verifyAdminPageTitle();
//		Assert.assertEquals(title, "Home");
//	}
//	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
}
}