package Test;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
//import PageObject.Homepage_Search;
import PageObject.LoginPage;
import PageObject.LogoutPage;
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

		// Nikhil ----> Now logout

		LogoutPage logout = new LogoutPage(driver);
		logout.clickOnProfileIcon();
		Thread.sleep(5000);
		logout.scrollProfileDropdown();
		Thread.sleep(2000);
		logout.clickOnLogout();
		Thread.sleep(2000);

	}

	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException {
		ReadConfig config = new ReadConfig();
		return new Object[][] { { config.getEmailId(), config.getPassword() } };

	}

}
