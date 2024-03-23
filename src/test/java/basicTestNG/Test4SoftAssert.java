package basicTestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Test4SoftAssert {

	@Test
	public void Ajio() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ajio.com/");
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		String expectedTitle = "Online punedeccan Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		
		//Create the object of soft assert
		SoftAssert s = new SoftAssert();
		s.assertEquals(actualTitle, expectedTitle);
		System.out.println("Jai Shree Ram");
		
		//Without assertAll() testScript is passed
		
		s.assertAll();
	}
}
