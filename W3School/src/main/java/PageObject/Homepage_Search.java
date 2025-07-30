package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage_Search extends Tutorial {

	public Homepage_Search(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//input[@id='tnb-google-search-input']")
	WebElement searchbtn;

	public void searchclick(String sd) {
		// searchbtn.click();
		searchbtn.sendKeys(sd);
		searchbtn.sendKeys(Keys.ENTER);
	}

	public void encapscroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement scrollableDiv = driver.findElement(By.id("leftmenuinnerinner")); // Use your actual ID or selector

		// Scroll the div 800 pixels down
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 900;", scrollableDiv);
	}

	@FindBy(xpath = "//a[normalize-space()='Java Encapsulation']")
	WebElement encapsulation;

	public void clickonenc() {
		encapsulation.click();
	}

	@FindBy(xpath = "//*[@id=\"main\"]/div[2]/a[2]")
	WebElement next;

	public void nextbtn() {
		next.click();

	}

	@FindBy(xpath = "//*[@id=\"main\"]/div[2]/a[1]")
	WebElement previous;

	public void previousbtn() {
		previous.click();

	}

	public void navigationLogin() {
		driver.navigate().to("https://www.w3schools.com/");
	}

}