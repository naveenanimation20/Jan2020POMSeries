package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pojo.Credentials;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.ElementActions;

import io.qameta.allure.Step;

public class LoginPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;

	// 1. By locators - Page Objects

	By username = By.id("username");
	By password = By.id("password");
	By login = By.id("loginBtn");
	By signup = By.linkText("Sign up");
	By errorMesg = By.cssSelector("h5.private-alert__title");
	By random = By.id("random");

	// 2. Constructor of page class:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(this.driver);
	}

	// 3. page actions/methods:
	@Step("getting the page title")
	public String getPageTitle() {
		return elementActions.doGetPageTitle(AppConstants.LOGIN_PAGE_TITLE);
	}

	@Step("verifying sign up link")
	public boolean verifySignUpLink() {
		elementActions.waitForElementPresent(signup);
		return elementActions.doIsDisplayed(signup);
	}

	@Step("login with username: {0} and password : {1} ")
	public HomePage doLogin(Credentials credentials) {
		System.out.println("credentials are : " + credentials.getEmailID()  + " " + credentials.getPassword());
		elementActions.waitForElementPresent(username);
		elementActions.doSendKeys(username, credentials.getEmailID());
		elementActions.doSendKeys(password, credentials.getPassword());
		elementActions.doClick(login);

		return new HomePage(driver);
	}

	public boolean checkLoginErrorMessg() {
		return elementActions.doIsDisplayed(errorMesg);
	}

}
