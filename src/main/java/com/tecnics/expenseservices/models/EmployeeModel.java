package com.tecnics.expenseservices.models;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "employee_table")
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long empId;

	@Column(nullable = false)
	private String firstName;

	@Column(nullable = false)
	private String lastName;

	private String state;
	
	private String address;

	@Column(nullable = false, unique = true)
	private Long mobile;

	@ManyToOne
	@JoinColumn(name = "department_id")
	private DepartmentModel department;
	
	@ManyToOne
	@JoinColumn(name = "manager_id")
	private ManagerModel manager;

	@Column(nullable = false, unique = true)
	private String emailId;
	
	private Long zip;

	@Column(nullable = false, unique = true)
	private Long accountNumber;

	@Column(nullable = false, unique = true)
	private Long creditCard;

	@CreationTimestamp
	private Timestamp created;

	@UpdateTimestamp
	private Timestamp updated;

	public EmployeeModel() {
		super();
		// TODO Auto-generated constructor stub

	}

	public EmployeeModel(Long empId, String firstName, String lastName, String state, String address, Long mobile,
			DepartmentModel department, ManagerModel manager, String emailId, Long zip, Long accountNumber,
			Long creditCard, Timestamp created, Timestamp updated) {
		super();
		this.empId = empId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.address = address;
		this.mobile = mobile;
		this.department = department;
		this.manager = manager;
		this.emailId = emailId;
		this.zip = zip;
		this.accountNumber = accountNumber;
		this.creditCard = creditCard;
		this.created = created;
		this.updated = updated;
	}

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
