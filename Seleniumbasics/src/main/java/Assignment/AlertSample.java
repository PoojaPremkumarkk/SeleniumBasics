package Assignment;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertSample {
	public void simpleAlert()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement single=driver.findElement(By.xpath("//button[@id='alertButton']"));
		single.click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	
	public void confirmAlert()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement confirm=driver.findElement(By.xpath("//button[@id='confirmButton']"));
		confirm.click();
		Alert confirmationalert=driver.switchTo().alert();
		confirmationalert.getText();
		System.out.println("Alert text: " + confirmationalert.getText());
		confirmationalert.accept();
	}
	public void promptAlert()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/alerts");
		WebElement prompt=driver.findElement(By.xpath("//button[@id='promtButton']"));
		prompt.click();
		Alert promptalert1=driver.switchTo().alert();
		promptalert1.sendKeys("hello");
		promptalert1.accept();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AlertSample a=new AlertSample();
		//a.simpleAlert();
		//a.confirmAlert();
		a.promptAlert();

	}

}
