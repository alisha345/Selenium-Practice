package webdriver;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PopUp_Handling {
public static WebDriver driver;
	
	public static void OpenUrl() {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumbymahesh.com");
		driver.manage().window().maximize();
		
	}
	public static void VerifyLogin() {
		driver.findElement(By.linkText("HMS")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
		
	}
	public static void VerifyRegistration() throws Exception {
		driver.findElement(By.linkText("Feedback")).click();
		Thread.sleep(3000);
		Set<String> windows = driver.getWindowHandles();
		System.out.println(windows);
		Object[] s =  windows.toArray();
		driver.switchTo().window(s[1].toString());
		driver.findElement(By.id("name")).sendKeys("Sajid");
		driver.findElement(By.id("email")).sendKeys("sajid@gmail.com");
		new Select(driver.findElement(By.id("car"))).selectByVisibleText("Audi");
		WebElement radio1  = driver.findElement(By.name("radio"));
		radio1.click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys("D:\\Library\\Java_for_selenium\\AM and NM.txt");
		driver.findElement(By.id("message")).sendKeys("Hello this is test message1");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.id("close")).click();
		driver.quit();


	}

	public static void main(String[] args) throws Exception {
OpenUrl();
VerifyLogin();
VerifyRegistration();

	}

}
