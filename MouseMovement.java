package AutomationConcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovement {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);

		driver.get("http://spicejet.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();

		String windowHandleBefore = driver.getWindowHandle();

		// Check Add-Ons menu
		action.moveToElement(driver.findElement(By.linkText("ADD-ONS"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Travel Insurance")).click();

		System.out.println("Go to Travel Insurance page");
		String travelInsuranceTitle = driver.getTitle();

		// Check page title
		if (travelInsuranceTitle.contains("SpiceJet Travel Insurance")) {
			System.out.println("Passed - 'SpiceJet Travel Insurance' page is displayed correctly");
		} else {
			System.out.println("Failed - 'SpiceJet Travel Insurance' page is NOT displayed correctly");
		}

		// Travel Agent Login page is available
		action.moveToElement(driver.findElement(By.id("ctl00_HyperLinkLogin"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Travel Agent Login")).click();

		String travelAgentLoginPage = driver.getTitle();

		System.out.println("Page displayed is '" + travelAgentLoginPage + "'");

		if (travelAgentLoginPage.contains(
				"Cheap Air Tickets Online, International Flights to India, Cheap International Flight Deals | SpiceJet Airlines")) {
			System.out.println("Passed - travelAgentLoginPage displayed correctly");
		} else {
			System.out.println("Failed - travelAgentLoginPage NOT displayed correctly");
		}

		// Check Deals
		driver.findElement(By.linkText("DEALS")).click();
		//
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		String hotDealsTitle = driver.getTitle();
		System.out.println(hotDealsTitle + ": displayed");
		String hotDealsSource = driver.getPageSource();

		String hotDealsURL = driver.getCurrentUrl();
		System.out.println("Page is " + hotDealsURL);

		if (hotDealsSource.contains("Welcome to Hot Deals")) {
			System.out.println("Passed - Hot deals page displayed");
		} else {
			System.out.println("Failed - Hot deals page NOT displayed");
		}
		driver.close();

		driver.switchTo().window(windowHandleBefore);

		// Gift card
		driver.findElement(By.linkText("GIFT CARD")).click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		String urlOfGiftCard = driver.getCurrentUrl();

		if (urlOfGiftCard.contentEquals("https://spicejet.woohoo.in/home")) {
			System.out.println("Passed - URL of gift card URL is correct");
		}
		driver.close();
		driver.switchTo().window(windowHandleBefore);

		driver.findElement(By.linkText("BOOK")).click();
		
		// Check Spice Club
		driver.findElement(By.linkText("SPICECLUB")).click();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		String urlSpiceClub = driver.getCurrentUrl();
		if (urlSpiceClub.contentEquals("https://www.spicejet.com/SpiceClub.aspx")) {
			System.out.println("Passed - Spice club URL is correct");
		}
		
		driver.switchTo().window(windowHandleBefore);
		driver.close();

	} // End main

}
