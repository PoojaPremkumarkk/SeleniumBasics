package testscripts;


		
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.testng.Assert;
		import org.testng.annotations.Test;

import automation.org.Base;
import constants.Constants;
import constants.Messages;
import dataprovider.DataProviders;
import pageObjects.HomePage;
		import pageObjects.LoginPage;
		import utilities.ExcelUtility;

		public class LoginTest extends Base {

		    @Test
		    public void userLoginWithValidCredentials() {
		        // Retrieve data from Excel
		        String emailId = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		        String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGINPAGE); 
		        String expectedLoginName = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);

		        // Perform login actions
		        LoginPage login = new LoginPage(driver);
		        login.enterUserName(emailId);
		        login.enterPassword(password);

		        // Click login button and navigate to home page
		        HomePage home = login.clickOnLoginButton();

		        // Retrieve the actual login text
		        String actualText = home.getLoginText();

		        // Assert the expected vs actual login text
		        Assert.assertEquals(actualText, expectedLoginName,Messages.LOGINNAMEMISMATCH);
		    }

		    @Test
		    public void errorMessageWithInvalidCredentials()
		    {
		        // Retrieve expected error message from Excel
		        String expectedErrorMessage = ExcelUtility.getStringData(0, 2,Constants.LOGINPAGE);

		        // Perform login actions with invalid credentials
		        LoginPage login = new LoginPage(driver);
		        String username = ExcelUtility.getStringData(1, 0, Constants.LOGINPAGE);
		        String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGINPAGE); 
		        login.enterUserName(username);
		        login.enterPassword(password);
		        login.clickOnLoginButton();
		        String actualErrorMessage =login.getActualErrorMessageText();

		       // Assert the expected vs actual error message
		        Assert.assertEquals(actualErrorMessage, expectedErrorMessage,Messages.INVALIDCREDS);
		    }
		}

			