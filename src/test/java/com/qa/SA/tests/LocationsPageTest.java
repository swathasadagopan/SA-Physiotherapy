package com.qa.SA.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.SA.Base.BasePage;
import com.qa.SA.pages.HomePage;
import com.qa.SA.pages.LocationsPage;
import com.qa.SA.pages.TeamPage;
import com.qa.SA.util.Constants;

public class LocationsPageTest {
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	HomePage homepage;
	LocationsPage locationpage;
	
	@BeforeTest()
	public void setup()
	{
		basepage = new BasePage();
		prop=basepage.init_properties();
		String browser =prop.getProperty("browser");
		driver=basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
		locationpage=homepage.gotolocation();
		}
	
	
	@Test(priority=1)
	public void verifylocationtitle()
	
	{
		Assert.assertEquals(locationpage.verifylocationtitle(),Constants.Locations_Page_Title);
	}
	
	@Test(priority=2)
	public void verifymodburylocation()
	
	{
		Assert.assertEquals(locationpage.verifymodburytest(),Constants.Modbury_Page_Title);
	}
	@Test(priority=3)
	public void verifymodburybutton()
	{
		Assert.assertEquals(locationpage.verifymodburybuttontest(),Constants.Modbury_Service_Title);
	}
	
	@Test(priority=4)
	public void verifyinitialappointment()
	{
		Assert.assertEquals(locationpage.verifyphysiotherapy(),Constants.Modbury_physio_initialtitle);
	}
	@Test(priority=5)
	public void verifyinitialselect()
	{
		Assert.assertTrue(locationpage.verifyinitialselect(),"Initial select button not found");
	}
	@Test(priority=6)
	public void verifygowriselect()
	{
		Assert.assertTrue(locationpage.verifygowriselect(),"Select gowri is not found");
	}
	@Test(priority=7)
	public void verifybooking() throws InterruptedException
	{
		Assert.assertEquals(locationpage.verifybookingtitle(),Constants.Modbury_booking_title);
	}
	@Test(priority=8)
	public void verifycalendar() throws InterruptedException
	{
		Assert.assertTrue(locationpage.verifycalendar(),"Mismatch is calendar selection");
	}
	@Test(priority=9)
	public void verifycalendartime()
	{
		Assert.assertTrue(locationpage.verifyselectdate(),"Mismatch in time select");
	}
	@Test(priority=10)
	public void verifyformtest() throws InterruptedException
	{
		locationpage.verifyform("Swatha","S","7","Apr","1992","swatha007@gmail.com","0410094028","Initial checkup");
	}
	
	@AfterTest()
	public void teardown()
	{
		driver.quit();
	}


}
