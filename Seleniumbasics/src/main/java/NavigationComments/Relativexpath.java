package NavigationComments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Relativexpath {
	public void verifyregisterxpath()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement genderfemale=driver.findElement(By.xpath("//input[@id='gender-female' and @name='Gender']"));
		genderfemale.click();
		WebElement Firstname=driver.findElement(By.xpath("//input[@id='FirstName']"));
		Firstname.sendKeys("pooja");
		WebElement Lastname=driver.findElement(By.xpath("//input[contains(@id,'LastName')]"));
		Lastname.sendKeys("premkumar");
		WebElement email=driver.findElement(By.xpath("//input[contains(@id,'Email')]"));
		email.sendKeys("poojaprem@gmail.com");
		WebElement password=driver.findElement(By.xpath("//input[starts-with(@id,'Password')]"));
		password.sendKeys("pooja123");
		WebElement confirmpassword=driver.findElement(By.xpath("//input[starts-with(@id,'ConfirmPassword')]"));
		confirmpassword.sendKeys("pooja123");
		WebElement submit=driver.findElement(By.xpath("//input[contains(@id,'register-button')]"));
		submit.click();
		
		//driver.close();
	}

	public static void main(String[] args) {
		
		Relativexpath x=new Relativexpath();
		x.verifyregisterxpath();
		

	}

}
