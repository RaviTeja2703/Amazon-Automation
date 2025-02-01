package com.amazon.web.tests.login;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.web.tests.BaseTest;

public class LoginTest extends BaseTest{
	
	public static Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeClass
    @Parameters({"siteURL"})
	public void initAmazonWebSite(String siteURL) throws InterruptedException{
		log.info("Starting initAmazonWebSite");
		
		getWebSite(siteURL);
		
		log.info("Ending initAmazonWebSite");
	}
	
	@Test(priority = 1)
	public void verifyLoginWithLessMobileNumber() throws InterruptedException {
		log.info("Starting verifyLoginWithLessMobileNumber method");
		
		loginPage.clickOnSignIn();
		loginPage.setMobileNumber(testDataProp.getProperty("mobile.lessthantendigit.text"));
		loginPage.clickOnContinueButton();
		
		Assert.assertEquals(loginPage.getIncorrectPhoneNumberText(), expectedAssertionsProp.getProperty("mobile.invalid.error.text"));
		
		log.info("Ending verifyLoginWithLessMobileNumber method");
	}
	
	public void verifyLoginWithsomeSymbols() {
		loginPage.setMobileNumber("@@@@@");
		loginPage.clickOnContinueButton();
	}
	
	@Test(priority = 2)
	public void verifyLoginWithSpecialCharacters() throws InterruptedException {
		log.info("Starting verifyLoginWithInvalidSpecialCharacters method");
		
		loginPage.setMobileNumber(testDataProp.getProperty("mobile.specialcharacters.text"));
		loginPage.clickOnContinueButton();
		
		Assert.assertEquals(loginPage.getInvalidEmailText(), expectedAssertionsProp.getProperty("email.invalid.error.text"));
		
		log.info("Ending verifyLoginWithInvalidSpecialCharacters method");
	}
	
	@Test(priority = 3)
	public void verifyLoginWithEmptyMobNumberField() throws InterruptedException {
		log.info("Starting verifyLoginWithInvalidSpaces method");
		
		loginPage.setMobileNumber(testDataProp.getProperty("mobile.empty.text"));
		loginPage.clickOnContinueButton();
		
		Assert.assertEquals(loginPage.getEnterEmailMobileText(), expectedAssertionsProp.getProperty("email.enter.error.text"));
		
		log.info("Ending verifyLoginWithInvalid");
	}

	/*@Test(priority = 4)
	public void verifyLoginWithInvalidPasswordWithSpecialCharacters() throws InterruptedException {
		log.info("Starting verifyLoginWithInvalidPasswordWithSpecialCharacters method");
		
		loginPage.setPassword(testDataProp.getProperty("password.invalid.specialcharacters.text"));
		loginPage.clickOnSignIn2();
		
		Assert.assertEquals(loginPage.getIncorrectPasswordText(), expectedAssertionsProp.getProperty("password.invalid.error.text"));
		
		log.info("Ending verifyLoginWithInvalidPasswordWithSpecialCharacters method");
	}
	
	@Test(priority = 5)
	public void verifyLoginWithInvalidEmptyPasswordField() throws InterruptedException {
		log.info("Starting verifyLoginWithInvalidEmptyPasswordField method");
		
		loginPage.setPassword(testDataProp.getProperty("password.empty.text"));
		loginPage.clickOnSignIn2();
		
		Assert.assertEquals(loginPage.getEnterPasswordText(), expectedAssertionsProp.getProperty("password.enter.error.text") );
		
		log.info("Ending verifyLoginWithInvalidEmptyPasswordField method");
	}
	
	@Test(priority = 6)
	public void verifyLoginWithInvalidPasswordWithNumbers() throws InterruptedException {
		log.info("Starting verifyLoginWithInvalidPasswordWithNumbers method");
		
		loginPage.setPassword(testDataProp.getProperty("password.invalid.numbers.text"));
		loginPage.clickOnSignIn2();
		
		Assert.assertEquals(loginPage.getIncorrectPasswordText(), expectedAssertionsProp.getProperty("password.invalid.error.text"));
		
		log.info("Ending verifyLoginWithInvalidPasswordWithNumbers method");
	}*/
	
	@Test(priority = 4)
	public void verifyLoginWithValidCredentials() throws InterruptedException {
		log.info("Starting verifyLoginWithValidDetails");
		
		loginPage.setMobileNumber(testDataProp.getProperty("mobile.valid.text"));
    	loginPage.clickOnContinueButton();
    	loginPage.setPassword(testDataProp.getProperty("password.valid.text"));
    	loginPage.clickOnSignIn2();

		Assert.assertTrue(loginPage.isAmazonLogoDisplayed());

		Assert.assertEquals(loginPage.getAccountAndListsText(), expectedAssertionsProp.getProperty("account,list.text"));
		
		Assert.assertTrue(loginPage.isCartImageDisplayed());
		
		Assert.assertEquals(loginPage.getAmazonPayText(), expectedAssertionsProp.getProperty("amazonpay.text"));
		
		//Assert.assertEquals(loginPage.getTodaysDealsText(), expectedAssertionsProp.getProperty("today'sdeals.text"));
		
		Assert.assertEquals(loginPage.getAllText(), expectedAssertionsProp.getProperty("all.text"));
		
		log.info("Ending verifyLoginWithValidDetails");
	}
	
	@AfterClass
	public void quitDriver(){
		log.info("Starting quitDriver method");
		driver.quit();
		log.info("Ending quitDriver method");
	}
}