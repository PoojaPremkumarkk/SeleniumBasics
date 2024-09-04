package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;

public class UserManagementPage {

	WebDriver driver;

	public UserManagementPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='User Management']")
	WebElement usermanagement;

	@FindBy(xpath = "//span[@class='title' and normalize-space(text())='Users']")
	WebElement users;

	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement addbutton;

	@FindBy(xpath = "//a[@class='btn btn-block btn-primary']")
	WebElement adduser;

	@FindBy(xpath = "//input[@class='form-control input-sm']")
	WebElement searchButton;

	@FindBy(xpath = "//i[@class='fa fa-dashboard']")
	WebElement home;

	public void verifyUserManagement() {
		WaitUtility.waitForElementToBeClickable(driver, usermanagement);
		usermanagement.click();
	}

	public void verifyUser() {
		WaitUtility.waitForElementToBeClickable(driver, users);
		users.click();
	}

	public CreateUsersPage clickAddButton() {
		WaitUtility.waitForElementToBeClickable(driver, adduser);
		adduser.click();
		return new CreateUsersPage(driver);
	}

	public UserProfilePage enterSearchTerm(String userName) {
		WaitUtility.waitForElementToBeVisible(driver, searchButton);
		searchButton.clear();
		searchButton.sendKeys(userName);
		return new UserProfilePage(driver);
	}

	public CreateUsersPage verifyAddUser() {
		WaitUtility.waitForElementToBeClickable(driver, addbutton);
		addbutton.click();
		return new CreateUsersPage(driver);
	}

	public HomePage clickHome() {
		WaitUtility.waitForElementToBeClickable(driver, home);
		home.click();
		return new HomePage(driver);
	}

	public boolean isUserPresent(String emailId) {
		searchButton.sendKeys(emailId);
		return false;
	}
}
