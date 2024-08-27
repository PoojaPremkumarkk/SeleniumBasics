package testscripts;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation.org.Base;
import constants.Constants;
import constants.Messages;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base{
	@Test
	
	public void homePageTest()
	{
		LoginPage login = new LoginPage(driver);
        String username = ExcelUtility.getStringData(3, 0,Constants.USERPAGE);
        String password = ExcelUtility.getIntegerData(1, 2,Constants.USERPAGE); 

        login.enterUserName(username);
        login.enterPassword(password);
        HomePage home = login.clickOnLoginButton();
        home.clickEndTour();
        home.clickHomeMenu();
        home.clickLogout();
        Assert.assertTrue(login.isLoginPageDisplayed(),Messages.LOGINPAGEDISPLAYERRORMESSSAGE);
	}
	
	}

