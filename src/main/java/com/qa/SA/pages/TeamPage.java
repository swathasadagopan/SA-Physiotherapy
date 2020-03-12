package com.qa.SA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.qa.SA.util.ElementUtil;

public class TeamPage {
	WebDriver driver;
	ElementUtil elementUtil;
	By modbury= By.xpath("//section[@id='pt130 pb100']//div[@class='container']//div[2]//div[1]//div[1]//div[1]//a[1]");
	By clinicteam= By.xpath("//h4[text()='Our Clinical Team']");
	By darlingtonteam=By.xpath("//div[8]//div[1]//div[1]//div[1]//a[1]");
	By shanontext= By.xpath("//h4[contains(text(),'Shannon Kaye')]");
	By darlingtontext= By.xpath("//div[@class='row text-center']//div[@class='row text-center']//p[@class='subheading underline-left'][contains(text(),'Darlington')]");
	By block = By.xpath("//img[@class='mfp-img']");
	By close=By.xpath("//button[@class='mfp-close']");
	
	
	public TeamPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
		//elementUtil.waitForTitlePresent(Constants.Contact_PageTitle,15);
	}
	
	public String getmodburydoctor() throws InterruptedException
	{
		//Actions action = new Actions(driver);
		//WebElement e = driver.findElement(modbury);
		//action.moveToElement(e).build().perform();
		elementUtil.domovetoelement(modbury);
		elementUtil.doActionsClick(modbury);
		String title = elementUtil.doGetText(clinicteam);
		for( int i=0;i<=11;i++)
		{
			Thread.sleep(500);
		
			elementUtil.doActionsClick(block);
		}
		elementUtil.doActionsClick(close);
		return title;
		}
	
	public String getdarlingtonteam()
	{
		elementUtil.domovetoelement(darlingtonteam);

		elementUtil.doActionsClick(darlingtonteam);
		String title = elementUtil.doGetText(darlingtontext);
		return title;
	}
}
