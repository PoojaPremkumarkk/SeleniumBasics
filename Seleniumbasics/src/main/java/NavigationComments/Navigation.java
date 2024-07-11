package NavigationComments;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;
public class Navigation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver=new EdgeDriver();
driver.manage().window().maximize();
driver.get("https://www.seleniumeasy.com/");
driver.navigate().back();
driver.navigate().forward();
driver.navigate().refresh();
driver.navigate().to("https://www.javatpoint.com/");
driver.close();
	}

}
