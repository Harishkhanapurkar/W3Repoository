package Test;


import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;
import PageObject.GetCertified;
//import PageObject.Homepage_Search;
import PageObject.LoginPage;
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
		
		//Anandi GetCertified 
		
		GetCertified gc = new GetCertified(driver);
		gc.clickgetcertified();
		Thread.sleep(2000);
		gc.scrolldown();
		Thread.sleep(1000);
		gc.clickaddtocart();
		Thread.sleep(2000);
		gc.clickremove();
		Thread.sleep(5000);
		gc.clickoption();
		Thread.sleep(6000);
		
	
	}
	

	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException {
		ReadConfig config = new ReadConfig();
		return new Object[][] { { config.getEmailId(), config.getPassword()} };
		
	}
	

}


