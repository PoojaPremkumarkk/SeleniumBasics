package utilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebElementUtility {
    public static boolean isElementDisplayed(WebElement element) {
        boolean status = element.isDisplayed();
        return status;
    }
    public static boolean isElementEnabled(WebElement element) {
        boolean status = element.isEnabled();
        return status;
    }
    public static boolean isElementSelected(WebElement element) {
        boolean status = element.isSelected();
        return status;
    }
    public static void scrollToElement(WebDriver driver, WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[2].scrollIntoView(true);", element);
    }
    public static void enterText(WebElement element, String text) {
        if (isElementEnabled(element)) {
            element.clear(); 
            element.sendKeys(text);
}}}
