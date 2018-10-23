package October;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class REadProperties2 {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.canspace.ca/");
		System.out.println("Logged into site");

		// getProperties();

	}
}
