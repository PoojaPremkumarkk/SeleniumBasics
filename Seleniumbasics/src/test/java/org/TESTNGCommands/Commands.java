package org.TESTNGCommands;

import org.automationCore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Commands extends Base {
	@Test
	public void verifyHomePageTitle()
	{
		driver.get("https://demowebshop.tricentis.com");
		String actualtitle=driver.getTitle();
		//System.out.println("Title" +actualtitle);
		String Exceptedtitle="demo Web Shop";
		Assert.assertEquals(actualtitle, Exceptedtitle, "Title mismatch");

		
		
}
	@Test
	
		public void demowebshop() {
		    
		    // Login email
		    
		    
		    driver.navigate().to("https://demowebshop.tricentis.com/login");
			
		    WebElement loginemail=driver.findElement(By.id("Email"));
		    loginemail.sendKeys("pooja@gmail.com");
		    WebElement loginpassword=driver.findElement(By.id("Password"));
		    loginpassword.sendKeys("pooja123");
		    WebElement login=driver.findElement(By.className("login-button"));
		    login.click();
		    
		    

		    String expectedEmail = "pooja@gmail.com";
		    WebElement emailid=driver.findElement(By.xpath("//a[text()='pooja@gmail.com']"));
		    String actualEmail=emailid.getText();

		    // Assertion
		    Assert.assertEquals(actualEmail, expectedEmail, "Email id mismatch");
		}
	@Test
	
	public void swagLabs()
	{
		driver.get("https://www.saucedemo.com/");
		WebElement username=driver.findElement(By.xpath("//input[@id='user-name']"));
		username.sendKeys("standard_user");
		WebElement pass=driver.findElement(By.xpath("//input[@id='password']"));
		pass.sendKeys("secret_sauce");
		WebElement login=driver.findElement(By.xpath("//input[@id='login-button']"));
		login.click();
		String exceptedapplogo="Swag Labs";
	WebElement actualapplogo=driver.findElement(By.xpath("//div[text()='Swag Labs']"));
	String actualr=actualapplogo.getText();
	Assert.assertEquals(actualr, exceptedapplogo, "This is not correct app logo");
	}
	
@Test
public void verifyDemoworkshop()
{
	driver.get("https://demowebshop.tricentis.com/register");
	WebElement check1=driver.findElement(By.xpath("//input[@id='gender-male']"));
	boolean isCheckboxSelected=check1.isSelected();
	//Assert.assertFalse(isCheckboxSelected, "check1 is selected");
	Assert.assertTrue(isCheckboxSelected, "check1 is not selected");
}
}

