package NavigationComments;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Commends {
	//To verify swag labs login
	
	public void verifyswaglabslogin()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		WebElement usernameField=driver.findElement(By.id("user-name"));
		usernameField.sendKeys("standard_user");
		WebElement password=driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
		WebElement login=driver.findElement(By.id("login-button"));
		login.click();
	}
	public static void main(String[] args) {
		Commends c=new Commends();
		c.verifyswaglabslogin();
	}}