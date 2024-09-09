package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import testscripts.ImportContactTest;

import org.openqa.selenium.support.FindBy;
import utilities.DateUtility;
import utilities.WaitUtility;

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

	@FindBy(xpath = " //a[@class='dropdown-toggle']//span")
	WebElement homeMenuPage;

	@FindBy(xpath = "//a[text()='Sign Out']")
	WebElement signout;

	@FindBy(xpath = "//div[@class='m-8 pull-left mt-15 hidden-xs']/strong")
	WebElement logindatefield;

	@FindBy(xpath = "//span[text()='Admin ']")
	WebElement loggeduser;
	@FindBy(xpath = " //a[@class='dropdown-toggle']//span")
	WebElement Adminmenu;

	@FindBy(xpath = "//a[@class='dropdown-toggle']//span")
	WebElement loggedInUserName;

	@FindBy(xpath = "//span[normalize-space()='Contacts']")
	WebElement contactsMenu;
	@FindBy(xpath = "//a[text()='Profile']")
	WebElement profile;

	public UserProfilePage clickOnProfile() {
		WaitUtility.waitForElementToBeClickable(driver, profile);
		profile.click();
		return new UserProfilePage(driver);
	}

	public ImportContactsPage clickContactsMenu() {
		contactsMenu.click();
		return new ImportContactsPage(driver);
	}

	public void clickOnAdmin() {
		WaitUtility.waitForElementToBeClickable(driver, Adminmenu);
		WaitUtility.waitForCondition(driver,
		ExpectedConditions.invisibilityOfElementLocated(By.className("toast-success")));
		Adminmenu.click();
	}

	public String getLoggedInUserName() {
		WaitUtility.waitForElementToBeVisible(driver, loggedInUserName);
		return loggedInUserName.getText();
	}

	public String getLoginDate() {
		WaitUtility.waitForElementToBeVisible(driver, logindatefield);
		return logindatefield.getText();
	}

	public String getCurrentDate() {
		return DateUtility.getUserLoginDate("dd-MM-YYYY");
	}

	public String getLoginText() {
		WaitUtility.waitForElementToBeVisible(driver, loginName);
		return loginName.getText();
	}

	public void clickEndTour() {
		WaitUtility.waitForElementToBeClickable(driver, endTour);
		endTour.click();
	}

	public UserManagementPage clickHomeMenu() {
		WaitUtility.waitForElementToBeClickable(driver, homeMenuPage);
		homeMenuPage.click();
		return new UserManagementPage(driver);
	}

	public void verifyLoginName(String expectedLoginName) {
		String actualText = getLoginText();
		loggedInUserName.click();
	}

	public LoginPage clickLogout() {
		WaitUtility.waitForElementToBeClickable(driver, signout);
		signout.click();
		return new LoginPage(driver);
	}
}
