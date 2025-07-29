package Test;


import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.JavaPage;
//import PageObject.Homepage_Search;
import PageObject.LoginPage;
//import PageObject.Tutorial;
import Utilities.ReadConfig;

public class LoginTest extends BaseClass {
	LoginPage lp;
	JavaPage jp;


	@Test(priority = 0, dataProvider = "loginData")
	public void SignInDetail(String emailid, String password) throws InterruptedException {
		lp = new LoginPage(driver); //this is for login page
		jp = new JavaPage(driver);

		lp.clickOnSignInbtn();
		lp.enterEmailId(emailid);
		lp.enterpass(password);
		lp.signinbtnclick();
		Thread.sleep(5000);
		lp.closePopupIfPresent();
		Thread.sleep(3000);
		lp.navigationLogin();
		
		// Sachin 
		jp.clickTopNavJava();
		Thread.sleep(2000);
		jp.scrollToTryItAndClick();
		Thread.sleep(5000);
		jp.handleTryItWindowAndRun();
		//jp.clickOnSignInbtn();
		Thread.sleep(5000);
		jp.navigationLogin();

	}
	
	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException {
		ReadConfig config = new ReadConfig();
		return new Object[][] { { config.getEmailId(), config.getPassword()} };
		
	}
	

}


