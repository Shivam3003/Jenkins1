package vtigercrm;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import commonUtils.PropertyFileUtil;

public class Leads {

	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		
				//Object creation
				PropertyFileUtil putil = new PropertyFileUtil();
				
				//To read data from property file
				String BROWSER = putil.getDataFromPropertyFile("Browser");
				String URL = putil.getDataFromPropertyFile("url");
				String USERNAME = putil.getDataFromPropertyFile("Username");
				String PASSWORD = putil.getDataFromPropertyFile("Password");
				
				//To launch the browser
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
				
				//Click on Leads
				driver.findElement(By.xpath("//a[text()='Leads']")).click();
				
				//Click on + 
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				
				//Enter first name
				driver.findElement(By.name("firstname")).sendKeys("Shah Rukh");
				
				//Enter last name
				driver.findElement(By.name("lastname")).sendKeys("Khan");
				
				//Enter company name
				driver.findElement(By.name("company")).sendKeys("Bollywood");
				
				//Click on group radio button
				driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
				
				//Handle the drop down
				WebElement dd = driver.findElement(By.name("assigned_group_id"));
				
				Select s = new Select(dd);
				
				s.selectByVisibleText("Team Selling");
				
				//Click on save button
				driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
				
				//Hover on image
				WebElement hover = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
				
				Actions a = new Actions(driver);
				
				a.moveToElement(hover).perform();
				
				//Click on Sign-out
				driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
	}

}
