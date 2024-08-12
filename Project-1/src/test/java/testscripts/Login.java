package testscripts;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation.org.Base;
import dataprovider.DataProviders;
import utilities.ExcelUtility;

	public class Login extends Base{
		@Test
		
		public void userLoginWithValidCredentials() throws IOException
		{
			driver.get("https://qalegend.com/billing/public/home");
			
			String emailId= ExcelUtility.getStringData(0, 0,"Login");
			String password=ExcelUtility.getStringData(0, 1, "Login");
			
			WebElement email=driver.findElement(By.xpath("//input[@id='username']"));
			email.sendKeys(emailId);
			WebElement password1=driver.findElement(By.xpath("//input[@id='Password']"));
			password1.sendKeys(password);
			WebElement login=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
			login.click();
			
}
		@Test(dataProvider="invalidUserCredentials", dataProviderClass=DataProviders.class)
		public void userLoginWithInvalidCredentials(String username,String password) throws IOException
		{
			driver.get("https://qalegend.com/billing/public/home");
			String errormessage=ExcelUtility.getStringData(0, 2, "Login");
			WebElement email=driver.findElement(By.xpath("//input[@id='username']"));
			email.sendKeys(username);
			WebElement password1=driver.findElement(By.xpath("//input[@id='Password']"));
			password1.sendKeys(password);
			WebElement login=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
			login.click();
			WebElement actualerror=driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']"));
			String actualerrormsg=actualerror.getText();
			Assert.assertEquals(actualerrormsg,errormessage,"Invalid login credentials" );
		}}
