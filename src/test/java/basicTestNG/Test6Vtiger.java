package basicTestNG;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Test6Vtiger {

	@Test
	public void vtiger()
	{
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
	}
	
	@BeforeSuite
	public void BS() {
		System.out.println("Before Suite");
	}
	
	@AfterSuite
	public void AS() {
		System.out.println("After Suite");
	}
	
	@BeforeClass
	public void BC() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public void AC() {
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void BM() {
		System.out.println("Before Method");
	}
	
	@AfterMethod
	public void AM() {
		System.out.println("After Method");
	}
	
	
}
