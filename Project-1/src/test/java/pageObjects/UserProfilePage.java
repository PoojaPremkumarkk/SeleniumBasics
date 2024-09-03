package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserProfilePage {

    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize WebDriver and page elements
    public UserProfilePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Profile']")
    WebElement profile;

    @FindBy(xpath = "//input[@id='last_name']")
    WebElement lastName;

    @FindBy(xpath = "//button[text()='Update']")
    WebElement updateButton;
    
     @FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_user_button']")
    WebElement deleteButton;
    
    @FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
    WebElement deleteOKButton;
    
    @FindBy(xpath="//i[@class='fa fa-eye']")
    WebElement viewButton;
    
    @FindBy(xpath="//h3[@class='profile-username']")
    WebElement profileUserName;
    
    @FindBy(xpath="//a[@class='btn btn-xs btn-primary']//i[@class='glyphicon glyphicon-edit']")
    WebElement editCreatedUser;
    
    public void editCreatedUser()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(editCreatedUser)).click();
    }
    
    public String getProfileName()
    {
    	return profileUserName.getText();
    }

    public void clickOnProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(profile)).click();
    }

    public void editLastName(String newLastName) {
     wait.until(ExpectedConditions.visibilityOf(lastName)).clear();
        lastName.sendKeys(newLastName);
    }

    public HomePage clickUpdateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(updateButton)).click();
        return new HomePage(driver);
    }
    public void clickOnDeleteButton()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
    	
    }
    public void clickOnDeleteOKButton()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(deleteOKButton)).click();
    }
    
    public HomePage clickOnViewButton()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(viewButton)).click();
    	return new HomePage(driver);
    }

    public String getLastName() {
        return wait.until(ExpectedConditions.visibilityOf(lastName)).getAttribute("value");
    }
}
