package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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

    public static void main(String[] args) {
        WebTableExample example = new WebTableExample();
        example.verifyDynamicWebTable();
    }
}

