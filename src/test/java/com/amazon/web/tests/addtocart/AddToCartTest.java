package com.amazon.web.tests.addtocart;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.amazon.pages.search.SearchPage;
import com.amazon.web.pages.addtocart.AddToCartPage;
import com.amazon.web.tests.BaseTest;

public class AddToCartTest extends BaseTest {
	public AddToCartPage addToCartPage;
	public SearchPage searchPage;

	public static Logger log = Logger.getLogger(AddToCartTest.class);

	@BeforeClass
	@Parameters({ "siteURL" })
	public void initAmazonWebsite(String siteURL) throws InterruptedException {
		getWebSite(siteURL);
         
		addToCartPage = new AddToCartPage(driver);
		searchPage = new SearchPage(driver);
	}

	@Test(priority = 1)
	public void addToCart() throws InterruptedException {
		log.info("Starting addToCart method");

		searchPage.SearchBar(testDataProp.getProperty("search.valid.tvname.text"));
		searchPage.clickOnSearchIcon();

		addToCartPage.clickOnLGSmartTv();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

		addToCartPage.clickOnAddToCart();
		
		log.info("Ending addToCart method");
	}

	@Test(priority = 2)
	public void removeFromCart() throws InterruptedException {
		log.info("Starting removeFromCart method");
		
		addToCartPage.clickOnCart();
		addToCartPage.clickOnDelete();

		Assert.assertEquals(addToCartPage.getCartIsEmptyText(), expectedAssertionsProp.getProperty("cartempty.text"));
		
		Assert.assertEquals(addToCartPage.getSubTotalText(), expectedAssertionsProp.getProperty("subtotal.text"));
		
		log.info("Ending removeFromCart method");
	}

   /*@AfterClass
   public void quitDriver(){
	   log.info("Starting quitDriver method");
	   driver.quit();
	   log.info("Ending quitDriver method");
   }*/
}