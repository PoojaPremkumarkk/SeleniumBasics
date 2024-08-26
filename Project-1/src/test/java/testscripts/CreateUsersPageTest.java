package testscripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.Duration;
import automation.org.Base;
import pageObjects.CreateUsersPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.UserManagementPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class CreateUsersPageTest extends Base {

    @Test
    public void verifyAddUser() {
      
        
        // Retrieve random and static data for user creation
        String prefix = RandomDataUtility.getPrefix();
        String firstName = RandomDataUtility.getFirstName();
        String lastName = RandomDataUtility.getLastName();
        String role = ExcelUtility.getStringData(0, 0, "UserPage");
        String profilename = ExcelUtility.getStringData(1, 0, "UserPage");
         String  commission=ExcelUtility.getIntegerData(1, 1, "UserPage");
         String successMessage =ExcelUtility.getStringData(2, 0, "UserPage");
        // Log details for debugging purposes
        System.out.println("Prefix: " + prefix);
        System.out.println("First Name: " + firstName);
        System.out.println("Last Name: " + lastName);

        // Construct email ID and password based on user details
        String emailId = firstName + "." + lastName + "@outlook.com";
        String passwordNew = firstName + "@" + lastName + "@";
        String newUserName = firstName + "." + lastName;

        // Initialize LoginPage object and perform login
        LoginPage login = new LoginPage(driver);
        String username = ExcelUtility.getStringData(0, 0, "LoginTest");
        String password = ExcelUtility.getIntegerData(0, 1, "LoginTest"); 

        login.enterUserName(username);
        login.enterPassword(password);
        

        // Wait for HomePage to be displayed after login
        HomePage home = login.clickOnLoginButton();
        //String actualLoginName = home.getLoginText();
       // String expectedLoginName = "Admin"; 
        //Assert.assertEquals(actualLoginName, expectedLoginName, "Invalid login name displayed");

        // Perform actions on HomePage
        home.clickEndTour();
        home.clickHomeMenu();
       
        
        UserManagementPage us=new  UserManagementPage(driver);
        us.verifyUserManagement();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='title' and normalize-space(text())='Users']")));
        element.click();

        us.verifyUser();
        us.clickAddButton();
        
        
CreateUsersPage create=new CreateUsersPage(driver);
create.enterPrefix(prefix);
create.enterFirstName(firstName);
create.enterLastName(lastName);
create.enterEmail(emailId);
create.enterPassword(password);
create.enterConfirmPassword(password);
create.enterProfileName(profilename);
create.selectRole(role);
create.enterCommission(commission);
 create.clickSubmit();     
        
 
 Assert.assertEquals(successMessage, "User added Successfully", "User creation failed");

   
        
}
    @Test
    
    public void verifyLoginWithNewlyAddUser() {

        // Initialize LoginPage object and perform login
        LoginPage login = new LoginPage(driver);
        String username = ExcelUtility.getStringData(0, 0, "LoginTest");
        String password = ExcelUtility.getIntegerData(0, 1, "LoginTest"); 

        // Enter login credentials and click login button
        login.enterUserName(username);
        login.enterPassword(password);
        HomePage home = login.clickOnLoginButton();

        // Perform actions on HomePage
        home.clickEndTour();
        home.clickHomeMenu();

        // Navigate to User Management Page
        UserManagementPage us = new UserManagementPage(driver);
        us.verifyUserManagement();

        // Perform user verification
        us.verifyUser();
        us.enterSearchTerm(username);
        String loggedInUser = home.getLoginText(); 

        // Assertion
        Assert.assertEquals(loggedInUser, username, "Logged-in user does not match the expected username.");
    }

   

    }

