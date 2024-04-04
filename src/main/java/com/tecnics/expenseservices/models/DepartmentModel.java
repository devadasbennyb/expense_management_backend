
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
@Table(name = "department_table")
public class DepartmentModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long departmentId;

	@Column(nullable = false, unique = true)
	private String departmentName;

	private String DepartmentDescription;

	@CreationTimestamp
	private Timestamp created;

	@UpdateTimestamp
	private Timestamp updated;

	public DepartmentModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DepartmentModel(Long departmentId, String departmentName, String departmentDescription, Timestamp created,
			Timestamp updated) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		DepartmentDescription = departmentDescription;
		this.created = created;
		this.updated = updated;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentDescription() {
		return DepartmentDescription;
	}

	public void setDepartmentDescription(String departmentDescription) {
		DepartmentDescription = departmentDescription;
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
