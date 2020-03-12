package com.qa.SA.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.SA.util.Constants;
import com.qa.SA.util.ElementUtil;




public class LocationsPage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	By modbury = By.xpath("//h2[contains(text(),'Modbury')]");
	By glenelg = By.xpath("//h2[contains(text(),'Glenelg')]");
	By darlington = By.xpath("//h2[contains(text(),'Darlington')]");
	By bookbutton = By.xpath("//a[text()='BOOK NOW']");
	By physiotherapytab =By.xpath("//button[contains(.,'Physiotherapy')]");
	By selectinitial= By.xpath("//section[@id='individual']//ul[@id='collapsable-module-item-1']//li[1]//div[1]//div[2]//button[1]");
	//By selectgowri = By.xpath("//section[@class='bookings-section--practitioner current']//ul[@class='section__content']//li[@class='module']//li[1]//div[1]//div[2]//button[1]");
	By selectgowri= By.xpath("//ul[2]/li/ul/li/div/div[2]/button");
	By navigatenext = By.xpath("//button[@class='button--datepicker-nav forward']");
	By calendarselect= By.xpath("//table[@class='datepicker__day']//td");
	By calendartitle = By.xpath("//h2[contains(text(),'Select a time')]");
	By timeselect= By.xpath("//button[contains(text(),'12:45pm')]");
	By name1=By.id("booking_patient_first_name");
	By name2= By.id("booking_patient_last_name");
	By day = By.id("booking_date_of_birth_3i");
	By month = By.id("booking_date_of_birth_2i");
	By year = By.id("booking_date_of_birth_1i");
	By email= By.id("booking_patient_email");
	By mobile = By.id("booking_patient_mobile_number");
	By notes = By.id("booking_notes");
	
	
	public LocationsPage(WebDriver driver)
	{
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	
	}
	
	public String verifylocationtitle()
	{
		String title=elementUtil.waitForTitlePresent(Constants.Locations_Page_Title, 20);
		return title;
		
	}
	
	public String verifymodburytest()
		{
		elementUtil.doActionsClick(modbury);
		String title = elementUtil.waitForTitlePresent(Constants.Modbury_Page_Title, 20);
		return title;
		}
	
	public String verifymodburybuttontest()
	{
		elementUtil.doActionsClick(bookbutton);
		String title = elementUtil.waitForTitlePresent(Constants.Modbury_Service_Title,20);
		return title;
	}
	
	public String verifyphysiotherapy()
	{
		elementUtil.doActionsClick(physiotherapytab);
		String title = elementUtil.doGetText(physiotherapytab);
		return title;
	}
	
	public boolean verifyinitialselect()
	{
		elementUtil.doActionsClick(selectinitial);
		return elementUtil.isElementDisplayed(selectinitial);
	}
	
	public boolean verifygowriselect()
	{
		elementUtil.doActionsClick(selectgowri);
		return elementUtil.isElementDisplayed(selectgowri);
	}
	
	public String verifybookingtitle() throws InterruptedException
	{
		for(int i=0;i<=3;i++)
		{
			Thread.sleep(1000);
		elementUtil.doActionsClick(navigatenext);
		}
	
		String title=elementUtil.waitForTitlePresent(Constants.Modbury_booking_title,20);
		return title;		
	}
	public boolean verifycalendar() throws InterruptedException
	{
		
		List<WebElement> dates = driver.findElements(calendarselect);
		
		int  total =dates.size();
		for(int i=0;i<=total;i++)
		{
			String date= dates.get(i).getText();
			if(date.equalsIgnoreCase("18"))
			{
				dates.get(i).click();
				break;
			}
		}
		//elementUtil.domovetoelement(timeselect);
		//elementUtil.doClick(timeselect);
		Thread.sleep(2000);
		return elementUtil.isElementDisplayed(calendartitle);
	}
	public boolean verifyselectdate()
	{
		elementUtil.doClick(timeselect);
		return elementUtil.isElementDisplayed(timeselect);
	}
	
	public void verifyform(String fname,String lname,String days,String months,String years,String emailid,String phone,String comments) throws InterruptedException
	{
		elementUtil.doActionsSendKeys(name1, fname);
		elementUtil.doActionsSendKeys(name2, lname);
		WebElement days1=elementUtil.getElement(day);
		Select select = new Select(days1);
		select.selectByVisibleText(days);
		
		WebElement month1=elementUtil.getElement(month);
		Select select1 = new Select(month1);
		select1.selectByVisibleText(months);
		
		WebElement year1=elementUtil.getElement(year);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("window.scrollBy(0,500);");
		js.executeScript("arguments[0].scrollIntoView(true);",year1);
		Select select2 = new Select(year1);
		Thread.sleep(1000);
		select2.selectByVisibleText(years);
		//select2.selectByIndex(29);
		
		elementUtil.doActionsSendKeys(email, emailid);
		elementUtil.doActionsSendKeys(mobile, phone);
		Thread.sleep(2000);
		elementUtil.doActionsSendKeys(notes, comments);
		
	}
	
}
