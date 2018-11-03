package October.Bootstrap;

import java.awt.Button;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Bootstrap_Example {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.get("https://getbootstrap.com/docs/4.0/components/dropdowns/");
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		manageBrowerSettings(driver);

		// selectDropdownButtonToggle(driver);
		selectAllOptionsButtonToggle(driver);
		System.out.println("The end");
	}

	private static void selectDropdownButtonToggle(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(@class, 'multiselect dropdown-toggle btn')]")).click();
		List<WebElement> boostrapDropDown = driver
				.findElements(By.xpath("//ul[@class ='multiselect-container dropdown-menu'] //li//a//label"));
		int listDropDownSize = boostrapDropDown.size();

		System.out.println("Drop down list size is " + listDropDownSize);

		// Get the text from the drop down options
		for (int i = 0; i < listDropDownSize; i++) {
			System.out.println(boostrapDropDown.get(i).getText());

			// Search for 'Angular' and select it
			if (boostrapDropDown.get(i).getText().equals("Angular")) {
				System.out.println("Searching...");
				boostrapDropDown.get(i).click();
				System.out.println("**'Angular selected'**");
				System.out.println("Breaking out of search");
				break;
			}

		} // End for loop

	}

	private static void selectAllOptionsButtonToggle(WebDriver driver) {
		driver.findElement(By.xpath("//button[contains(@class, 'multiselect dropdown-toggle btn')]")).click();
		List<WebElement> boostrapDropDown = driver
				.findElements(By.xpath("//ul[@class ='multiselect-container dropdown-menu'] //li//a//label"));
		int listDropDownSize = boostrapDropDown.size();

		for (int i = 0; i < listDropDownSize; i++) { // Click all options
			// System.out.println("Checkbox '" + boostrapDropDown.get(i).getText() + "'
			// selected");
			
			if (!boostrapDropDown.get(i).isSelected()) {
				boostrapDropDown.get(i).click();
				System.out.println("Option selected is '" + boostrapDropDown.get(i).getText() + "'");
			}

			// while (!boostrapDropDown.get(i).isSelected()) {
			// System.out.println("Checkbox '" + boostrapDropDown.get(i).getText() + "' now
			// selected");
			//
			// }

		} // End for loop

	} // End selectDropdownButtonToggle

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
