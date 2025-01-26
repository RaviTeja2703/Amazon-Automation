package com.amazon.pages.search;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.web.pages.BasePage;

public class SearchPage extends BasePage{
	
	@FindBy(xpath = "//input[@placeholder='Search Amazon.in']")
	WebElement txtSearchBar;
	
	@FindBy(xpath = "//input[@id='nav-search-submit-button']")
	WebElement btnSearchIcon;
	
	@FindBy(xpath = "//span[contains(text(), 'No results for')]")
	WebElement lblNoResultsFound;
	
	@FindBy(xpath = "//span[contains(text (), 'A2 (Sea Green, 2GB RAM, 64GB Storage')]")
	WebElement btnRedmiA2;
	
	@FindBy(xpath = "//span[contains(text(), 'Results')]")
	WebElement lblResults;
	
	public static Logger log = Logger.getLogger(SearchPage.class);
	
	public SearchPage(WebDriver driver) {
		super(driver);
		log.info("Starting SearchPage Constructor");
		log.info("Ending SearchPage Constructor");
	}
    
	public void SearchBar(String text) {
		log.info("Starting SearchBar method");
		
		txtSearchBar.clear();
		explicitWait(txtSearchBar);
		txtSearchBar.sendKeys(text);
		
		log.info("Ending SearchBar method");
	}
	
    public void clickOnSearchIcon() {
    	log.info("Starting clickOnSearchIcon method");
    	
    	explicitWait(btnSearchIcon);
    	btnSearchIcon.click();
    	
    	log.info("Ending clickOnSearchIcon method");
    }
    
    public String getNoResultFoundText() {
    	log.info("Starting getNoResultFoundText method");
    	
    	explicitWait(lblNoResultsFound);
    	
    	log.info("Ending getNoResultFoundText method");
    	
		return lblNoResultsFound.getText();
    }
    
    public String getRedmiA2Text() throws InterruptedException{
    	log.info("Starting getRedmiA2Text method");
    	
    	explicitWait(btnRedmiA2);
    	
    	log.info("Ending getRedmiA2Text method");
    	
		return btnRedmiA2.getText();
    }
    
    public String getResultsText() throws InterruptedException{
    	log.info("Starting getResultsText method");
    	
    	explicitWait(lblResults);
    	
    	log.info("Ending getResultsText method");
    	
		return lblResults.getText();
    }
}
