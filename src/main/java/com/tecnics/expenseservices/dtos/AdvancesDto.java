package com.tecnics.expenseservices.dtos;

import java.sql.Date;
import java.sql.Timestamp;

import com.tecnics.expenseservices.models.EmployeeModel;
import com.tecnics.expenseservices.utils.Status;

public class AdvancesDto {

	private Long advanceId;

	private String advanceName;

	private Date date;

	private EmployeeModel employee;

	private Status status;

	private Long amount;

	private String description;

	private Timestamp created;

	private Timestamp updated;

	public Long getAdvanceId() {
		return advanceId;
	}

	public void setAdvanceId(Long advanceId) {
		this.advanceId = advanceId;
	}

	public String getAdvanceName() {
		return advanceName;
	}

	public void setAdvanceName(String advanceName) {
		this.advanceName = advanceName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EmployeeModel getEmployee() {
		return employee;
	}

	public void setEmployee(EmployeeModel employee) {
		this.employee = employee;
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
