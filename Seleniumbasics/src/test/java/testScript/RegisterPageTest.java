package testScript;

import org.automationCore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterPageTest extends Base{
	@Test
	public void userRegistration()
	{
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radiog=driver.findElement(By.xpath("//input[@id='gender-male']"));
		 Boolean isButtonSelected=radiog.isSelected();
		System.out.println("male gender before selection"+isButtonSelected);
		 radiog.click();
		 isButtonSelected=radiog.isSelected();
			System.out.println("male gender after selection"+isButtonSelected);
			Assert.assertEquals(isButtonSelected, true, "The male gender radio button should be selected after clicking.");
			
			
		
	}

}
