package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetPage {
	WebDriver driver;
	 WebDriverWait wait;
	
    // Constructor to initialize WebDriver and page elements
    public ResetPage(WebDriver driver) {
        this.driver = driver;
        
        PageFactory.initElements(driver, this);
    }
    
   
	@FindBy(xpath="//a[@class='btn btn-link']")
    WebElement resetLink;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement femail;
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
			WebElement submit;
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement success;
	
	@FindBy(xpath="//span[@class='help-block']//strong")
	WebElement failure;
    public void clickResetLink()
    {
    	resetLink.click();
    }
    
    public void clickSubmit()
    {
    	submit.click();
    }
    
    public void enterEmail(String email) {
    	// WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']")));
        femail.sendKeys(email);
}

    public String getSuccessMessage() {
    	
    	return success.getText();
    }
    
public String getErrorMessage() {
    	
    	return failure.getText();
    }
}
