package testscripts;

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
		  String emailId = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		  String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGINPAGE); 
		  String expectedLoginName = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
          LoginPage login = new LoginPage(driver);
		  login.enterUserName(emailId);
		  login.enterPassword(password);
		  HomePage home = login.clickOnLoginButton();
		  String actualText = home.getLoginText();
		  Assert.assertEquals(actualText, expectedLoginName,Messages.LOGINNAMEMISMATCH);
		      }
   @Test(dataProvider = "invalidUserCredentials", dataProviderClass = DataProviders.class)
			public void errorMessageWithInvalidCredentials(String username, String password)
		    {
		     LoginPage login = new LoginPage(driver);
		     login.enterUserName(username);
		     login.enterPassword(password);
		     login.clickOnLoginButton();
		     String actualErrorMessage =login.getActualErrorMessageText();
		     String expectedErrorMessage = ExcelUtility.getStringData(0, 2,Constants.LOGINPAGE);
		     Assert.assertEquals(actualErrorMessage, expectedErrorMessage,Messages.INVALIDCREDS);
		    }}

			