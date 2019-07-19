package webdriverBasics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TakingScreenshot {
	static WebDriver driver;


	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://spicejet.com");//Entering the title

	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://spicejet.com");//Entering the title

		
	}
	
	public static void main(String[] args) throws IOException {
		
		Firefox();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:\\workspace\\Selenium_Screenshots\\spicejet1.jpg"));
		driver.quit();
	}

}
