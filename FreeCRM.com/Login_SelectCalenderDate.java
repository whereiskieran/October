package October.FreeCRMTesting;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Login_SelectCalenderDate {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		manageWindow(driver);
		loginToSite(driver);
		goToCalender(driver);
	}

	private static void goToCalender(WebDriver driver) {
		driver.switchTo().frame("mainpanel");
		String date = "32-November-2019";
		String dateArray[] = date.split("-");
		String day = dateArray[0];
		String month = dateArray[1];
		String year = dateArray[2];

		Select selectMonth = new Select(driver.findElement(By.name("slctMonth")));
		selectMonth.selectByVisibleText(month);
		Select selectYear = new Select(driver.findElement(By.name("slctYear")));
		selectYear.selectByVisibleText(year);

		String beforeXPath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXPath = "]/td[";

		final int totalWeekDays = 7;

		boolean flag = false;
		String dayValue = null;
		for (int rowNum = 2; rowNum <= 7; rowNum++) {
			for (int colNum = 1; colNum <= totalWeekDays; colNum++) {

				try {
					dayValue = driver.findElement(By.xpath(beforeXPath + rowNum + afterXPath + colNum + "]")).getText();
				} catch (NoSuchElementException e) {
					System.out.println("No such element exception error " + e);
					flag = false;
					break;
				}
				System.out.print("Day value = " + dayValue + ",");
				if (dayValue.equals(day)) {
					driver.findElement(By.xpath(beforeXPath + rowNum + afterXPath + colNum + "]")).click();

					flag = true;
					break;
				}

			} // End for inner loop
			if (flag) {
				break;
			}

		} // End for outer loop

		System.out.println("Month day " + day + " is selected");

	}

	private static void loginToSite(WebDriver driver) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("kieraninozz");
		driver.findElement(By.name("password")).sendKeys("tibet1");
		System.out.println("Click submit to login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	private static void manageWindow(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
	}

}
