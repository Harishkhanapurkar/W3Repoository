package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_Services extends LoginPage{
	

	public HomePage_Services(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath = "//*[@id=\"navbtn_services\"]")
	WebElement services;

	public void clickonservices() {
		services.click();
	}

	@FindBy(xpath = "//*[@id=\"services_list\"]/div[3]/div[1]/a/div")
	WebElement freetutorials;

	public void ftuturials() {
		freetutorials.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement scrollableDiv = driver.findElement(By.id("leftmenuinnerinner")); // Use your actual ID or selector

		// Scroll the div 800 pixels down
		js.executeScript("arguments[0].scrollTop = arguments[0].scrollTop + 800;", scrollableDiv);

	}

	@FindBy(xpath = "//*[@id=\"leftmenuinnerinner\"]/a[24]")
	WebElement sql;

	public void clickonsql() {
		sql.click();
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