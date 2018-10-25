package AutomationConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://html.com/input-type-file/");

		manageBrowerSettings(driver);
		handlePopUp(driver);
		uploadFile(driver);

	} // End Main

	private static void manageBrowerSettings(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		// Dynamic Wait max 40 seconds
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		// Dynamic Wait, after the page is loaded, wait 20 sec
		// If the element is available after 10 sec, it moves on
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	} // End manageBrowerSettings

	private static void handlePopUp(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//a[@title='Close']")).click();

	} // End handlePopUp

	private static void uploadFile(WebDriver driver) {
		System.out.println("Upload file bit starts here");
		driver.findElement(By.xpath("//input[@value='fileupload' and @id='fileupload']"))
				.sendKeys("c:\\Tmp\\EBayHomePage.PNG");

		WebElement element = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", element);

		System.out.println("Upload file bit finished");
	} // End uploadFile

}
