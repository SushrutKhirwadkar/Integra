package com.soch.Integra.dto;


public class ApplicationUserDTO {
	
	private String firstName;
	private String lastName;
	private String title;
	private int userId;
	private String role;
	private String emailId;
	private boolean newEntry;
	private boolean active;
	
	private int applicationUserId;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public boolean isNewEntry() {
		return newEntry;
	}

	public void setNewEntry(boolean newEntry) {
		this.newEntry = newEntry;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public int getApplicationUserId() {
		return applicationUserId;
	}

	public void setApplicationUserId(int applicationUserId) {
		this.applicationUserId = applicationUserId;
	}
	
}
