package vtigercrm;

import java.io.IOException;
//import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;

import commonUtils.ExcelUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class Contacts {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFileUtil putil = new PropertyFileUtil();
		WebDriverUtil wdu = new WebDriverUtil();
		ExcelUtil eutil = new ExcelUtil();
		
		//To read data from property file
		String BROWSER = putil.getDataFromPropertyFile("Browser");
		String URL = putil.getDataFromPropertyFile("url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//To read the data from Excel File
		String FIRSTNAME = eutil.getDataFromExcelFile("Contacts", 0, 1);
		String LASTNAME = eutil.getDataFromExcelFile("Contacts", 1, 1);
		String GROUP = eutil.getDataFromExcelFile("Contacts", 2, 1);
		
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
		wdu.maximize(driver);
		//driver.manage().window().maximize();
		
		//TO apply implicit wait
		wdu.implicitwait(driver);
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		//To launch the application
		driver.get(URL);
		
		//Login to application
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);;
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Contacts
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
		//Click on Create contact..(+)
		driver.findElement(By.cssSelector("img[alt='Create Contact...']")).click();
		
		//Enter First name
		driver.findElement(By.cssSelector("input[name='firstname']")).sendKeys(FIRSTNAME);
		
		//Enter Last name
		driver.findElement(By.cssSelector("input[name='lastname']")).sendKeys(LASTNAME);
		
		//Click on Group radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//Select team selling
		WebElement dd= driver.findElement(By.name("assigned_group_id"));
		/*Select s = new Select(dd);//in select constructor pass targeted webElement 
		s.selectByVisibleText("Team Selling");*/
		wdu.handledropdown(dd, GROUP);
		
		//Click on + in Organization name
		driver.findElement(By.xpath("(//img[@alt='Select'])[1]")).click();
		
		//To transfer the control from parent to child window
		wdu.switchWindow(driver, "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=");
		
		//Enter the Organization name in search tf
		driver.findElement(By.id("search_txt")).sendKeys("TCS");
						
		//Click on search now button
		driver.findElement(By.name("search")).click();
				
		//Click on Organization name
		driver.findElement(By.xpath("//a[text()='TCS']")).click();
		
		//Transfer the control from child to parent window
		wdu.switchWindow(driver, "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
						
		//Click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		
		//Mouse hover on image
		WebElement hover = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		/*Actions a = new Actions(driver);
		a.moveToElement(hover).perform();*/
		wdu.mousehover(driver, hover);
		
		//Click on Sign-out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
