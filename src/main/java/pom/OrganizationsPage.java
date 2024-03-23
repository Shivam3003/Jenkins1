package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	
	//Here driver is global
	public WebDriver driver;

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createorganization;

	public WebElement getCreateorganization() {
		return createorganization;
	}
	
	public OrganizationsPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		PageFactory.initElements(driver, this);
	}
	
	//Create a method
	public OrganizationInformationPage Organizations() {
		//Click on Create Organization..(+)
		createorganization.click();
		return new OrganizationInformationPage(driver);
	}
}
