package com.skyweb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.skyweb.qa.base.TestBase;
import com.skyweb.qa.pages.AdminPage;
import com.skyweb.qa.pages.LoginPage;


public class GeofenceNotificationPage extends TestBase {
	AdminPage adminPage;
	GeofencesPage geofencesPage;
	LoginPage loginPage;

	@FindBy(xpath="//a[@id='ctl00_MainContentPlaceHolder_GeofenceEventControl_skyWizard_EmailControl_emailRadGrid_ctl01_ctl03_ctl01_InitInsertButton']")
	WebElement AddRecord;


	@FindBy(id= "ctl00_MainContentPlaceHolder_GeofenceEventControl_skyWizard_EmailControl_emailRadGrid_ctl01_ctl02_ctl01_EmailAddressTextBox")
	WebElement EmailAddressBox;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_GeofenceEventControl_skyWizard_EmailControl_emailRadGrid_ctl01_ctl02_ctl01_PerformInsertButton")
	WebElement InsertBtn;
	

	@FindBy(id = "ctl00_MainContentPlaceHolder_GeofenceEventControl_skyWizard_EmailControl_emailRadGrid_ctl01_ctl04_EditButton")
	WebElement EditBtn;

	@FindBy(id = "ctl00_MainContentPlaceHolder_GeofenceEventControl_skyWizard_EmailControl_emailRadGrid_ctl01_ctl04_EmailAddressTextBox")
	WebElement EmailAddressText;

	@FindBy(id = "ctl00_MainContentPlaceHolder_GeofenceEventControl_skyWizard_EmailControl_emailRadGrid_ctl01_ctl04_UpdateButton")
	WebElement UpdateBtn;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_GeofenceEventControl_skyWizard_EmailControl_emailRadGrid_ctl01_ctl04_EmailAddressLabel")
	WebElement EmailAddressLabel;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_GeofenceEventControl_skyWizard_EmailControl_emailDeleteConfirmed")
	WebElement emailDeleteConfirmed;
	
	
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_GeofenceEventControl_skyWizard_EmailControl_emailRadGrid_ctl01_ctl04_DeleteButton")
	WebElement Deletbtn;
	
	
	public GeofenceNotificationPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyAdminPageTitle(){
		return driver.getTitle();
	}

	public  GeofenceNotificationPage VerifyGeofenceNotificationPage() throws InterruptedException{
		adminPage = new AdminPage();
		adminPage.ClickOnGeofenceNotification();
		AddRecord.click();
		EmailAddressBox.sendKeys("user@rcas.co.in");
		InsertBtn.click();
		
		EditBtn.click();
		String editmail = EmailAddressText.getAttribute("value");
		System.out.println("value="+editmail);
		EmailAddressText.clear();
		EmailAddressText.sendKeys("user@rcas.co.in");
		Thread.sleep(3000);
		
		Thread.sleep(3000);
		UpdateBtn.click();
		Thread.sleep(3000);
		String afteredit = EmailAddressLabel.getText();
				//getAttribute("value");
		System.out.println("value="+afteredit);
//		if (editmail.matches(afteredit)){
//			System.out.println("The edited record has been updated sucessfully");
//		}
//		else{
//			Assert.fail("The edited record has not been updated sucessfully");
//		
//			Thread.sleep(3000);
//		}
		//SoftAssert softAssert = new SoftAssert();
		Assert.assertEquals(editmail, afteredit);
		Deletbtn.click();
		Thread.sleep(3000);
		emailDeleteConfirmed.click();
		Thread.sleep(3000);
		driver.navigate().back();
		return new GeofenceNotificationPage();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
