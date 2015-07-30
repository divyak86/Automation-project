package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageObject {

private static WebElement element;
	
	public static WebElement enterUsername(WebDriver driver){
		element=driver.findElement(By.id("emailAddress"));
		return element;
	}
	
	public static WebElement enterPassword(WebDriver driver){
		element=driver.findElement(By.id("password"));
		return element;
	}
	
	public static WebElement submit(WebDriver driver){
		element=driver.findElement(By.id("submit"));
		return element;
	}
}
