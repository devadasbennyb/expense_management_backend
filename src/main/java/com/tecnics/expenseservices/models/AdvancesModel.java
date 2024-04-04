package com.tecnics.expenseservices.models;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.tecnics.expenseservices.utils.Status;

@Entity
@Table(name = "advances_Table")
public class AdvancesModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long advanceId;

	@Column(nullable = false, unique = true)
	private String advanceName;

	@ManyToOne
	@JoinColumn(name = "emp_id")
	private EmployeeModel employee;

	@Column(nullable = false)
	private Date date;

	@Column(nullable = false)
	private Long amount;

	@Column(nullable=false)
	@Enumerated(EnumType.STRING)
	private Status status;

	private String description;

	@CreationTimestamp
	private Timestamp created;

	@UpdateTimestamp
	private Timestamp updated;

	public AdvancesModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AdvancesModel(Long advanceId, String advanceName, EmployeeModel employee, Date date, Long amount,
			Status status, String description, Timestamp created, Timestamp updated) {
		super();
		this.advanceId = advanceId;
		this.advanceName = advanceName;
		this.employee = employee;
		this.date = date;
		this.amount = amount;
		this.status = status;
		this.description = description;
		this.created = created;
		this.updated = updated;
	}

	public Long getAdvanceId() {
		return advanceId;
	}

	public void setAdvanceId(Long advanceId) {
		this.advanceId = advanceId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getAdvanceName() {
		return advanceName;
	}

	public void setAdvanceName(String advanceName) {
		this.advanceName = advanceName;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
	}


	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
