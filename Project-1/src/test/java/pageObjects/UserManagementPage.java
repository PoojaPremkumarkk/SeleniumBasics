package pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserManagementPage {
    WebDriver driver;

    // Constructor to initialize WebDriver and page elements
    public UserManagementPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    
    
    @FindBy(xpath="//span[text()='User Management']")
	WebElement usermanagement;
    
	
    
    @FindBy(xpath="//span[@class='title' and normalize-space(text())='Users']")
      WebElement users;
    
    @FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addbutton;
    
    @FindBy(xpath="//a[@class='btn btn-block btn-primary']")
    WebElement adduser;
    
	@FindBy(xpath="//input[@class='form-control input-sm']")
	
	WebElement searchButton;
	
	
	
	@FindBy(xpath="//i[@class='fa fa-dashboard']")
	WebElement home;
	public void verifyUserManagement()
	{
		usermanagement.click();
	}
	public void verifyUser()
	{
		users.click();
		
	}
	public void clickAddButton() {
		adduser.click();
	}
	
	
	
	
	public void enterSearchTerm(String userName) {
        searchButton.clear();
        searchButton.sendKeys(userName);
    }
	
	public CreateUsersPage verifyAddUser()
	{
		addbutton.click();
		return new CreateUsersPage(driver);
	}
	public HomePage clickHome()
	{
		home.click();
		return new HomePage(driver);
	}
	
	
	public boolean isUserPresentInSearchResults(String profilename) {
	    try {
	        // Locate the row containing the specified profile name using a corrected and relative XPath
	        WebElement userRow = driver.findElement(By.xpath("//table[@id='userTable']//td[contains(text(), '" + profilename + "')]"));
	        
	        // Return true if the profile name is found in the search results
	        return userRow.isDisplayed();
	    } catch (NoSuchElementException e) {
	        // Return false if the profile name is not found
	        return false;
	    }
	}

	}



