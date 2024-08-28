package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;

import utilities.DateUtility;
import utilities.WaitUtility;  // Import  WaitUtility class

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        // Initialize PageFactory elements
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin ']")
    WebElement loginName;

    @FindBy(xpath = "//button[@data-role='end']")
    WebElement endTour;

    @FindBy(xpath = " //a[@class='dropdown-toggle']//span")
    WebElement homeMenuPage;

    @FindBy(xpath = "//a[text()='Sign Out']")
    WebElement signout;
    @FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']/strong")
    WebElement logindatefield;
    
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
    public void clickHomeMenu() {
        // Wait for the home menu link to be clickable using WaitUtility
        WaitUtility.waitForElementToBeClickable(driver, homeMenuPage);
        homeMenuPage.click();
    }

    // Method to verify the login name
    public void verifyLoginName(String expectedLoginName) {
        // Get the actual login name from the web page
        String actualText = getLoginText();
        
    }

    // Method to click on the sign out button and return to the LoginPage
    public LoginPage clickLogout() {
        // Wait for the sign-out button to be clickable using WaitUtility
        WaitUtility.waitForElementToBeClickable(driver, signout);
        signout.click();
        return new LoginPage(driver); // Return a new instance of LoginPage
    }

}
