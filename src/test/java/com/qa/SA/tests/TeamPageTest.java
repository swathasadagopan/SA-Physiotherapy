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
import com.qa.SA.pages.TeamPage;

public class TeamPageTest {
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	HomePage homepage;
	TeamPage teampage;
	
	@BeforeTest()
	public void setup()
	{
		basepage = new BasePage();
		prop=basepage.init_properties();
		String browser =prop.getProperty("browser");
		driver=basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
		teampage=homepage.gototeampage();
		}
	
	
	@Test(priority=1)
	public void verifydoctorteam() throws InterruptedException
	
	{
		Assert.assertEquals(teampage.getmodburydoctor(),"Our Clinical Team");
	}
	@Test(priority=2)
	public void verifydarlingtonteam()
	{
		Assert.assertEquals(teampage.getdarlingtonteam(),"DARLINGTON");
	}
	
	@AfterTest()
	public void teardown()
	{
		driver.quit();
	}
}

