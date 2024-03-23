package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Vtiger1Test1 {

	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//WebDriver driver = new ChromeDriver();
		
		//To read data from property file
		//Step1: Create object of FileInputStream class & in the FileInputStream constructor pass the path of the external file
		FileInputStream fis = new FileInputStream("src\\test\\resources\\LoginCredintial.properties");
		
		//Step2: Create object of properties class
		Properties properties = new Properties();
		
		properties.load(fis);
		
		String BROWSER = properties.getProperty("Browser");
		String URL = properties.getProperty("url");
		String USERNAME = properties.getProperty("Username");
		String PASSWORD = properties.getProperty("Password");
		
		//to Launch the browser
		if(BROWSER.equals("Chrome")) {
			 driver = new ChromeDriver();
			
		}
		else if(BROWSER.equals("Edge")) {
			 driver = new EdgeDriver();
			
		}
		else{
			 driver = new FirefoxDriver();
		}
		
		//To maximize the window
		driver.manage().window().maximize();
		
		//TO apply implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//To launch the application
		driver.get(URL);
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);;
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
	}
}
