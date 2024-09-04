package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement loginButton;

	@FindBy(xpath = "//span[text()='User Management']")
	WebElement usermanagement;

	@FindBy(xpath = "//strong[text()='These credentials do not match our records.']")
	WebElement actualerror;

	public void enterUserName(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public HomePage clickOnLoginButton() {
		loginButton.click();
		return new HomePage(driver);
	}

	public String getActualErrorMessageText() {
		return actualerror.getText();
	}

	public void clickUserManagement() {
		usermanagement.click();
	}

	public boolean isLoginPageDisplayed() {

		return usernameField.isDisplayed() && passwordField.isDisplayed() && loginButton.isDisplayed();
	}
}