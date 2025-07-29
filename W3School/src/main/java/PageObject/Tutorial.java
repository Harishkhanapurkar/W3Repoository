package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Tutorial extends LoginPage {
	public Tutorial(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	@FindBy(xpath = "//a[contains(text(), 'Tutorials')]")
	WebElement tutorial;

	public void clickOnTutorialLink() {
		driver.switchTo().frame("top-nav-bar-iframe");

		mywait.until(ExpectedConditions.elementToBeClickable(tutorial));
		tutorial.click();
		// driver.switchTo().defaultContent(); //this is used to back to home page
	}

	// to capture all the given links in tutorial list
	@FindBy(xpath = "//div[@id='tutorials_list']")
	List<WebElement> tutorialLinks;

	@FindBy(xpath = "//a[@class='w3-bar-item w3-button acctop-link ga-top-drop ga-top-drop-tut-jquery']")
	WebElement lin;

	public void SelectOnelink() {
		mywait.until(ExpectedConditions.elementToBeClickable(lin));
		lin.click();

	}

}

/*
 * public void navigationLogin() { //driver.get("https://www.w3schools.com/");
 * driver.navigate().to("https://www.w3schools.com/"); }
 */


