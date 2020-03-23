package com.qa.hubspot.pages;

import org.openqa.selenium.WebDriver;

import com.qa.hubspot.base.BasePage;

public class ProfilePage extends BasePage{
	
	WebDriver driver;
	public ProfilePage(WebDriver driver){
		this.driver = driver;
	}
	
  public void get(){
    System.out.println("get profile page");
  }
  
	
	

}
