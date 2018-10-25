package AutomationConcepts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomXPath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://ebay.com");

		manageBrowerSettings(driver);
		searchByVariousXPath(driver);
		dailyDealslinkText(driver);
		giftCardslinkText(driver);
		
		System.out.println("The end");

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

	private static void searchByVariousXPath(WebDriver driver) throws InterruptedException {
		// Enter data in the search box
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("This and that");
		// driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"))
		// .sendKeys(" By classname");

		driver.findElement(By.xpath("//input[@id='gh-ac']")).clear();
		driver.findElement(By.xpath("//input[@id='gh-ac']")).sendKeys("This one by id");
		driver.findElement(By.xpath("//input[@name='_nkw']")).sendKeys(" and by name xxx");

		String className = driver.findElement(By.xpath("//input[@name='_nkw']")).getClass().toString();
		System.out.println("className is =" + className);
		String getLocation = driver.findElement(By.xpath("//input[@name='_nkw']")).getLocation().toString();
		System.out.println("getLocation is =" + getLocation);
		Boolean isNameElementDisplayed = driver.findElement(By.xpath("//input[@name='_nkw']")).isDisplayed();
		System.out.println("is Search input field 'name' Element Displayed =" + isNameElementDisplayed);

		// driver.findElement(By.xpath("//input[@name='_nkw']")).submit(); //Submit,
		// does what??

		// Clear and write to search again
		driver.findElement(By.xpath("//input[@id='gh-ac']")).clear();
		driver.findElement(By.xpath("//input[contains(@class, 'gh-tb ui-autocomplete-input ui-autocomplete-loading')]"))
				.sendKeys("class sendkeys");

		// Wait 5 seconds
		Thread.sleep(5000);
		// Contains, full class ref
		driver.findElement(By.xpath("//input[contains(@class, 'gh-tb ui-autocomplete-input ui-autocomplete-loading')]"))
				.clear();

		// Contains, partial class ref
		driver.findElement(By.xpath("//input[contains(@class, 'ui-auto') ]")).sendKeys("Test partial contains");

		// Contains, partial name
		driver.findElement(By.xpath("//input[contains(@name, 'kw')]")).clear();
		driver.findElement(By.xpath("//input[contains(@name, 'kw')]")).sendKeys("partial name text ");

		driver.findElement(By.xpath("//input[contains(@name, 'kw')]")).clear();

		// Contains, partial type
		driver.findElement(By.xpath("//input[contains(@type, 'te')]")).sendKeys("partial type contains");

		// Contains length
		driver.findElement(By.xpath("//input[contains(@size, '50')]")).sendKeys(" and MaxLenght????");

		driver.findElement(By.xpath("//input[contains(@maxlength, '300')]")).clear();

		// By placeholder
		driver.findElement(By.xpath("//input[@placeholder='Search for anything']"))
				.sendKeys("Search for anything again");
		driver.findElement(By.xpath("//input[contains(@placeholder, 'anything')]")).clear();
		driver.findElement(By.xpath("//input[@role ='combobox']")).sendKeys("role ='combobox'");

		driver.findElement(By.xpath("//input[contains(@aria-owns, 'ui-id-1')]")).sendKeys("aria-owns='ui-id-1'");

		// Clear search field
		driver.findElement(By.xpath("//input[@aria-haspopup= 'true']")).clear();

		driver.findElement(By.xpath("//input[starts-with(@aria-owns, 'ui-i')]"))
				.sendKeys("starts-with - aria-owns='ui-id-1'");

		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Search')]")).clear();

		driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Search')]")).sendKeys("t-shirt");
		driver.findElement(By.xpath("//input[starts-with(@placeholder, 'Search')]")).submit();
		System.out.println("Search has been selected ");
	}

	private static void giftCardslinkText(WebDriver driver) {

		driver.findElement(By.xpath("//a[contains(text(), 'Gift Cards')]")).click();

		String giftCards = driver.findElement(By.className("b-pageheader")).getText();
		System.out.println("Gift Cards is =" + giftCards);
		if (giftCards.contains("Gift Cards & Coupons")) {
			System.out.println("Passed - text displayed correctly - Gift Cards & Coupons");
		} else {
			System.out.println("Failed - text NOT displayed correctly - Gift Cards & Coupons");
		}
		driver.findElement(By.xpath("//input[contains(@class, 'gh-tb')]")).sendKeys("cars");
	}

	private static void dailyDealslinkText(WebDriver driver) {
		String tShirtMen = driver.findElement(By.linkText("t shirt men")).getText();

		System.out.println("tShirtMen = " + tShirtMen);
		if (tShirtMen.contentEquals("t shirt men")) {
			System.out.println("Passed - Search result displays 't shirt men'");
		} else {
			System.out.println("Error - Search result does NOT displays 't shirt men'");
		}

		driver.findElement(By.xpath("//a[contains(text(), 'Daily Deals')]")).click();

		String deals = driver.findElement(By.id("s2")).getText();

		if (deals.contentEquals(deals)) {
			System.out.println("Passed - Deals text is displayed correctly");
		} else {
			System.out.println("Failed - Deals text is NOT displayed correctly");
		}
		
		

	}

}
