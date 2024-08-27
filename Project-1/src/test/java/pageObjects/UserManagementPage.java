package pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class UserManagementPage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize WebDriver and page elements
    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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
        wait.until(ExpectedConditions.elementToBeClickable(usermanagement)).click();
    }

    public void verifyUser() {
        wait.until(ExpectedConditions.elementToBeClickable(users)).click();
    }

    public void clickAddButton() {
        wait.until(ExpectedConditions.elementToBeClickable(adduser)).click();
    }

    public void enterSearchTerm(String userName) {
        wait.until(ExpectedConditions.visibilityOf(searchButton));
        searchButton.clear();
        searchButton.sendKeys(userName);
    }

    public CreateUsersPage verifyAddUser() {
        wait.until(ExpectedConditions.elementToBeClickable(addbutton)).click();
        return new CreateUsersPage(driver);
    }

    public HomePage clickHome() {
        wait.until(ExpectedConditions.elementToBeClickable(home)).click();
        return new HomePage(driver);
    }

	public boolean isUserPresent(String emailId) {
		// TODO Auto-generated method stub
		searchButton.sendKeys(emailId);
		return false;
	}

   
    
}
