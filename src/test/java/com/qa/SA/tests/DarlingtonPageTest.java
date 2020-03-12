package com.qa.SA.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.SA.Base.BasePage;
import com.qa.SA.pages.DarlingtonPage;
import com.qa.SA.pages.GlenelgPage;
import com.qa.SA.pages.HomePage;
import com.qa.SA.pages.ServicesPage;
import com.qa.SA.util.Constants;

public class DarlingtonPageTest {
	BasePage basepage;
	Properties prop;
	WebDriver driver;
	HomePage homepage;
	ServicesPage servicepage;
	DarlingtonPage darlingtongpage;
	
	@BeforeTest()
	public void setup()
	{
		basepage = new BasePage();
		prop=basepage.init_properties();
		String browser =prop.getProperty("browser");
		driver=basepage.init_driver(browser);
		driver.get(prop.getProperty("url"));
		homepage = new HomePage(driver);
		darlingtongpage = homepage.gotodarlingtonlocation();
		
		}
	
	
	@Test(priority=1)
	public void verifydarlingtontitle()
	
	{
	Assert.assertEquals(darlingtongpage.darlingtontitle(),Constants.Darlington_Page_title);
	}
	@Test(priority=2)
	public void bookingdarlington()
	{
		Assert.assertEquals(darlingtongpage.darlingtonbooking(),Constants.Darlington_Booking_title);
	}
	@Test(priority=3)
	public void verifyotherservice()
	{
		Assert.assertTrue(darlingtongpage.otherservice(),"Other services not selected");
	}
	@Test(priority=4)
	public void verifywcselect() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.otherserviceselect(),"Select not clickable");
	}
	@Test(priority=5)
	public void verifymaheshselect()
	{
		Assert.assertTrue(darlingtongpage.maheshselect(),"Select not successful");
	}
	@Test(priority=6)
	public void verifycalendartest() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.calendarselect(),"Mismatch in select");
	}
	@Test(priority=7)
	public void verifycalendartime()
	{
		Assert.assertTrue(darlingtongpage.verifyselectdate(),"Mismatch in time select");
	}
	
	@Test(priority=8)
	public void verifyformtest() throws InterruptedException
	{
		darlingtongpage.verifyform("Ram","bagavathy","28","Mar","1989","ramanarayanan.bagavathi@gmail.com"," ","Initial Booking");
		}
		
	@Test(priority=9)
	public void verifyformbacktest() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.verifyformback(),"Formback click error");
	}
	@Test(priority=10)
	public void verifychristest() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.verifychrisselect(),"Chrisselect click select error");
	}
	
	@Test(priority=11)
	public void bookingchris()
	{
		Assert.assertTrue(darlingtongpage.navigateselect(),"Navigate error");
	}
	@Test(priority=12)
	public void verifydateselect()
	{
		Assert.assertTrue(darlingtongpage.selectdate(),"Select date error");
	}
	@Test(priority=13)
	public void verifydamienselect()
	{
		Assert.assertTrue(darlingtongpage.selectdamien(),"Select error in damien");
	}
	@Test(priority=14)
	public void verifydamiencalendar() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.damiennavigate(),"Select date error");
	}
	@Test(priority=15)
	public void verifydoctor() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.anydoctor(),"Select doctor error");
	}
	@Test(priority=16)
	public void verifybookingtest() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.anydoctorbooking(),"Select booking doctor error");
	}
	@Test(priority=17)
	public void physiotest() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.physiotherapy(),"Physi click error");
	}
	@Test(priority=18)
	public void verifydamiselect()
	{
		Assert.assertTrue(darlingtongpage.damienselecttest(),"Dami select error");
	}
	@Test(priority=19)
	public void verifydamibooktest()
	{
			Assert.assertTrue(darlingtongpage.damicalendar(),"Dami book error");
	}
	@Test(priority=20)
	public void verifychriselecttest() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.followmktest(),"Chris select error");
	}
	@Test(priority=21)
	public void verifymaheshmk() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.mkmaheshtest(),"Mahesh mk error");
	}
	@Test(priority=22)
	public void verifymkanydoctortest() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.mkanydoctorhtest(),"MK any doctor error");
	}
	@Test(priority=23)
	public void verifyconsultdvtest() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.consultdvtest(),"Consult dv error");
	}
	@Test(priority=24)
	public void verifyconsultmktest() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.initialmktest(),"initial mk error");
	}
	@Test(priority=25)
	public void verifymkchristest() throws InterruptedException
	{
		Assert.assertTrue(darlingtongpage.initialmkchris(),"initial mk doctors");
	}
	@AfterTest()
	public void teardown()
	{
		driver.quit();
	}
	
}
