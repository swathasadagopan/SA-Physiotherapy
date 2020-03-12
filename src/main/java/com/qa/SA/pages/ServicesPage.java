package com.qa.SA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.SA.Base.BasePage;
import com.qa.SA.util.Constants;
import com.qa.SA.util.ElementUtil;

public class ServicesPage extends BasePage{
	
	WebDriver driver;
	ElementUtil elementUtil;
	
	By services = By.xpath("//a[text()='Services']");
	By condition = By.xpath("//a[contains(text(),'Conditions')]");
	By modal = By.xpath("//a[contains(@href, 'Modalities.html')]");
	By modalmanual = By.cssSelector(".photography:nth-child(1) img");
	By modaltitle= By.xpath("//h2[text()='MODALITIES']");
	By musculoservice = By.xpath("//h4[text()='MUSCULOSKELETAL INJURIES']");
	By musculopara= By.xpath("//img[@class='mfp-img']");
	By womenhealth = By.xpath("//h4[text()=\"WOMEN'S HEALTH\"]");
	By servicetitle = By.xpath("//h2[text()=' SERVICES ']");
	By imageclose= By.xpath("//button[@class='mfp-close']");
	By sports = By.xpath("//h4[text()='SPORTS INJURIES']");
	By mainservice = By.xpath("//a[contains(text(),'Our Services')]");
	By conditions= By.xpath("//*[@id=\"navbar\"]/div/ul/li[2]/ul/li/div/div/ul/li[2]/a]");
	By conditiontitle=By.xpath("//h2[text()='CONDITIONS']");
	By condheadache = By.xpath("/html/body/div[1]/section/div/div/ul/li[1]/a/div/img");
	By imgheadclick = By.cssSelector(".mfp-img");
	
	
	public ServicesPage(WebDriver driver)
	{
		this.driver = driver;
		 elementUtil = new ElementUtil(driver);
		 elementUtil.waitForTitlePresent(Constants.Services_Page_Title,20);
	}
	
	public String getservicepagetitle()
	{
		String title =elementUtil.waitForTitlePresent(Constants.Services_Page_Title,20);
		return title;
		
	}

	public boolean getservices() throws InterruptedException
	{
		elementUtil.doActionsClick(musculoservice);
		for(int i=0;i<=10;i++)
		{
			Thread.sleep(500);
			elementUtil.doClick(musculopara);
			
		} 
		elementUtil.doClick(imageclose);
		
		elementUtil.doActionsClick(mainservice);
		return elementUtil.isElementDisplayed(conditions);
		//elementUtil.doActionsClick(conditions);
	}
	
	public String getcondition() throws InterruptedException
	{
		elementUtil.domovetoelement(mainservice);
		elementUtil.waitForElementPresent(condition, 20);
		elementUtil.domovetoelement(condition);
		elementUtil.doClick(condition);
		elementUtil.doActionsClick(condheadache);
		for(int i= 0;i<=11;i++)
		{
			Thread.sleep(500);
			elementUtil.doActionsClick(imgheadclick);
		}
		elementUtil.doClick(imageclose);
		String title= elementUtil.doGetText(conditiontitle);
		return title;
		
	}
	
	public String getModalities() throws InterruptedException
	{
		
		elementUtil.domovetoelement(mainservice);
		elementUtil.waitForElementPresent(modal, 20);
		elementUtil.domovetoelement(modal);
		elementUtil.doClick(modal);
		elementUtil.doActionsClick(modalmanual);
		for(int i= 0;i<=10;i++)
		{
			Thread.sleep(1000);
			elementUtil.doActionsClick(imgheadclick);
		}
		elementUtil.doClick(imageclose);
		String title= elementUtil.doGetText(modaltitle);
		return title;
	}
	
}
