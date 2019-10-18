package com.skyweb.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.skyweb.qa.base.TestBase;

public class GeofencesPage extends TestBase{
	AdminPage adminPage;
	GeofencesPage geofencesPage;
	
	
	@FindBy(partialLinkText="Geofences")
	WebElement Geofences;


	@FindBy(id= "AddButton")
	WebElement AddButton;
	
	@FindBy(id = "NameText")
	WebElement Label;
	

	@FindBy(id = "DistanceText")
	WebElement Radius;

	@FindBy(id = "LatitudeText")
	WebElement Latitude;

	@FindBy(id = "LongitudeText")
	WebElement Longitude;
	
	@FindBy(id = "OkButton")
	WebElement Okbtn;
	
	@FindBy(id = "ctl00_MainContentPlaceHolder_GeofenceControl_RadGrid1_ctl00__0")
	WebElement Lblbtn;
	
	@FindBy(xpath = "//*[@id=\\\"ctl00_MainContentPlaceHolder_GeofenceControl_RadGrid1_ctl00__0\\\"]")
	WebElement Lbllink;
	
	@FindBy(id = "DeleteButton")
	WebElement Deletbtn;
	
	
	
	public GeofencesPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyAdminPageTitle(){
		return driver.getTitle();
	}

	public  AdminPage CreateOnGeofences() throws InterruptedException{
		Geofences.click();
		AddButton.click();
		driver.switchTo().frame("SkyTrac_Controls_Window_InnerFrame_0"); 
		Label.sendKeys(prop.getProperty("Label"));
		Radius.sendKeys(prop.getProperty("Radius")); 
		Latitude.sendKeys(prop.getProperty("Latitude"));
		Longitude.sendKeys(prop.getProperty("Longitude"));
		Thread.sleep(5000);
		Okbtn.click(); 
		driver.switchTo().defaultContent();
		Lblbtn.click();
		//Lbllink.click();
		Deletbtn.click();
		Alert alertg = driver.switchTo().alert();	
		String alertMsggeo = driver.switchTo().alert().getText();
		System.out.println(alertMsggeo);
		alertg.accept();	
		driver.navigate().back();
		return new AdminPage();
	
	}
	

}
