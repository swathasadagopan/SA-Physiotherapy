package com.qa.SA.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.SA.Base.BasePage;
import com.qa.SA.pages.GlenelgPage;
import com.qa.SA.pages.HomePage;
import com.qa.SA.pages.ServicesPage;
import com.qa.SA.util.Constants;

public class GlenelgPageTest {

	BasePage basepage;
	Properties prop;
	WebDriver driver;
	HomePage homepage;
	ServicesPage servicepage;
	GlenelgPage glenelgpage;
	
	@BeforeTest()
	public void setup()
	{
		basepage = new BasePage();
		prop=basepage.init_properties();
		String browser =prop.getProperty("browser");
		driver=basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
		glenelgpage = homepage.gotoglenelglocation();
		
		}
	
	
	@Test(priority=1)
	public void verifyglenelgtext()
	{
		Assert.assertEquals(glenelgpage.getglenelg(),Constants.Glenelg_Page_title);
	}
	
	@Test(priority=2)
	public void verifybooktest()
	{
		Assert.assertTrue(glenelgpage.bookbutton(),"Back to homepage not present");
	}
	@Test(priority=3)
	public void verifybackhome()
	{
		Assert.assertEquals(glenelgpage.homebutton(),Constants.Home_Page_Title);
	}
	
	@AfterTest()
	public void teardown()
	{
		driver.quit();
	}
	
	

}

	
