package Test;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Base.BaseClass;

import PageObject.HomePage_Services;


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
	public void SignInDetail(String emailid, String password) throws InterruptedException {

		lp = new LoginPage(driver); // this is for login page


		lp = new LoginPage(driver); // this is for login page

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

		// Nikhil ----> Now logout

		LogoutPage logout = new LogoutPage(driver);
		logout.clickOnProfileIcon();
		Thread.sleep(5000);
		logout.scrollProfileDropdown();
		Thread.sleep(2000);
		logout.clickOnLogout();
		Thread.sleep(2000);

	}


		

		//
		SearchDropDownselect sp = new SearchDropDownselect(driver);
		sp.scrolldown();
		sp.searchAndClickFourthOption();
		Thread.sleep(5000);
		sp.navLogin();
		Thread.sleep(2000);
		
	}


		// Sachin 
		jp.clickTopNavJava();
		Thread.sleep(2000);
		jp.scrollToTryItAndClick();
		Thread.sleep(5000);
		jp.handleTryItWindowAndRun();
		//jp.clickOnSignInbtn();
		Thread.sleep(5000);
		jp.navigationLogin();


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
		

		//mohini
		Tutorial t=new Tutorial(driver); ///this is for tutorial page
		t.clickOnTutorialLink();
		t.SelectOnelink();
		t.navigationLogin();
	



	}


	@DataProvider(name = "loginData")
	public Object[][] loginData() throws IOException {
		ReadConfig config = new ReadConfig();
		return new Object[][] { { config.getEmailId(), config.getPassword() } };

	}

}
