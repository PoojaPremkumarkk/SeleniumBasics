package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
	WebDriver driver;

    // Constructor to initialize WebDriver and page elements
    public ResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    

	@FindBy(xpath="//a[@class='btn btn-link']")
    WebElement resetLink;
    public void clickResetLink()
    {
    	resetLink.click();
    }

}
