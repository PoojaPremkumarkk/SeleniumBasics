package pageObjects;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateUsersPage {
	WebDriver driver;

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

	@FindBy(xpath = "//input[@id='username']")
	WebElement username;

	@FindBy(xpath = "//input[@id='cmmsn_percent']")
	WebElement commission;

	@FindBy(xpath = "//button[@id='submit_user_button']")
	private WebElement submit;

	public void enterPrefix(String prefix) {
		prefix1.sendKeys(prefix);
	}

	public void enterFirstName(String fn) {
		firstname.sendKeys(fn);
	}

	public void enterLastName(String ln) {
		lastname.sendKeys(ln);
	}

	public void enterEmail(String email) {
		this.email.sendKeys(email);
	}

	public void selectRole(String roleName) {
		roleDropdown.click();
		for (WebElement option : roleOptions) {
			if (option.getText().equals(roleName)) {
				option.click();
				break;
			}
		}
	}

	public void enterPassword(String password) {
		this.password.sendKeys(password);
	}

	public void enterConfirmPassword(String confirmPassword) {
		this.confirmpassword.sendKeys(confirmPassword);
	}

	public void enterProfileName(String pname) {
		username.sendKeys(pname);
	}

	public void enterCommission(String comm) {
		commission.sendKeys(comm);
	}

	public HomePage clickSubmit() {
		submit.click();
		return new HomePage(driver);
	}

}
