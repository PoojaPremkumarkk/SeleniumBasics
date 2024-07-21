package NavigationComments;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
	public void eselector(){
		boolean isButtonSelected;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com/register");
		WebElement radiog=driver.findElement(By.xpath("//input[@id='gender-male']"));
		 isButtonSelected=radiog.isSelected();
		System.out.println("male gender before selection"+isButtonSelected);
		 radiog.click();
		 isButtonSelected=radiog.isSelected();
			System.out.println("male gender after selection"+isButtonSelected);
	}
	
	public void verifyisenabled()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com");
		WebElement subscribe=driver.findElement(By.xpath("//input[contains(@id,'newsletter-subscribe-button')]"));
		boolean isButtonEnabled=subscribe.isEnabled();
		System.out.println(" before enabled"+isButtonEnabled);
		 subscribe.click();
		 isButtonEnabled=subscribe.isSelected();
			System.out.println(" after enabled"+isButtonEnabled);
	}
	public void verifyisdisplayed()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demowebshop.tricentis.com");
		WebElement vote=driver.findElement(By.xpath("//input[contains(@id,'vote-poll-1')]"));
		boolean isButtonDisplayed=vote.isDisplayed();
		System.out.println("before displayed"+isButtonDisplayed);
		vote.click();
		isButtonDisplayed=vote.isDisplayed();
		System.out.println("after displayed" +isButtonDisplayed);
	}
	
	public void verify_valuesfromdropdown()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement countdrop=driver.findElement(By.xpath("//select[@name='country']"));
		Select s=new Select(countdrop);
		//s.selectByIndex(2);
		WebElement getcountryname=s.getFirstSelectedOption();
		System.out.println(getcountryname.getText());
		
	}
	public void getTotalDropdownValues()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		WebElement dropdowncountry=driver.findElement(By.xpath("//select[@name='country']"));
		Select select=new Select(dropdowncountry);
		List<WebElement> dropdownlist=select.getOptions();
		System.out.println("total number of values in dropdown list " +dropdownlist.size());
		
		}
	
	public void verifySimpleAlert()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement clickmebutton=driver.findElement(By.xpath("//button[@id='alertButton']"));
		clickmebutton.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		driver.close();
	}
	
	public static void main(String[] args) {
		Commends c=new Commends();
		//c.verifyswaglabslogin();
		//c.eselector();
		//c.verifyisenabled();
		//c.verifyisdisplayed();
		//c.getTotalDropdownValues();
		c.verifySimpleAlert();
		//c.verify_valuesfromdropdown();
	}}