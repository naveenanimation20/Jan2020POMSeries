package com.qa.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;
import com.qa.hubspot.pojo.Contacts;
import com.qa.hubspot.util.AppConstants;
import com.qa.hubspot.util.ElementActions;
import com.qa.hubspot.util.JavaScriptUtil;

public class ContactsPage extends BasePage {

	WebDriver driver;
	ElementActions elementActions;
	JavaScriptUtil jsUtil;

	By createContactButton = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=1]");
	By createContactFormButton = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=2]");

	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");
	
	By contactsNavigate = By.xpath("(//i18n-string[text()='Contacts'])[2]");

	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new ElementActions(driver);
		jsUtil = new JavaScriptUtil(driver);
	}

	public String getContactsPageTitle() {
		return elementActions.doGetPageTitle(AppConstants.CONTACTS_PAGE_TITLE);
	}

	public void createContact(Contacts contacts)
			throws InterruptedException {

		elementActions.waitForElementPresent(createContactButton);
		elementActions.doClick(createContactButton);

		elementActions.waitForElementPresent(this.email);
		elementActions.doSendKeys(this.email, contacts.getEmail());

		elementActions.doSendKeys(this.firstName, contacts.getFirstName());

		elementActions.doSendKeys(this.lastName, contacts.getLastName());

		elementActions.waitForElementPresent(this.jobTitle);
		elementActions.doSendKeys(this.jobTitle, contacts.getJobTitle());

		// elementUtil.doClick(createContactFormButton);
		jsUtil.clickElementByJS(elementActions.getElement(createContactFormButton));

		elementActions.waitForElementPresent(this.contactsNavigate);
		elementActions.doClick(this.contactsNavigate);
		
	}

}
