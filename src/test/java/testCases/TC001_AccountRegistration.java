package testCases;

import org.testng.Assert;

import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistration extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verifyAccountRegistration() throws InterruptedException {

		logger.info("***********Starting the TC001_AccountRegistration*************");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("***********Clicked on My Account Link*************");
			hp.clickRegister();
			logger.info("***********Clicked on Register Link*************");
			AccountRegistrationPage arp = new AccountRegistrationPage(driver);

			/*
			 * arp.setFirstName("Santosh"); arp.setLastName("Subudhi");
			 * arp.setEmail("subudhisantosh10@gmail.com"); arp.setTelephone("5776512312");
			 * arp.setPassword("S@ilesh12345"); arp.setConfirmPassword("S@ilesh12345");
			 */
			logger.info("***********Providing customer details*************");
			arp.setFirstName(randomString().toUpperCase());
			arp.setLastName(randomString().toUpperCase());
			arp.setEmail(randomString() + "@gmail.com");// randomly we have to generate
			arp.setTelephone(randomNumber());

			String passwOrd = randomAlphaNumeric();

			arp.setPassword(passwOrd);
			arp.setConfirmPassword(passwOrd);

			arp.setSubscribe();
			arp.checkPrivacyPolicy();
			arp.clickContinue();

			logger.info("***********Clicked on continue button*************");

			logger.info("***********Validating expected Message*************");

			Assert.assertEquals(arp.getConfirmationMesaage(), "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("******Test Failed******");
			//logger.debug("****debug logs****");
			Assert.fail();
		}

		logger.info("***************Test case finished****************");
	}

}
