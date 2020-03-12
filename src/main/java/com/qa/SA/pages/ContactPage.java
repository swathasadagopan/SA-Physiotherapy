package com.qa.SA.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.SA.util.Constants;
import com.qa.SA.util.ElementUtil;

public class ContactPage {
	WebDriver driver;
	ElementUtil elementUtil;
	
	By name = By.xpath("//input[@id='name']");
	By mail = By.id("email");
	By subject = By.id("subject");
	By comments = By.id("comments");
	
	public ContactPage(WebDriver driver) {
		this.driver= driver;
		elementUtil = new ElementUtil(driver);
		//elementUtil.waitForTitlePresent(Constants.Contact_PageTitle,15);
	}

	public void feedbackform(String names, String mails, String subjects, String message)
	{
		
		elementUtil.waitForElementPresent(name, 20);
		elementUtil.doActionsSendKeys(name,names);
		
		elementUtil.doActionsSendKeys(mail, mails);
		
		elementUtil.doActionsSendKeys(subject, subjects);
		
		elementUtil.doActionsSendKeys(comments, message);
		
	}

	
	}
	

