package com.amazon.web.tests.search;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.pages.search.SearchPage;
import com.amazon.web.tests.BaseTest;

public class SearchTest extends BaseTest{
   public SearchPage searchPage;
   
   public static Logger log = Logger.getLogger(SearchTest.class);
   
   @BeforeClass
   @Parameters({"siteURL"})
   public void initAmazonWebsite(String siteURL)   {
	   log.info("Starting initAmazonWebsite method");
	   
		super.getWebSite(siteURL);
	  
		amazonLogin();
	
	   searchPage = new SearchPage(driver);
	   
	   log.info("Ending initAmazonWebsite method");
   }

   
   @Test(priority = 1)
   public void verifySearchWithAlphabets() {
	   log.info("Starting verifySearchWithInvalidLetters method");
	   amazonLogin();
	   searchPage.SearchBar(testDataProp.getProperty("search.invalid.letters.text"));
	   searchPage.clickOnSearchIcon(); 
	   
	   Assert.assertEquals(searchPage.getNoResultFoundText(), expectedAssertionsProp.getProperty("search.invalid.error.text"));
	   
	   log.info("Ending verifySearchWithInvalidLetters method");
   }
   
   @Test(priority = 2)
   public void verifySearchWithInvalidNumbers() throws InterruptedException { 
	   log.info("Starting verifySearchWithInvalidNumbers method");
	   
	   searchPage.SearchBar(testDataProp.getProperty("search.invalid.numbers.text"));
	   searchPage.clickOnSearchIcon();
	   
	   Assert.assertEquals(searchPage.getNoResultFoundText(), expectedAssertionsProp.getProperty("search.invalid.error.text"));
	   
	   log.info("Ending verifySearchWithInvalidNumbers method");
   }
   
   @Test(priority = 3)
   public void verifySearchWithValidCaseSensitiveLetters() throws InterruptedException {
	   log.info("Starting verifySearchWithValidCaseSensitiveLetters method");
	   
	   searchPage.SearchBar(testDataProp.getProperty("search.valid.casesensitiveletters.text"));
	   searchPage.clickOnSearchIcon();
	   
	   Assert.assertEquals(searchPage.getRedmiA2Text(), expectedAssertionsProp.getProperty("redmi.text"));
	   
	   log.info("Ending verifySearchWithValidCaseSensitiveLetters method");
   }
   
   @Test(priority = 4)
   public void verifySearchWithValidTvName() throws InterruptedException {
	   log.info("Starting verifySearchWithValidTvName method");
	   
	   searchPage.SearchBar(testDataProp.getProperty("search.valid.tvname.text"));
	   searchPage.clickOnSearchIcon();
	   
	   Assert.assertEquals(searchPage.getResultsText(), expectedAssertionsProp.getProperty("results.text"));
	   
	   log.info("Ending verifySearchWithValidTvName method");
   }
   
//   @AfterClass
//   public void quitDriver(){
//	   log.info("Starting quitDriver method");
//	   driver.quit();
//	   log.info("Ending quitDriver method");
//   }
}
