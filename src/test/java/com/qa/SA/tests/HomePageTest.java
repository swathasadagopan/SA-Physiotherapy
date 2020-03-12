package com.qa.SA.tests;

import static org.testng.Assert.assertEquals;

import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.SA.Base.BasePage;
import com.qa.SA.pages.HomePage;
import com.qa.SA.util.Constants;

public class HomePageTest {
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	HomePage homepage;
	
	@BeforeTest()
	public void setup()
	{
		basepage = new BasePage();
		prop=basepage.init_properties();
		String browser =prop.getProperty("browser");
		driver=basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
		}
	
	
	@Test(priority=1)
	public void verifypopuptest()
	{
		Assert.assertEquals(homepage.closealert(),"BOOK NOW");
	}
	
	@Test(priority=2)
	public void verifyglenelgtest()
	{
		Assert.assertEquals(homepage.getglenelgservice(),"GLENELG");
	}
	
	@Test(priority=3)
	public void verifyhomepagetitletest()
	{
		Assert.assertEquals(homepage.getPageTitle(),"SA Physiotherapy");
	}
	
	@Test(priority=4)
	
		public void verifyforwardscreenTest()
		{
			Assert.assertTrue(homepage.getforwardscreen(),"forward navigation error");
		}
	
	@Test(priority=5)
	
	public void verifypreviouscreenTest()
	{
		Assert.assertTrue(homepage.getpreviouscreen(),"previous navigation error");
	}
	
	@Test(priority=6)
	
	public void verifycallNowTest()
	{
		Assert.assertTrue(homepage.getcall(),"Call Now Click Error");
	}

	@Test(priority=7)
	public void verifyfbiconTest()
	{
		Assert.assertEquals(homepage.getfblink(),Constants.Facebook_Icon);
	}
	
	@Test(priority=8)
	public void verifytwittericontest()
	{
		Assert.assertEquals(homepage.gettwitterlink(),Constants.Twitter_Icon);
	}
	
	@Test(priority=9)
	public void verifylinkedinicontest()
	{
		Assert.assertEquals(homepage.getLinkedinlink(),Constants.Linkedin_Icon);
	}
	
	@Test(priority=10)
	public void verifyservicetest()
	{
		Assert.assertEquals(homepage.getServices(), Constants.Service_Service_Title);
	}
	@Test(priority=11)
	public void verifyourTeamtest()
	{
		Assert.assertEquals(homepage.getTeam(), Constants.Team_Page_Title);
	}
	
	@Test(priority=12)
	
	public void verifylocationPage()
	{
		Assert.assertTrue(homepage.getLocations(),"location page is not navigated");
	}
	
	@Test(priority=13)
	
	public void verifycontactPage()
	{
		Assert.assertEquals(homepage.getcontact(),Constants.Contact_PageTitle);
	}
	
	@Test(priority=14)
	public void verifyourblogtest()
	{
		Assert.assertEquals(homepage.getblog(), Constants.Blog_Page_Title);
	}
	
	@Test(priority=15)
	public void verifyourbloghometest()
	{
		Assert.assertEquals(homepage.getbloghome(), Constants.Home_Page_Title);
	}
	
	
	@AfterTest()
	public void teardown()
	{
		driver.quit();
	}
	
	

}
