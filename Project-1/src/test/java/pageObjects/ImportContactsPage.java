package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constants.Constants;

public class ImportContactsPage {
	WebDriver driver;
    WebDriverWait wait;
	    public ImportContactsPage(WebDriver driver) {
	    	this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        PageFactory.initElements(driver, this);
	    }
	    
	    @FindBy(xpath="//span[text()='Contacts']")
	    WebElement contactsmenu;
	    @FindBy(xpath="//a[@href='https://qalegend.com/billing/public/contacts/import']")
	    WebElement contact;
	    @FindBy(xpath="//input[@name='contacts_csv']")
	    WebElement upload;
	    @FindBy(xpath="//button[@class='btn btn-primary']")
	    WebElement submit;
	    @FindBy(xpath="//div[@class='toast-message']")
	    WebElement successMessage;
	    
	    public void clickOnContactsMenu() {
	        wait.until(ExpectedConditions.elementToBeClickable(contactsmenu)).click();
	    }
	    public void clickOnImportContacts() {
	        wait.until(ExpectedConditions.elementToBeClickable(contact)).click();
	    }
	    public void clickOnFileupload()
	    {
	     upload.sendKeys(Constants.HOME_DIRECTORY + Constants.IMPORT_CONTACTPATH);
	    }
	    public void clickOnSubmitButton() {
	        wait.until(ExpectedConditions.elementToBeClickable(submit)).click();
	    }
		public String getSuccessMessage() {
			return successMessage.getText();
		}}