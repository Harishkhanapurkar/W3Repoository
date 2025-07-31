package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class GetCertified extends JavaPage {

	public GetCertified(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//a[@class=\"user-authenticated tnb-certificates-btn w3-bar-item w3-button w3-right w3-white ga-top ga-top-certificates\"]")
	WebElement clickongetcertified;

	public void clickgetcertified() throws InterruptedException {
		clickongetcertified.click();
		Thread.sleep(3000);
	}

	public void scrolldown() throws InterruptedException {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 600)"); // Scroll to bottom
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//a[@href='/en-in/collections/course-catalog/products/css-course' and .//img[contains(@src, '50_86a0025a')]]")
	WebElement clickonlearncss;

	public void clicklearncss() throws InterruptedException {

		clickonlearncss.click();
	}

	@FindBy(xpath = "(//button[.//span[@class='atc-button--text' and normalize-space(.)='Add to Cart']])[1]")
	WebElement clickonaddtocart;

	public void clickaddtocart() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 300)"); // Scroll to bottom
		Thread.sleep(2000);
		clickonaddtocart.click();
		Thread.sleep(3000);
	}

	@FindBy(xpath = "//*[name()='svg' and contains(@class, 'icon-remove')]")
	WebElement clickonremove;

	public void clickremove() throws InterruptedException {
		clickonremove.click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(1000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, -500);"); // Scrolls up by 300 pixels
		Thread.sleep(2000);

	}

	@FindBy(xpath = "//select[@id=\"product_grid_sort\"]") // dropdown element
	WebElement searchoneoption;

	public void clickoption() throws InterruptedException {

		// Store the original window handle at the beginning
		String originalWindow = driver.getWindowHandle();
		// Create Select object
		Select select = new Select(searchoneoption);

		// Select the 4th option by index (index starts from 0)
		select.selectByIndex(3); // 0 - Featured, 1 - Best selling, 2 - A-Z, 3 - Z-A
		Thread.sleep(3000);

		// some code that opens new window/tab and switches to it

		// Close original window
		driver.switchTo().window(originalWindow).close();

		// Wait for other windows to appear
		Thread.sleep(2000);

		// Switch to any other open window
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
			break;
		}
	}
}
