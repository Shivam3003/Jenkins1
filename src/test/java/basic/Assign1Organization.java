package basic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

public class Assign1Organization {
	
	public static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		PropertyFileUtil putil = new PropertyFileUtil();
		
		ExcelUtil eutil = new ExcelUtil();//To get the data from excel sheet of a company name
		
		JavaUtil jutil = new JavaUtil();//To generate a random number along with company name to avoid same company
										//register company name
		
		WebDriverUtil wutil = new WebDriverUtil();
		
		String BROWSER = putil.getDataFromPropertyFile("Browser");
		String URL = putil.getDataFromPropertyFile("url");
		String USERNAME = putil.getDataFromPropertyFile("Username");
		String PASSWORD = putil.getDataFromPropertyFile("Password");
		
		//To read data from Excel file
		String ORGNAME = eutil.getDataFromExcelFile("Organizations", 0, 1);
		String GROUP = eutil.getDataFromExcelFile("Organizations", 1, 1);
		
		if (BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
			
		} else if (BROWSER.equals("Edge")){
			driver = new EdgeDriver();
			
		}else {
			driver = new FirefoxDriver();
			
		}
		
		wutil.maximize(driver);
		
		wutil.implicitwait(driver);
				
		driver.get(URL);
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		//Click on Organizations
		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		//click on create organization(+)
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		
		//Enter organizations name
		driver.findElement(By.cssSelector("input[name='accountname']")).sendKeys(ORGNAME+jutil.getRandomNumber());
		
		//click on group radio button
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		//Select support group radio button
		WebElement dd = driver.findElement(By.name("assigned_group_id"));
		
		/*Select s = new Select(dd);
		s.selectByVisibleText(GROUP);*/
		
		wutil.handledropdown(dd, GROUP); // We are calling this method to reduce the code and reuse multiple time
		
		
		//Click on save button
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		Thread.sleep(2000);
		
		//Mouse hover on image
		WebElement mouse = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		
		/*Actions a = new Actions(driver);
		a.moveToElement(mouse).perform();*/
		
		wutil.mousehover(driver, mouse);
		
		//click on sign out
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		
	}

}
