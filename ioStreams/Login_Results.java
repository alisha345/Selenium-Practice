package ioStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Login_Results {
public WebDriver driver;
public FileInputStream fi;
public Workbook w;
public Sheet s;
public FileOutputStream fo;
public WritableWorkbook wb;
public WritableSheet ws;
public String str;

@Test
public void loginResults() throws Exception {
	 fi = new FileInputStream("D:\\workspace\\SeleniumAutomation\\test_data\\login.xls");
	w = Workbook.getWorkbook(fi);
	s = w.getSheet("Sheet1");
		fo = new FileOutputStream("D:\\workspace\\SeleniumAutomation\\results\\results.xls");
		wb = Workbook.createWorkbook(fo);
		ws = wb.createSheet("test1", 0);
		
		

		for (int i = 1; i < s.getRows(); i++) {
			driver.findElement(By.name("username")).sendKeys(s.getCell(0, i).getContents());
			driver.findElement(By.name("password")).sendKeys(s.getCell(1, i).getContents());
			driver.findElement(By.name("submit")).click();
			Thread.sleep(3000);
			try 
			{
				driver.findElement(By.linkText("Logout")).isDisplayed();
				driver.findElement(By.linkText("Logout")).click();
				System.out.println("Valid Credential");
				str = "PASS";
			} 
			catch (Exception e) 
			{
				System.out.println("Invalid Credential");
				str = "FAIL";
				driver.switchTo().alert().accept();
			}
		
			Label results = new Label(2, i, str);
			ws.addCell(results);
			for (int j = 0; j < s.getColumns(); j++) {
				System.out.println(s.getCell(j, i).getContents());
				Label a = new Label(j, i, s.getCell(j, i).getContents());
				ws.addCell(a);
			}
		}

		Label un = new Label(0, 0, "User Name");
		Label pw = new Label(1, 0, "Password");
		Label rs = new Label(2, 0, "Results");
		ws.addCell(un);
		ws.addCell(pw);
		ws.addCell(rs);
		wb.write();
		wb.close();
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
