package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    public static final long IMPLICITLY_WAIT = 10; // 10 seconds for implicit waits
    public static final long EXPLICITLY_WAIT = 10; // 10 seconds for explicit waits

    // Set an implicit wait for the entire WebDriver session
    public static void setImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
    }

    // Explicit wait until an element is clickable
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Explicit wait until an element is visible
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    

    // Custom wait for any specific condition
    public static void waitForCondition(WebDriver driver, ExpectedCondition<?> condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT));
        wait.until(condition);
    }
}
