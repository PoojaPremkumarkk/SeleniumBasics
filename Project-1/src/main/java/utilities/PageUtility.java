package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


public class PageUtility {

    // Method to select a value from a dropdown by its value
    public static void selectByValueFromDropDown(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }

    // Method to perform mouse hover action
    public static void hoverOverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }

    // Method to perform right-click (context click) on an element
    public static void rightClickOnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).perform();
    }
    public static void doubleClickOnElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.doubleClick(element).perform();
    }
    public static void dragAndDrop(WebDriver driver, WebElement source, WebElement target) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).perform();
    }
    public static void uploadFile(WebElement fileInput, String filePath) {
        fileInput.sendKeys(filePath);
    }
    public static void switchToFrameByElement(WebDriver driver, WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }
    public static void switchToFrameByIndex(WebDriver driver, int index) {
        driver.switchTo().frame(index);
    }
    public static void switchToFrameByNameOrId(WebDriver driver, String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }
    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
}

	


    



