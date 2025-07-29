package Test;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.HomePage_Services;
//import PageObject.Homepage_Search;
import PageObject.LoginPage;
//import PageObject.Tutorial;
import Utilities.ReadConfig;

public class LoginTest extends BaseClass {
	LoginPage lp;

	@Test(priority = 0, dataProvider = "loginData")
	public void SignInDetail(String emailid, String password) throws InterruptedException {
		lp = new LoginPage(driver); // this is for login page
		lp.clickOnSignInbtn();
		lp.enterEmailId(emailid);
		lp.enterpass(password);
		lp.signinbtnclick();
		Thread.sleep(5000);
		lp.closePopupIfPresent();
		Thread.sleep(3000);
		lp.navigationLogin();

		// VICKY'S CODE STARTED

		HomePage_Services hs = new HomePage_Services(driver);

		hs.clickonservices();

		// To find text is present or not on the web page
		String text = "All Our Services";
		if (driver.getPageSource().contains(text))
			System.out.println("Text is present");

		else
			System.out.println("Text is not present");

		Thread.sleep(3000);

		hs.ftuturials();
		hs.clickonsql();
		hs.nextbtn();
		hs.previousbtn();
		hs.navigationLogin();

	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException {
		ReadConfig config = new ReadConfig();
		return new Object[][] { { config.getEmailId(), config.getPassword() } };

	}

}
