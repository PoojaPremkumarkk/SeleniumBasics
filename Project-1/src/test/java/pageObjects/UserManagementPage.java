package pageObjects;

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
    
	//@FindBy(xpath="//li[@class='active active-sub']//following-sibling::span")
    
    @FindBy(xpath="//span[@class='title' and normalize-space(text())='Users']")
      WebElement users;
    
    @FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement addbutton;
    
    @FindBy(xpath="//a[@class='btn btn-block btn-primary']")
    WebElement adduser;
    
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement SearchButton;
	
	@FindBy(xpath="//table[@id='users_table']/tbody/tr[1]/td[1]")
	WebElement  alreadyusers;
	
	
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
	
	
	
	public void verifySearchField(String username)
	{
		SearchButton.sendKeys(username);
	}
	public String verifySearchResults()
	{
		String name = alreadyusers.getText();
		return name;
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
    
}

