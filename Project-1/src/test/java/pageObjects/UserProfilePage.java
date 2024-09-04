package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;

public class UserProfilePage {

	WebDriver driver;

	public UserProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Profile']")
	WebElement profile;

	@FindBy(xpath = "//input[@id='last_name']")
	WebElement lastName;

	@FindBy(xpath = "//button[text()='Update']")
	WebElement updateButton;

	@FindBy(xpath = "//button[@class='btn btn-xs btn-danger delete_user_button']")
	WebElement deleteButton;

	@FindBy(xpath = "//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement deleteOKButton;

	@FindBy(xpath = "//i[@class='fa fa-eye']")
	WebElement viewButton;

	@FindBy(xpath = "//h3[@class='profile-username']")
	WebElement profileUserName;

	@FindBy(xpath = "//a[@class='btn btn-xs btn-primary']//i[@class='glyphicon glyphicon-edit']")
	WebElement editCreatedUser;

	public void editCreatedUser() {
		WaitUtility.waitForElementToBeClickable(driver, editCreatedUser);
		editCreatedUser.click();
	}

	public String getProfileName() {
		return profileUserName.getText();
	}

	public void clickOnProfile() {
		WaitUtility.waitForElementToBeClickable(driver, profile);
		profile.click();
	}

	public void editLastName(String newLastName) {
		WaitUtility.waitForElementToBeVisible(driver, lastName);
		lastName.clear();
		lastName.sendKeys(newLastName);
	}

	public HomePage clickUpdateButton() {
		WaitUtility.waitForElementToBeClickable(driver, updateButton);
		updateButton.click();
		return new HomePage(driver);
	}

	public void clickOnDeleteButton() {
		WaitUtility.waitForElementToBeClickable(driver, deleteButton);
		deleteButton.click();
	}

	public void clickOnDeleteOKButton() {
		WaitUtility.waitForElementToBeClickable(driver, deleteOKButton);
		deleteOKButton.click();
	}

	public HomePage clickOnViewButton() {
		WaitUtility.waitForElementToBeClickable(driver, viewButton);
		viewButton.click();
		return new HomePage(driver);
	}

	public String getLastName() {
		WaitUtility.waitForElementToBeVisible(driver, lastName);
		return lastName.getAttribute("value");
	}
}
