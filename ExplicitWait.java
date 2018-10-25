package AutomationConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://ebay.com");

		// Select Search
		WebElement search = driver.findElement(By.xpath("//*[@id='gh-btn']"));
		clickOn(driver, search, 10);

		// Select flip your phone
		WebElement flipPhone = driver.findElement(By.xpath("//*[@id='gh-hsi']"));
		clickOn(driver, flipPhone, 10);

		// Select Samsung
		WebElement Samsung = driver.findElement(By.linkText("I can't find my Brand"));
		clickOn(driver, Samsung, 5);
		// Samsung.click();

		// Search for item
		searchForItem(driver);

	} // End main method

	private static void searchForItem(WebDriver driver) {
		//WebElement searchTextDisplayed = driver.findElement(By.xpath("//contains(text(), 'Give us a title for your listing')]"));
		String searchTextDisplayed = driver.findElement(By.xpath("//*[contains(text(), 'Give us a title for your listing')]")).getText();

		if (searchTextDisplayed.contains("Give us a title for your listing")) {
			System.out.println("Passed - Text displayed correctly - Give us a title for your listing");
		} else {
			System.out.println("Failed - Text NOT displayed correctly - Give us a title for your listing");
		}

		
		//search.sendKeys("This and that");

	} // End searchForItem

	private static void cantFindModel(WebDriver driver) {
		// WebElement cantFindModelTxt =
		// driver.findElement(By.xpath("//a[contains(text(), 'Galaxy S9')]"));
		WebElement cantFindModelTxt = driver.findElement(By.xpath("//a[sp_data= 'Model:Galaxy S9']"));
		cantFindModelTxt.click();
	}

	// Find item

	// Explicit wait method
	public static void clickOn(WebDriver driver, WebElement locator, int timeOut) {

		new WebDriverWait(driver, timeOut).ignoring(StaleElementReferenceException.class)
				.until(ExpectedConditions.elementToBeClickable(locator));
		locator.click();
		System.out.println("Locator in '" + driver.getCurrentUrl() + "' is displayed");

	}
}
