package com.skyweb.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.skyweb.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="ctl00$MainContentPlaceHolder$skyWebLogin$UserName")
	WebElement username;
	
	@FindBy(name="ctl00$MainContentPlaceHolder$skyWebLogin$Password")
	WebElement password;
	
	@FindBy(name="ctl00$MainContentPlaceHolder$skyWebLogin$LoginButton")
	WebElement loginBtn;
	
	@FindBy(xpath="//*[@id=\"body\"]/section[2]/div[1]/table/tbody/tr[1]/td[3]/div/a")
	WebElement AdminbtnBtn;
	
	@FindBy(partialLinkText = "[LOG OUT]")
	WebElement logoutBtn;
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	

	
	public AdminPage login(String un, String pwd) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		Thread.sleep(3000);
	//	AdminbtnBtn.click();   	
		return new AdminPage();
	}	
	
	
	public AdminPage Administration() {
		AdminbtnBtn.click();
		return new AdminPage();
	}
	
		public LoginPage logout() throws InterruptedException {
			Thread.sleep(1000);
			logoutBtn.click();
			return new LoginPage();
		}
	}
	
