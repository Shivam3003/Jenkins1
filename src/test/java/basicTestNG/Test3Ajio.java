package basicTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test3Ajio {

	@Test
	public void Ajio() {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.ajio.com/");
		/*String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		
		String expectedTitle = "Online Shopping for Women, Men, Kids – Clothing, Footwear | AJIO";
		
		Assert.assertEquals(actualTitle, expectedTitle);
		System.out.println("Jai Shree Ram");*/
		
		WebElement searchtf = driver.findElement(By.name("searchVal"));
		
		//Hard assert
		
		/*//True condition the output will be pass---search text field is enable
		//False condition the output will be fail---search text field is selected
		Assert.assertTrue(searchtf.isEnabled()); //True condition
		Assert.assertTrue(searchtf.isSelected()); //False condition
		System.out.println("Jai Shree Ram");*/
		
		//True condition the output will be fail---search text field is enable
		//False condition the output will be pass---search text field is selected
		Assert.assertFalse(searchtf.isEnabled()); //True condition
		Assert.assertFalse(searchtf.isSelected()); //False condition
		System.out.println("Jai Shree Shyam");
		
	}
}
