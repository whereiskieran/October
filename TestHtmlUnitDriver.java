package October;

public class TestHtmlUnitDriver {

	public static void main(String[] args) {
		TestHtmlUnitDriver example = new TestHtmlUnitDriver();
		example.testHtmlUnitDriver();
	}
	
	public void testHtmlUnitDriver()
	{
		WebDriver driver = null;
		
		try
		{
			// Initiate HtmlUnitDriver object.
			driver = new HtmlUnitDriver();
			
			/* If you want to see the browser interaction, you can uncomment below code to use Firefox to run this test script.
			//assign webdriver executable file path to the value of system variable
			System.setProperty("webdriver.gecko.driver", "C:\\Workspace\\dev2qa.com\\Lib\\geckodriver-v0.16.1-win64\\geckodriver.exe");
			//Initiate a browser
			driver = new FirefoxDriver();
			*/
			driver.get("http://www.bing.com");
			
			// Get input search text box.
			By byIdSearchInput = By.id("sb_form_q");
			WebElement searchInput = driver.findElement(byIdSearchInput);
			if(searchInput!=null)
			{
				// Type search keyword in search text box.
				searchInput.sendKeys("selenium");
			}
			
			// Get search form submit button.
			By byIdSubmitBtn = By.id("sb_form_go");
			WebElement submitBtn = driver.findElement(byIdSubmitBtn);
			if(submitBtn!=null)
			{
				// Click submit button to search.
				submitBtn.click();
			}
			
			Thread.sleep(3000);
			
			// Get search result list in first result page by xpath.
			By byXPathResultList = By.xpath("//*[@id=\"b_results\"]/li[@class=\"b_algo\"]");
			List resultElementList = driver.findElements(byXPathResultList);
			
			if(resultElementList!=null)
			{
				// Loop the search result list.
				int size = resultElementList.size();
				for(int i=0;i<size;i++)
				{
					WebElement resultElement = resultElementList.get(i);
					
					// Get the result title from current result item by xpath.
					By byXPathTitle = By.xpath(".//a");
					WebElement titleElement = resultElement.findElement(byXPathTitle);
					String title = titleElement.getText();
					System.out.println(title);
					System.out.println();
					
					// Get the result description from curent result item by xpath.
					By byXPathDesc = By.xpath(".//p");
					WebElement descElement = resultElement.findElement(byXPathDesc);
					String description = descElement.getText();
					System.out.println(description);
					System.out.println();
					System.out.println();
				}
			}
			
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			if(driver!=null)
			{
				driver.close();
				driver=null;
			}
		}
	}

}
