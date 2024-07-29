package org.TESTNGCommands;

import org.automationCore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Commands extends Base {
	@Test
	public void verifyHomePageTitle()
	{
		driver.get("https://demowebshop.tricentis.com/");
		String title=driver.getTitle();
		System.out.println("Title" +title);

		
		
}
	@Test
	public void demowebshop()
	{
		
	
	
	WebElement register=driver.findElement(By.className("ico-register"));
	register.click();
	//register details
	WebElement firstname=driver.findElement(By.id("FirstName"));
	firstname.sendKeys("pooja");
	WebElement lastname=driver.findElement(By.id("LastName"));
	lastname.sendKeys("premkumar");
	WebElement email=driver.findElement(By.id("Email"));
	email.sendKeys("pooja@gmail.com");
	//password
	WebElement password=driver.findElement(By.id("Password"));
	password.sendKeys("pooja123");
	WebElement confirmpassword=driver.findElement(By.id("ConfirmPassword"));
	confirmpassword.sendKeys("pooja123");
	WebElement submitregister=driver.findElement(By.id("register-button"));
	submitregister.click();
	
	
	
}}
