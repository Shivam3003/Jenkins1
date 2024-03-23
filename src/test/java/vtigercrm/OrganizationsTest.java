package vtigercrm;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import commonUtils.BaseClass;
import commonUtils.ExcelUtil;
import commonUtils.JavaUtil;
import commonUtils.ListenerImplementation;
import commonUtils.PropertyFileUtil;
import commonUtils.WebDriverUtil;

@Listeners(ListenerImplementation.class)

public class OrganizationsTest extends BaseClass{
//
//	WebDriverUtil wutil = new WebDriverUtil();
//	JavaUtil jutil = new JavaUtil();
//	ExcelUtil eutil = new ExcelUtil();
//	
//	
//	@Test
//	public void OrganizationsTest() throws EncryptedDocumentException, IOException {
//	//To read data from excel file
//	String ORGNAME = eutil.getDataFromExcelFile("Organizations", 0, 1);
//	String Group = eutil.getDataFromExcelFile("Organizations", 1, 1); 
//	
//	        //To Click on organization
//			/*driver.findElement(By.linkText("Organizations")).click();
//			
//			//To Click on (+) button
//			driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
//			
//			//To Enter Organization name
//			driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
//			
//			//In AssignedTo Click on Group radio button
//			driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
//			
//			//In the Dropdown Select support group 
//			WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
//			wutil.handledropdown(dropdown, Group);
//			
//			//To click on save button
//			driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();*/
	
	PropertyFileUtil putil = new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	ExcelUtil eutil = new ExcelUtil();
	JavaUtil jutil = new JavaUtil();
	
	@Test
	public void CreateOrganizationTest() throws IOException, InterruptedException {
		
	//To read data from Excel File
	String ORGNAME = eutil.getDataFromExcelFile("Organizations", 0, 1);
	String GROUP = eutil.getDataFromExcelFile("Organizations", 1, 1);
	
	//Click on Organization
	driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
	
	//Click on Create Organization..(+)
	driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();

	wutil.screenShot(driver);
	
	//Enter Organization Name
	driver.findElement(By.name("accountname")).sendKeys(ORGNAME+jutil.getRandomNumber());
	
	//To fail the testScript we are using asserts 
	String actualUrl = driver.getCurrentUrl();
	String expectedUrl = "http://localhost:8888/pune/index.php?module=Home&action=index&parenttab=My%20Home%20Page";
	Assert.assertEquals(actualUrl, expectedUrl);
	
	//In AssignedTo Click on Group
	driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	//In the dropdown select Support group
	WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
	wutil.handledropdown(dropdown, GROUP);
	
	//Click on Save Button
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	
	}
}
