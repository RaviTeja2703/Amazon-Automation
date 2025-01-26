package com.amazon.web.tests;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeSuite;

import com.amazon.web.pages.login.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	public WebDriver driver;
	public LoginPage loginPage;

	protected static Properties testDataProp = null;
	protected static Properties expectedAssertionsProp = null;

	@BeforeSuite
	public void initTestData() {
		FileReader testDataReader = null;
		FileReader assertionsReader = null;

		try {
			testDataReader = new FileReader("src/main/resources/testdata.properties");
			assertionsReader = new FileReader("src/main/resources/expectedassertions.properties");

			testDataProp = new Properties();
			testDataProp.load(testDataReader);

			expectedAssertionsProp = new Properties();
			expectedAssertionsProp.load(assertionsReader);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void getWebSite(String siteURL)  {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.get(siteURL);
		loginPage = new LoginPage(driver);
	}

	public void amazonLogin()  {
		loginPage.clickOnSignIn();
		loginPage.setMobileNumber(testDataProp.getProperty("mobile.valid.text"));
		loginPage.clickOnContinueButton();
		loginPage.setPassword(testDataProp.getProperty("password.valid.text"));
		loginPage.clickOnSignIn2();
		
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}