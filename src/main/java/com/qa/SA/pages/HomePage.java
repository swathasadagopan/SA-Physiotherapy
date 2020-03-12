package com.qa.SA.pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.qa.SA.Base.BasePage;
import com.qa.SA.util.Constants;
import com.qa.SA.util.ElementUtil;

public class HomePage extends BasePage{
	WebDriver driver;
	ElementUtil elementUtil;
	By book = By.xpath("//button[text()='BOOK NOW']");
	By call = By.xpath("//button[text()='CALL NOW']");
	By callglenelg = By.xpath("(//div[@class='dropdown']//div[@class='dropdown-content']//span[@class='AVANSERnumber-A-2439']//a[text()='GLENELG'])[1]");
	By service = By.xpath("//a[contains(text(),'Our Services')]");
	By team = By.xpath("//a[text()='Our Team']");
	By location = By.xpath("//a[text()='Our Locations']");
	By blog=By.xpath("//a[text()='Blog']");
	By bloghome = By.xpath("//a[text()='Home']");
	By headerLocation = By.xpath("//h1[text()='Our Locations']");
	By popup = By.id("popup-close");
	By text1 = By.xpath("//p[text()='Our Philosophy']");
	By PrevButton= By.xpath("//div[@class='owl-prev']");
	By ForwardButton= By.xpath("//div[@class='owl-next']");
	By FirstPage = By.xpath("//div//div//p[text()='Our Philosophy']");
	By ThirdPage = By.xpath("//div//div//p[text()='Our Mission']");
	By LastScreen = By.xpath("//div//div//p[text()='Our Vision']");
	By tabtitle = By.cssSelector("body");
	By fbicon = By.xpath("//i[@class='ion-social-facebook']");
	By Twittericon = By.xpath("//i[@class='ion-social-twitter']");
	By Linkedinicon = By.xpath("//i[@class='ion-social-linkedin']");
	By Glenelg = By.xpath("(//a[text()='GLENELG'])[3]");
	By glenelgtext = By.xpath("//h2[text()='To make a booking @ Glenelg please call 8 82951890']");
	By contact = By.xpath("//a[text()='Contact Us']");
	public HomePage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
		elementUtil.waitForTitlePresent(Constants.Home_Page_Title,15);
	}
	
	public String closealert()
	{
	
	elementUtil.doClick(popup);
	String present = elementUtil.doGetText(book);
	System.out.println(present);
	elementUtil.doClick(book);
	return present;
	}
	public boolean getglenelgservice()
	{
		elementUtil.domovetoelement(book);
		//elementUtil.doActionsClick(book);
		elementUtil.domovetoelement(Glenelg);
		//elementUtil.doActionsClick(Glenelg);
		return elementUtil.isElementDisplayed(Glenelg);
	}
	public String getPageTitle()
	{
		String title = elementUtil.waitForTitlePresent(Constants.Home_Page_Title, 20);
		System.out.println(title);
		return title;
	}
	
	public boolean getforwardscreen()
	{
		for(int i=0;i<=3;i++)
		{
		elementUtil.doActionsClick(ForwardButton);
		
		}
		return elementUtil.isElementDisplayed(LastScreen);
	}

	public boolean getpreviouscreen()
	{
		for(int i=0;i<=4;i++)
		{
			elementUtil.doActionsClick(PrevButton);
		
		}
		return elementUtil.isElementDisplayed(FirstPage);
	}
	
	public boolean getcall()
	{
		elementUtil.doClick(call);
		return elementUtil.isElementDisplayed(callglenelg);
	}
	
	public String getfblink()
	{
		elementUtil.doClick(fbicon);
		return elementUtil.getwindowhandles();
		
	}
	
	public String gettwitterlink()
	{
		elementUtil.doClick(Twittericon);
		return elementUtil.getwindowhandles();
	}
	
	public String getLinkedinlink()
	{
		
		
		elementUtil.doActionsClick(Linkedinicon);
		return elementUtil.getwindowhandles();
	}
	
	public String getServices()
	{
		elementUtil.doActionsClick(service);
		String title=elementUtil.waitForTitlePresent(Constants.Service_Service_Title, 30);
		return title;
		
	}
	
	public String getTeam()
	{
		elementUtil.doActionsClick(team);
		String title=elementUtil.waitForTitlePresent(Constants.Team_Page_Title, 30);
		return title;
		
	}
	public boolean getLocations()
	{
		
		elementUtil.doClick(location);
		

		return elementUtil.isElementDisplayed(headerLocation);
	}
	
	public String getcontact()
	{
		elementUtil.doActionsClick(contact);
		String title=elementUtil.waitForTitlePresent(Constants.Contact_PageTitle,20);
		return title;
	}
	
	
	public String getblog()
	{
		elementUtil.doActionsClick(blog);
		String title=elementUtil.waitForTitlePresent(Constants.Blog_Page_Title, 30);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return title;
	}
	public String getbloghome()
	{
		elementUtil.doActionsClick(bloghome);
		String title=elementUtil.waitForTitlePresent(Constants.Home_Page_Title,20);
		return title;
	
		}
	public ContactPage gotocontactpage()
	{
		getcontact();
		return new ContactPage(driver);
	}
	
	public TeamPage gototeampage()
	{
		getTeam();
		return new TeamPage(driver);
	}
	
	public LocationsPage gotolocation()
	{
		getLocations();
		return new LocationsPage(driver);
		
	}
	
	public GlenelgPage gotoglenelglocation()
	{
		getLocations();
		return new GlenelgPage(driver);
		
	}
	public DarlingtonPage gotodarlingtonlocation()
	{
		getLocations();
		return new DarlingtonPage(driver);
		
	}
	public ServicesPage gotoservicepage()
	{
		getServices();
		return new ServicesPage(driver);
	}
	
//	public GlenelgPage gotoglenel()
//	{
//		getglenelgservice();
//		return new GlenelgPage(driver);
//		
//	}
}
