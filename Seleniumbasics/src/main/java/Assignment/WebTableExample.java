package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

public class WebTableExample {
    public void verifyDynamicWebTable() {
       
   
        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://money.rediff.com/indices/nse");

        // Click the "Show More" button
        WebElement showmore = driver.findElement(By.xpath("//a[@id='showMoreLess']"));
        showmore.click();

        // Locate the full table
        WebElement fulltable = driver.findElement(By.xpath("//table[@id='dataTable']"));

        // Locate a specific row (optional, for example purposes)
        WebElement tablerow = driver.findElement(By.xpath("//table[@id='dataTable']/tbody/tr[5]"));

        // Get all rows of the table
        List<WebElement> rows = fulltable.findElements(By.tagName("tr"));
        int rowsize = rows.size();

        // Iterate through the rows
        for (int i = 0; i < rowsize; i++) {
            List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
            int columnsize = columns.size();

            // Iterate through the columns
            for (int j = 0; j < columnsize; j++) {
                String cellData = columns.get(j).getText();
                
                // Check if the cell data matches "NIFTY BANK"
                if (cellData.equals("NIFTY BANK")) {
                    System.out.println("Prev Close value is " + columns.get(1).getText());
                }
            }
        }

        // Close the browser
        driver.close();
    }
    public void verifyFileUpload()
    {
    	WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/test/upload/");
        WebElement fileupload=driver.findElement(By.xpath("//input[@id='uploadfile_0']"));
        fileupload.sendKeys("C:\\Users\\pooja\\git\\Seleniumbasics\\Seleniumbasics\\src\\main\\resources\\fileupload");
        WebElement check=driver.findElement(By.id("terms"));
        check.click();
        WebElement submit=driver.findElement(By.id("submitbutton"));
        submit.click();
        driver.close();
        
    	
    }

    
    public void verifyKeyboardActions() throws AWTException
    {
    	WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com");
        Robot robot=new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_T);
        robot.keyRelease(KeyEvent.VK_CONTROL);
    	
    }
    public static void main(String[] args) throws AWTException {
        WebTableExample example = new WebTableExample();
        example.verifyKeyboardActions();
        //example.verifyFileUpload();
        //example.verifyDynamicWebTable();
    }
}

