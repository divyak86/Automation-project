package com.mycompany.app;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SchedulePage {
	
	 LoginPage lpage = new LoginPage();
	 WebDriver driver = null;
	 WebElement element;
	 String userId;
	 String password;
	 String url;
	
	@BeforeMethod
	public void setup(){
		driver = new FirefoxDriver();
	}
	
	@AfterMethod
	public void teardown(){
		driver.close();
		driver = null;
	}
	
	@Test
	public void scheduleWebinarpage(){
		
		lpage.login(driver);
		driver.findElement(By.partialLinkText("Schedule a webinar")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String title = driver.getTitle();
		Assert.assertEquals(title, "Schedule a webinar");
		System.out.println("Title matches");
		 
	}
	
	 
}
