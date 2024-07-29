package org.automationCore;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Base {
	
	public WebDriver driver;
	//Initialize browser
	public void initializeBrowser(String browser)
	{
		if(browser.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else 
		{
			throw new RuntimeException("invalid Browser");
		}
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	
	public void setBrowser()
	{
		initializeBrowser("Chrome");
		
	}
	@AfterMethod
	
	public void closeBrowser()
	{
		driver.close();
	}

}
