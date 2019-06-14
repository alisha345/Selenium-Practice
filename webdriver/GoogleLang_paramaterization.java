package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleLang_paramaterization {
	public static WebDriver driver;
	
	public static void OpenUrl() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://google.com");
		driver.manage().window().maximize();
	}
	public static void AllLang(String str) {
		driver.findElement(By.xpath(str)).click();
		driver.findElement(By.linkText("English")).click();
	}
	
	
		

		

public static void main(String[] args) {
	OpenUrl();
	AllLang("//div[@id='SIvCob']/a[1]"); //Hindi
	AllLang("//div[@id='SIvCob']/a[2]"); //Bengali
	AllLang("//div[@id='SIvCob']/a[3]");//telugu
	AllLang("//div[@id='SIvCob']/a[4]");//marathi
	AllLang("//div[@id='SIvCob']/a[5]");//tamil
	AllLang("//div[@id='SIvCob']/a[6]");//gujarathi
	AllLang("//div[@id='SIvCob']/a[7]");//kannada
	driver.close();

}
}
