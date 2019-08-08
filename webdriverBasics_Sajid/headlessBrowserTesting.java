package webdriverBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class headlessBrowserTesting {

		static WebDriver driver;
		
		public static void headlessChromeTesting() {
			System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			options.addArguments("window-size=1800,800");
			options.addArguments("headless");
			
			driver = new ChromeDriver(options);//Launching Browser
			driver.get("https://classic.crmpro.com/login.cfm");//Entering the title
			System.out.println("Title of login page : "+ driver.getTitle());
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys("seleniumtest346");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("seleniumtest");
			driver.findElement(By.xpath("//input[@class='btn btn-small']")).submit();
			System.out.println("Title of Home page : "+ driver.getTitle());

		}
		
		public static void headlessFirefoxTesting() {
			
			System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
			
			FirefoxOptions fo = new FirefoxOptions();
			fo.setHeadless(true);
			
			driver = new FirefoxDriver(fo);//Launching Firefox
			driver.manage().deleteAllCookies();
			driver.get("https://classic.crmpro.com/login.cfm");//Entering the title
			System.out.println("Title of login page : "+ driver.getTitle());			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//input[@placeholder='Login']")).sendKeys("seleniumtest346");
			driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("seleniumtest");
			driver.findElement(By.xpath("//input[@class='btn btn-small']")).submit();
			
			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			WebElement frame = driver.findElement(By.xpath("//frame[@name='mainpanel']"));

			wait.until(ExpectedConditions.elementToBeClickable(frame));
			System.out.println("Title of Home page : "+ driver.getTitle());
			//WebElement frame = driver.findElement(By.xpath("//frame[@name='mainpanel']"));
			driver.switchTo().frame(frame);
			driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
			
			
		}
		
		
	public static void main(String[] args) {
		
		//headlessChromeTesting();

		headlessFirefoxTesting();
	}

}
