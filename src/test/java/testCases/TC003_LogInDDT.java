package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LogInPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;


/* data is valid --login success --test pass --logout 
 data is valid --login failed --test fail
 
 data is invalid --login success --test fail --logout 
 data is invalid --login failed --test pass*/

public class TC003_LogInDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups="Datadriven") // since data providers are in another class
																				
	public void verify_loginDDT(String email, String pwd, String exp) {

		logger.info("***********Starting the TC003_LogInDDT*************");

		try {// home page
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickLogIn();

			// login page
			LogInPage lp = new LogInPage(driver);
			lp.setLogInEmail(email);// email and password maintained in the config.properties file
			lp.setLogInPassdword(pwd);
			lp.clickBtn_login();

			// my account page

			MyAccountPage mp = new MyAccountPage(driver);
			boolean targetpage = mp.isMyAccountPageExists();// if it its returns true login successful

			
			/* data is valid --login success --test pass --logout 
			 data is valid --login failed --test fail
			 
			 data is invalid --login success --test fail --logout 
			 data is invalid --login failed --test pass*/
			 

			if (exp.equalsIgnoreCase("Valid")) {
				if (targetpage == true) {
					mp.clickLogout();
					//System.out.println("Email: " + email + ", Pwd: " + pwd + ", Expected: " + exp + ", Actual result: " + targetpage);

					Assert.assertTrue(true);
					
				} else {
					//System.out.println("Email: " + email + ", Pwd: " + pwd + ", Expected: " + exp + ", Actual result: " + targetpage);
					Assert.assertTrue(false);
					
				}

			}

			else if (exp.equalsIgnoreCase("Invalid")) {
				if (targetpage == true) {
					//System.out.println("Email: " + email + ", Pwd: " + pwd + ", Expected: " + exp + ", Actual result: " + targetpage);
					mp.clickLogout();
					
					Assert.assertTrue(false);
					//Assert.fail();
				} else {
					//System.out.println("Email: " + email + ", Pwd: " + pwd + ", Expected: " + exp + ", Actual result: " + targetpage);
					Assert.assertTrue(true);
				}

			}
		} catch (Exception e) {
			Assert.fail();
		}

		logger.info("***********Finished the TC003_LogInDDT*************");

	}

}
