package October;

import java.awt.Button;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadPropFile {

	static Properties prop = new Properties();

	public static void main(String[] args) throws Exception {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\01 Kieran\\Workspace\\Exercises\\October\\config.properties");
		prop.load(ip);
		launchBrowser(prop);

	}

	private static void launchBrowser(Properties prop) throws Exception {

		String browserName = prop.getProperty("browser");

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String url = prop.getProperty("URL");
			
			enterFormInChrome(driver, prop);
		} else if (browserName.contains("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			String url = prop.getProperty("URL");
			driver.get(url);
		} else if (browserName.contains("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\IEDriverServer.exe");
			WebDriver driver = new InternetExplorerDriver();
			String url = prop.getProperty("URL");
			enterDataInFormForIE(driver);

			System.out.println("Launch Internet Explorer");
			enterDataInFormForIE(driver);
		}
		

		//getProperties();
	} // End launchBrowser

	private static void enterFormInChrome(WebDriver driver, Properties prop) {
		String url = prop.getProperty("URL");
		driver.get(url);
		
		
		String string1 = "Taoiseach says Govt wants to avoid an election";
		String string2 = "More Stories";
		String string3 = "Weekend Essentials ";
		
		
		Boolean isString1Displayed = verifyTextPresent(string1, driver);
		Boolean isString2Displayed = verifyTextPresent(string2, driver);
		Boolean isString3Displayed = verifyTextPresent(string3, driver);
		
		System.out.println("String '"+string1+"' displayed = "+isString1Displayed);
		System.out.println("String '"+string2+"' displayed = "+isString2Displayed);
		System.out.println("String '"+string3+"' displayed = "+isString3Displayed);
		
	}

	private static void getProperties() throws IOException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\01 Kieran\\Workspace\\Exercises\\October\\config.properties");
		prop.load(ip);

		String name = prop.getProperty("name");
		String age = prop.getProperty("age");
		String url = prop.getProperty("URL");
		String browser = prop.getProperty("browser");

		System.out.println("Name in the properties file is " + prop.getProperty("name"));
		System.out.println("Name in the properties file is " + name);
		System.out.println("Age in the properties file is " + age);
		System.out.println("URL in the properties file is " + url);
		System.out.println("Browser in the properties file is " + browser);

	} // End getProperties

	private static void enterDataInFormForIE(WebDriver driver) throws IOException, InterruptedException {
		Properties prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\01 Kieran\\Workspace\\Exercises\\October\\config.properties");
		prop.load(ip);

		String firstName = prop.getProperty("xpath_FirstName");
		String lastName = prop.getProperty("xpath_LastName");
		String email = prop.getProperty("xpath_Email");
		String phone = prop.getProperty("xpath_Phone");
		String company = prop.getProperty("xpath_Company");
		String numberOfDevices = prop.getProperty("xpath_numberofDevices");
		String country = prop.getProperty("xpath_Country");
		String state = prop.getProperty("xpath_State");

		Select numberOfDevicesDD = new Select(driver.findElement(By.xpath(numberOfDevices)));

		Select countryDD = new Select(driver.findElement(By.xpath(country)));
		Select stateDD = new Select(driver.findElement(By.xpath(state)));

		System.out.println("Enter data in the form");
		driver.findElement(By.xpath(firstName)).sendKeys("firstName A");
		driver.findElement(By.xpath(lastName)).sendKeys("lastName B");
		driver.findElement(By.xpath(email)).sendKeys("this@that.com");
		driver.findElement(By.xpath(phone)).sendKeys("123456789");
		driver.findElement(By.xpath(company)).sendKeys("Company_A");
		numberOfDevicesDD.selectByVisibleText("51-250 devices");
		stateDD.selectByIndex(3);

		// Select submit
		System.out.println("Form is submitted");
		driver.findElement(By.xpath("//button[contains(text(),'Start Your Free Trial!')]")).click();
		
	
		String thankYouTitle = driver.getTitle();
		
		// View confirmation message
//		System.out.println("Title thank you "+thankYouTitle);
		
		String value = "Try SolarWinds Backup Free for 30 Days";
		Boolean confirmationText = verifyTextPresent(value, driver);
		
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		System.out.println("'Try SolarWinds Backup Free for 30 Days' displayed = "+confirmationText);
		
		//WebElement element = driver.findElement(By.xpath("//*[contains(text(),'" + confirmationMessage + "')]"));

		//System.out.println("Check confirmation message");


	} // End enterDataInFormForIE
	
	public static Boolean verifyTextPresent(String string, WebDriver driver)
	{
	  if (driver.getPageSource().contains(string)) {
		  return true;
	  } else {
		  return false;
	  }
	  
	} //End

}
