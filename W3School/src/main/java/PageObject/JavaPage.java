package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JavaPage extends HomePage_Services {
	// WebDriver driver;

	public JavaPage(WebDriver driver) {
		super(driver);
		// this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='JAVA']")
	WebElement javaTopNavLink;

	public void clickTopNavJava() {
		javaTopNavLink.click();
	}

	@FindBy(xpath = "(//a[contains(text(),'Try it Yourself')])[1]")
	WebElement tryBtn;

	public void scrollToTryItAndClick() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			System.out.println("Waiting for 'Try it Yourself' button...");
			wait.until(ExpectedConditions.visibilityOf(tryBtn));

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", tryBtn);
			js.executeScript("window.scrollBy(0, -100);");

			System.out.println("Clicking 'Try it Yourself' button...");
			wait.until(ExpectedConditions.elementToBeClickable(tryBtn)).click();
			System.out.println("Clicked successfully.");

		} catch (Exception e) {
			System.out.println("Exception while clicking Try it Yourself: " + e.getMessage());
		}
	}

	@FindBy(xpath = "//button[@id='runbtn']")
	WebElement runBtn;

	public void handleTryItWindowAndRun() {
		// Store the current window handle
		String originalWindow = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Wait for new window/tab and switch to it
		wait.until(driver -> driver.getWindowHandles().size() > 1);

		for (String windowHandle : driver.getWindowHandles()) {
			if (!windowHandle.equals(originalWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}

		try {
			// Wait and click the Run button
			WebElement runBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("runbtn")));
			System.out.println("Clicking Run button...");
			runBtn.click();
			System.out.println("Run button clicked.");

			Thread.sleep(2000); // Wait for result to appear
		} catch (Exception e) {
			System.out.println("Error interacting with Run button: " + e.getMessage());
		}

		// Optional: Close TryIt window and return
		driver.close();
		driver.switchTo().window(originalWindow);
	}

	public void navigationLogin() {
		// driver.get("https://www.w3schools.com/");
		driver.navigate().to("https://www.w3schools.com/");
	}
}
