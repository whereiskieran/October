package AutomationConcepts;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserPopUp {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://popuptest.com");
		manageBrowerSettings(driver);

		handlePopUpThree(driver);

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

	private static void handlePopUpThree(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font[2]/b/a")).click();
		Set<String> handler = driver.getWindowHandles();

		Iterator<String> it = handler.iterator();
		String parentWindiowId = it.next();
		System.out.println("Parent id is " + parentWindiowId);

		String childWindiowId = it.next();
		System.out.println("Child id is " + childWindiowId);

		Thread.sleep(2000);
		String child2WindiowId = it.next();
		System.out.println("Child id is " + child2WindiowId);

		String child3WindiowId = it.next();
		System.out.println("Child id is " + child3WindiowId);

		Thread.sleep(2000);
		driver.switchTo().window(childWindiowId);
		System.out.println("Closing window title -" + driver.getTitle());

		driver.close();

		driver.switchTo().window(child2WindiowId);
		System.out.println("Closing window title -" + driver.getTitle());
		driver.close();

		driver.switchTo().window(child3WindiowId);
		System.out.println("Closing window title -" + driver.getTitle());
		driver.close();
	}

}
