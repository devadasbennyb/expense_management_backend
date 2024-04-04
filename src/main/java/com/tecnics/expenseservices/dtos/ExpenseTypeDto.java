package com.tecnics.expenseservices.dtos;

import java.sql.Timestamp;

public class ExpenseTypeDto {

	public Long expenseTypeId;

	public String expenseType;

	public String description;
	
	private Timestamp created;

	private Timestamp updated;

	public Long getExpenseTypeId() {
		return expenseTypeId;
	}

	public void setExpenseTypeId(Long expenseTypeId) {
		this.expenseTypeId = expenseTypeId;
	}

	public String getExpenseType() {
		return expenseType;
	}

	public void setExpenseType(String expenseType) {
		this.expenseType = expenseType;
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
