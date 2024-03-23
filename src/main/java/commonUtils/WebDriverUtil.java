package commonUtils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
public class WebDriverUtil {

	JavaUtil jutil = new JavaUtil();
	
	public void maximize(WebDriver driver) {
		
		driver.manage().window().maximize();
		
	}
	
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public void handledropdown(WebElement targeteddropdown,String targetedoption) {
		
		Select s = new Select(targeteddropdown);
		s.selectByVisibleText(targetedoption);
	}
	
	public void mousehover(WebDriver driver,WebElement targeted) {
		
		Actions a = new Actions(driver);
		a.moveToElement(targeted);
		a.perform();
	}
	
	public void switchWindow(WebDriver driver, String expectedUrl) {
		
		//Check how many window are present in the webPage 
		Set<String> ids = driver.getWindowHandles();
		
		//To transfer the control from parent to child window
		for(String allWindow: ids )
		{
			String actualUrl = driver.switchTo().window(allWindow).getCurrentUrl();
			
			if(actualUrl.contains(expectedUrl)) {
				break;
			}
		}
	}
	
	public String screenShot(WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File destinationfile = new File("./ScrenShot/image"+jutil.getRandomNumber()+".png");
		FileUtils.copyFile(temp, destinationfile);
		
		return destinationfile.getAbsolutePath();
		
	}
	
}
