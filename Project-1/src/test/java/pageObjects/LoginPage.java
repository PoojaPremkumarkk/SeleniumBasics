package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {

    WebDriver driver;

    // Constructor to initialize WebDriver and page elements
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Locators for the login page elements
    @FindBy(id = "username")
    WebElement usernameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement loginButton;

    @FindBy(xpath = "//span[text()='User Management']")
    WebElement usermanagement; // XPath for user management (move this to HomePage if needed)
    
    @FindBy(xpath="//strong[text()='These credentials do not match our records.']")
    WebElement actualerror;

    // Method to enter the username
    public void enterUserName(String username) {
        usernameField.sendKeys(username);
    }

    // Method to enter the password
    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    // Method to click the login button and return the HomePage object
    public HomePage clickOnLoginButton() {
        loginButton.click();
        return new HomePage(driver); //login takes you to the HomePage
    }
    
    public String getActualErrorMessageText() {
        return actualerror.getText();
    }

    // Method to click on the user management option (if required immediately after login)
    public void clickUserManagement() {
        usermanagement.click();
    }

	public boolean isLoginPageDisplayed() {
		// TODO Auto-generated method stub
		return usernameField.isDisplayed() && 
	               passwordField.isDisplayed() && 
	               loginButton.isDisplayed();
	}
}
