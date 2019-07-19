package webdriverBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LocatorsAll {
	static WebDriver driver;

	public static void Chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.get("http://ebay.com");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.get("http://ebay.com");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
	}
	
	
	
	
	public static void EbaySearch() throws Exception {
		
		/*There are total 8 locators in selenium
		1. Xpath 2.CssSelector 3.id 4.name 5.linkText(used only for links) 6.class(not used in realtime)
		7.tagname 8.partialLinkText (not used in realtime)
		*/
		
		 driver.findElement(By.id("gh-ac")).sendKeys("mobiles"); // Locator : id
		 driver.findElement(By.xpath("//input[@id='gh-ac']")).clear();//Locator : Xpath
		 driver.findElement(By.name("_nkw")).sendKeys("laptops");// Locator : name
		 driver.findElement(By.cssSelector("#gh-ac")).clear();// Locator : cssSelector
		 driver.findElement(By.linkText("Advanced")).click();// Locator : linkText
		 Thread.sleep(5000);
		 driver.quit();

	}


	public static void main(String[] args) throws Exception {
		Chrome();
		EbaySearch();
		
		/*
		 Firefox();
		EbaySearch();
		*/

		

	}

}
