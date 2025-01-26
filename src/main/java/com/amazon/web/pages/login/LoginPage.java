package com.amazon.web.pages.login;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.web.pages.BasePage;

public class LoginPage extends BasePage{
		
	@FindBy(xpath = "//a[@data-nav-ref='nav_ya_signin']")
	WebElement btnSignIn;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement txtEnterMobileNumber;
	
	@FindBy(xpath = "//input[@id='continue']")
	WebElement btnContinue;
	
	@FindBy(xpath = "//h4[contains(text() ,'Incorrect phone number')]")
	WebElement lblIncorrectMobileNumber;
	
	@FindBy(xpath = "//span[contains(text(), ' We cannot find an account with that email address')]")
	WebElement lblInvalidEmailError;
	
	@FindBy(xpath = "//div[contains(text(), 'Enter your email or mobile phone number')]")
	WebElement lblEnterEmailMobileError;
	
	@FindBy(xpath = "//span[contains(text(), ' Your password is incorrect')]")
	WebElement lblIncorrectPassword;
	
	@FindBy(xpath = "//div[contains(text(), 'Enter your password')]")
	WebElement lblEnterPassword;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement txtPassword;
	
	@FindBy(xpath = "//span[@id='auth-signin-button']")
	WebElement btnSignIn2;
	
	@FindBy(xpath = "//a[@aria-label='Amazon.in']")
	WebElement imgAmazonLogo;
	
	@FindBy(xpath = "//span[text () = 'Account & Lists']")
	WebElement btnAccountAndLists;
	
	@FindBy(xpath = "//span[@class=\"nav-cart-icon nav-sprite\"]")
	WebElement imgCart;
	
	@FindBy(xpath = "//a[@data-csa-c-content-id=\"nav_cs_apay\"]")
	WebElement btnAmazonPay;
	
	@FindBy(xpath = "//a[@data-csa-c-content-id='nav_cs_gb']")
	WebElement btnTodaysDeals;
	
	@FindBy(xpath = "//span[@class=\"hm-icon-label\"]")
	WebElement btnAll;
	
	@FindBy(xpath = "//a[@id=\"nav-link-amazonprime\"]")
	WebElement btnPrime;
	
	public static Logger log = Logger.getLogger(LoginPage.class);
	
	public LoginPage(WebDriver driver) {
		super(driver);
		log.info("Starting LoginPage Constructor");
		log.info("Ending LoginPage Constructor");
	}
	
	public void clickOnSignIn() {
		log.info("Starting clickOnSignIn method");
		
		explicitWait(btnSignIn);
		btnSignIn.click();
		
		log.info("Ending clickOnSignIn method");
	}
	
	public void setMobileNumber(String mobileNumber) {
		log.info("Starting setMobileNumber method");
		
		explicitWait(txtEnterMobileNumber);
		txtEnterMobileNumber.clear();
		txtEnterMobileNumber.sendKeys(mobileNumber);
		
		log.info("Ending setMobileNumber method");
	}
	
	public void clickOnContinueButton()  {
		log.info("Starting clickOnContinueButton method");
		
		explicitWait(btnContinue);
		btnContinue.click();
		
		log.info("Ending clickOnContinueButton method");
	}
	
	public String getIncorrectPhoneNumberText() throws InterruptedException{
		log.info("Starting getIncorrectPhoneNumberText method");
		
		explicitWait(lblIncorrectMobileNumber);
		
		log.info("Ending getIncorrectPhoneNumberText method");
		
		return lblIncorrectMobileNumber.getText();
	}
	
	public String getInvalidEmailText() throws InterruptedException{
		log.info("Starting getInvalidEmailText method");
		
		explicitWait(lblInvalidEmailError);
		
		log.info("Ending getInvalidEmailText method");
		
		return lblInvalidEmailError.getText();
	}
	
	public String getEnterEmailMobileText() throws InterruptedException{
		log.info("Starting getEnterEmailMobileText method");
		
		explicitWait(lblEnterEmailMobileError);
		
		log.info("Ending getEnterEmailMobileText method");
		
		return lblEnterEmailMobileError.getText();
	}
	
	public String getIncorrectPasswordText() throws InterruptedException{
		log.info("Starting getIncorrectPasswordText method");
		
		explicitWait(lblIncorrectPassword);
		
		log.info("Ending getIncorrectPasswordText method");
		
		return lblIncorrectPassword.getText();
	}
	
	public String getEnterPasswordText() throws InterruptedException{
		log.info("Starting getEnterPasswordText method");
		
		explicitWait(lblEnterPassword);
		
		log.info("Ending getEnterPasswordText method");
		
		return lblEnterPassword.getText();
	}
	
	public void setPassword(String password) {
		log.info("Starting setPassword method");
		
		explicitWait(txtPassword);
		txtPassword.clear();
		txtPassword.sendKeys(password);
		
		log.info("Ending setPassword method");
	}
	
	public void clickOnSignIn2() {
		log.info("Starting clickOnSignIn2 method");
		
		explicitWait(btnSignIn2);
		btnSignIn2.click();
		
		log.info("Ending clickOnSignIn2 method");
	}
	
	public boolean isAmazonLogoDisplayed() throws InterruptedException{
		log.info("Starting isAmazonLogoDisplayed method");
		
		explicitWait(imgAmazonLogo);
		
		log.info("Ending isAmazonLogoDisplayed method");
		
		return imgAmazonLogo.isDisplayed();
	}
	
	public String getAccountAndListsText() throws InterruptedException{
		log.info("Starting getAccountAndListsText method");
		
		explicitWait(btnAccountAndLists);
		
		log.info("Ending getAccountAndListsText method");
		
		return btnAccountAndLists.getText();
	}
	
	public boolean isCartImageDisplayed() throws InterruptedException{
		log.info("Starting isCartImageDisplayed method");
		
		explicitWait(imgCart);
		
		log.info("Ending isCartImageDisplayed method");
		
		return imgCart.isDisplayed();
	}
	
	public String getAmazonPayText() throws InterruptedException{
		log.info("Starting getAmazonPayText method");
		
		explicitWait(btnAmazonPay);
		
		log.info("Ending getAmazonPayText method");
		
		return btnAmazonPay.getText();
	}
	
	public String getTodaysDealsText() throws InterruptedException{
		log.info("Starting getTodaysDealsText method");
		
		explicitWait(btnTodaysDeals);
		
		log.info("Ending getTodaysDealsText method");
		
		return btnTodaysDeals.getText();
	}
	
	public String getAllText() throws InterruptedException{
		log.info("Starting getAllText method");
		
		explicitWait(btnAll);
		
		log.info("Ending getAllText method");
		
		return btnAll.getText();
	}
	
	public String getPrimeText() throws InterruptedException{
		log.info("Starting getPrimeText method");
		
		explicitWait(btnPrime);
		
		log.info("Ending getPrimeText method");
		
		return btnPrime.getText();
	}

}
