package com.qa.SA.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.qa.SA.util.Constants;
import com.qa.SA.util.ElementUtil;

public class DarlingtonPage {
	WebDriver driver;
	ElementUtil elementUtil;
	By darlingtonplace = By.xpath("//body/div[@class='site-wrapper']/section[@class='pt100 pb70']/div[@class='container']/div[@class='row']/div[3]/a[1]/div[1]");
	By darlingtonbook= By.xpath("//a[text()='BOOK NOW']");
	By otherservices=By.xpath("//body[@class='cliniko-online-bookings embedded']/div[@id='cliniko-online-bookings']/div[@class='bookings__content']/main[@id='main']/section[@class='bookings-section--service current']/section[@id='individual']/ul[@class='section__content']/li[2]/button[1]");
	By wcselect=By.xpath("//ul[@id='collapsable-module-item-2']//button[@class='button--select']");
	By maheshtext=By.xpath("//li[@class='module__item']//h4[@class='heading--l2'][contains(text(),'Mr Mahesh Kuppusamy')]");
	By maheshselect = By.xpath("//section[@class='bookings-section--practitioner current']//li[3]//div[1]//div[2]//button[1]");
	By maheshtext1 = By.xpath("//span[contains(text(),'with Mr Mahesh Kuppusamy')]");
	By calendarselect= By.xpath("//table[@class='datepicker__day']//td");
	By calendartitle = By.xpath("//h2[contains(text(),'Select a time')]");
	By timeselect= By.xpath("//button[contains(text(),'11:20am')]");
	By navigatenext=By.xpath("//button[@class='button--datepicker-nav forward']");
	
	By name1=By.id("booking_patient_first_name");
	By name2= By.id("booking_patient_last_name");
	By day = By.id("booking_date_of_birth_3i");
	By month = By.id("booking_date_of_birth_2i");
	By year = By.id("booking_date_of_birth_1i");
	By email= By.id("booking_patient_email");
	By mobile = By.id("booking_patient_mobile_number");
	By notes = By.id("booking_notes");
	By formback = By.xpath("//button[@class='button--back']");
	By chrisselect=By.xpath("//section[@class='bookings-section--practitioner current']//ul[@class='section__content']//li[@class='module']//li[1]//div[1]//div[2]//button[1]");
	By christext=By.xpath("//h2[contains(text(),'Select a time')]");
	By darlingtontext =By.xpath("//p[contains(text(),'Please arrive 10 mins early for New Patients')]");
	By damienselect = By.xpath("//section[@class='bookings-section--practitioner current']//li[2]//div[1]//div[2]//button[1]");
	By damientext= By.xpath("//h2[contains(text(),'Select a time')]");
	By anydoctorselect= By.xpath("//ul[@class='section__content highlighted']//li[@class='module']//ul//button[@class='button--select']");
	
	By anydoctortext= By.xpath("//h2[contains(text(),'Select a time')]");
	By physioselect=By.xpath("//button[@class='category-expand-toggle']");
	By dvtext= By.xpath("//h2[contains(text(),'Select a practitioner')]");
	By followdvselect=By.xpath("//ul[@id='collapsable-module-item-1']//li[1]//div[1]//div[2]//button[1]");
	By followmkselect=By.xpath("//section[@class='bookings-section--service current']//li[@class='module']//li[2]//div[1]//div[2]//button[1]");
	
	By consultdv= By.xpath("//section[@class='bookings-section--service current']//li[3]//div[1]//div[2]//button[1]");
	By consultmk= By.xpath("//section[@class='bookings-section--service current']//li[3]//div[1]//div[2]//button[1]");
	By repeatpatient=By.xpath("//li[5]//div[1]//div[2]//button[1]");
	By wcinitial=By.xpath("//li[6]//div[1]//div[2]//button[1]");
	By doctortext=By.xpath("//h1[contains(text(),'Select a service')]");
	public DarlingtonPage(WebDriver driver)

	{
		this.driver= driver;
		elementUtil= new ElementUtil(driver);
		elementUtil.waitForTitlePresent(Constants.Glenelg_Title,20);
		
	}
	
	public String darlingtontitle()
	{
		elementUtil.doActionsClick(darlingtonplace);
		String title = elementUtil.waitForTitlePresent(Constants.Darlington_Page_title,20);
		return title;
	}
	 public String darlingtonbooking()
	 {
		 elementUtil.doActionsClick(darlingtonbook);
		 String title = elementUtil.waitForTitlePresent(Constants.Darlington_Booking_title,20);
		 return title;
	 }
	 public boolean otherservice()
	 
	 {
		elementUtil.doActionsClick(otherservices);
		return elementUtil.isElementDisplayed(wcselect);
		
	 }
	 public boolean otherserviceselect() throws InterruptedException
	 {
		 elementUtil.doActionsClick(wcselect);
		 Thread.sleep(1000);
		 return elementUtil.isElementDisplayed(maheshtext);
		
	 }
	 public boolean maheshselect()
	 {
		 elementUtil.doActionsClick(maheshselect);
		 return elementUtil.isElementDisplayed(maheshtext1);
	 }
	 
