package Assignment;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
public class Assign {
	public void simpleformdemo()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/simple-form-demo.php");
		WebElement message=driver.findElement(By.xpath("//input[@id='single-input-field']"));
		message.sendKeys("Hello message");
		WebElement button1=driver.findElement(By.xpath("//button[@id='button-one']"));
		button1.click();
		WebElement value1=driver.findElement(By.xpath("//input[@id='value-a']"));
		value1.sendKeys("3");
		WebElement value2=driver.findElement(By.xpath("//input[@id='value-b']"));
		value2.sendKeys("5");
		WebElement submit=driver.findElement(By.xpath("//button[@id='button-two']"));
		submit.click();
		}
	public void checkboxdemo()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/check-box-demo.php");
		WebElement check1=driver.findElement(By.xpath("//input[@id='gridCheck']"));
		check1.click();
		boolean isCheckboxDisplayed=check1.isDisplayed();
		System.out.println("before displayed"+isCheckboxDisplayed);
		isCheckboxDisplayed=check1.isDisplayed();
		System.out.println("after displayed"+ isCheckboxDisplayed);
		WebElement selectall=driver.findElement(By.xpath("//input[@id='button-two']"));
		selectall.click();
		//driver.quit();
	}
	public void radioButtondemo()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/radio-button-demo.php");
		WebElement radio=driver.findElement(By.xpath("//input[@id='inlineRadio1']"));
		radio.click();
		WebElement button1=driver.findElement(By.xpath("//button[@id='button-one']"));
		button1.click();
		WebElement patientgender=driver.findElement(By.xpath("//input[@id='inlineRadio21']"));
		patientgender.click();
		WebElement patientage=driver.findElement(By.xpath("//input[@id='inlineRadio24']"));
		patientage.click();
		WebElement result=driver.findElement(By.xpath("//button[@id='button-two']"));
		result.click();
	}
	
	public void selectinput()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/select-input.php");
		WebElement drop=driver.findElement(By.xpath("//select[@id='single-input-field']"));
		Select select=new Select(drop);
		WebElement getcolourname=select.getFirstSelectedOption();
		System.out.println(getcolourname.getText());
		
		select.selectByVisibleText("Red");
		
		List<WebElement> dropdownlist=select.getOptions();
		System.out.println("total number of values in dropdown list " +dropdownlist.size());
		
		WebElement multidrop=driver.findElement(By.xpath("//select[@id='multi-select-field']"));
		Select s=new Select(multidrop);
		s.selectByIndex(2);
		WebElement selectall=driver.findElement(By.xpath("//button[@id='button-all']"));
		selectall.click();
		
	}
	

	public static void main(String[] args) {
		Assign a=new Assign();
		//a.simpleformdemo();
		//a.checkboxdemo();
		//a.radioButtondemo();
		a.selectinput();
		

	}

}
