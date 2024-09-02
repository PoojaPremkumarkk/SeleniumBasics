package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation.org.Base;
import constants.Constants;
import constants.Messages;
import pageObjects.CreateUsersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserManagementPage;
import pageObjects.UserProfilePage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class UserPageTest extends Base {
	
	@Test
	public void verifyDeleteProfile()
	{
		String prefix = RandomDataUtility.getPrefix();
	    String firstName = RandomDataUtility.getFirstName();
	    String lastName = RandomDataUtility.getLastName();
	    String role = ExcelUtility.getStringData(0, 0, Constants.USERPAGE);
	    String commission = ExcelUtility.getIntegerData(1, 1, Constants.USERPAGE);
	    String successMessage = ExcelUtility.getStringData(2, 0, Constants.USERPAGE);
	    String username=RandomDataUtility.getUserName();
	    String emailId = firstName + Constants.DOTEMAIL +lastName+Constants.ATEMAIL+ Constants.OUTLOOK;
	    String passwordNew = firstName +Constants.ATEMAIL+lastName + Constants.ATEMAIL;
	    LoginPage login = new LoginPage(driver);
	    String Adminname = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
	    String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGINPAGE);
        login.enterUserName(Adminname);
	    login.enterPassword(password);
	    HomePage home = login.clickOnLoginButton();
	    home.clickEndTour();
	    home.clickHomeMenu();
	    UserManagementPage us = new UserManagementPage(driver);
	    us.verifyUserManagement();
	    us.verifyUser();
	    us.clickAddButton();
	    CreateUsersPage create = new CreateUsersPage(driver);
	    create.enterPrefix(prefix);
	    create.enterFirstName(firstName);
	    create.enterLastName(lastName);
	    create.enterEmail(emailId);
	    create.enterPassword(passwordNew);  
	    create.enterConfirmPassword(passwordNew); 
	    create.enterProfileName(username);
	    create.selectRole(role);
	    create.enterCommission(commission);
	    create.clickSubmit();
	    us.enterSearchTerm(emailId);
        UserProfilePage profile=new UserProfilePage(driver);
        profile.clickOnDeleteButton();
        profile.clickOnDeleteOKButton();
        boolean isUserDeleted = us.isUserPresent(emailId); 
        Assert.assertFalse(isUserDeleted,Messages.USERDELETEMSG);
	    
	}
	@Test
	public void viewUserProfile()
	{
		String prefix = RandomDataUtility.getPrefix();
	    String firstName = RandomDataUtility.getFirstName();
	    String lastName = RandomDataUtility.getLastName();
	    String role = ExcelUtility.getStringData(0, 0, Constants.USERPAGE);
	    String commission = ExcelUtility.getIntegerData(1, 1, Constants.USERPAGE);
	    String successMessage = ExcelUtility.getStringData(2, 0, Constants.USERPAGE);
	    String username=RandomDataUtility.getUserName();
	    String emailId = firstName + Constants.DOTEMAIL +lastName+Constants.ATEMAIL+ Constants.OUTLOOK;
	    String passwordNew = firstName +Constants.ATEMAIL+lastName + Constants.ATEMAIL;
	    LoginPage login = new LoginPage(driver);
	    String Adminname = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
	    String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGINPAGE);
	    login.enterUserName(Adminname);
	    login.enterPassword(password);
	    HomePage home = login.clickOnLoginButton();
	    home.clickEndTour();
	    home.clickHomeMenu();
	    UserManagementPage us = new UserManagementPage(driver);
	    us.verifyUserManagement();
	    us.verifyUser();
	    us.clickAddButton();
	    CreateUsersPage create = new CreateUsersPage(driver);
	    create.enterPrefix(prefix);
	    create.enterFirstName(firstName);
	    create.enterLastName(lastName);
	    create.enterEmail(emailId);
	    create.enterPassword(passwordNew);  
	    create.enterConfirmPassword(passwordNew); 
	    create.enterProfileName(username);
	    create.selectRole(role);
	    create.enterCommission(commission);
	    create.clickSubmit();
	    us.enterSearchTerm(emailId);
        UserProfilePage profile=new UserProfilePage(driver);
        profile.clickOnViewButton();
        String actualname=profile.getProfileName();
        Assert.assertNotEquals(actualname,username,Messages.USERADDFAILED);
        
	}
		
	@Test
       public void editCreatedUser()
       {
		String prefix = RandomDataUtility.getPrefix();
	    String firstName = RandomDataUtility.getFirstName();
	    String lastName = RandomDataUtility.getLastName();
	    String role = ExcelUtility.getStringData(0, 0, Constants.USERPAGE);
	    String commission = ExcelUtility.getIntegerData(1, 1, Constants.USERPAGE);
	    String successMessage = ExcelUtility.getStringData(2, 0, Constants.USERPAGE);
	    String username=RandomDataUtility.getUserName();
	    String emailId = firstName + Constants.DOTEMAIL +lastName+Constants.ATEMAIL+ Constants.OUTLOOK;
	    String passwordNew = firstName +Constants.ATEMAIL+lastName + Constants.ATEMAIL;
	    LoginPage login = new LoginPage(driver);
	    String Adminname = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
	    String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGINPAGE);
        login.enterUserName(Adminname);
	    login.enterPassword(password);
	    HomePage home = login.clickOnLoginButton();
	    home.clickEndTour();
	    home.clickHomeMenu();
	    UserManagementPage us = new UserManagementPage(driver);
	    us.verifyUserManagement();
	    us.verifyUser();
	    us.clickAddButton();
	    CreateUsersPage create = new CreateUsersPage(driver);
	    create.enterPrefix(prefix);
	    create.enterFirstName(firstName);
	    create.enterLastName(lastName);
	    create.enterEmail(emailId);
	    create.enterPassword(passwordNew);  
	    create.enterConfirmPassword(passwordNew); 
	    create.enterProfileName(username);
	    create.selectRole(role);
	    create.enterCommission(commission);
	    create.clickSubmit();
	    us.enterSearchTerm(emailId);
        UserProfilePage profile=new UserProfilePage(driver);
        profile.editCreatedUser();
        String newLastName = RandomDataUtility.getLastName();
        profile.editLastName(newLastName);
        profile.clickUpdateButton();
        String updatedLastName = profile.getLastName();
        Assert.assertEquals(updatedLastName, newLastName,Messages.LASTNAMEERRMSG);
    
}}
