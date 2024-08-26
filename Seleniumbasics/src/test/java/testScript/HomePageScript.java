package testScript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.automationCore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import listeners.RetryAnalyser;

public class HomePageScript extends Base{
	
//@Test(retryAnalyzer=RetryAnalyser.class)
	@Test(groups="Sanity")


	public void verifyHomePageTitle()
	{
		
	driver.get("https://demowebshop.tricentis.com/");
	String title=driver.getTitle();
	AssertJUnit.assertEquals(title,"Demo Web Shop");
	
	}
@Test(groups="Smoke")
public void verifyCommunityPollSelection()
{
	driver.get("https://demowebshop.tricentis.com/");
	WebElement Excellent=driver.findElement(By.xpath("//label[text()='Excellent']"));
	WebElement Good=driver.findElement(By.xpath("//label[text()='Good']"));
	WebElement Poor=driver.findElement(By.xpath("//label[text()='Poor']"));
	
	Excellent.click();
	//AssertJUnit.assertFalse(Excellent.isSelected(), "Excellent is not selected");
}

}
