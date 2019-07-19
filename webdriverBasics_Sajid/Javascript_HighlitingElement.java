package webdriverBasics;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Javascript_HighlitingElement {
	static WebDriver driver;

	
	public static void chrome() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.manage().deleteAllCookies();
		driver.get("http://facebook.com");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public static void Firefox() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();//Launching Firefox
		driver.manage().deleteAllCookies();
		driver.get("http://facebook.com");//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public static void highlighterElement() throws Exception{
		
		//JavascriptExecutor js 	 = (JavascriptExecutor) driver;
		WebElement username		 = driver.findElement(By.id("email"));
		WebElement pass			 = driver.findElement(By.id("pass"));
		
		//refeshes the browser
		refreshBrowserByJS(driver);
		
		//SendKeys Action using JS
		sendkeysActionByJS(username, driver, "sajid2");
		sendkeysActionByJS(pass, driver, "pass");
		
		//Flashing Element Using JS
		WebElement login = driver.findElement(By.xpath("//input[@value='Log In']"));
		flash(login, driver);
		
		//Draw Border to element
		drawBorder(pass, driver);
		//Takes Screenshot and stores as File format
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//Storing screenshot to desired location
		FileUtils.copyFile(src, new File("D:\\workspace\\Selenium_Screenshots\\FbLoginPage.jpg"));
		
		//Generating alert
		generatingAlert(driver, "There is a problem with Highlited Element");
		driver.switchTo().alert().accept();
		
		
		//clicking button using javascript
		clickActionByJS(login, driver);
		//js.executeScript("document.getElementById('u_0_a').click();");



	}
	
	/*
	 * 
Sometimes web controls don’t react well against selenium commands and we may face issues with the above statement (click()).
To overcome such kind of situation, we use JavaScriptExecutor interface.
It provides mechanism to execute Javascript through Selenium driver. 
It provides “executescript” & “executeAsyncScript” methods, to run
JavaScript in the context of the currently selected frame or window.
	 */
		
	public static void flash(WebElement element, WebDriver driver) {
		
		JavascriptExecutor js 	= (JavascriptExecutor) driver;
		String bgcolor 			= element.getCssValue("backgroundColor");
		for(int i=0; i<10; i++) {
			changeColor("rgb(0,200,0)", element, driver);
			changeColor(bgcolor, element, driver);
		}
	}
	

	public static void changeColor(String color, WebElement element, WebDriver driver) {
		
		JavascriptExecutor js 	= (JavascriptExecutor) driver;
		
		//executeScript -- used to execute the arguments
		js.executeScript("arguments[0].style.backgroundColor = '"+color+"'", element);
		
	}
	public static void refreshBrowserByJS(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("history.go(0)");
    }
	public static void clickActionByJS(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}
	public static void sendkeysActionByJS(WebElement element, WebDriver driver, String str) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value ='"+str+"';", element);
	}
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].style.border='5px solid red'", element);

	}
	public static void generatingAlert(WebDriver driver,String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('"+message+"')");
		
	}
	public static String getTitleByJS(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String title = js.executeScript("return document.title;").toString();
    	return title;
    }
    public static String getPageInnerText(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	String pageText = js.executeScript("return document.documentElement.innerText;").toString();
    	return pageText;
    }
    
    public static void scrollPageDown(WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
    }
    
    public static void scrollIntoView(WebElement element, WebDriver driver){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
    	js.executeScript("arguments[0].scrollIntoView(true);", element);
    }
    

	public static void main(String[] args) throws Exception {
		
		chrome();
		highlighterElement();
		System.out.println(getTitleByJS(driver));
		//get the tile of the page by JS:
		System.out.println(getTitleByJS(driver));
		
		//get the page text:
		System.out.println(getPageInnerText(driver));
				
		//scroll page down by its height
		//scrollPageDown(driver);
				
		//scrolls down the page by targeted element.
		WebElement forgotPwdLink = driver.findElement(By.xpath("//a[contains(text(), 'Español')]"));
		scrollIntoView(forgotPwdLink, driver);
				
		//driver.quit();

	}

}
