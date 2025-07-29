package Test;


import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
//import PageObject.Homepage_Search;
import PageObject.LoginPage;
import PageObject.SearchDropDownselect;
//import PageObject.Tutorial;
import Utilities.ReadConfig;

public class LoginTest extends BaseClass {
	LoginPage lp;

	@Test(priority = 0, dataProvider = "loginData")
	public void SignInDetail(String emailid, String password) throws InterruptedException {
		lp = new LoginPage(driver); //this is for login page
		lp.clickOnSignInbtn();
		lp.enterEmailId(emailid);
		lp.enterpass(password);
		lp.signinbtnclick();
		Thread.sleep(5000);
		lp.closePopupIfPresent();
		Thread.sleep(3000);
		lp.navigationLogin();
		
		//
		SearchDropDownselect sp = new SearchDropDownselect(driver);
		sp.scrolldown();
		sp.searchAndClickFourthOption();
		Thread.sleep(5000);
		sp.navLogin();
		Thread.sleep(2000);
		
	}
	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException {
		ReadConfig config = new ReadConfig();
		return new Object[][] { { config.getEmailId(), config.getPassword()} };
		
	}
	

}


