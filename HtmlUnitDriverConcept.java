package October;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HtmlUnitDriverConcept {

	private static final TimeUnit TimeUnit = null;

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		//Configure window
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");
		
		loginToSite(driver);

	}

	private static void loginToSite(WebDriver driver) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("FirstName");
		driver.findElement(By.name("password")).sendKeys("password");
		System.out.println("Login to site ");
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(2000);
	}

}
