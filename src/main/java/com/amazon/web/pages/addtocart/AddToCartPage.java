package com.amazon.web.pages.addtocart;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.web.pages.BasePage;

public class AddToCartPage extends BasePage{

	@FindBy(xpath = "//span[text () = 'LG 80 cm (32 inches) HD Ready Smart LED TV 32LM563BPTC (Dark Iron Gray)']")
	WebElement btnLGSmartTv;
	
	@FindBy(xpath = "(//span[contains(@class,\"a-button a-spacing-small a-button-primary a\")])[2]")
	WebElement btnAddToCart;
	
	@FindBy(xpath = "(//input[@class=\"a-button-input\" and @type=\"submit\" and @aria-labelledby=\"attach-sidesheet-view-cart-button-announce\"])[1]")
	WebElement btnCart;
	
	@FindBy(xpath = "//input[contains(@name,'submit.delete')]")
	WebElement btnDelete;
	
	@FindBy(xpath = "//h1[contains(text(), ' Your Amazon Cart is empty.')]")
	WebElement lblCartIsEmpty;
	
	@FindBy(xpath = "//span[@class=\"a-size-medium sc-number-of-items\"]")
	WebElement lblSubTotal;
	
	public static Logger log = Logger.getLogger(AddToCartPage.class);
	
	public AddToCartPage(WebDriver driver) {
		super(driver);
		log.info("Starting AddToCartPage Constructor");
		log.info("Ending AddToCartPage Constructor");
	}
    
	public void clickOnLGSmartTv() throws InterruptedException{
		log.info("Starting clickOnLGSmartTv method");
		
		fluentWait(btnLGSmartTv);
		btnLGSmartTv.click();
		
		log.info("Ending clickOnLGSmartTv method");
	}
	
	public void clickOnAddToCart() throws InterruptedException{
		log.info("Starting clickOnAddToCart method");
		
		explicitWait(btnAddToCart);
		btnAddToCart.click();
		
		log.info("Ending clickOnAddToCart method");
	}
	
	public void clickOnCart() throws InterruptedException{
		log.info("Starting clickOnCart method");
		
		explicitWait(btnCart);
		btnCart.click();
		
		log.info("Ending clickOnCart method");
	}
	
	public void clickOnDelete() throws InterruptedException{
		log.info("Starting clickOnDelete method");
		
		explicitWait(btnDelete);
		btnDelete.click();
		
		log.info("Ending clickOnDelete method");
	}
	
	public String getCartIsEmptyText() throws InterruptedException{
		log.info("Starting getCartIsEmptyText method");
		
		explicitWait(lblCartIsEmpty);
		
		log.info("Ending getCartIsEmptyText method");
		
		return lblCartIsEmpty.getText();
	}
	
	public String getSubTotalText() throws InterruptedException{
		log.info("Starting getSubTotalText method");
		
		explicitWait(lblSubTotal);
		
		log.info("Ending getSubTotalText method");
		
		return lblSubTotal.getText();
	}
}
