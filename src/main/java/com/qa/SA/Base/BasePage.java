package com.qa.SA.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {
	
	WebDriver driver;
	
	public WebDriver init_driver(String browserName)
	{
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equals("ff"))
		
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else
		{
			System.out.println("Browser not found"+browserName);
		}
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		return driver;
	}
	
	public Properties init_properties()
	{
		Properties prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("D:\\selenium\\eclipse\\eclipse\\SAPhysiotherapy2020\\src\\main\\java\\com\\qa\\SA\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return prop;
	}
}
