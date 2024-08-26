package testscripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation.org.Base;
import pageObjects.LoginPage;
import pageObjects.ResetPage;
import utilities.ExcelUtility;

public class ResetTest  extends Base {
	@Test
	
	
	public void errormessagewithInvalidEmailid()
	{
		//WebElement forgetpasswordlink=driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		//forgetpasswordlink.click();
		ResetPage reset=new ResetPage(driver);
		reset.clickResetLink();
		String emailId= ExcelUtility.getStringData(0, 0,"ResetTest");
		String errormessage=ExcelUtility.getStringData(0, 1, "ResetTest");
		reset.enterEmail(emailId);
		reset.clickSubmit();
		String actualerrormsg=reset.getErrorMessage();
		
		Assert.assertEquals(actualerrormsg,errormessage,"Invalid RESET Credentials" );
		
}
	@Test
	
	public void passwordResetwithValidEmailid()
	{
		//WebElement forgetpasswordlink=driver.findElement(By.xpath("//a[@class='btn btn-link']"));
		//forgetpasswordlink.click();
		
		ResetPage reset=new ResetPage(driver);
		reset.clickResetLink();
		String emailId= ExcelUtility.getStringData(1, 0,"ResetTest");
		reset.enterEmail(emailId);
		reset.clickSubmit();
		String expectedSuccessMessage = ExcelUtility.getStringData(0, 2, "ResetTest");
		String actualSuccessMessage=reset.getSuccessMessage();
		
		assertEquals("We have e-mailed your password reset link!", expectedSuccessMessage, actualSuccessMessage);
		
	}
}
