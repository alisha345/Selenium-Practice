package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class LaunchingBrowesers {
	public static WebDriver driver;
	public static void openurl()
	{
		System.setProperty("webdriver.gecko.driver", 
				"D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
		driver.close();
	}
	public static void chrome() {
		System.setProperty("webdriver.chrome.driver", 
				"D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://yahoo.com");
		driver.manage().window().maximize();
		driver.close();
	}
	public static void edge() {
		System.setProperty("webdriver.edge.driver", 
				"D:\\Library\\MicrosoftWebDriver.exe");
		driver = new EdgeDriver();
		driver.get("http://guru99.com");
		driver.manage().window().maximize();
		driver.close();
	}
	public static void ie() {
		System.setProperty("webdriver.ie.driver", 
				"D:\\Library\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://seleniumbymahesh.com");
		driver.manage().window().maximize();
		driver.close();
	}
	public static void opera() {
		System.setProperty("webdriver.opera.driver", 
				"D:\\Library\\operadriver_win32\\operadriver.exe");
		driver = new OperaDriver();
		driver.get("http://seleniumbymahesh.com");
		driver.manage().window().maximize();
		driver.close();
	}

	public static void main(String[] args) {
		openurl();
		chrome();
		edge();
		ie();
		//opera();

	}

}
