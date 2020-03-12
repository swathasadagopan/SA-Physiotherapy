package com.qa.SA.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.SA.Base.BasePage;
import com.qa.SA.pages.HomePage;
import com.qa.SA.pages.ServicesPage;
import com.qa.SA.util.Constants;

public class ServicesPageTest {
	
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	HomePage homepage;
	ServicesPage servicepage;
	
	@BeforeTest()
	public void setup()
	{
		basepage = new BasePage();
		prop=basepage.init_properties();
		String browser =prop.getProperty("browser");
		driver=basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
		servicepage = homepage.gotoservicepage();
		
		}
	
	
	@Test(priority=1)
	public void verifyservicetitletest()
	{
		Assert.assertEquals(servicepage.getservicepagetitle(),Constants.Services_Page_Title);
	}
	
	@Test(priority=2)
	public void verifynavigatetest() throws InterruptedException
	{
		Assert.assertTrue(servicepage.getservices(),"Title error");
	}
	
	@Test(priority=3)
	public void verifyconditiontest() throws InterruptedException
	{
		Assert.assertEquals(servicepage.getcondition(),"CONDITIONS");
	}
	
	@Test(priority=4)
	public void verifymodaltest() throws InterruptedException
	{
		Assert.assertEquals(servicepage.getModalities(),"MODALITIES");
	}
}
