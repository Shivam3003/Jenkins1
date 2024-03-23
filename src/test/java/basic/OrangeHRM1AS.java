package basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM1AS {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		//driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//Step1: Create object of FileInputStream class & in the FileInputStream constructor pass the path of the external file
		FileInputStream fis = new FileInputStream("src\\test\\resources\\data.properties");
		//select the data.properties file -- right click --properties -location - copy & paste until src
		
		//Step2: Create object of properties class
		Properties p = new Properties();
		
		//Step3: Call a load(InputStream)
		p.load(fis);
		
		//Step4: Call a getProperty(String Key)
		String USERNAME = p.getProperty("Username");
		String PASSWORD = p.getProperty("Password");
		String url = p.getProperty("URL");
		driver.get(url);
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		
	}

}
