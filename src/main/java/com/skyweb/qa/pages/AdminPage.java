package com.skyweb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skyweb.qa.base.TestBase;

public class AdminPage extends TestBase {
	AdminPage adminPage;
	
	@FindBy(partialLinkText="Geofences")
	WebElement Geofences;
	
	GeofenceNotificationPage geofencenotificationpage;
	GeofencesPage geofencesPage;

	@FindBy(id="ctl00_MainContentPlaceHolder_adminControl_skyWizard_chooseUnit_unitRadTextBox_text")
	WebElement Clear;
	
	@FindBy(id="ctl00_MainContentPlaceHolder_adminControl_skyWizard_chooseUnit_unitRadTextBox_text")
	WebElement SendUnit;
	
	@FindBy(id="ctl00_MainContentPlaceHolder_adminControl_skyWizard_chooseUnit_findButton")
	WebElement Findbtn;
	
	@FindBy(id="ctl00_MainContentPlaceHolder_adminControl_skyWizard_chooseUnit_unitRadGrid_ctl01_ctl04_selectRadioButton")
	WebElement Radiobtn;
	
	@FindBy(id= "ctl00_MainContentPlaceHolder_adminControl_skyWizard_SideBarContainer_SideBarList_ctl18_SideBarButton")
	WebElement GeofenceNotification;

	// Initializing the Page Objects:
	public AdminPage() {
		PageFactory.initElements(driver, this);
	}

	public String verifyAdminPageTitle(){
		return driver.getTitle();
	}

	public  GeofencesPage ClickOnGeofences() throws InterruptedException{
		Geofences.click();
		return new GeofencesPage();

	}

	public  GeofenceNotificationPage ClickOnGeofenceNotification() throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Clear.clear();
		SendUnit.sendKeys(prop.getProperty("unit"));
		Findbtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(Radiobtn));
		Thread.sleep(2000);
		Radiobtn.click();
		Thread.sleep(2000);
		GeofenceNotification.click();
		return new GeofenceNotificationPage();
	}




}