package com.skyweb.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.skyweb.qa.base.TestBase;
import com.skyweb.qa.pages.AdminPage;
import com.skyweb.qa.pages.LoginPage;

public class AdminPageTest extends TestBase {
	LoginPage loginPage;
	AdminPage adminpage;
	public AdminPageTest(){
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
		loginPage = new LoginPage();
		adminpage =	loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//Thread.sleep(5000);
		loginPage.Administration();
	}

	@Test(priority=1)
	public void verifyAdminPageTitleTest() {
		String homepage = adminpage.verifyAdminPageTitle();
		Assert.assertEquals(homepage, "Admini", "admin page tittle not matched");
	}

	@Test(priority=2)
	public void ClickOnGeofencesTest() throws InterruptedException {
		adminpage.ClickOnGeofences();
	}

	@Test(priority=3)
	public void ClickOnGeofenceNotificationTest() throws InterruptedException {
		adminpage.ClickOnGeofenceNotification();
	}


	@AfterMethod
	public void tearDown() throws InterruptedException{
		loginPage.logout();
		driver.quit();
	}

}
