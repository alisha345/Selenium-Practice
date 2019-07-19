package webdriverBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Launchingsite {
static WebDriver driver;
static String str;
public static void Firefox() {
	System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
	driver = new FirefoxDriver();//Launching Firefox
	driver.get("http://seleniumbymahesh.com");//Entring the title
	str = driver.getTitle();//Getting the title
	System.out.println("The title of the page is :"+str);
	
	//Validation Point
	if (str.equals("SeleniumByMahesh | Learn From Expert")) {
		System.out.println("Title is correct");
	}
	else {
		System.out.println("\n"+"Title is In-correct");
	}
	System.out.println("\n"+"The Current URL is : " + driver.getCurrentUrl());//Printing Current URL 
	
	//System.out.println("\n"+driver.getPageSource());//Printing Page Source code
	driver.quit();//closing the browser

}
public static void Chrome() {
	System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
	driver = new ChromeDriver();//Launching Browser
	driver.get("http://seleniumbymahesh.com");//Entring the title
	driver.manage().window().maximize();//Maximising the window

	str = driver.getTitle();//Getting the title
	System.out.println("The title of the page is :"+str);
	
	//Validation Point
	if (str.equals("SeleniumByMahesh | Learn From Expert")) {
		System.out.println("Title is correct");
	}
	else {
		System.out.println("\n"+"Title is In-correct");
	}
	System.out.println("\n"+"The Current URL is : " + driver.getCurrentUrl());//Printing Current URL 
	
	driver.quit();//closing the browser

	
}

public static void Safari() {
	driver = new SafariDriver();//Launching Browser
	driver.get("http://seleniumbymahesh.com");//Entring the title
	str = driver.getTitle();//Getting the title
	driver.manage().window().maximize();
	System.out.println("The title of the page is :"+str);
	
	//Validation Point
	if (str.equals("SeleniumByMahesh | Learn From Expert")) {
		System.out.println("Title is correct");
	}
	else {
		System.out.println("\n"+"Title is In-correct");
	}
	System.out.println("\n"+"The Current URL is : " + driver.getCurrentUrl());//Printing Current URL 
	
	driver.quit();//closing the browser
	

	
}
	public static void main(String[] args) {
		
		Firefox();
		Chrome();
		//Safari();// Requires Safari 10.x or greater version
		
	}

}
