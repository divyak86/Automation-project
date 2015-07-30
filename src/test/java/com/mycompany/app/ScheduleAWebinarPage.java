package com.mycompany.app;

import static org.testng.AssertJUnit.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScheduleAWebinarPage {

	 WebDriver driver = null;
	 WebElement element;
	 String userId;
	 String password;
	 String url;
	 SchedulePage schedulePage = new SchedulePage();
	 LoginPage loginPage = new LoginPage();
	
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
	public void ScheduleWebinar(){
		loginPage.login(driver);
		ScheduleAWebinarPageObjects.scheduleAWebinarclick(driver).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		scheduleAWebinar();
	}
	
	public void scheduleAWebinar(){
		Date currentDate = new Date();
		ScheduleNewWebinarPageObjects.webinarTitle(driver).sendKeys("Sample Webinar"+" set up at "+ currentDate);
		ScheduleNewWebinarPageObjects.actualDescription(driver).sendKeys("Hello there! Want to schedule a meeting through GotoMeeting");
		Calendar currentDate1 = Calendar.getInstance(); 
		SimpleDateFormat formatter= new SimpleDateFormat("dd"); 
		currentDate1.add(Calendar.DAY_OF_MONTH,3); 
		SimpleDateFormat df = new SimpleDateFormat("EEE, MMM d");
		String checkDate= df.format(currentDate1.getTime());
		String futureDate = formatter.format(currentDate1.getTime());
		if(futureDate.charAt(0)=='0'){
			futureDate=String.valueOf(futureDate.charAt(1));
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ScheduleNewWebinarPageObjects.openCalendar(driver).click();
		setDateInCalendar(futureDate);		
		ScheduleNewWebinarPageObjects.submit(driver).click();
		String datetext=getWebinarDate(driver);
		assertEquals(checkDate,datetext);
	}

	private void setDateInCalendar(String futureDate) {
		
		try{
		 selectDate(futureDate);
		}
		catch(NoSuchElementException ex){
			WebElement nextMonth=driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/div[1]/a[2]"));
			nextMonth.click();
			selectDate(futureDate);
		}
		
	}

	private void selectDate(String futureDate) {
		WebElement table;
		WebElement date;
		table = driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody"));
		 date = table.findElement(By.linkText(futureDate));
		 date.click();
	}
	
	public String getWebinarDate(WebDriver driver){
		
		String currentUrl=driver.getCurrentUrl();
		String[] splitUrl=currentUrl.split("=");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String datetext;
		WebElement myWebinarpage =driver.findElement(By.xpath(".//*[@id='manageWebinar']/div[2]/div[2]/div[1]/div/div/ul/li[1]/a"));
		myWebinarpage.click();
		try{
			String xpath=".//*[@id='webinar-"+splitUrl[1]+"']/ul[1]/li[2]/span";
		 datetext=driver.findElement(By.xpath(xpath)).getText();
		}
		catch(org.openqa.selenium.NoSuchElementException ex){
			WebElement nextPage=driver.findElement(By.xpath(".//*[@id='upcomingWebinar-page-right']")); //this is for 2 pages.....
			nextPage.click();
			String xpath=".//*[@id='webinar-"+splitUrl[1]+"']/ul[1]/li[2]/span";
			datetext=driver.findElement(By.xpath(xpath)).getText();
						
		}
		
		return datetext;
	}
	
}

