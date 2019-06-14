package testNG;

import java.util.Arrays;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AlertsHandling {
	public WebDriver driver;
	public String regcode;
	@Test(priority = 0)
  public void VerifyLogin() {
		driver.findElement(By.linkText("HMS")).click();
		driver.findElement(By.name("username")).sendKeys("admin");
		driver.findElement(By.name("password")).sendKeys("admin");
		driver.findElement(By.name("submit")).click();
  }
  @Test(priority = 1)
  public void VerifyRegistration() throws Exception {
		driver.findElement(By.linkText("Registration")).click();
		driver.findElement(By.linkText("Perminent Registration")).click();
		Thread.sleep(3000);


	}
  @Test(priority = 2)
	public void verifyPR() throws Exception {
		new Select(driver.findElement(By.name("PATIENT_CAT"))).selectByVisibleText("Self");
		new Select(driver.findElement(By.name("RELATION"))).selectByVisibleText("Brother");
		new Select(driver.findElement(By.name("TITLE"))).selectByVisibleText("Mr.");
		(driver.findElement(By.name("PNT_NAME"))).sendKeys("ALISHA");
		new Select(driver.findElement(By.name("PAT_IDENTITY"))).selectByVisibleText("AAdhar Card");
		(driver.findElement(By.name("PAT_IDENTITY_PROOF"))).sendKeys("12345678900");
		(driver.findElement(By.name("LAST_NAME"))).sendKeys("AHAMAD");
		(driver.findElement(By.name("DOB"))).sendKeys("01-01-2019");	
		new Select(driver.findElement(By.name("NATIONALITY"))).selectByVisibleText("Indian");
		(driver.findElement(By.name("AGE"))).sendKeys("26");	
		new Select(driver.findElement(By.name("IS_MLC"))).selectByVisibleText("No");
		new Select(driver.findElement(By.name("SEX"))).selectByVisibleText("Male");
		new Select(driver.findElement(By.name("EDUCATION"))).selectByVisibleText("B.Tech");
		new Select(driver.findElement(By.name("MTRL_STATUS"))).selectByVisibleText("Single");
		new Select(driver.findElement(By.name("OCCUPATION"))).selectByVisibleText("Self Employeed");
		new Select(driver.findElement(By.name("RELIGION"))).selectByVisibleText("Muslim");
		new Select(driver.findElement(By.name("BLOOD_GRP_CODE"))).selectByVisibleText("O+");
		new Select(driver.findElement(By.name("PLANGUAGE"))).selectByVisibleText("Telugu");
		new Select(driver.findElement(By.name("CITIZENSHIP"))).selectByVisibleText("Indian");
		new Select(driver.findElement(By.name("SC_PROOF"))).selectByVisibleText("No");
		new Select(driver.findElement(By.name("COUNTRY_CODE"))).selectByVisibleText("India");
		(driver.findElement(By.name("ADDRESS1"))).sendKeys("OU COLONY, SHEIKPET");
		(driver.findElement(By.name("MOBILE_NO"))).sendKeys("1234567890");
		(driver.findElement(By.name("ZIP"))).sendKeys("500089");
		(driver.findElement(By.name("image"))).sendKeys("D:\\Resume\\my pic.jpg");
		(driver.findElement(By.name("submit"))).click();

		
		Thread.sleep(3000);

	}
  @Test (priority = 3)
  public void AlertHandling() throws Exception {
	  String str; 
	  Alert alrt = driver.switchTo().alert();
	  str = alrt.getText();
	  String[] s = str.split("\\s");
	   regcode = s[s.length-1];
	  System.out.println("the alret in strig arrays :" +Arrays.toString(s));
      System.out.println("The registation number is:" + regcode);
      driver.switchTo().alert().accept();
      Thread.sleep(3000);
  }     
      @Test (priority = 4)
     public void RegistrationSearch() {
    	  driver.findElement(By.linkText("Search Registration")).click();
    	  driver.findElement(By.name("search")).sendKeys(regcode);
    	  driver.findElement(By.name("submit")).click();
    	  
      }
	  //driver.quit();
  
 
@BeforeTest
  public void OpenUrl() {
	  System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://seleniumbymahesh.com");
		driver.manage().window().maximize();
  }

}
