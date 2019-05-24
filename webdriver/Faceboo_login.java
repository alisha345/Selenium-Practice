package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Faceboo_login {
	public static WebDriver driver;
		
	
	public static void OpenUrl() {
		System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("http://facebook.com");
		driver.manage().window().maximize();
	}
	public static void VerifyLogin() {
		driver.findElement(By.id("email")).sendKeys("8341400974");
		driver.findElement(By.id("pass")).sendKeys("Apsmfc@123");
		driver.findElement(By.id("u_0_8")).click();
	}
	public static void Logout() {
		
		driver.findElement(By.xpath("//div[@id=userNavigationLabel']")).click();
		
	}

	public static void main(String[] args) {
		OpenUrl();
		VerifyLogin();
		Logout();
	


}
}