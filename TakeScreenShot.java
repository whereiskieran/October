package AutomationConcepts;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class TakeScreenShot {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		String fileWithPath = "C:\\Tmp\\";
		WebDriver driver = new ChromeDriver();
		driver.get("http://ebay.com");
		manageBrowerSettings(driver);

		takeScreenShot(driver);
	}

	private static void takeScreenShot(WebDriver driver) throws IOException {
		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scr, new File("c:\\Tmp\\EBayHomePage.png"));

	}

	private static void manageBrowerSettings(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Dynamic Wait max 40 seconds
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		// Dynamic Wait, after the page is loaded, wait 20 sec
		// If the element is available after 10 sec, it moves on
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}
}
