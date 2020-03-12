package com.qa.SA.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.SA.Base.BasePage;
import com.qa.SA.pages.ContactPage;
import com.qa.SA.pages.HomePage;

public class ContactPageTest {
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	HomePage homepage;
	ContactPage contactpage;
	
	@BeforeTest()
	public void setup()
	{
		basepage = new BasePage();
		prop=basepage.init_properties();
		String browser =prop.getProperty("browser");
		driver=basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
		contactpage=homepage.gotocontactpage();
		}
	
	
	@Test(priority=1)
	public void verifymessagetest()
	{
		contactpage.feedbackform("ramanarayananbagavathy","ramanarayanan.bagavathi@gmail.com","Appointment","GoodTreatment");
	}
	
	@AfterTest()
	public void teardown()
	{
		driver.quit();
	}
}
