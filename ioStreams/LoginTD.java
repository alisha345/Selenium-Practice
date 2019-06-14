package ioStreams;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

public class LoginTD {
	public WebDriver driver;
	public FileInputStream fi;
	public Workbook w;
	public Sheet s;
	
  @Test
  public void f() throws Exception {
	 fi = new FileInputStream("D:\\workspace\\SeleniumAutomation\\test_data\\login.xls");
		w = Workbook.getWorkbook(fi);
		s = w.getSheet("Sheet1");
		driver.findElement(By.name("username")).sendKeys(s.getCell(0, 1).getContents());
		driver.findElement(By.name("password")).sendKeys(s.getCell(1, 1).getContents());
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
  }
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumbymahesh.com/HMS");
		driver.manage().window().maximize();
  }

}
