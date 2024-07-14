package NavigationComments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Example {
	public void demowebshop()
	{
		
	
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://demowebshop.tricentis.com/");
	WebElement register=driver.findElement(By.className("ico-register"));
	register.click();
	//register details
	WebElement firstname=driver.findElement(By.id("FirstName"));
	firstname.sendKeys("pooja");
	WebElement lastname=driver.findElement(By.id("LastName"));
	lastname.sendKeys("premkumar");
	WebElement email=driver.findElement(By.id("Email"));
	email.sendKeys("pooja@gmail.com");
	//password
	WebElement password=driver.findElement(By.id("Password"));
	password.sendKeys("pooja123");
	WebElement confirmpassword=driver.findElement(By.id("ConfirmPassword"));
	confirmpassword.sendKeys("pooja123");
	WebElement submitregister=driver.findElement(By.id("register-button"));
	submitregister.click();
	
	// Navigate to login page
	
	driver.navigate().to("https://demowebshop.tricentis.com/login");
	
WebElement loginemail=driver.findElement(By.id("Email"));
loginemail.sendKeys("pooja@gmail.com");
WebElement loginpassword=driver.findElement(By.id("Password"));
loginpassword.sendKeys("pooja123");
WebElement login=driver.findElement(By.className("login-button"));
login.click();
}
	public static void main(String[] args) {
		Example e =new Example();
		e.demowebshop();
	}
	}
	