package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.org.Base;
import constants.Constants;
import constants.Messages;
import pageObjects.CreateUsersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserProfilePage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class UserProfilePageTest extends Base {

	@Test
	public void verifyEditProfile() {

		String username = ExcelUtility.getStringData(0, 0, Constants.EDIT);
		String password = ExcelUtility.getStringData(0, 1, Constants.EDIT);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home = login.clickOnLoginButton();
		home.clickHomeMenu();
		UserProfilePage profile = home.clickOnProfile();
		String newLastName = RandomDataUtility.getLastName();
		profile.editLastName(newLastName);
		profile.clickUpdateButton();
		String updatedLastName = profile.getLastName();
		Assert.assertEquals(updatedLastName, newLastName, Messages.LASTNAMEERRMSG);
	}

	@Test
	public void profileUserLogout() {

		String username = ExcelUtility.getStringData(0, 0, Constants.EDIT);
		String password = ExcelUtility.getStringData(0, 1, Constants.EDIT);
		LoginPage login = new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassword(password);
		HomePage home = login.clickOnLoginButton();
		home.clickHomeMenu();
		home.clickLogout();
		Assert.assertTrue(login.isLoginPageDisplayed(), Messages.LOGINNOTSHOW);
	}
}