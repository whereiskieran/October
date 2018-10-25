package AutomationConcepts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		driver.switchTo().frame(0);

		Actions action = new Actions(driver);

		dragTestIsDisplayed(driver);
		beforeDragAndDrop(driver);
		afterDragAndDrop(driver, action);

	}

	private static void dragTestIsDisplayed(WebDriver driver) {
		String dragTest = driver.findElement(By.id("draggable")).getText();

		if (dragTest.contentEquals("Drag me to my target")) {
			System.out.println("Passed - text 'Drag me to my target' displayed correctly");
		} else {
			System.out.println("Failed - text 'Drag me to my target' NOT displayed correctly");
		}
	}

	private static void beforeDragAndDrop(WebDriver driver) {
		String dropHere = driver.findElement(By.id("droppable")).getText();

		if (dropHere.equals("Drop here")) {
			System.out.println("Passed - 'Drop here', text is displayed correctly");
		} else {
			System.out.println("Failed - 'Drop here', text is NOT displayed correctly");
		}
	}

	private static void afterDragAndDrop(WebDriver driver, Actions action) {
		action.clickAndHold(driver.findElement(By.xpath("//*[@id='draggable']")))
				.moveToElement(driver.findElement(By.xpath("//*[@id='droppable']"))).release().build().perform();

		System.out.println("Action - Drag and drop performed");

		String droppedConfirmation = driver.findElement(By.id("droppable")).getText();
		if (droppedConfirmation.contains("Dropped")) {
			System.out.println("Passed - Dropped conformation is displayed");
		} else {
			System.out.println("Failed - Dropped message is not displayed");
		}

	}
}
