package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtility;
import constants.Constants;

public class ImportContactsPage {
	WebDriver driver;

	public ImportContactsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Contacts']")
	WebElement contactsmenu;
	@FindBy(xpath = "//a[@href='https://qalegend.com/billing/public/contacts/import']")
	WebElement contact;
	@FindBy(xpath = "//input[@name='contacts_csv']")
	WebElement upload;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	WebElement submit;
	@FindBy(xpath = "//div[@class='toast-message']")
	WebElement successMessage;

	public void clickOnContactsMenu() {
		WaitUtility.waitForElementToBeClickable(driver, contactsmenu);
		contactsmenu.click();
	}

	public void clickOnImportContacts() {
		WaitUtility.waitForElementToBeClickable(driver, contact);
		contact.click();
	}

	public void clickOnFileupload() {
		upload.sendKeys(Constants.HOME_DIRECTORY + Constants.IMPORT_CONTACTPATH);
	}

	public void clickOnSubmitButton() {
		WaitUtility.waitForElementToBeClickable(driver, submit);
		submit.click();
	}

	public String getSuccessMessage() {
		return successMessage.getText();
	}
}