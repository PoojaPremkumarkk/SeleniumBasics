package org.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Launchfirefox {

	public static void main(String[] args) {
		
        WebDriver driver = new FirefoxDriver();

        
        driver.get("https://www.google.com");

        
        System.out.println("Title: " + driver.getTitle());

        // Close the browser
        driver.quit();
    }
	}


