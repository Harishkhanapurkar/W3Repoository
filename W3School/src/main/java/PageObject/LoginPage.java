package PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class LoginPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@title='Sign in to your account']")
	WebElement signInBtn;

	public void clickOnSignInbtn() {
		signInBtn.click();
	}

	@FindBy(xpath = "//input[@id='tnb-login-dropdown-email']")
	WebElement email;

	public void enterEmailId(String emailid) {
		email.sendKeys(emailid);
	}

	@FindBy(xpath = "//input[@id='tnb-login-dropdown-password']")
	WebElement pass;

	public void enterpass(String password) {
		pass.sendKeys(password);
	}

	@FindBy(xpath = "//form[@id='loginFormElement']//button[@type='submit']")
	WebElement signIn;

	public void signinbtnclick() {
		signIn.click();
	}

	@FindBy(xpath = "//button[@class='chakra-modal__close-btn css-uyzm7t']")
	WebElement popup;

	public void closePopupIfPresent() {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOf(popup)).click();
	}

	@FindBy(xpath = "//a[contains(text(), 'Tutorials')]")
	WebElement tutorial;

	public void clickOnTutorialLink() {
		driver.switchTo().frame("top-nav-bar-iframe");
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(tutorial));
		tutorial.click();
		//driver.switchTo().defaultContent(); //this is used to back to home page
	}
	public void navigationLogin() {
		//driver.get("https://www.w3schools.com/");
		driver.navigate().to("https://www.w3schools.com/");
	}
}


