package com.sample.Login.dto;

public class UserDTO {
	
	private Integer empNo;
	private String name;
	private Long contactNumber;
	private String emailId;
	private AdminDTO admin;
	

	public UserDTO(Integer empNo, String name, Long contactNumber, String emailId, AdminDTO admin) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.admin = admin;
	}
	
	

	public AdminDTO getAdmin() {
		return admin;
	}



	public void setAdmin(AdminDTO admin) {
		this.admin = admin;
	}



	public Integer getEmpNo() {
		return empNo;
	}

	public void setEmpNo(Integer empNo) {
		this.empNo = empNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(Long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

}
