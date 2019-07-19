package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {
	static WebDriver driver;
	

	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.get("http://www.seleniumbymahesh.com");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.get("http://www.seleniumbymahesh.com");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
	}
	// creating explicit wait for all click(); functions
	public static void clickon(WebDriver driver , WebElement element, int timeout) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	// ceating method for all sendkeys(); function
	public static void senkeys(WebDriver driver , WebElement locator, int timeout, String value) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.sendKeys(value);
		
	}
	public static void hmslogin() {
		clickon(driver, driver.findElement(By.xpath("//li[@id='menu-item-186']/a[contains(text(), 'HMS')]")), 30);
		
		
		/*Xpath using Parent child ralation , where child tag uses contains(text(), 'value') method
		 * findElement(By.xpath("//li[@id='menu-item-186']/a[contains(text(), 'HMS')]"))
		 */
		WebElement username 	= driver.findElement(By.name("username"));
		WebElement password 	= driver.findElement(By.name("password"));
		WebElement login 		= driver.findElement(By.name("submit"));
		WebElement logout		= driver.findElement(By.xpath("//a[contains(text(), 'Logout')]"));
		
		
		senkeys(driver, username, 10, "admin");// passing username
		senkeys(driver, password, 5, "admin");// passing password
		clickon(driver, login, 5);// clicking login button
		clickon(driver, logout, 5); // clicking logout button
		driver.quit();
		
	}
	

	public static void main(String[] args) {
		Firefox();
		hmslogin();

	}

}
