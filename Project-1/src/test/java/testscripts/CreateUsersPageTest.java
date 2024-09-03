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
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

    public class CreateUsersPageTest extends Base {

	@Test(groups="Smoke")
        public void verifyAddUser() {
        String prefix = RandomDataUtility.getPrefix();
        String firstName = RandomDataUtility.getFirstName();
        String lastName = RandomDataUtility.getLastName();
        String role = ExcelUtility.getStringData(0, 0, Constants.USERPAGE);
        String commission = ExcelUtility.getIntegerData(1, 1, Constants.USERPAGE);
        String successMessage = ExcelUtility.getStringData(2, 0, Constants.USERPAGE);
        String username=RandomDataUtility.getUserName();
        String emailId = firstName + Constants.DOTEMAIL +lastName+Constants.ATEMAIL+ Constants.OUTLOOK;
        String passwordNew = firstName +Constants.ATEMAIL+ lastName + Constants.ATEMAIL;
        LoginPage login = new LoginPage(driver);
        String Adminname = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
        String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGINPAGE);
        login.enterUserName(Adminname);
        login.enterPassword(password);
        HomePage home = login.clickOnLoginButton();
        home.clickEndTour();
        UserManagementPage us = home.clickHomeMenu();
        us.verifyUserManagement();
        us.verifyUser();
        CreateUsersPage create = us.clickAddButton();
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
        Assert.assertEquals(successMessage, Messages.USERADDEDSUCCESS,Messages.ADDUSERFAIL);
               }
         @Test
         public void verifyLoginWithNewlyAddUser() {
        	 String prefix = RandomDataUtility.getPrefix();
             String firstName = RandomDataUtility.getFirstName();
             String lastName = RandomDataUtility.getLastName();
             String role = ExcelUtility.getStringData(0, 0, Constants.USERPAGE);
             String commission = ExcelUtility.getIntegerData(1, 1, Constants.USERPAGE);
             String successMessage = ExcelUtility.getStringData(2, 0, Constants.USERPAGE);
             String username=RandomDataUtility.getUserName();
             String emailId = firstName + Constants.DOTEMAIL +lastName+Constants.ATEMAIL+ Constants.OUTLOOK;
             String passwordNew = firstName +Constants.ATEMAIL+ lastName + Constants.ATEMAIL;
             LoginPage login = new LoginPage(driver);
             String Adminname = ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
             String password = ExcelUtility.getIntegerData(0, 1, Constants.LOGINPAGE);
             String loggedInUser=ExcelUtility.getStringData(0, 0, Constants.LOGINPAGE);
             login.enterUserName(Adminname);
             login.enterPassword(password);
             HomePage home = login.clickOnLoginButton();
             home.clickEndTour();
             UserManagementPage us = home.clickHomeMenu();
             us.verifyUserManagement();
             us.verifyUser();
             CreateUsersPage create = us.clickAddButton();
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
             home.clickOnAdmin();
             home.getLoggedInUserName();
             home.clickLogout();
             login.enterUserName(Adminname);
             login.enterPassword(password);
             login.clickOnLoginButton();
             Assert.assertEquals(loggedInUser,Adminname,Messages.LOGGEDINNOTMATCH);
             }}
         


    

