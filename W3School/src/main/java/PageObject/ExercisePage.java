package PageObject;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExercisePage extends SearchDropDownselect {

	public ExercisePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
	@FindBy(xpath="//a[@id=\"navbtn_exercises\"]")
	WebElement exercise;
	
	public void clickOnExerciseLink() {
		

		mywait.until(ExpectedConditions.elementToBeClickable(exercise));
		exercise.click();
	
	}
	public void scrollToBottom() {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
    @FindBy(xpath="//a[contains(text(),'MongoDB')]")
    WebElement ClickMangoDB;
    
    public void ClickBtn() {
    	mywait.until(ExpectedConditions.elementToBeClickable(ClickMangoDB));
		ClickMangoDB.click();
    }
    public void BackToOriginal() {
		// driver.get("https://www.w3schools.com/");
		driver.navigate().to("https://www.w3schools.com/");
        System.out.println("Exercise page validate succesfully..");
	}
    
	
	
}
