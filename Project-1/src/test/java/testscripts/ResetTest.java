package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.org.Base;
import utilities.ExcelUtility;

public class ResetTest  extends Base {
	@Test
	
	
	public void errormessagewithInvalidEmailid()
	{
		WebElement forgetpasswordlink=driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgetpasswordlink.click();
		
		String emailId= ExcelUtility.getStringData(0, 0,"ResetTest");
		String errormessage=ExcelUtility.getStringData(0, 1, "ResetTest");
		WebElement femail=driver.findElement(By.xpath("//input[@id='email']"));
		femail.sendKeys(emailId);
		WebElement submit=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit.click();
		
		WebElement actualerror=driver.findElement(By.xpath("//span[@class='help-block']//strong"));
		String actualerrormsg=actualerror.getText();
		Assert.assertEquals(actualerrormsg,errormessage,"Invalid RESET Credentials" );
		
}
	@Test
	
	public void passwordResetwithValidEmailid()
	{
		WebElement forgetpasswordlink=driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		forgetpasswordlink.click();
		
		String emailId= ExcelUtility.getStringData(1, 0,"Reset");
		String errormessage=ExcelUtility.getStringData(1, 1, "Reset");
		WebElement femail=driver.findElement(By.xpath("//input[@id='email']"));
		femail.sendKeys(emailId);
		WebElement submit=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		submit.click();
		
	}
}
