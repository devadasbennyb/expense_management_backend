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
@Table(name = "manager_table")
public class ManagerModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long managerId;

	@Column(nullable = false, unique = true)
	private String managerName;

	@CreationTimestamp
	private Timestamp created;

	@UpdateTimestamp
	private Timestamp updated;

	public ManagerModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ManagerModel(Long managerId, String managerName, Timestamp created, Timestamp updated) {
		super();
		this.managerId = managerId;
		this.managerName = managerName;
		this.created = created;
		this.updated = updated;
	}

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
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
