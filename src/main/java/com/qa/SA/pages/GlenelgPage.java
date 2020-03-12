package com.qa.SA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.SA.util.Constants;
import com.qa.SA.util.ElementUtil;

public class GlenelgPage {
	WebDriver driver;
	ElementUtil elementUtil;
	By glenelgbutton=By.xpath("//body/div[@class='site-wrapper']/section[@class='pt100 pb70']/div[@class='container']/div[@class='row']/div[2]/a[1]/div[1]");
	By glenelgbook= By.xpath("//a[text()='BOOK NOW']");
	By textdisplay=By.xpath("Get To Know Us");
	By backbutton= By.xpath("//a[@class='btn btn-primary btn-xs']");
	public GlenelgPage(WebDriver driver)

	{
		this.driver= driver;
		elementUtil= new ElementUtil(driver);
		elementUtil.waitForTitlePresent(Constants.Glenelg_Title,20);
		
	}
	
	public String getglenelg()
	{
		elementUtil.doActionsClick(glenelgbutton);
		String title = elementUtil.waitForTitlePresent(Constants.Glenelg_Page_title,20);
		return title;
		
	}
	public boolean bookbutton()
	{
		
		elementUtil.doActionsClick(glenelgbook);
		return elementUtil.isElementDisplayed(backbutton);
		
		}
	public String homebutton()
	{
		elementUtil.doActionsClick(backbutton);
		String title=elementUtil.waitForTitlePresent(Constants.Home_Page_Title,20);
		return title;
		
	}
	
	}
