package Test;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;

import PageObject.HomePage_Services;
import PageObject.Homepage_Search;
import PageObject.JavaPage;

import PageObject.GetCertified;

//import PageObject.Homepage_Search;
import PageObject.LoginPage;

import PageObject.SearchDropDownselect;

import PageObject.Tutorial;

import PageObject.LogoutPage;

//import PageObject.Tutorial;
import Utilities.ReadConfig;

public class LoginTest extends BaseClass {
	LoginPage lp;
	JavaPage jp;

	@Test(priority = 0, dataProvider = "loginData")
	public void SignInDetail(String emailid, String password, String value) throws InterruptedException {

		lp = new LoginPage(driver); // this is for login page

		lp = new LoginPage(driver); // this is for login page

		lp = new LoginPage(driver); // this is for login page
		jp = new JavaPage(driver);

		lp.clickOnSignInbtn();
		lp.enterEmailId(emailid);
		lp.enterpass(password);
		lp.signinbtnclick();
		Thread.sleep(5000);
		lp.closePopupIfPresent();
		Thread.sleep(3000);
		lp.navigationLogin();

		// isha suvarna nimal
		SearchDropDownselect sp = new SearchDropDownselect(driver);
		sp.scrolldown();
		sp.searchAndClickFourthOption();
		Thread.sleep(5000);
		sp.navLogin();
		Thread.sleep(1000);

		// mohini
		Tutorial t = new Tutorial(driver); /// this is for tutorial page
		Thread.sleep(2000);
		t.clickOnTutorialLink();
		Thread.sleep(2000);
		t.SelectOnelink();
		t.navigationLogin();
		Thread.sleep(3000);

		// Harish code
		Homepage_Search s = new Homepage_Search(driver);
		s.searchclick(value);
		Thread.sleep(7000);
		s.encapscroll();
		Thread.sleep(4000);
		s.clickonenc();
		Thread.sleep(2000);
		s.nextbtn();
		Thread.sleep(2000);
		s.previousbtn();
		Thread.sleep(2000);
		s.navigationLogin();
		Thread.sleep(2000);

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
		Thread.sleep(1000);

		// Sachin
		jp.clickTopNavJava();
		Thread.sleep(2000);
		jp.scrollToTryItAndClick();
		Thread.sleep(5000);
		jp.handleTryItWindowAndRun();
		// jp.clickOnSignInbtn();
		Thread.sleep(5000);
		jp.navigationLogin();
		Thread.sleep(1000);

		// Anandi GetCertified

		GetCertified gc = new GetCertified(driver);
		gc.clickgetcertified();
		Thread.sleep(2000);
		gc.scrolldown();
		Thread.sleep(1000);
		gc.clicklearncss();
		Thread.sleep(2000);
		gc.clickaddtocart();
		Thread.sleep(2000);
		gc.clickremove();
		Thread.sleep(5000);
		gc.clickoption();
		Thread.sleep(2000);
		
		
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
		return new Object[][] { { config.getEmailId(), config.getPassword(), config.getData() } };

	}

}
