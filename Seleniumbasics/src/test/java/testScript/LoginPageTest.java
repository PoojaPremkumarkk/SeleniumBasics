package testScript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.automationCore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import dataProvider.Dataproviders;
import utilities.ExcelUtility;

public class LoginPageTest extends Base{
	@Test(groups= {"Smoke","Sanity"})
	
	public void userLoginWithValidCredentials() throws IOException
	{
		driver.get("https://demowebshop.tricentis.com/login");
		
		String emailId= ExcelUtility.getStringData(0, 0,"LoginPageTest");
		String password=ExcelUtility.getStringData(0, 1, "LoginPageTest");
		
		WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys(emailId);
		WebElement password1=driver.findElement(By.xpath("//input[@id='Password']"));
		password1.sendKeys(password);
		WebElement login=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
		login.click();
		
		//WebElement validemail=driver.findElement(By.xpath("//a[text()='poojapremkumar@gmail.com']"));
		
		//Assert.assertTrue(validemail.isDisplayed(),"not displayed");
		
		
		
	}
//	@Test
//public void userLoginWithvalidEmailAndInvalidPassword()
//{
//	driver.get("https://demowebshop.tricentis.com/login");
//	WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
//	email.sendKeys("pooja@gmail.com");
//	WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
//	password.sendKeys("p");
//	WebElement login=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
//	login.click();
//	
//	WebElement validemail=driver.findElement(By.xpath("//a[text()='pooja@gmail.com']"));
//	
//	Assert.assertTrue(validemail.isDisplayed(),"not displayed");
//	
//}
	
	@Test(dataProvider="invalidUserCredentials", dataProviderClass=Dataproviders.class)
public void userLoginWithInvalidCredentials(String username,String password) throws IOException
{
	driver.get("https://demowebshop.tricentis.com/login");
	String errormessage=ExcelUtility.getStringData(0, 2, "LoginPageTest");
	WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
	email.sendKeys(username);
	WebElement password1=driver.findElement(By.xpath("//input[@id='Password']"));
	password1.sendKeys(password);
	WebElement login=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
	login.click();
	WebElement actualerror=driver.findElement(By.xpath("//div[@class='validation-summary-errors']//span"));
	String actualerrormsg=actualerror.getText();
	Assert.assertEquals(actualerrormsg,errormessage,"Invalid login message" );
	
	//WebElement validemail=driver.findElement(By.xpath("//div[@class='header-links'] //a[@class='account'] "));
	
	//Assert.assertTrue(validemail.isDisplayed(),"not displayed");
	
}
//	//@Test
////public void userLoginWithInvalidEmailAndInvalidPassword()
////{
//	driver.get("https://demowebshop.tricentis.com/login");
//	WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
//	email.sendKeys("poo@gmail.com");
//	WebElement password=driver.findElement(By.xpath("//input[@id='Password']"));
//	password.sendKeys("po123");
//	WebElement login=driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
//	login.click();
//	
//	WebElement validemail=driver.findElement(By.xpath("//a[text()='pooja@gmail.com']"));
//	
//	Assert.assertTrue(validemail.isDisplayed(),"not displayed");
//	
//	
}

