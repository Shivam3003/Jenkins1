package basicPOM;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import commonUtils.JavaUtil;
import pom.HomePage;
import pom.LoginPage;
import pom.OrganizationInformationPage;
import pom.OrganizationsPage;

public class BasePage {
//	public static void main(String[] args) throws InterruptedException {
//		WebDriver driver = new ChromeDriver();
//		
//		driver.manage().window().maximize();
//		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		
//		driver.get("http://localhost:8888/");
//		
//		LoginPage lp = new LoginPage();
//		
//		//To initialize the webElements we are using PageFactory class
//		PageFactory.initElements(driver, lp);
//		//Enter admin in user name text field
//		lp.getUsernametf().sendKeys("admin");
//		//Enter admin in password text field
//		lp.getPasswordtf().sendKeys("admin");
//		//click on login btn
//		lp.getLoginbtn().click();
//		
//		HomePage hp = new HomePage();
//		
//		//To initialize the webElements we are using PageFactory class
//		PageFactory.initElements(driver, hp); 
//		//Click on Organization
//		hp.getOrganizations().click();
//		
//		OrganizationsPage op = new OrganizationsPage();
//		//To initialize the webElements we are using PageFactory class
//		PageFactory.initElements(driver, op);
//		//Click on create Organization ... (+)
//		op.getCreateorganization().click();
//		
//		OrganizationInformationPage oip = new OrganizationInformationPage();
//		
//		PageFactory.initElements(driver, oip);
//		//Enter Intel in Organization name tf
//		oip.getGroupbtn().click();
//		
//		
//		/*Thread.sleep(2000);
//		Actions a = new Actions(driver);
//		a.moveToElement(hp.getImage()).perform();
//		hp.getSignoutbtn().click();*/
//		
//	}
	
	JavaUtil jutil =new JavaUtil();
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/");
		
		LoginPage lp = new LoginPage(driver);
		lp.login("admin", "admin");
		
		/*//To initialize the webelement
		PageFactory.initElements(driver, lp);
		//Enter admin in username tf
		lp.getUsernametf().sendKeys("admin");
		//Enter admin in password tf
		lp.getPasswordtf().sendKeys("admin");
		//Click on Login button
		lp.getLoginbtn().click();*/
		
		HomePage hp = new HomePage(driver);
		hp.home();
		
		/*//To initialize the webelement
		PageFactory.initElements(driver, hp);
		//Click on Organizations
		hp.getOrganizations().click();*/
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.Organizations();
		
		/*//To initialize the webelement
		PageFactory.initElements(driver, op);
		//Click on Create Organization..(+)
		op.getCreateorganization().click();*/
		
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		oip.organizationInformation("Intel", "Support Group");
		
		/*oip.organizationInformation("Intel");
		To initialize the webelement
		PageFactory.initElements(driver, oip);
		Enter Intel in Organization name tf
		oip.getOrganizationnametf().sendKeys("Intel28");		
		Click on group radio button
		oip.getGroupbtn().click();	
		Handle dropdown and select support group
		Select s = new Select(oip.getDropdown());
		s.selectByVisibleText("Support Group");		
		Click on save button
		oip.getSavebtn().click();*/
		
		Thread.sleep(2000);
		
		hp.home(driver);
		/*Actions a = new Actions(driver);
		a.moveToElement(hp.getImage()).perform();
		hp.getSignoutbtn().click();*/
	}
}
