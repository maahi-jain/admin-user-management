package com.sample.Login.dto;

import java.time.LocalDate;
import java.util.List;

public class AdminDTO {
	private String userName;
	private String password;
	private String name;
	private long contactNumber;
	private String emailId;
	private LocalDate DOB;
	private List<UserDTO> users;
	
	

	public AdminDTO(String userName, String password, String name, long contactNumber, String emailId, LocalDate dOB,
			List<UserDTO> users) {
		super();
		this.userName = userName;
		this.password = password;
		this.name = name;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		DOB = dOB;
		this.users = users;
	}

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDOB() {
		return DOB;
	}

	public void setDOB(LocalDate DOB) {
		this.DOB = DOB;
	}
	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
