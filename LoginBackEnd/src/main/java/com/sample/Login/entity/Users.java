package com.sample.Login.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int empId;
	private String name;
	private Long contactNumber;
	private String emailId;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="admin")
	private Admin admin;
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getEmpId() {
		return empId;
	}
//	public void setEmpId(Integer empId) {
//		this.empId = empId;
//	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactNumber() {
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
