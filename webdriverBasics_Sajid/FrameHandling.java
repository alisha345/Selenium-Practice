package webdriverBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameHandling {
	static WebDriver driver;


	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.get("https://classic.crmpro.com/index.html");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.get("https://classic.crmpro.com/index.html");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().deleteAllCookies();
		/* pageload is dynamic in nature, it will wait maximum of 30 sec for webpage to load,
		 *  but if page loaded faster than prescribed time it will ignore reaming time and proceeds 
		 *  further
		 */
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	}
	
	public static void HandlingFrames() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("seleniumtest346");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("seleniumtest");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).submit();
		/*implicitly wait is also same as page load but it is for all the elements 
		 * in the webpage.
		 * 
		 */
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.switchTo().frame("mainpanel");//Shifting focus to frame 1
		 
	driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	driver.switchTo().defaultContent();
		driver.quit();
		
	}
	public static void main(String[] args) throws InterruptedException {
		
		Firefox();
		HandlingFrames();
		
		//Chrome();
		//HandlingFrames();


	}

}
