package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUsersPage {

    WebDriver driver;

    // Constructor
    public CreateUsersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='surname']")
      WebElement prefix1;

    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firstname;

    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lastname;

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//span[@id='select2-role-container']")
    private WebElement roleDropdown;

    @FindBy(xpath = "//ul[@id='select2-role-results']//li")
    private List<WebElement> roleOptions;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='confirm_password']")
    private WebElement confirmpassword;
     @FindBy(xpath="//input[@id='username']")
     WebElement username;
    @FindBy(xpath="//input[@id='cmmsn_percent']")
    WebElement  commission;
    
    

    @FindBy(xpath = "//button[@id='submit_user_button']")
    private WebElement submit;
   

    // Method to enter prefix
    public void enterPrefix(String prefix) {
        prefix1.sendKeys(prefix);
    }

    // Method to enter first name
    public void enterFirstName(String fn) {
        firstname.sendKeys(fn);
    }

    // Method to enter last name
    public void enterLastName(String ln) {
        lastname.sendKeys(ln);
    }

    // Method to enter email
    public void enterEmail(String email) {
        this.email.sendKeys(email);
    }

    // Method to select a role from the dropdown
    public void selectRole(String roleName) {
        // Click to open the dropdown
        roleDropdown.click();

        // Wait for options to be visible and select the desired role
        for (WebElement option : roleOptions) {
            if (option.getText().equals(roleName)) {
                option.click();
                break;
            }
        }
    }

    // Method to enter password
    public void enterPassword(String password) {
        this.password.sendKeys(password);
    }

    // Method to enter confirm password
    public void enterConfirmPassword(String confirmPassword) {
        this.confirmpassword.sendKeys(confirmPassword);
    }
    
    
    // Method to enter username
    public void enterProfileName(String pname) {
        username.sendKeys(pname);
    }
    

    // Method to enter  Commission 
    public void enterCommission(String comm) {
    	 commission.sendKeys(comm);
    }
    
    

 // Method to click the submit button and return a new HomePage object
    public HomePage clickSubmit() {
        submit.click();
        return new HomePage(driver);
    }

	
}
