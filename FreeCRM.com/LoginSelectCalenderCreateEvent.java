package October.FreeCRMTesting;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javafx.scene.control.Alert;

public class LoginSelectCalenderCreateEvent {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String date = "22-June-2020";
		String hour = "09:00 AM";

		manageWindow(driver);
		loginToSite(driver);
		selectCalenderDate(date, driver);
		createNewEvent(driver, hour);
		enterEventInformation(driver, date);
		confirmEventCreated(driver, date);

	} // End Main

	private static void confirmEventCreated(WebDriver driver, String date) {
		String confirmTitle = driver.getTitle();
		System.out.println("Confirmation title is " + confirmTitle);
		String confirmation = driver.getPageSource();
		
		if (confirmation.contains("Email notifications were sent to all attendees.")) {
			System.out.println("Passed - confirmation msg displayed - Event created correctly");
		} else {
			System.out.println("Failed - confirmation msg displayed - Event NOT created correctly");
		}
	}

	private static void enterEventInformation(WebDriver driver, String date) {
		driver.findElement(By.name("title")).sendKeys("Event title " + date);
		Select category = new Select(driver.findElement(By.name("category")));
		category.selectByVisibleText("Social");

		// Fill out form

		// Contact
		driver.findElement(By.name("contact_lookup")).sendKeys("Test_contact " + date);

		// Company
		driver.findElement(By.name("client_lookup")).sendKeys("Test_company " + date);

		// Deal
		driver.findElement(By.name("prospect_lookup")).sendKeys("Test_deal " + date);

		// Task
		driver.findElement(By.name("task_lookup")).sendKeys("Test_task " + date);

		// Tags
		driver.findElement(By.name("tags")).sendKeys("Test_tags " + date);

		// Location
		driver.findElement(By.name("location")).sendKeys("Test_location " + date);

		// Notes
		driver.findElement(By.id("notes")).sendKeys("Test_notes " + date);

		// Minutes
		driver.findElement(By.id("meeting_notes")).sendKeys("Test_minutes " + date);

		Boolean confirmed = driver.findElement(By.name("confirmed")).isSelected(); // Should be false
		if (!confirmed) {
			System.out.println("Passed - Confirmed checkbox is 'No'");
		} else {
			System.out.println("Failed - Confirmed checkbox is NOT 'No'");
		}
		// Email alert is checked

		Boolean emailAlertEmail = driver.findElement(By.name("email_alert")).isSelected();

		if (emailAlertEmail) {
			System.out.println("Passed - Email checkbox tickbox is selected");
		} else {
			System.out.println("Failed - Email checkbox tickbox NOT is selected");
		}

		// Click on Submit
		driver.findElement(By.xpath("//input [@type ='submit']")).click();
		String popUpText = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		System.out.println("Pop up text is ='" + popUpText + "'");

		assignToUser(driver);
	}

	private static void assignToUser(WebDriver driver) {
		System.out.println("Correct error - Assign to user");

		// Select the user
		driver.findElement(By.name("assigned_to_user_id_src")).click();

		// Add the user
		System.out.println("Add the user by clicking on the button");
		// driver.findElement(By.xpath("//input[@value =
		// '==ADD==>'][class='button']")).click();
		driver.findElement(By.xpath("//input[@value='==ADD==>'][@class='button']")).click();

		// Save the form now
		driver.findElement(By.xpath("//input [@type ='submit']")).click();
	}

	private static void createNewEvent(WebDriver driver, String hour) {
		System.out.println("createNewEvent method called");
		String beforeXpath = "/html/body/table[2]/tbody/tr[1]/td[2]/table/tbody/tr/td/table/tbody/tr/td[1]/table/tbody/tr[";
		String afterXpath = "]/td[";

		final int hoursInDay = 18;
		String hourValue = null;
		boolean flag = false;

		for (int rowNum = 2; rowNum <= hoursInDay; rowNum++) {
			try {
				hourValue = driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + 1 + "]")).getText();
				System.out.println("Hour value is = " + hourValue);
			} catch (NoSuchElementException e) {
				System.out.println("Error with the hour");
				flag = false;
				break;
			}

			if (hourValue.equals(hour)) {
				System.out.println("Create the event by the hour time");
				driver.findElement(By.xpath(beforeXpath + rowNum + afterXpath + 2 + "]")).click();
				System.out.println("Hour selected is=" + hourValue);
				flag = true;

				break;
			} // End select day in the calendar
		} // End for loop

	}

	private static void selectCalenderDate(String date, WebDriver driver) {
		System.out.println("Select date =" + date);
		driver.switchTo().frame("mainpanel");

		String dateSplit[] = date.split("-");

		String day = dateSplit[0];
		String month = dateSplit[1];
		String year = dateSplit[2];

		System.out.println("Day =" + dateSplit[0]);
		System.out.println("Month =" + dateSplit[1]);
		System.out.println("Year =" + dateSplit[2]);

		// Select year
		Select selectYear = new Select(driver.findElement(By.name("slctYear")));
		selectYear.selectByVisibleText(year);

		// Select month
		Select selectMonth = new Select(driver.findElement(By.name("slctMonth")));
		selectMonth.selectByVisibleText(month);

		String beforeXPath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String afterXPath = "]/td[";

		final int weekDays = 7;
		String dayValue = null;
		boolean flag = false;

		for (int rowNum = 2; rowNum <= weekDays; rowNum++) {
			for (int colNum = 1; colNum <= weekDays; colNum++) {
				try {
					dayValue = driver.findElement(By.xpath(beforeXPath + rowNum + afterXPath + colNum + "]")).getText();
				} catch (NoSuchElementException e) {
					System.out.println("Error - Please enter a correct date");
					flag = false;
					break;
				}

				if (dayValue.equals(day)) {
					driver.findElement(By.xpath(beforeXPath + rowNum + afterXPath + colNum + "]")).click();
					System.out.println("Day selected is=" + dayValue);
					flag = true;
					System.out.println("Month day selected is = " + dayValue);
					break;
				} // End select day in the calendar
			}

			if (flag) {
				break;
			}

		} // End for loop

	} // End selectCalenderDate

	private static void loginToSite(WebDriver driver) throws InterruptedException {
		driver.findElement(By.name("username")).sendKeys("kieraninozz");
		driver.findElement(By.name("password")).sendKeys("tibet1");
		System.out.println("Click submit to login");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	} // End loginToSite

	private static void manageWindow(WebDriver driver) {
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		driver.get("http://www.freecrm.com");
	} // End manageWindow

}
