package testscripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import automation.org.Base;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base{
	@Test
	
	public void homePageTest()
	{
		LoginPage login = new LoginPage(driver);
        String username = ExcelUtility.getStringData(0, 0, "LoginTest");
        String password = ExcelUtility.getIntegerData(0, 1, "LoginTest"); 

        login.enterUserName(username);
        login.enterPassword(password);
        HomePage home = login.clickOnLoginButton();
        home.clickEndTour();
        home.clickHomeMenu();
        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //WebElement signOutButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Sign Out']")));

        //signOutButton.click();
        home.clickLogout();
	}
	
	}

