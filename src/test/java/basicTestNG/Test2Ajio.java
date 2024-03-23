package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test2Ajio {
	@Test
	public void Ajio() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ajio.com/");
		String actualUrl = driver.getCurrentUrl();
		System.out.println(actualUrl);
		
		/*if(actualUrl.equals("https://www.ajio.com/")) {
			System.out.println("URL is matching");
		}else {
			System.out.println("URL is not matching");
		}
		System.out.println("Good Morning");*/
		
		String expectedUrl = "https://www.ajio.com/pune";
		Assert.assertEquals(actualUrl, expectedUrl);
		System.out.println("Good Morning");
	}
}
