package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Google_Lang_Change {
	public static WebDriver driver;

	public static void OpenUrl() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
	}

	public static void Hindi() {
		driver.findElement(By.xpath("//div[@id='SIvCob']/a[1]")).click();//Hindi
		driver.findElement(By.linkText("English")).click();
	}
	public static void Bengali() {
		driver.findElement(By.xpath("//div[@id='SIvCob']/a[2]")).click();//Bengali
		driver.findElement(By.linkText("English")).click();
	}
	public static void Telugu() {
		driver.findElement(By.xpath("//div[@id='SIvCob']/a[3]")).click();//Telugu
		driver.findElement(By.linkText("English")).click();
	}
	public static void Marathi() {
		driver.findElement(By.xpath("//div[@id='SIvCob']/a[4]")).click();//Marathi
		driver.findElement(By.linkText("English")).click();
		
	}
	public static void Tamil() {
		driver.findElement(By.xpath("//div[@id='SIvCob']/a[5]")).click();//Tamil
		driver.findElement(By.linkText("English")).click();
	}
	
	public static void main(String[] args) {
		OpenUrl();
		Hindi();
		Bengali();
		Telugu();
		Marathi();
		Tamil();

	}

}
