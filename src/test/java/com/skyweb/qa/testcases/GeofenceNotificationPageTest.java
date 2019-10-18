package com.skyweb.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.skyweb.qa.base.TestBase;
import com.skyweb.qa.pages.AdminPage;
import com.skyweb.qa.pages.GeofenceNotificationPage;
import com.skyweb.qa.pages.GeofencesPage;
import com.skyweb.qa.pages.LoginPage;

public class GeofenceNotificationPageTest extends TestBase {

	LoginPage loginPage;
	AdminPage adminpage;
	GeofencesPage geofencesPage;
	GeofenceNotificationPage geofencenotificationpage;
	
	public GeofenceNotificationPageTest(){
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
	public void VerifyGeofenceNotificationPageTest() throws InterruptedException {
		geofencenotificationpage = new 	GeofenceNotificationPage();
		geofencenotificationpage.VerifyGeofenceNotificationPage();
		
		
	}
	
	

	@AfterMethod
	public void tearDown() throws InterruptedException{
		loginPage.logout();
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
