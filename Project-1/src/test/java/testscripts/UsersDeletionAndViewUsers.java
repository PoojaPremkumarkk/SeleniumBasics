package testscripts;

import org.testng.annotations.Test;

import automation.org.Base;
import constants.Constants;
import pageObjects.CreateUsersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserManagementPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class UsersDeletionAndViewUsers extends Base {
	
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
	    // Construct email ID and password based on user details
	    String emailId = firstName + Constants.DOTEMAIL +lastName+Constants.ATEMAIL+ Constants.OUTLOOK;
	    String passwordNew = firstName +Constants.ATEMAIL+lastName + Constants.ATEMAIL;

	    // Initialize LoginPage object and perform login
	    LoginPage login = new LoginPage(driver);
	    String Adminname = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
	    String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGINPAGE);

	    login.enterUserName(Adminname);
	    login.enterPassword(password);

	    // Perform login and wait for the HomePage to load
	    HomePage home = login.clickOnLoginButton();

	    // Perform actions on HomePage
	    home.clickEndTour();
	    home.clickHomeMenu();

	    // Navigate to User Management Page
	    UserManagementPage us = new UserManagementPage(driver);
	    us.verifyUserManagement();
	    us.verifyUser();
	    us.clickAddButton();

	    // Create a new user
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
	    us.enterSearchTerm(emailId);//search username
	 //Delete new user
	    
	}
		
	}