	 public boolean calendarselect() throws InterruptedException
	 {
		 List<WebElement> dates = driver.findElements(calendarselect);
			
			int  total =dates.size();
			for(int i=0;i<=total;i++)
			{
				String date= dates.get(i).getText();
				if(date.equalsIgnoreCase("29"))
				{
					dates.get(i).click();
					break;
				}
			}
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
			Select select2 = new Select(year1);
			Thread.sleep(1000);
			select2.selectByVisibleText(years);
			//select2.selectByIndex(29);
			//form[@id='new_booking']//button[@class='button--select']
			
			elementUtil.doActionsSendKeys(email, emailid);
			elementUtil.doActionsSendKeys(mobile, phone);
			Thread.sleep(2000);
			elementUtil.doActionsSendKeys(notes, comments);
			
		}
	 public boolean verifyformback() throws InterruptedException
	 {
		 elementUtil.doActionsClick(formback);
		 Thread.sleep(1000);
		 elementUtil.doActionsClick(formback);
		 Thread.sleep(1000);
		 return elementUtil.isElementDisplayed(maheshtext1);
	 }
	 public boolean verifychrisselect() throws InterruptedException
	 {
		
		 elementUtil.doActionsClick(chrisselect);
		 Thread.sleep(1000);
		 return elementUtil.isElementDisplayed(christext);
	 }
	 public boolean navigateselect()
	 {
		 for(int i=0;i<1;i++)
		 {
			 elementUtil.doActionsClick(navigatenext);
		 }
		return elementUtil.isElementDisplayed(darlingtontext);
		 
	 }
	 
	 public boolean selectdate()
	 {
		 elementUtil.doCalendarselect(calendarselect, "30");
		 return elementUtil.isElementDisplayed(darlingtontext);
	 }
	 public boolean selectdamien()
	 {
		 elementUtil.doActionsClick(formback);
		 elementUtil.doActionsClick(damienselect);
		 return elementUtil.isElementDisplayed(damientext);
	 }
	 public boolean damiennavigate() throws InterruptedException
	 {
		 for(int i=0;i<=6;i++)
		 {
			 Thread.sleep(2000);
			 elementUtil.doActionsClick(navigatenext);
		 }
		 Thread.sleep(2000);
		 elementUtil.doCalendarselect(calendarselect, "24");
		 return elementUtil.isElementDisplayed(damientext);
	 }
	 public boolean anydoctor() throws InterruptedException
	 {
	 elementUtil.doActionsClick(formback);
	 Thread.sleep(1000);
	 elementUtil.doActionsClick(anydoctorselect);
	 return elementUtil.isElementDisplayed(anydoctortext);
	 
	 }
	 public boolean anydoctorbooking() throws InterruptedException
	 {
		 for(int i=0;i<=9;i++)
		 {
			 Thread.sleep(2000);
			 elementUtil.doActionsClick(navigatenext);
		 }
		 Thread.sleep(2000);
		 elementUtil.doCalendarselect(calendarselect, "31");
		 return elementUtil.isElementDisplayed(anydoctortext);
	 }
	public  boolean physiotherapy() throws InterruptedException
	{
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(physioselect);
		Thread.sleep(2000);
		elementUtil.doActionsClick(followdvselect);
		Thread.sleep(2000);
		return elementUtil.isElementDisplayed(dvtext);
		
		}
	public boolean damienselecttest()
	{
		elementUtil.doActionsClick(damienselect);
		return elementUtil.isElementDisplayed(dvtext);
	}
	public boolean damicalendar()
	{
		elementUtil.doCalendarselect(calendarselect, "14");
		return elementUtil.isElementDisplayed(damientext);
	}
	public boolean followmktest() throws InterruptedException
	{
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(followmkselect);
		Thread.sleep(2000);
		elementUtil.doActionsClick(chrisselect);
		return elementUtil.isElementDisplayed(christext);
		
	}
	public boolean mkmaheshtest() throws InterruptedException
	{
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(followmkselect);
		Thread.sleep(2000);
		elementUtil.doActionsClick(maheshselect);
		return elementUtil.isElementDisplayed(maheshtext1);
	}
	public boolean mkanydoctorhtest() throws InterruptedException
	{
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(anydoctorselect);
		Thread.sleep(2000);
		return elementUtil.isElementDisplayed(anydoctortext);
	}
	public boolean consultdvtest() throws InterruptedException
	{
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(consultdv);
		Thread.sleep(2000);
		elementUtil.doActionsClick(damienselect);
		return elementUtil.isElementDisplayed(dvtext);
	}
	public boolean initialmktest() throws InterruptedException
	{
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(consultmk);
		Thread.sleep(2000);
		return elementUtil.isElementDisplayed(dvtext);
	}
	public boolean initialmkchris() throws InterruptedException
	{
		elementUtil.doActionsClick(chrisselect);
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(maheshselect);
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		elementUtil.doActionsClick(formback);
		Thread.sleep(2000);
		return elementUtil.isElementDisplayed(doctortext);
		
	}
	
}

