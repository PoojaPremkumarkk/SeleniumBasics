package testscripts;


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
	
	public void userLoginDate()
	{
		LoginPage login = new LoginPage(driver);
        String username = ExcelUtility.getStringData(3, 0,Constants.USERPAGE);
        String password = ExcelUtility.getIntegerData(1, 2,Constants.USERPAGE); 

        login.enterUserName(username);
        login.enterPassword(password);
        HomePage home = login.clickOnLoginButton();
        home.clickEndTour();
        home.clickHomeMenu();
        String homepagedate=home.getLoginDate();
        String currentdate=home.getCurrentDate();
        Assert.assertEquals(homepagedate,currentdate,Messages.DATEMISMATCH);
	}
	
}


        
        
        
	