package org.autoIT.com;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class imageUpload {
	static WebDriver driver;
	
	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.get("http://www.seleniumbymahesh.com/HMS");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		

	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.get("http://www.seleniumbymahesh.com");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
	}
	
	public static void clickon(WebDriver driver , WebElement element, int timeout) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
	}
	
	public static void submit(WebDriver driver , WebElement element, int timeout) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(element));
		element.submit();
		
	}
	// ceating method for all sendkeys(); function
	public static void senkeys(WebDriver driver , WebElement locator, int timeout, String value) {
		new WebDriverWait(driver, 30).ignoring(StaleElementReferenceException.class)
		.until(ExpectedConditions.elementToBeClickable(locator));
		locator.sendKeys(value);
		
	}
	
	public static void imageUpload1() throws Exception {
		
		WebElement userid = driver.findElement(By.name("username"));
		senkeys(driver, userid, 30, "admin");
		
		
		WebElement pass = driver.findElement(By.name("password"));
		senkeys(driver, pass, 30, "admin");
		
		WebElement login = driver.findElement(By.name("submit"));
		clickon(driver, login, 30);
		
		WebElement reg = driver.findElement(By.linkText("Registration"));
		clickon(driver, reg, 30);
		
		WebElement perreg = driver.findElement(By.linkText("Perminent Registration"));
		clickon(driver, perreg, 30);
		WebElement image = driver.findElement(By.name("image"));
		clickon(driver, image, 30);
		Thread.sleep(3000);

		Runtime.getRuntime().exec("D:\\workspace\\Autoit_testeditor\\test-1.exe");
		
		Thread.sleep(10000);
		
		WebElement logout = driver.findElement(By.linkText("Logout"));
		clickon(driver, logout, 30);
		driver.quit();
		
		
		
		
	}

	public static void main(String[] args)  throws Exception {
		
		Chrome();
		imageUpload1();

		
	}

}
