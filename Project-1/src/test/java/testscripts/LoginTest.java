package testscripts;


		
		import org.openqa.selenium.By;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.testng.Assert;
		import org.testng.annotations.Test;

import automation.org.Base;
import dataprovider.DataProviders;
import pageObjects.HomePage;
		import pageObjects.LoginPage;
		import utilities.ExcelUtility;

		public class LoginTest extends Base {

		    @Test
		    public void userLoginWithValidCredentials() {
		        // Retrieve data from Excel
		        String emailId = ExcelUtility.getStringData(0, 0, "LoginTest");
		        String password = ExcelUtility.getIntegerData(0, 1, "LoginTest"); 
		        String expectedLoginName = ExcelUtility.getStringData(0, 0, "LoginTest");

		        // Perform login actions
		        LoginPage login = new LoginPage(driver);
		        login.enterUserName(emailId);
		        login.enterPassword(password);

		        // Click login button and navigate to home page
		        HomePage home = login.clickOnLoginButton();

		        // Retrieve the actual login text
		        String actualText = home.getLoginText();

		        // Assert the expected vs actual login text
		        Assert.assertEquals(actualText, expectedLoginName, "Invalid login");
		    }

		    @Test(dataProvider = "invalidUserCredentials", dataProviderClass = DataProviders.class)
		    public void errorMessageWithInvalidCredentials(String username, String password) {
		        // Retrieve expected error message from Excel
		        String expectedErrorMessage = ExcelUtility.getStringData(0, 2, "LoginTest");

		        // Perform login actions with invalid credentials
		        LoginPage login = new LoginPage(driver);
		        login.enterUserName(username);
		        login.enterPassword(password);
		        login.clickOnLoginButton();

		        // Find the error message element
		        WebElement actualError = driver.findElement(By.xpath("//strong[text()='These credentials do not match our records.']"));
		        String actualErrorMessage = actualError.getText();

		        // Assert the expected vs actual error message
		        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Invalid login credentials");
		    }
		}

			