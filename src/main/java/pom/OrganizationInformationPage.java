package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonUtils.WebDriverUtil;

public class OrganizationInformationPage {

	//Here driver is global
	public WebDriver driver;
	
	WebDriverUtil wutil = new WebDriverUtil();
	
	@FindBy(name="accountname")
	private WebElement organizationnametf;
	
	@FindBy(xpath="(//input[@name='assigntype'])[2]")
	private WebElement groupbtn;
	
	@FindBy(name="assigned_group_id")
	private WebElement dropdown;
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement savebtn;

	public WebElement getOrganizationnametf() {
		return organizationnametf;
	}

	public WebElement getGroupbtn() {
		return groupbtn;
	}

	public WebElement getDropdown() {
		return dropdown;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	
	public OrganizationInformationPage(WebDriver driver) {
		//TO initialize the webElement
		PageFactory.initElements(driver, this);
	}
	
	//Create a method 
	public HomePage organizationInformation(String orgname, String dropdownelement) {
		//Enter Intel in Organization name tf
		organizationnametf.sendKeys(orgname);
		//Click on group radio button
		groupbtn.click();
		//Handle drop down and select support group
		wutil.handledropdown(dropdown, dropdownelement);
		//click on save button
		savebtn.click();
		
		return new HomePage(driver);
	}
	
	
}
