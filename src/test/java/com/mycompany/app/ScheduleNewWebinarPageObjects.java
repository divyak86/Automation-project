package com.mycompany.app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ScheduleNewWebinarPageObjects {
	
	private static WebElement element;
	
	public static WebElement webinarTitle(WebDriver driver){
		element= driver.findElement(By.id("name"));
		return element;
		}
	public static WebElement webinarDescription(WebDriver driver){
		element= driver.findElement(By.id("descriptionLabel"));
		return element;
		}
	public static WebElement actualDescription(WebDriver driver){
		element= driver.findElement(By.xpath(".//*[@id='description']"));
		return element;
		}
	public static WebElement startDateLabel(WebDriver driver){
		element= driver.findElement(By.id("webinarTimesForm.dateTimes_0.baseDateLabel"));
		return element;
		}
	public static WebElement openCalendar(WebDriver driver){
		element= driver.findElement(By.xpath(".//*[@id='dateContainer_0']/div[1]/div/img"));
		return element;
		}
	public static WebElement startDate(WebDriver driver){
		element= driver.findElement(By.id("webinarTimesForm.dateTimes_0.baseDate"));
		return element;
		}
	
	public static WebElement submit(WebDriver driver){
		element= driver.findElement(By.id("schedule.submit.button"));
		return element;
		}
	    
}
