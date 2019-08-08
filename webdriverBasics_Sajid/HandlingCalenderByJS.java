package webdriverBasics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class HandlingCalenderByJS {

static WebDriver driver;

	
	public static void chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.manage().deleteAllCookies();
		driver.get("https://www.spicejet.com/");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	public static void selectDtaeByJS(WebElement element, String date) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '"+date+"');", element);
		
	}

	public static void main(String[] args) {

		Firefox();
		WebElement depart_date	= driver.findElement(By.id("ctl00_mainContent_txt_Fromdate"));
		
		String Dep_date = "19-08-2019";
		String Ret_date = "25-09-2019";
		
		selectDtaeByJS(depart_date, Dep_date);
		
		Actions action = new Actions(driver);
		WebElement target_depart_date = driver.findElement(By.id("ctl00_mainContent_view_date1"));
		action.doubleClick(target_depart_date).build().perform();
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		
		 WebElement return_date = driver.findElement(By.id("ctl00_mainContent_txt_Todate"));
		selectDtaeByJS(return_date, Ret_date);
		WebElement target_return_date = driver.findElement(By.id("ctl00_mainContent_view_date2"));
		action.doubleClick(target_return_date).build().perform();
		
		driver.quit();
				
	}

}
