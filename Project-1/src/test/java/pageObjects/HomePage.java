package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        // Initialize PageFactory elements
        PageFactory.initElements(driver, this);
        // Initialize WebDriverWait with a timeout of 10 seconds
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

   @FindBy(xpath = "//span[text()='Admin ']")
    WebElement loginName;

   @FindBy(xpath = "//button[@data-role='end']")
    WebElement endTour;
    
 
    @FindBy(xpath = " //a[@class='dropdown-toggle']//span")
    WebElement homeMenuPage;

   @FindBy(xpath = "//a[text()='Sign Out']")
    WebElement signout;
   
  

    // Method to get the already logged user name text
    public String getLoginText() {
        // Wait for the login name element to be visible
        wait.until(ExpectedConditions.visibilityOf(loginName));
        return loginName.getText();
    }

    // Method to click on the 'End Tour' button
    public void clickEndTour() {
        // Wait for the end tour button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(endTour));
        endTour.click();
    }

    // Method to click on the home menu
    public void clickHomeMenu() {
        // Wait for the home menu link to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(homeMenuPage));
        homeMenuPage.click();
    }

    // Method to verify the login name
    public void verifyLoginName(String expectedLoginName) {
        // Get the actual login name from the web page
        String actualText = getLoginText();
        
    }
    

    // Method to click on the sign out button and return to the LoginPage
    public LoginPage clickLogout() {
        // Wait for the sign-out button to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(signout));
        signout.click();
        return new LoginPage(driver); // Return a new instance of LoginPage
    }

}
