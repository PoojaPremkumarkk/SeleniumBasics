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

public class UserProfilePageTest extends Base{
	
@Test

public void verifyEditProfile() {
    // Retrieve login credentials and profile information
    String username = ExcelUtility.getStringData(0, 0, Constants.EDIT);
    String password = ExcelUtility.getStringData(0, 1, Constants.EDIT);
    
    // Initialize LoginPage and perform login
    LoginPage login = new LoginPage(driver);
    login.enterUserName(username);
    login.enterPassword(password);
    HomePage home = login.clickOnLoginButton();
    
    // Navigate to the Home Page and User Profile Page
    home.clickHomeMenu();
    UserProfilePage profile = new UserProfilePage(driver);
    profile.clickOnProfile();
    
    // Generate a new last name and update the profile
    String newLastName = RandomDataUtility.getLastName();
    profile.editLastName(newLastName);
    profile.clickUpdateButton();
    
    // Retrieve the updated last name from the profile page
    String updatedLastName = profile.getLastName();
    
    // Assertion: Verify that the last name has been updated
    Assert.assertEquals(updatedLastName, newLastName,Messages.LASTNAMEERRMSG);
}
}