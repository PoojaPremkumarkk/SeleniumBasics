package org.selenium.basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class LaunchEdge1 {

	public static void main(String[] args) {
		
			// TODO Auto-generated method stub
			WebDriver driver=new EdgeDriver();
			
			driver.manage().window().maximize();
			driver.get("https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java/4.18.1");
				String title=driver.getTitle();
				System.out.println(title);
				String url=driver.getCurrentUrl();
				System.out.println(url);
				String p=driver.getPageSource();
				System.out.println(p);
				driver.close();
		}
		

	}


