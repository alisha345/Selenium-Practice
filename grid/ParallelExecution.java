package grid;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelExecution {
	public WebDriver driver;
	public String regcode, table;
	@Test(priority = 0)
	  public void VerifyLogin() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	
			driver.findElement(By.linkText("HMS")).click();
			driver.findElement(By.name("username")).sendKeys("admin");
			driver.findElement(By.name("password")).sendKeys("admin");
			driver.findElement(By.name("submit")).click();
	  }
	  @Test(priority = 1)
	  public void VerifyRegistration() throws Exception {
			driver.findElement(By.linkText("Registration")).click();
			driver.findElement(By.linkText("Perminent Registration")).click();
			


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


		}
	  @Test (priority = 3)
	  public void AlertHandling() throws Exception {
		  String str; 
		  Alert alrt = driver.switchTo().alert();
		  str = alrt.getText();
		  String[] s = str.split("\\s");
		   regcode = s[s.length-1];
	      driver.switchTo().alert().accept();
	  }     
	      @Test (priority = 4)
	     public void RegistrationSearch() {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	  driver.findElement(By.linkText("Search Registration")).click();
	    	  driver.findElement(By.name("search")).sendKeys(regcode);
	    	  driver.findElement(By.name("submit")).click();
	    	  
	      }
	      @Test (priority = 5)
		     public void Webtable() {
		    	 table = driver.findElement(By.xpath("//table[@width='100%'][2]")).getText();
		    	 String[] web = table.split("\\s");
		    	 for (int i = 0;i<web.length;i++)
		    		 if(web[i].equalsIgnoreCase(regcode));
		    	
		    			 
	      }
	      @Test (priority = 6)
		     public void Logout() throws Exception {
	    	  driver.findElement(By.linkText("Logout")).click();
	    	  driver.close();
	      }
  
  @Parameters("Sajid")
  @BeforeTest
  public void beforeTest(String str) {
	  if(str.equalsIgnoreCase("firefox"))
	  {
		  System.setProperty("webdriver.gecko.driver", 
					"D:\\Library\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get("http://seleniumbymahesh.com");
	  }
	  else if (str.equalsIgnoreCase("chrome")) 
	  {
		  System.setProperty("webdriver.chrome.driver", 
					"D:\\Library\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://seleniumbymahesh.com");
		
	}
	  else if (str.equalsIgnoreCase("edge"))
	  {
		  System.setProperty("webdriver.edge.driver", 
					"D:\\Library\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get("http://seleniumbymahesh.com");
		
	}
	  else if (str.equalsIgnoreCase("ie"))
	  {
			System.setProperty("webdriver.ie.driver", 
					"D:\\Library\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get("http://seleniumbymahesh.com");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
	}
  
  }
  
  

}
