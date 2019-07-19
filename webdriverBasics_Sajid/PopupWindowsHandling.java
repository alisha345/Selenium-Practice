package webdriverBasics;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopupWindowsHandling {
	static WebDriver driver;


	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		
		/*Implicity waits are only recommended for simple or light website.
		 * for Heavy website it is recommended to use explicit wait.
		 */
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://seleniumbymahesh.com");//Entering the title

	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		/*Implicit waits are only recommended for simple or light website.
		 * for Heavy website it is recommended to use explicit wait.
		 */
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("http://seleniumbymahesh.com");//Entering the title

		
	}
	public static void Popups() throws InterruptedException {
			
			driver.findElement(By.linkText("HMS")).click();
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.name("submit")).click();
			driver.findElement(By.linkText("Feedback")).click();
			
		// POPUPS HANDLING
		Set<String> handler = driver.getWindowHandles();
		Object[] K = handler.toArray();
		driver.switchTo().window(K[1].toString());// Focus switches to child window 
		System.out.println("The title of the child Window is :"+ driver.getTitle());
		System.out.println("The URL of the child Window is :"+ driver.getCurrentUrl());

		driver.findElement(By.id("name")).sendKeys("Selenium student");
		driver.findElement(By.id("email")).sendKeys("popup_handling@gmail.com");
		Thread.sleep(3000);
		driver.close();//closes current window only
		//driver.quit();closes browsers (all windows)
		
		driver.switchTo().window(K[0].toString());//Focus shifts to parent window
		
		driver.findElement(By.xpath("//a[contains(text(),'ADT')]")).click();	
		System.out.println("The Popup is Sucessfully handeled");
		
		

		
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		Chrome();
		Popups();
	}

}
