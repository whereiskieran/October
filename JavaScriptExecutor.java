package October;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.io.Files;

public class JavaScriptExecutor {

	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Configure window
		driver.manage().deleteAllCookies();
		DesiredCapabilities dc = new DesiredCapabilities();
		driver.manage().window().setSize(new Dimension(300, 300));
		// driver.manage().window().fullscreen();

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.freecrm.com");

		WebElement buttonElement = driver.findElement(By.xpath("//input[@type='submit']"));
		WebElement arrowElement = driver.findElement(By.xpath("//button[@class='navbar-toggle']"));

		System.out.println("Title is " + getTitleByJS(driver));
		System.out.println("Menu Minimized button flashing here");
		flashWebElement(driver, arrowElement);
		System.out.println("SignIn button flashing here");
		flashWebElement(driver, buttonElement);

		driver.manage().window().fullscreen();

		// loginToSite(driver);
		drawBorder(buttonElement, driver);

	} // End main

	public static void generateAlert(WebDriver driver, String message) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
	} // End generateAlert

	public static void drawBorder(WebElement element, WebDriver driver) throws IOException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);

		File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(scr, new File("c:\\Tmp\\BorderHighlightedRed.png"));
		generateAlert(driver, "Alert: Issue with login button on home page");
		driver.switchTo().alert().dismiss();

		// Click login - Refreshes the screen
		// clickElement(element, driver);

		// Refresh here
		// driver.navigate().refresh();

		// Fresh browser VIA javascript
		// refreshBrowser(driver);
		// getTitleByJs(driver);
		// System.out.println("Page inner text = "+getPageInnerText(driver));
		// scrollPageDown(driver);

		//WebElement forgotPassword = driver.findElement(By.linkText("Forgot Password?"));
		WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(), 'Forgot Password?')]"));
		
		scrollIntoView(forgotPassword, driver);

	} // End drawBorder

	private static void scrollIntoView(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	} // scrollIntoView

	public static void scrollPageDown(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

	public static String getPageInnerText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String innerTextByJs = js.executeScript(" return document.documentElement.innerText;").toString();

		return innerTextByJs;
	}

	public static String getTitleByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String titleByJS = js.executeScript("return document.title;").toString();
		System.out.println("Title in getTitleByJs is " + titleByJS);
		return titleByJS;
	}

	public static void refreshBrowser(WebDriver driver) {
		System.out.println("Refresh browser");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");

	}// End refreshBrowser

	public static String getTitleByJS(WebDriver driver) {
		System.out.println("getTitleByJS by Javascript");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String pageTitle = js.executeScript("return document.title;").toString();
		String x = pageTitle;
		return x;
	} // End getTitleByJS

	private static void loginToSite(WebDriver driver) throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.name("username")).sendKeys("kieraninozz");
		driver.findElement(By.name("password")).sendKeys("tibet1");
		System.out.println("Login to site ");

		WebElement buttonElement = driver.findElement(By.xpath("//input[@type='submit']"));
		js.executeScript("arguments[0].click();", buttonElement);

		Thread.sleep(2000);
	} // End loginToSite

	private static void flashWebElement(WebDriver driver, WebElement buttonElement) {
		System.out.println("flashWebElement here");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		String bgcolor = buttonElement.getCssValue("backgroundColor");
		for (int i = 0; i < 10; i++) {
			changeColor("rgb(0,200,0)", buttonElement, driver);
			changeColor(bgcolor, buttonElement, driver);
		}
	} // End flashWebElement

	private static void changeColor(String color, WebElement element, WebDriver driver) {

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			System.out.println("InterruptedException caught here " + e);
		}

	} // End changeColor

	public static void clickElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].click();", element);
	}

}
