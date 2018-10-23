package October;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibilityTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\01 Kieran\\01 Automatiom\\Webdriver\\chromedriver.exe");
		String fileWithPath = "C:\\Tmp\\";
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.freecrm.com/register");

		submitIsDisplayed(driver);
		submitIsEnabledFalse(driver);
		checkBoxSelectedFalse(driver);
		System.out.println("Terms selected, Submit button is active ="+agreeTermsSubmitBtnActive(driver));

	}

	private static boolean agreeTermsSubmitBtnActive(WebDriver driver) {
		driver.findElement(By.name("agreeTerms")).click();
		boolean isEnabled = driver.findElement(By.name("submitButton")).isEnabled();
		if (isEnabled) {
			System.out.println("Passed - user agreed terms and submit is selected");
			return isEnabled;
		} else {
			System.out.println("Failed - user agreed terms and submit is NOT selected");
			return isEnabled;
		}

	} //End agreeTermsSubmitBtnActive

	private static boolean checkBoxSelectedFalse(WebDriver driver) {
		boolean checkboxSelectedFalse = driver.findElement(By.name("agreeTerms")).isSelected();
		System.out.println("Passed - Check box selected, expected false =" + checkboxSelectedFalse);
		return checkboxSelectedFalse;
	}

	private static boolean submitIsEnabledFalse(WebDriver driver) {
		boolean submitIsEnabledFalse = driver.findElement(By.id("submitButton")).isEnabled();
		System.out.println("Passed - Submit button enabled, expected False = " + submitIsEnabledFalse);
		return submitIsEnabledFalse;
	}

	private static Boolean submitIsDisplayed(WebDriver driver) {
		boolean isDisplayedSubmit = driver.findElement(By.id("submitButton")).isDisplayed();
		System.out.println("Passed - Submit button displayed = " + isDisplayedSubmit);
		return isDisplayedSubmit;
	}

	// Agree terms tick box, submit button is active

}
