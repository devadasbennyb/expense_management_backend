package com.tecnics.expenseservices.models;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "expensetype_table")
public class ExpenseTypeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long expenseTypeId;

	@Column(nullable = false,unique = true)
	public String expenseType;

	public String description;
	
	@CreationTimestamp
	private Timestamp created;

	@UpdateTimestamp
	private Timestamp updated;

	public ExpenseTypeModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExpenseTypeModel(Long expenseTypeId, String expenseType, String description, Timestamp created,
			Timestamp updated) {
		super();
		this.expenseTypeId = expenseTypeId;
		this.expenseType = expenseType;
		this.description = description;
		this.created = created;
		this.updated = updated;
	}

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
