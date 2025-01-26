package com.amazon.web.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver = null;
    
    public BasePage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void implicitWait() {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    
    public void explicitWait(WebElement element) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public void fluentWait(WebElement element) {
    	Wait wait = new FluentWait(driver)
    			.withTimeout(Duration.ofSeconds(60))
    			.pollingEvery(Duration.ofSeconds(10))
    			.ignoring(NoSuchElementException.class);
    	wait.until(ExpectedConditions.visibilityOf(element));
    }
}