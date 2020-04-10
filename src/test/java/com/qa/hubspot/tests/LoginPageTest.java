package com.qa.hubspot.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pages.HomePage;
import com.qa.hubspot.pages.LoginPage;
import com.qa.hubspot.pojo.Credentials;
import com.qa.hubspot.util.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

@Epic("Epic - 101 : define login feature for hubpot application")
@Feature("US - 1001 : create features for login with signup, title and login")
public class LoginPageTest {

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
	}

	@Test(priority = 2)
	@Description("verify Login Page Title Test")
	@Severity(SeverityLevel.NORMAL)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getPageTitle();
		System.out.println("Login page title is : " + title);
		Assert.assertEquals(title, AppConstants.LOGIN_PAGE_TITLE);
	}

	@Test(priority = 1, enabled=false)
	@Description("verify SignUp Link Test")
	@Severity(SeverityLevel.CRITICAL)
	public void verifySignUpLinkTest() {
		Assert.assertTrue(loginPage.verifySignUpLink());
	}

	@Test(priority = 3, description = "verify app login test", enabled=false)
	@Description("verify app login Test")
	@Severity(SeverityLevel.BLOCKER)
	public void loginTest() {
		homePage = loginPage.doLogin(credentials);
		String loggedInUserVal = homePage.isUSerLoggedIn();
		System.out.println("logged in user is : " + loggedInUserVal);
		Assert.assertEquals(loggedInUserVal, prop.getProperty("accountname"));
	}

	@DataProvider
	public Object[][] getLoginInvalidData() {
		Object data[][] = { { "test@gmail.com", "test" }, { "test@gmail.com", " " }, { "", "test" }, { "test", "test" },
				{ " ", " " } };
		return data;
	}

//	@Test(priority = 4, dataProvider = "getLoginInvalidData", enabled = false)
//	public void login_InvalidTestCases(String emailID, String pwd) {
//		loginPage.doLogin(emailID, pwd);
//		Assert.assertTrue(loginPage.checkLoginErrorMessg());
//	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
