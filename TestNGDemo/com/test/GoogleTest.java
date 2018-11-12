package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://google.com");
	} // End setUp

	@Test(priority = 2)
	public void googleTitleTest() {
		String title = driver.getTitle();
		System.out.println("Title of page is" + title);
	}

	@Test(priority = 3)
	public void googleLogoTest() {
		boolean googleLogo = driver.findElement(By.id("hplogo")).isDisplayed();
		System.out.println("Google logo displayed =" + googleLogo);

	}// end googleLogoTest

	@Test(priority = 1)
	public void gMailLinkTest() {
		boolean isDisplayedgMailLink = driver.findElement(By.linkText("Gmail")).isDisplayed();
		System.out.println("Gmail link displayed is =" + isDisplayedgMailLink);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
