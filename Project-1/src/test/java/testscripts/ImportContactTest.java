package testscripts;


import org.testng.Assert;
import org.testng.annotations.Test;
import automation.org.Base;
import constants.Constants;
import constants.Messages;
import pageObjects.HomePage;
import pageObjects.ImportContactsPage;
import pageObjects.LoginPage;
import utilities.ExcelUtility;

public class ImportContactTest extends Base{
	@Test(groups= {"Smoke","Sanity"})
	public void verifyImportContact(){
	      String emailId = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
		  String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGINPAGE); 
		  String expectedSuccessMessage = ExcelUtility.getStringData(1, 2, Constants.LOGINPAGE);
          LoginPage login = new LoginPage(driver);
		  login.enterUserName(emailId);
		  login.enterPassword(password);
		  HomePage home = login.clickOnLoginButton();
		  home.clickEndTour();
		  ImportContactsPage contact=home.clickContactsMenu();
		  contact.clickOnImportContacts();
		  contact.clickOnFileupload();
		  contact.clickOnSubmitButton();
		  String actualSuccessMessage = contact.getSuccessMessage();
	     Assert.assertNotEquals(actualSuccessMessage, expectedSuccessMessage,Messages.SUCCESSNOTMATCH);
	      }}