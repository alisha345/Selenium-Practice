package webdriverBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ElementvisibilityTest {
	static WebDriver driver;
	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Entering the title
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");
		
		driver.manage().window().maximize();//Maximizing the window
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		//Entering the title
		driver.get("https://reg.ebay.com/reg/PartialReg?ru=https%3A%2F%2Fwww.ebay.com%2F");

		driver.manage().window().maximize();//Maximizing the window
	}
	

	public static void main(String[] args) throws Exception {
		
		//Firefox();
		Chrome();
		
		//1. isDisplayed method: Available for all the elements
		//Returns true(boolean) if element is available else returns false
		
		boolean b1 = driver.findElement(By.id("ppaFormSbtBtn")).isDisplayed();//true
		System.out.println(b1);
		
		//2. isEnabled method: Returns true(boolean) if element is enabled else returns false

		boolean b2 = driver.findElement(By.id("ppaFormSbtBtn")).isEnabled();//false
		System.out.println(b2);
		
		driver.findElement(By.id("firstname")).sendKeys("tommy");
		driver.findElement(By.id("firstname")).click();
		
		driver.findElement(By.id("lastname")).sendKeys("tomas");
		driver.findElement(By.id("lastname")).click();

		driver.findElement(By.id("email")).sendKeys("123@gmail.com");
		driver.findElement(By.id("email")).click();

		driver.findElement(By.id("PASSWORD")).sendKeys("Bcci@456");
		driver.findElement(By.id("PASSWORD")).click();
		Thread.sleep(2000);
		
		boolean b3 = driver.findElement(By.id("ppaFormSbtBtn")).isEnabled();//true
		System.out.println(b3);
		
		/*
		 * 3. isSelected method:only applicable for checkbox, radio buttons and dropdowns.
		 *    Returns true(boolean) if element is selected else returns false
		 */
		 
		boolean b4 = driver.findElement(By.xpath("//input[@aria-label='Show password checkbox']"))
		.isSelected();//false
		System.out.println(b4);
		
		driver.findElement(By.xpath("//input[@aria-label='Show password checkbox']")).click();
		
		boolean b5 = driver.findElement(By.xpath("//input[@aria-label='Show password checkbox']"))
				.isSelected();//true
				System.out.println(b5);
				
		driver.quit();
	}

}
