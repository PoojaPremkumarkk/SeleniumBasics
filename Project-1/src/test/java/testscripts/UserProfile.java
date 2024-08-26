package testscripts;

import org.testng.annotations.Test;

import automation.org.Base;
import pageObjects.LoginPage;
import utilities.ExcelUtility;

public class UserProfile extends Base{
	
@Test

public void verifyEditProfile() {
	

	
    String username = ExcelUtility.getStringData(3, 0, "UserPage");
    String password = ExcelUtility.getStringData(2, 1, "UserPage"); 

	//LoginPage login = new LoginPage(driver);
	//login.clickOnLoginButton();
}
}