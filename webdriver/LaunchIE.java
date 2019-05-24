package webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchIE {

	public static  WebDriver driver; 
	public static void OpenUrl() {
		System.setProperty("webdriver.ie.driver", "D:\\Library\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
	
	}
	public static void main(String[] args) {
		OpenUrl();
	}
}
