package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtil;

public class HomePage {
	
	//Here driver is global
	public WebDriver driver;
	
	WebDriverUtil wutil = new WebDriverUtil();

	@FindBy(xpath="(//a[text()='Organizations'])[1]")
	private WebElement organizations;
	
	@FindBy(xpath="//a[text()='Contacts']")
	private WebElement contacts;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement image;
	
	@FindBy(xpath="//a[text()='Sign Out']")
	private WebElement signoutbtn;

	public WebElement getOrganizations() {
		return organizations;
	}

	public WebElement getContacts() {
		return contacts;
	}

	public WebElement getImage() {
		return image;
	}

	public WebElement getSignoutbtn() {
		return signoutbtn;
	}
	
	//Create a constructor 
	public HomePage(WebDriver driver) {
		//To initialize the webelement
		PageFactory.initElements(driver, this);
	}
	
	//Create a method
	public void home() {
		//Click on organization
		organizations.click();
	}
	
	//Create a method
	public LoginPage home(WebDriver driver) {
		//mouse hover on image
		wutil.mousehover(driver, image);	
		//click on sign out button
		signoutbtn.click();
		
		return new LoginPage(driver);
	}
	
}
