package automation.org;



	import java.io.File;
	import java.io.IOException;

	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.ITest;
	import org.testng.ITestResult;
	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;

	public class Base {
		
		public WebDriver driver;
		//Initialize browser
		public void initializeBrowser(String browser)
		{
			if(browser.equals("Chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(browser.equals("Edge"))
			{
				driver=new EdgeDriver();
			}
			else if(browser.equals("firefox"))
			{
				driver=new FirefoxDriver();
			}
			else 
			{
				throw new RuntimeException("invalid Browser");
			}
			driver.manage().window().maximize();
		}
		
		@BeforeMethod
		
		public void setBrowser()
		{
			
			initializeBrowser("Chrome");
			
		}
		@AfterMethod
		
		public void closeBrowser(ITestResult result) throws IOException
		{
			if( result.getStatus()==ITestResult.FAILURE)
			{
				verifyTakeScreenshot(result);
			}
		
			
			
			driver.close();
		}
		public void verifyTakeScreenshot(ITestResult result) throws IOException
		{
			TakesScreenshot takesscreenshot=(TakesScreenshot)driver;
			File screenshot =takesscreenshot.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshot,new File("./Screenshots/" +result.getName()+".png"));//Create a screenshot folder and save
			
			
		}

	}



