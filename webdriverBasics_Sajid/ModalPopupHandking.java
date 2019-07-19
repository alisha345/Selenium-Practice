package webdriverBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalPopupHandking {
	static WebDriver driver;
	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.get("http://www.hotstar.com");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.get("http://www.hotstar.com");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}
	// creating explicit wait for all click(); functions
	public static void clickon(WebDriver driver , WebElement element, int timeout) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	// Creating method for all sendkeys(); function
	public static void senkeys(WebDriver driver , WebElement locator, int timeout, String value) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.sendKeys(value);
		
	}
	public static void login() {
		
		WebElement login = driver.findElement(By.xpath("//div[@class='signIn']"));
		clickon(driver, login, 5);
		
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//input[@id='phoneNo']")))
		.click()
		.build().perform();
		WebElement mobile_number = driver.findElement(By.xpath("//input[@id='phoneNo']"));
		senkeys(driver, mobile_number, 10, "8341400974");
		WebElement submit = driver.findElement(By.xpath("//button[@class='submit-button']"));
		clickon(driver, submit, 10);

		try {
			driver.findElement(By.linkText("Privacy Policy")).isDisplayed();
			WebElement error_text = driver.findElement(By.xpath("//p[@class='error-txt']"));
			System.out.println("The error msg is :"+error_text.getText());
		} catch(Exception e) {
			System.out.println("Enter 4-digit pin send to ur mobile number");
		}
		
		
		
		}
	
	public static void main(String[] args) {

		Chrome();
		login();
		
	}

}
