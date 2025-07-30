package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchDropDownselect extends LoginPage {

	public SearchDropDownselect(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void scrolldown() throws InterruptedException {
		// Step 3: Scroll to the dropdown using JavaScript (optional but safer)
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 100);");
		Thread.sleep(1000); // Let page adjust scroll
	}

	@FindBy(xpath = "//input[@placeholder='Search our tutorials, e.g. HTML']")
	WebElement searchBox;

	public void searchAndClickFourthOption() throws InterruptedException {
		// Step 1: Enter "java" into the search box
		searchBox.sendKeys("java");

		// Step 2: Wait for dropdown suggestions to appear
		Thread.sleep(2000); // Replace with WebDriverWait for better handling

		// Step 4: Use Actions to move down slowly to the 4th suggestion
		Actions actions = new Actions(driver);

		for (int i = 0; i < 2; i++) {
			actions.sendKeys(Keys.ARROW_DOWN).perform();
			Thread.sleep(700);
		}
		// Step 5: Press Enter to click the 4th suggestion
		actions.sendKeys(Keys.ENTER).perform();

	}

	public void navLogin() throws InterruptedException {
		// driver.get("https://www.w3schools.com/");
		driver.navigate().to("https://www.w3schools.com/");
		// Thread.sleep();
	}

}
