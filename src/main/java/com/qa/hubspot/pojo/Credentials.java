package com.qa.hubspot.pojo;

public class Credentials {

	String emailID;
	String password;

	public Credentials(String emailID, String password) {
		this.emailID = emailID;
		this.password = password;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
