package com.qa.SA.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;

	public ElementUtil(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public WebElement getElement(By locator)
	{
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		}catch(Exception e)
		{
			System.out.println("some exception occured while creating the webelement");
			System.out.println(e.getMessage());
		}
		return element;
		
	}
	
	public void doCalendarselect(By locator,String value)
	{
		List<WebElement> dates = driver.findElements(locator);
		
		int  total =dates.size();
		for(int i=0;i<=total;i++)
		{
			String date= dates.get(i).getText();
			if(date.equalsIgnoreCase(value))
			{
				dates.get(i).click();
				break;
			}
		}
	}
	
	public void waitForElementPresent(By locator,int timeout)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
		}
	
	public String waitForTitlePresent(String title,int timeout) {
		WebDriverWait wait = new WebDriverWait(driver,timeout);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	public void domovetoelement(By locator)
	{
		WebElement e =getElement(locator);
		Actions action = new Actions(driver);
		action.moveToElement(e).build().perform();
		
	}
	
	public void doClick(By locator)
	{
		try
		{
			getElement(locator).click();
		}catch(Exception e)
		{
			System.out.println("Some Exception occured while clicking the webelement");
			System.out.println(e.getMessage());
		}
		
	}
	public void doActionsClick(By locator)
	{
		try {
			Actions action = new Actions(driver);
			action.click(getElement(locator)).build().perform();
		//	action.moveToElement((WebElement) locator);

		}catch(Exception e) {
			System.out.println("some exception occured while clicking on the webelement");
			System.out.println(e.getMessage());
		}
	}
	
	
	
		public void doSendKeys(By locator,String value)
		{
			try {
				getElement(locator).sendKeys(value);
			}catch(Exception e)
			{
				System.out.println("some exception occured while passing value to the webelement");
				System.out.println(e.getMessage());
			}
		}
		
		public void doActionsSendKeys(By locator,String value)
		{
			try
			{
				Actions action = new Actions(driver);
				action.sendKeys(getElement(locator),value).build().perform();
			}catch(Exception e)
			{
				System.out.println("some exception occured while passing value to the webelement");
				System.out.println(e.getMessage());
			}
		}
		public String doGetText(By locator)
		{
			try
			{
				return getElement(locator).getText();
			}catch(Exception e)
			{
				System.out.println("some exception occured while getting text of the webelement");
				System.out.println(e.getMessage());	
			
			}
			return null;
		}
		public boolean isElementDisplayed(By locator)
		{
			try 
			{
				getElement(locator).isDisplayed();
				return true;
			}catch(Exception e)
			{
				System.out.println("some exception occured while checking the element is displayed");
				System.out.println(e.getMessage());	
			}
				return false;
			
		}
		
		public String getwindowhandles() {
			Set<String> handles= driver.getWindowHandles();
			Iterator<String> it =handles.iterator();
			String parent=it.next();
			String child=it.next();
			driver.switchTo().window(child);
			String title=driver.getTitle();
			System.out.println("Title" +title);
			driver.close();
			driver.switchTo().window(parent);
			return title;
			
			
		}
		
		public void getnavigateback()
		{
			driver.navigate().back();
		}
		
}
		
	
	

