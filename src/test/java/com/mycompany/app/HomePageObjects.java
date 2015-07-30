package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePageObjects {

	private static WebElement element;
	
	public static WebElement signInPageObject(WebDriver driver){
		element=driver.findElement(By.partialLinkText("Sign In"));
		return element;
	}

	
}
