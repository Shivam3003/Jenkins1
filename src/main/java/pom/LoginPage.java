package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	//Here driver is global
	public WebDriver driver;
	
	@FindBy(name="user_name")
	private WebElement usernametf;
	
	@FindBy(name="user_password")
	private WebElement passwordtf;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;

	public WebElement getUsernametf() {
		return usernametf;
	}

	public WebElement getPasswordtf() {
		return passwordtf;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	//Create a Constructor
	public LoginPage(WebDriver driver) {
		//To initialize the webElement
		PageFactory.initElements(driver, this);
	}
	
	//Create a method 
	public HomePage login(String username, String passworddata) {
		
		usernametf.sendKeys(username);
		passwordtf.sendKeys(passworddata);
		loginbtn.click();
		return new HomePage(driver);
	}
}
