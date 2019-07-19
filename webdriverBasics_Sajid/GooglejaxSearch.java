package webdriverBasics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GooglejaxSearch {
	
static WebDriver driver;

	
	public static void chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testing");
		
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testing");

	}
	//div[@class='aajZCb']//ul//li//descendant::div[@class='sbl1']

	public static void main(String[] args) {
		Firefox();
		List<WebElement> list = driver.findElements(By
				.xpath("//div[@class='aajZCb']//ul//li//descendant::div[@class='sbl1']"));
		System.out.println(list.size());
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("tools")) {
				list.get(i).click();
				break;
			}
		}
		driver.quit();

	}

}
