package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[text()='Admin ']")
    WebElement loginName;

    @FindBy(xpath = "//button[@data-role='end']")
    WebElement endTour;

    @FindBy(xpath = "//a[contains(@href,'public/home')]//span")
    WebElement homeMenuPage;

    @FindBy(xpath = "//a[text()='Sign Out']")
    WebElement signout;

    // Method to get the already logged user name text
    public String getLoginText() {
        return loginName.getText();
    }

    // Method to click on the 'End Tour' button
    public void clickEndTour() {
        endTour.click();
    }

    // Method to click on the home menu
    public void clickHomeMenu() {
        homeMenuPage.click();
    }

    // Method to verify the login name
    public void verifyLoginName(String expectedLoginName) {
        // Get the actual login name from the web page
        String actualText = getLoginText();
        // Assert the actual login name with the expected login name
        Assert.assertEquals(actualText, expectedLoginName, "Invalid login name displayed");
    }

    // Method to click on the sign out button and return to the LoginPage
    public LoginPage clickLogout() {
        signout.click();
        return new LoginPage(driver); // Return a new instance of LoginPage
    }

    
}
