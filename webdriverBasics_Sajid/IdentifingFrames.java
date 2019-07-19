package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IdentifingFrames {
	static WebDriver driver;
	public static void launchingBrowser() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.get("https://classic.crmpro.com/index.html");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().deleteAllCookies();
	}

public static void Login() throws InterruptedException {
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("seleniumtest346");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("seleniumtest");
		driver.findElement(By.xpath("//input[@class='btn btn-small']")).submit();
		Thread.sleep(3000);
}

public static void Frames() {
	
	int size = driver.findElements(By.tagName("frame")).size();
	  System.out.println("total number of frames:"+size);

}

	public static void main(String[] args) throws InterruptedException {
		launchingBrowser();
		Login();
		Frames();
		

		
	}

}
