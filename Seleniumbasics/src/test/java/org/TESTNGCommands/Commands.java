package org.TESTNGCommands;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.automationCore.Base;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Commands extends Base {
	@Test
	public void verifyHomePageTitle()
	{
		driver.get("https://demowebshop.tricentis.com");
		String actualtitle=driver.getTitle();
		//System.out.println("Title" +actualtitle);
		String Exceptedtitle="Demo Web Shop";
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
	boolean isCheckSelected;
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radiog=driver.findElement(By.xpath("//input[@id='gender-male']"));
		 isCheckSelected=radiog.isSelected();
		System.out.println("male gender before selection"+isCheckSelected);
		 radiog.click();
		 Assert.assertFalse(isCheckSelected);
		 isCheckSelected=radiog.isSelected();
			System.out.println("male gender after selection"+isCheckSelected);
			Assert.assertTrue(isCheckSelected);
					
}
@Test
public void verifyJavascript()
{
	driver.get("https://demowebshop.tricentis.com/");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("document.getElementById(\"newsletter-email\").value='p@gmail.com'");
	js.executeScript("document.getElementById(\"newsletter-subscribe-button\").click()");
	}
@Test

public void verifyScroll()
{
	driver.get("https://demowebshop.tricentis.com/");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	
}
@Test
public void verifyWaitCommands()
{
	driver.get("https://demoqa.com/alerts");
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//implicit wait
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));//explicit wait
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
	WebElement clickme=driver.findElement(By.xpath("//button[@id='alertButton']"));
	clickme.click();
	wait.until(ExpectedConditions.alertIsPresent());
	Alert alert=driver.switchTo().alert();
	alert.accept();
}
@Test
public void verifyFluentWait()
{
	driver.get("https://demoqa.com/alerts");
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("window.scrollBy(0,1000)");
	WebElement clickme=driver.findElement(By.xpath("//button[@id='alertButton']"));
	FluentWait fluentwait=new FluentWait(driver);
	fluentwait.withTimeout(Duration.ofSeconds(20));
	fluentwait.pollingEvery(Duration.ofSeconds(20));
	fluentwait.ignoring(NoSuchElementException.class);
	clickme.click();
	fluentwait.until(ExpectedConditions.alertIsPresent());
	Alert alert=driver.switchTo().alert();
	alert.accept();
}}

