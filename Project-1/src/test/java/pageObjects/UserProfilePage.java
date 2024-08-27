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

    public void clickOnProfile() {
        wait.until(ExpectedConditions.elementToBeClickable(profile)).click();
    }

    public void editLastName(String newLastName) {
        // Clear the existing last name
        wait.until(ExpectedConditions.visibilityOf(lastName)).clear();

        // Enter the new last name
        lastName.sendKeys(newLastName);
    }

    public HomePage clickUpdateButton() {
        wait.until(ExpectedConditions.elementToBeClickable(updateButton)).click();
        return new HomePage(driver);
    }

    public String getLastName() {
        return wait.until(ExpectedConditions.visibilityOf(lastName)).getAttribute("value");
    }
}
