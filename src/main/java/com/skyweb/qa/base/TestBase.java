package com.skyweb.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.qa.skyweb.util.TestUtil;



public class TestBase {
	
	protected static WebDriver driver;
	protected static Properties prop;
	static String driverPath = System.getProperty("user.dir");
	//public static String BrowserName=null;
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/skyweb/qa/config/Config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("Chrome")){
			String driverPath = System.getProperty("user.dir");
			System.setProperty("webdriver.chrome.driver", driverPath+"\\Drivers\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(BrowserName.equalsIgnoreCase("firefox")){
			String driverPath = System.getProperty("user.dir");
			System.setProperty("webdriver.gecko.driver", driverPath+"\\Drivers\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
//		driver.findElement(By.name("ctl00$MainContentPlaceHolder$skyWebLogin$UserName")).sendKeys(prop.getProperty("username"));
//		driver.findElement(By.name("ctl00$MainContentPlaceHolder$skyWebLogin$Password")).sendKeys( prop.getProperty("password"));
//		driver.findElement(By.name("ctl00$MainContentPlaceHolder$skyWebLogin$LoginButton")).click();
//		driver.findElement(By.partialLinkText("ADMINISTRATION")).click();
	}
	
	
	
	
	
	
	
	

}