package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {
	
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
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().deleteAllCookies();
		driver.get("https://classic.crmpro.com/index.html");//Entering the title
		
	}
	
public static void Login() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("seleniumtest346");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("seleniumtest");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).submit();
		Thread.sleep(3000);
}
		 
	public static void Mouse_movement() throws InterruptedException {
		
		driver.switchTo().frame("mainpanel");//Shifting focus to frame 1
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		//driver.findElement(By.linkText("Email")).click();
		//driver.findElement(By.linkText("Deals")).click();
		

		
		Actions action = new Actions(driver);
	action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		
		
	}

	public static void main(String[] args) throws InterruptedException {

			Firefox();
			Login();
			Mouse_movement();
	}

}
