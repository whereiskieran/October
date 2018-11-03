package October.Bootstrap;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBootStrapDropBoxes {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		driver.get("http://v4-alpha.getbootstrap.com/components/dropdowns/");

		selectDropDownButton(driver);

		System.out.println("The end");
	} // End main

	private static void selectDropDownButton(WebDriver driver) throws InterruptedException {
		System.out.println("Select drop down");
		driver.findElement(By.id("dropdownMenuButton")).click();

		List<WebElement> list = driver.findElements(By.xpath("//div[@aria-labelledby='dropdownMenuButton']//a"));

		System.out.println("Size of the list is " + list.size());
		System.out.println("Contents of the drop down box is ");
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i + ": " + list.get(i).getText());

			if (list.get(i).getText().equals("Another action")) {
				Thread.sleep(2000);
				list.get(i).click();
				System.out.println("Item selected");
				break;
			}
		}

	}

}
