package com.qa.hubspot.pojo;

public class Contacts {

	String email;
	String firstName;
	String lastName;
	String jobTitle;

	public Contacts(String email, String firstName, String lastName, String jobTitle) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobTitle = jobTitle;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

}
