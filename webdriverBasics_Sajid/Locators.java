package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locators {
	
	static WebDriver driver;
	static String str;
	public static void OpenUrl() {
		
	
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.get("http://seleniumbymahesh.com");//Entering the title
		driver.manage().window().maximize();//maximizing the the  window
	}
	
	/*There are total 8 locators in selenium
	1. Xpath 2.CssSelector 3.id 4.name 5.linkText(used only for links) 6.class(not used in realtime)
	7.tagname 8.partialLinkText (not used in realtime)
	*/
	public static void HmsLogin() {
		driver.findElement(By.linkText("HMS")).click();//Locator: 'LinkText' 
		
		driver.findElement(By.name("username")).sendKeys("admin"); //Locator: 'name'
		driver.findElement(By.name("password")).sendKeys("admin");
		
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
	}
	
	public static void Registration() {
		driver.findElement(By.linkText("Registration")).click();
		
	}

	public static void main(String[] args) {
OpenUrl();
HmsLogin();

driver.quit();
	}

}
