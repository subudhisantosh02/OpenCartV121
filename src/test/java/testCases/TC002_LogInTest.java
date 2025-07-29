package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LogInTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login() throws InterruptedException {

		logger.info("***********Starting the TC002_LoginTest*************");
		
			// home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogIn();

			// login page
			LogInPage lp = new LogInPage(driver);
			lp.setLogInEmail(prop.getProperty("email"));// email and password maintained in the config.properties file
			lp.setLogInPassdword(prop.getProperty("password"));
			lp.clickBtn_login();

			// my account page

			MyAccountPage mp = new MyAccountPage(driver);
			boolean targetpage = mp.isMyAccountPageExists();
			Assert.assertTrue(targetpage);
			
			mp.clickLogout();
			
			logger.info("***********Finshed the TC002_LoginTest*************");
		} 

		

	}


