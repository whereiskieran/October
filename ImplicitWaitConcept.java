package AutomationConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWaitConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://theage.com.au");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		//Dynamic Wait max 40 seconds
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
		//Dynamic Wait, after the page is loaded, wait 20 sec
		//If the element is available after 10 sec, it moves on
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

}
