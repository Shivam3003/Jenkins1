package commonUtils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

	/*@BeforeSuite
	public void BS() {
		
	}
	
	@BeforeClass
	public void BC() {
		
	}
	
	@BeforeMethod
	public void BM() {
		
	}
	
	@AfterMethod
	public void AM() {
		
	}
	
	@AfterClass
	public void AC() {
		
	}
	
	@AfterSuite
	public void AS() {
		
	}*/
	
	//Driver is global
	public WebDriver driver;
	
	//only to screenshot
	public static WebDriver sdriver;
	
	
	//Object creation
	PropertyFileUtil putil = new PropertyFileUtil();
	JavaUtil jUtil = new JavaUtil();
	ExcelUtil eutil = new ExcelUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	
	@BeforeSuite
	public void BS() {
		System.out.println("Connect to Data-base");
	}
	
	@BeforeClass
	public void BC() throws IOException {
		
			String browser= putil.getDataFromPropertyFile("Browser");
			String url= putil.getDataFromPropertyFile("Url");
		
		//TO LAUNCH THE BROWSER
				if(browser.equals("Chrome")) {
					driver = new ChromeDriver();
				}
				else if(browser.equals("Edge")) {
					driver = new EdgeDriver();
				}
				else {
					driver = new FirefoxDriver();
				}
				
				//Initialize the static driver for takeScreenshot
				sdriver = driver;
				
				//TO maximize
				wutil.maximize(driver);
				//To apply implicit wait
				//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				wutil.implicitwait(driver);
				//To launch application
				driver.get(url);
	}
	
	@BeforeMethod
	public void BM() throws IOException {
		String username=putil.getDataFromPropertyFile("Username");
		String password=putil.getDataFromPropertyFile("Password");
		
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
	}
	
	@AfterMethod
	public void AM() throws InterruptedException {
		Thread.sleep(2000);
		
		WebElement account = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Perform actions mouseHover
		wutil.mousehover(driver, account);
		//Click to Sign-out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}
	
	@AfterClass
	public void AC() {
		driver.quit();
	}
	
	@AfterSuite
	public void AS() {
		System.out.println("Disconnect from Database");
	}
}
