package webdriverBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LinksCounting {
	static WebDriver driver;
	static int count =0;

	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.manage().deleteAllCookies();
		driver.get("https://spicejet.com");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().deleteAllCookies();
		driver.get("https://spicejet.com");//Entering the title
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public static void LinksCount() {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Toatal number of Links: "+links.size());
		System.out.println("TheVisible Links are:");
		for(int i = 0; i<links.size();i++) {
			
			if(!links.get(i).getText().isEmpty()) {
				System.out.println(links.get(i).getText());
				links = driver.findElements(By.tagName("a"));//Avoids stale element reference error
				count = count+1;
				
			}
		}
		System.out.println("Total number of Visible links are :"+count);
		System.out.println("Total number of Non-Visible links are :"+(links.size()-count));		
		driver.quit();
	}
	

	public static void main(String[] args) {
		
		Firefox();
		LinksCount();

	}

}
