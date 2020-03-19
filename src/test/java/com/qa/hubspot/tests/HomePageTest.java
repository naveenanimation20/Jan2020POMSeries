package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pojo.Credentials;
import com.qa.hubspot.util.AppConstants;

public class HomePageTest {

	Properties prop;
	WebDriver driver;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	Credentials credentials;

	@BeforeTest
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.init_prop();
		driver = basePage.init_driver(prop);
		loginPage = new LoginPage(driver);
		credentials = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
		homePage = loginPage.doLogin(credentials);
	}

	@Test(priority = 2)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("home page title is : " + title);
		Assert.assertEquals(title, AppConstants.HOME_PAGE_TITLE);
	}

	@Test(priority = 1)
	public void verifyHomePageHedearTest() {
		String headerValue = homePage.isHomePageHeaderExist();
		System.out.println("Home page header is : " + headerValue);
		Assert.assertEquals(headerValue, AppConstants.HOME_PAGE_HEADER);
	}

	@Test(priority = 3)
	public void verifyLoggedInUserTest() {
		String loggedInUserVal = homePage.isUSerLoggedIn();
		System.out.println("logged in user is : " + loggedInUserVal);
		Assert.assertEquals(loggedInUserVal, prop.getProperty("accountname"));
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
