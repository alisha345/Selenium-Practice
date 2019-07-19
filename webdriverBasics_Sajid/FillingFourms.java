package webdriverBasics;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class FillingFourms {

	static WebDriver driver;
	public String str,regcode,table;
	public static String Browser_name, user_name, Hms, id_value, pass_value,pass_name,log_in;

	
	public static void browsers() throws Exception {
		Properties po = new Properties();
		FileInputStream fi = new FileInputStream
				("D:\\workspace\\SajidSelenium\\src\\webdriverBasics\\FillingForms.properties");
		
		po.load(fi);
		
		//creating variables for keys in .properties files
		Browser_name	= po.getProperty("Browser");
		user_name 		= po.getProperty("username");	
		Hms				= po.getProperty("HMS");
		id_value		= po.getProperty("userid");
		pass_value 		= po.getProperty("pass");
		pass_name		= po.getProperty("password");
		log_in			= po.getProperty("login");
		
		
		if (Browser_name.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", "D:\\Library\\chromedriver.exe");
		driver = new ChromeDriver();//Launching Browser
		driver.get(po.getProperty("URL"));//Entering the title
		driver.manage().window().maximize();//Maximizing the window
		}
		else if (Browser_name.equals("firefox")) {
			
		
			System.setProperty("webdriver.gecko.driver", "D:\\Library\\geckodriver.exe");
			driver = new FirefoxDriver();//Launching Firefox
			driver.get(po.getProperty("URL"));//Entering the title
			driver.manage().window().maximize();//Maximizing the window
			
		}
		else if (Browser_name.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "D:\\Library\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();//Launching Firefox
			driver.get(po.getProperty("URL"));//Entering the title
			driver.manage().window().maximize();//Maximizing the window
		}
	}
	

	// Using OBJECT REPORITIES (.PROPERTIES FILES)
	public static void Hms_Login() {
		
		driver.findElement(By.xpath(Hms)).click();
		driver.findElement(By.xpath(user_name)).sendKeys(pass_value);
		driver.findElement(By.xpath(pass_name)).sendKeys(id_value);
		driver.findElement(By.xpath(log_in)).click();
		
	}
	
	public static void PR() {
		driver.findElement(By.linkText("Registration")).click();
		
		//Dropdown select
		Select s = new Select(driver.findElement(By.name("PATIENT_CAT")));
		s.selectByVisibleText("Self");
			new Select(driver.findElement(By.name("RELATION"))).selectByVisibleText("Brother");
			new Select(driver.findElement(By.name("TITLE"))).selectByVisibleText("Mr.");
			driver.findElement(By.name("PNT_NAME")).sendKeys("TOMMY");
			new Select(driver.findElement(By.name("PAT_IDENTITY"))).selectByVisibleText("AAdhar Card");
			driver.findElement(By.name("PAT_IDENTITY_PROOF")).sendKeys("12345678900");
			driver.findElement(By.name("LAST_NAME")).sendKeys("MATHEWS");
			driver.findElement(By.name("DOB")).sendKeys("01-01-2019");	
			new Select(driver.findElement(By.name("NATIONALITY"))).selectByVisibleText("Indian");
			driver.findElement(By.name("AGE")).sendKeys("26");	
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
			driver.findElement(By.name("ADDRESS1")).sendKeys("OU COLONY, SHEIKPET");
			driver.findElement(By.name("MOBILE_NO")).sendKeys("1234567890");
			driver.findElement(By.name("ZIP")).sendKeys("500089");
			
			//uploading image without directly handling desktop popups
			driver.findElement(By.name("image")).sendKeys("D:\\Resume\\my pic.jpg");
			driver.findElement(By.name("submit")).click();

		
	}
	
	public void AlertHandling() throws Exception {
		  Alert alrt = driver.switchTo().alert();
		  str = alrt.getText();
		  String[] s = str.split("\\s");
		    regcode = s[s.length-1];
	      alrt.accept();
	      Thread.sleep(3000);
	}
	
	 public void RegistrationSearch() {
   	  driver.findElement(By.linkText("Search Registration")).click();
   	  driver.findElement(By.name("search")).sendKeys(regcode);
   	  driver.findElement(By.name("submit")).click();
   	  
     }
	
     public void Webtable() {
	    	 table = driver.findElement(By.xpath("//table[@width='100%'][2]")).getText();
	    	 String[] web = table.split("\\s");
	    	 for (int i = 0;i<web.length;i++)
	    		 if(web[i].equalsIgnoreCase(regcode));
	    	 System.out.println("Your data is succesfully saved."+
	    		 "\n"+"your registration id is:" +regcode+"."+"\n"+"Save your "
	    		 		+ "id for furture referrence.");
	    			 
     }
     public void Logout() throws Exception {
   	  driver.findElement(By.linkText("Logout")).click();
   	  Thread.sleep(3000);
   	  driver.quit();
     }
     
	public static void main(String[] args) throws Exception {		
		//creating object for calling non static method inside static method
		FillingFourms s = new FillingFourms();
		
		
		// calling static method
				browsers();
				Hms_Login();
				PR();
				
				//calling instance method with reference class object, inside static method 
				s.AlertHandling();
				s.RegistrationSearch();
				s.Webtable();
				s.Logout();
		
		

	}

}
