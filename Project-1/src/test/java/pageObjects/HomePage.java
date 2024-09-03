package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;

import utilities.DateUtility;
import utilities.WaitUtility;  // Import  WaitUtility class

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin ']")
    WebElement loginName;

    @FindBy(xpath = "//button[@data-role='end']")
    WebElement endTour;

    @FindBy(xpath = " //a[@class='dropdown-toggle']//span")
    WebElement homeMenuPage;
    @FindBy(xpath = " //a[@class='dropdown-toggle']//span")
    WebElement Adminmenu;

    @FindBy(xpath = "//a[text()='Sign Out']")
    WebElement signout;
    @FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']/strong")
    WebElement logindatefield;
    @FindBy(xpath="//span[text()='Admin ']")
    WebElement loggeduser;
    @FindBy(xpath = "//a[@class='dropdown-toggle']//span")
	WebElement loggedInUserName;
    
    public void clickOnAdmin()
    {
    	     	    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-success")));

    	    // Wait until the Admin menu is clickable
    	    WebElement adminElement = wait.until(ExpectedConditions.elementToBeClickable(Adminmenu));
    	    
    	    // Click on the Admin menu
    	    adminElement.click();
    	 
    }
    public String getLoggedInUserName() {
		String userNameText = loggedInUserName.getText();
		return userNameText;
	}
    public String getLoginDate()
    {
    	String logindate=logindatefield.getText();
    	return logindate;
    }
    public String getCurrentDate()
    {
    	return DateUtility.getUserLoginDate("dd-MM-YYYY");
    }

    // Method to get the already logged user name text
    public String getLoginText() {
        // Wait for the login name element to be visible using WaitUtility
        WaitUtility.waitForElementToBeClickable(driver, loginName);
        return loginName.getText();
    }

    // Method to click on the 'End Tour' button
    public void clickEndTour() {
        // Wait for the end tour button to be clickable using WaitUtility
        WaitUtility.waitForElementToBeClickable(driver, endTour);
        endTour.click();
    }

    // Method to click on the home menu
    public UserManagementPage clickHomeMenu() {
        // Wait for the home menu link to be clickable using WaitUtility
        WaitUtility.waitForElementToBeClickable(driver, homeMenuPage);
        homeMenuPage.click();
        return new UserManagementPage(driver);
    }
    public void verifyLoginName(String expectedLoginName) {
        // Get the actual login name from the web page
        String actualText = getLoginText();
        loggedInUserName.click();
        
    }

    // Method to click on the sign out button and return to the LoginPage
    public LoginPage clickLogout() {
        // Wait for the sign-out button to be clickable using WaitUtility
        WaitUtility.waitForElementToBeClickable(driver, signout);
        signout.click();
        return new LoginPage(driver); // Return a new instance of LoginPage
    }

}
