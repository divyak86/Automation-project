package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScheduleAWebinarPageObjects {

	private static WebElement element;
	public static WebElement scheduleAWebinarclick(WebDriver driver){
		element=driver.findElement(By.partialLinkText("Schedule a webinar"));
		return element;
	}
}
