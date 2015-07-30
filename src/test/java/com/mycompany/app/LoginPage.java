package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPage {
    WebDriver driver = null;
    WebElement element;
    String userId, password,url;
    String emptyuserId,emptyPassword;
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
    public void login(WebDriver driver){
    	
    	enterLoginFields(driver);
    	submitLoginPage(driver);
    }
	
  
    public void enterLoginFields(WebDriver driver){
    	TestProperties prop = new TestProperties();
    	userId=prop.getUserId();
    	password=prop.getPassword();
    	url=prop.getURL();
    	driver.get(url);
    	HomePageObjects.signInPageObject(driver).click();
    	LoginPageObject.enterUsername(driver).sendKeys(userId);
    	LoginPageObject.enterPassword(driver).sendKeys(password);
    	
    }
    
    public void submitLoginPage(WebDriver driver){
    	LoginPageObject.submit(driver).click();
    }
    
 
	
	
}
