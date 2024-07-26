package Assignment;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class Assign {
	public void multipleWindowHandling()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://webdriveruniversity.com/");
		WebElement contact1=driver.findElement(By.xpath("//h1[text()='CONTACT US']"));
		contact1.click();
		WebElement login1=driver.findElement(By.xpath("//h1[text()='LOGIN PORTAL']"));
		login1.click();
		String parent=driver.getWindowHandle();
		System.out.println("parent " +parent);
		Set<String> allwindows=driver.getWindowHandles();
		for(String temp:allwindows)
		{
			System.out.print("windows" +temp);
			driver.switchTo().window(temp);
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println("********************************");
		}
	}
	public void verifyDynamicWebTable()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/indices/nse");
		WebElement showmore=driver.findElement(By.xpath("//a[@id='showMoreLess']"));
		showmore.click();
		WebElement fulltable=driver.findElement(By.xpath("//table[@id='dataTable']"));
		//System.out.println(fulltable.getText());
		WebElement tablerow=driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[5]"));
		//System.out.println(tablerow.getText());
		List<WebElement> rows=fulltable.findElements(By.tagName("tr"));
		int rowsize=rows.size();
		for(int i=0;i<rowsize;i++)
		{
			List<WebElement> columns=rows.get(i).findElements(By.tagName("td"));
			int columnsize=columns.size();
			for(int j=0;j<columnsize;j++)
			{
				String cellData=columns.get(j).getText();
				if(cellData.equals("NIFTY BANK"));
				System.out.println("Prev Close value is"+columns.get(1).getText());
			}
			
		;
	}
	driver.close();
}
	
	public void verifyDragAndDrop()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://selenium.qabible.in/drag-drop.php");
		WebElement drag=driver.findElement(By.xpath("//span[text()='Draggable n°1']"));
		WebElement drop=driver.findElement(By.xpath("//div[@id='mydropzone']"));
		Actions action=new Actions(driver);
		action.moveToElement(drag).build().perform();
		action.click(drag).build().perform();
		action.contextClick(drag).build().perform();
		action.dragAndDrop(drag, drop).build().perform();
		}
	public void frames()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/guru99home/");
		
		WebElement iframe=driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
		driver.switchTo().frame(iframe);
		WebElement img=driver.findElement(By.xpath("//img[@src='Jmeter720.png']"));
		img.click();
	}
	
	
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
	public void verifyRightclick()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement rightclick=driver.findElement(By.xpath("//span[text()='right click me']"));
		Actions act=new Actions(driver);
		act.contextClick(rightclick).build().perform();
		
		
	}
	public void verifyDoubleClick()
	{

		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		WebElement doubleclick=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		Actions act=new Actions(driver);
		act.doubleClick(doubleclick).build().perform();
		Alert alert=driver.switchTo().alert();
		alert.accept();
				
	}
	
	public void verifyMouseHover()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/menu/");
		WebElement menuitem2=driver.findElement(By.xpath("//a[text()='Main Item 2']"));
		WebElement sublistmenu=driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));
		Actions action=new Actions(driver);
		action.moveToElement(menuitem2).moveToElement(sublistmenu).build().perform();
		driver.close();
		}
	

	public static void main(String[] args) {
		Assign a=new Assign();
		a.verifyDynamicWebTable();
		//a.multipleWindowHandling();
		//a.frames();
		//a.simpleformdemo();
		//a.checkboxdemo();
		//a.radioButtondemo();
		//a.selectinput();
		//a.verifyRightclick();
		//a.verifyDoubleClick();
		//a.verifyMouseHover();
		//a.verifyDragAndDrop();

	}

}
