package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {

    public static final long IMPLICITLY_WAIT = 10; 
    public static final long EXPLICITLY_WAIT = 10; 

    public static void setImplicitWait(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
    }
    public static void waitForElementToBeClickable(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static void waitForElementToBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForCondition(WebDriver driver, ExpectedCondition<?> condition) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT));
        wait.until(condition);
    }
    public static void waitForAlertToBePresent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT));
        wait.until(ExpectedConditions.alertIsPresent());
    }
    public static void waitForElementToBeSelected(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }
    public static void waitForAnElementFrequentExecution(WebDriver driver , WebElement element)
    {
    	FluentWait fluentwait = new FluentWait(driver);
    	fluentwait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
