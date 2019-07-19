package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DraggAndDrop {

	static WebDriver driver;

	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.manage().deleteAllCookies();
		driver.get("https://jqueryui.com/droppable/");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().deleteAllCookies();
		driver.get("https://jqueryui.com/droppable/");//Entering the title
		
	}
	public static void DraggingAndDropping() throws InterruptedException {
		
		//shifting to frame
		WebElement e = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(e);
		
		Actions a = new Actions(driver);
		//clicking and holding the source
		a.clickAndHold(driver.findElement(By.xpath("//div[@id='draggable']")))
		//moving the source to target element
		.moveToElement(driver.findElement(By.xpath("//div[@id='droppable']")))
		//releasing the hold
		.release()
		//actions class methods
		.build().perform();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//a[contains(text(),'Accept')]")).click();
		Thread.sleep(3000);
		driver.quit();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		Chrome();
		DraggingAndDropping();
		

	}

}
