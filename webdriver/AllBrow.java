package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AllBrow {
	public static WebDriver driver;
	public static void ff() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
	}
	public static void Search() throws InterruptedException {
		WebElement elements = driver.findElement(By.name("q"));
		elements.sendKeys("selenium ");
		elements.submit();
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.close();
	}
	public static void chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.google.com");
	}
	public static void edge() {
		System.setProperty("webdriver.edge.driver", "D:\\Library\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		driver.get("https://www.google.com");
	}

	public static void main(String[] args) throws InterruptedException {
ff();
Search();
chrome();
Search();
edge();
Search();
	}
}


