package AutomationConcepts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class findElementsConcept {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://ebay.com");
		// driver.get("http://theage.com.au");

		manageBrowerSettings(driver);

		findTotalLinkElements(driver);
		findTotalInputElements(driver);
		findTotalButtonElements(driver);
		allCategories(driver);
		
		System.out.println("End of automated script");

	}

	private static void allCategories(WebDriver driver) {
		String dropDown = driver.findElement(By.name("_sacat")).getText();
		System.out.println("Categories are " + dropDown);
	}

	private static void findTotalButtonElements(WebDriver driver) {
		List<WebElement> buttonNumber = driver.findElements(By.tagName("button"));
		int buttonNumberSize = buttonNumber.size();
		System.out.println("Total buttons displayed are " + buttonNumberSize);
	}

	private static void findTotalInputElements(WebDriver driver) {
		List<WebElement> inputNumber = driver.findElements(By.tagName("input"));
		int inputNumberSize = inputNumber.size();
		System.out.println("Total input fields are " + inputNumberSize);

	}

	private static void findTotalLinkElements(WebDriver driver) {
		List<WebElement> linkList = driver.findElements(By.tagName("a"));
		int linkSize = linkList.size();
		System.out.println("Total hyper links are " + linkSize);

		for (int i = 0; i < linkList.size(); i++) {
			String totallinkList = linkList.get(i).getText();
			System.out.println(totallinkList);
		}
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
