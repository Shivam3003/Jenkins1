package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1Flipkart {
	
	@Test(priority =  1)
	public void flipkart() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
	}
	
	@Test(priority = 0)
	public void amazon() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
	}
	
}
