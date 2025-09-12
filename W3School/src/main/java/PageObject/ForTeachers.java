package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForTeachers extends LoginPage
{

	public ForTeachers(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//a[@class=\"user-authenticated tnb-for-teachers tnb-jobs-btn w3-bar-item w3-button w3-right w3-white ga-top ga-top-teachers\"]")
	WebElement clickonforteachers;
	
	public void clickfortearchers()
	{
		clickonforteachers.click();
	}
	public void nevilogin()
	{
		driver.navigate().to("https://www.w3schools.com");
	}
}
