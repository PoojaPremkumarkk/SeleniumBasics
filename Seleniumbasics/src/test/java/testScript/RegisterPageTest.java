package testScript;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.automationCore.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import utilities.RandomDataUtility;

public class RegisterPageTest extends Base{
	@Test
	public void userRegistration()
	{
		//java faker example
		driver.get("https://demowebshop.tricentis.com/register");
		String firstname=RandomDataUtility.getFirstName();
		String lastname=RandomDataUtility.getLastName();
		String emailid=firstname+"."+lastname+"@yahoo.com";
		String password=firstname+"."+"@"+lastname;
		
		
		WebElement first=driver.findElement(By.xpath("//input[@id='FirstName']"));
		first.sendKeys(firstname);
		WebElement last=driver.findElement(By.xpath("//input[@id='LastName']"));
		last.sendKeys(lastname);
		
		WebElement email=driver.findElement(By.xpath("//input[@id='Email']"));
		email.sendKeys(emailid);
		WebElement vpassword=driver.findElement(By.xpath("//input[@id='Password']"));
		vpassword.sendKeys(password);
		WebElement cpassword=driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
		cpassword.sendKeys(password);
		WebElement radiog=driver.findElement(By.xpath("//input[@id='gender-male']"));
		 Boolean isButtonSelected=radiog.isSelected();
		System.out.println("male gender before selection"+isButtonSelected);
		 radiog.click();
		 isButtonSelected=radiog.isSelected();
			System.out.println("male gender after selection"+isButtonSelected);
			//AssertJUnit.assertEquals(isButtonSelected, true);
			WebElement register=driver.findElement(By.xpath("//input[@id='register-button']"));
			register.click();
			
			
		
	}

}
