package com.tecnics.expenseservices.dtos;

import java.sql.Timestamp;

import com.tecnics.expenseservices.models.DepartmentModel;
import com.tecnics.expenseservices.models.ManagerModel;

public class EmployeeDto {

	private Long empId;

	private String firstName;

	private String lastName;

	private String state;

	private String address;

	private Long mobile;

	private DepartmentModel department;

	private ManagerModel manager;

	private String emailId;

	private Long zip;

	private Long accountNumber;

	private Long creditCard;
	
	private Timestamp created;

	private Timestamp updated;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobile() {
		return mobile;
	}

	public void setMobile(Long mobile) {
		this.mobile = mobile;
	}

	public DepartmentModel getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentModel department) {
		this.department = department;
	}

	public ManagerModel getManager() {
		return manager;
	}

	public void setManager(ManagerModel manager) {
		this.manager = manager;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getZip() {
		return zip;
	}

	public void setZip(Long zip) {
		this.zip = zip;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(Long creditCard) {
		this.creditCard = creditCard;
	}

	public Timestamp getCreated() {
		return created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public Timestamp getUpdated() {
		return updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	

}
