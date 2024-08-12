package testScript;

import org.automationCore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageScript extends Base{
	
@Test


	public void verifyHomePageTitle()
	{
		
	driver.get("https://demowebshop.tricentis.com/");
	String title=driver.getTitle();
	Assert.assertEquals(title,"Demo Web Shop");
	}
@Test
public void verifyCommunityPollSelection()
{
	driver.get("https://demowebshop.tricentis.com/");
	WebElement Excellent=driver.findElement(By.xpath("//label[text()='Excellent']"));
	WebElement Good=driver.findElement(By.xpath("//label[text()='Good']"));
	WebElement Poor=driver.findElement(By.xpath("//label[text()='Poor']"));
	
	Excellent.click();
	Assert.assertFalse(Excellent.isSelected(), "Excellent is not selected");
}

}
